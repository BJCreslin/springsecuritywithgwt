DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  role VARCHAR(50) NOT NULL DEFAULT 'USER',
  status VARCHAR(50) NOT NULL DEFAULT 'ACTIVE'
);

INSERT INTO users (  email, first_name,last_name,password,role,status) VALUES
('admin@g.com','firstAdmin','LastASdmin','$2y$12$EJSJ88ptQQSqqRhuioyXFu/beVgeqNDeu.X5N7seMQng7rB9ysZZG','ADMIN','ACTIVE'),
('user@g.com','firstUSer','LastUser','$2y$12$piBfugUbhMnFDGo.EBp29uGhCSkATEq/c2h4nOx7Q3SmgA92MobBK','USER','ACTIVE');

