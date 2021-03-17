DROP SCHEMA IF EXISTS merch_app CASCADE;
CREATE SCHEMA merch_app;

--DROP TYPE IF EXISTS merch_app.role CASCADE;
--CREATE TYPE merch_app.role AS ENUM ('ADMIN', 'MERCHANT');

DROP TABLE IF EXISTS merch_app.users CASCADE;
CREATE TABLE merch_app.users (
	id SERIAL PRIMARY KEY,
	merch_name VARCHAR (250) UNIQUE,
	username VARCHAR (250) UNIQUE NOT NULL,
	password VARCHAR (250) NOT NULL,
	role VARCHAR (250) CHECK( role IN ('ADMIN', 'MERCHANT'))
);

DROP TABLE IF EXISTS merch_app.inventories CASCADE;
CREATE TABLE merch_app.inventories (
	id SERIAL PRIMARY KEY,
	name_of_goods VARCHAR (250) NOT NULL,
	quantity INTEGER NOT NULL CHECK (quantity >= 0) DEFAULT 0
	-- might not need owner column
);

DROP TABLE IF EXISTS merch_app.users_inventories_jt CASCADE;
CREATE TABLE merch_app.users_inventories_jt (
	owner INTEGER NOT NULL REFERENCES merch_app.users (id),
	inv_id INTEGER NOT NULL REFERENCES merch_app.inventories (id)
);

DROP TABLE IF EXISTS merch_app.logins CASCADE;
CREATE TABLE merch_app.logins (
	user_id INTEGER NOT NULL REFERENCES merch_app.users (id),
	session_id BIGINT NOT NULL UNIQUE
	-- consider multiple login from different devices
);



