-- users
INSERT INTO users(email, password)
VALUES ('user1@email.com', '{bcrypt}$2a$12$S40LnvkeNZkUvOOQYig/Eu.g7nUxWG1b8w9q3PwZinkS8I8G3G7lC');
INSERT INTO users(email, password)
VALUES ('user2@email.com', '{bcrypt}$2a$10$awdgj/myiRi1ANCchZRHru/048Or2K1G/ZbOLFOXXHHV9dfOuh3tO');
INSERT INTO users(email, password)
VALUES ('admin@email.com', '{bcrypt}$2a$10$sJo9dqHcKaceBovssW6ykOja17AZqwA.e/VKbNjZHNUZE2oc96RPi');

-- roles
INSERT INTO roles(email, role)
VALUES ('user1@email.com', 'VIEW_INFO');
INSERT INTO roles(email, role)
VALUES ('user1@email.com', 'STANDARD');
INSERT INTO roles(email, role)
VALUES ('user2@email.com', 'VIEW_ADMIN');
INSERT INTO roles(email, role)
VALUES ('admin@email.com', 'VIEW_INFO');
INSERT INTO roles(email, role)
VALUES ('admin@email.com', 'VIEW_ADMIN');
INSERT INTO roles(email, role)
VALUES ('admin@email.com', 'STANDARD');