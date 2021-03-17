INSERT INTO merch_app.users (username, password, role) VALUES ('hespejel', 'eta.epsilon', 'ADMIN');

INSERT INTO merch_app.users (merch_name, username, password, role) VALUES ('Alpha''s Goods','alphys', 'apassword', 'MERCHANT');

INSERT INTO merch_app.users (merch_name, username, password, role) VALUES ('Beta''s Stocks','betys', 'b.password', 'MERCHANT');

INSERT INTO merch_app.inventories (name_of_goods, quantity) VALUES ('apples', 10);

INSERT INTO merch_app.inventories (name_of_goods, quantity) VALUES ('bananas', 20);

INSERT INTO merch_app.inventories (name_of_goods, quantity) VALUES ('sheep', 100);

INSERT INTO merch_app.inventories (name_of_goods, quantity) VALUES ('wheat', 75);

INSERT INTO merch_app.inventories (name_of_goods, quantity) VALUES ('clay', 120);

INSERT INTO merch_app.inventories (name_of_goods, quantity) VALUES ('ore', 200);

INSERT INTO merch_app.inventories (name_of_goods, quantity) VALUES ('apricots', 35);

INSERT INTO merch_app.users_inventories_jt ("owner", inv_id) VALUES (2, 1);

INSERT INTO merch_app.users_inventories_jt ("owner", inv_id) VALUES (3, 2);

INSERT INTO merch_app.users_inventories_jt ("owner", inv_id) VALUES (2, 9);

INSERT INTO merch_app.users_inventories_jt ("owner", inv_id) VALUES (9, 4);

INSERT INTO merch_app.users_inventories_jt ("owner", inv_id) VALUES (3, 5);

INSERT INTO merch_app.users_inventories_jt ("owner", inv_id) VALUES (10, 8);