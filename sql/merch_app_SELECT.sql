SELECT merch_app.users.id, merch_app.users.merch_name, merch_app.users.username, merch_app.users.password, merch_app.users.role, 
merch_app.inventories.id AS inventory_id, merch_app.inventories.name_of_goods, merch_app.inventories.quantity FROM merch_app.users 
LEFT JOIN merch_app.users_inventories_jt ON merch_app.users.id = merch_app.users_inventories_jt.owner LEFT JOIN merch_app.inventories 
ON merch_app.inventories.id = merch_app.users_inventories_jt.inv_id;