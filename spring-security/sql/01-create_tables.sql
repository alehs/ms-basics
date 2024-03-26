DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    email    varchar(128) PRIMARY KEY,
    password varchar(500) NOT NULL
);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    email varchar(128) NOT NULL,
    role  varchar(20)  NOT NULL,
    PRIMARY KEY (email, role),
    CONSTRAINT fk_roles_users FOREIGN KEY (email) REFERENCES users (email)
);

DROP TABLE IF EXISTS secrets;
CREATE TABLE secrets(
    email varchar(128) PRIMARY KEY,
    secret varchar  NOT NULL,
    token varchar(36) NOT NULL UNIQUE,
    link varchar NOT NULL,
    CONSTRAINT fk_secrets_users FOREIGN KEY (email) REFERENCES users (email)
);