package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private HttpServletRequest req;
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	public List<User> findAll() {
		MDC.put("userID", 1);
		log.info("Recieved all Users.");
		return userDAO.findAll();
		
	}

	public User findById(int id) {
		log.info("Found User with ID: " + id);
		return userDAO.findById(id)
				.orElseThrow(() -> new UserNotFoundException(String.format("No User with ID: %d", id)));
	}

	public User findByUsername(String username) {
		return userDAO.findByUsername(username).orElseThrow(
				() -> new UserNotFoundException(String.format("No User found with username: %s", username)));
	}

	public User insert(User u) {
		if (u.getId() != 0) {
			// Make this a custom exception when possible
			throw new RuntimeException("User ID must be zero to create a new User");
		}

		userDAO.save(u);

		return u;
	}

	public User update(User u) {
		if (!userDAO.existsById(u.getId())) {
			throw new RuntimeException("User must already exist to update");
		}

		userDAO.save(u);

		HttpSession session = req.getSession(false);

		User sessionUser = (User) session.getAttribute("currentUser");

		if (sessionUser.getId() == u.getId()) {
			session.setAttribute("currentUser", u);
		}

		return u;
	}

//	public void deleteByUser(User u) {
//		userDAO.delete(u);
//	}

	public boolean delete(int id) {
		if (!userDAO.existsById(id)) {
			return false;
		}

		userDAO.deleteById(id);

		return true;
	}

//	public User login(String username, String password) {
//		User exists = userDAO.findByUsername(username)
//				.orElseThrow( () -> new UserNotFoundException(String.format("No User with username: %s", username)));
//				
//		// Find a way to input password
//		
//		HttpSession session = req.getSession();
//		
//		User sessionUser = (User) session.getAttribute("currentUser");
//		
//		if (sessionUser.getId() == exists.getId()) {
//			session.setAttribute("currentUser", exists);
//			
//			return exists;
//		}
//		
//		return new User();		
//	}

	public User login(String username, String password) {
		
		MDC.put("login", username);
		User u = userDAO.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException(String.format("No User with username = %s", username)));
		if (u.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("currentUser", u);
			log.info("User successfully logged in");
			MDC.clear();
			return u;
		}
		MDC.put("wrongPassword", password);
		log.error("Incorrect password");
		MDC.clear();
		return null;
	}

	public void logout() {

		HttpSession session = req.getSession(false);

		if (session == null) {
			return;
		}

		session.invalidate();
	}
}
