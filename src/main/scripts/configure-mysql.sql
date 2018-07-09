-- Start/Stop mysql on Mac: > mysql.server start/stop
-- Run with docker: # docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

-- Create database service accounts ! Create Your User!
-- CREATE USER 'sfg_dev_user'@'localhost' IDENTIFIED BY 'guru';
-- CREATE USER 'sfg_prod_user'@'localhost' IDENTIFIED BY 'guru';
-- CREATE USER 'sfg_dev_user'@'%' IDENTIFIED BY 'guru';
-- CREATE USER 'sfg_prod_user'@'%' IDENTIFIED BY 'guru';

-- Create Databases
CREATE DATABASE spring5web_dev;
create DATABASE spring5web_prod;

-- Database Grants
GRANT SELECT ON spring5web_dev.* TO 'dev_user'@'localhost';
GRANT INSERT ON spring5web_dev.* TO 'dev_user'@'localhost';
GRANT DELETE ON spring5web_dev.* TO 'dev_user'@'localhost';
GRANT UPDATE ON spring5web_dev.* TO 'dev_user'@'localhost';
GRANT SELECT ON spring5web_prod.* TO 'prod_user'@'localhost';
GRANT INSERT ON spring5web_prod.* TO 'prod_user'@'localhost';
GRANT DELETE ON spring5web_prod.* TO 'prod_user'@'localhost';
GRANT UPDATE ON spring5web_prod.* TO 'prod_user'@'localhost';
-- GRANT SELECT ON spring5web_dev.* TO 'spring_dev_user'@'%';
-- GRANT INSERT ON spring5web_dev.* TO 'spring_dev_user'@'%';
-- GRANT DELETE ON spring5web_dev.* TO 'spring_dev_user'@'%';
-- GRANT UPDATE ON spring5web_dev.* TO 'spring_dev_user'@'%';
-- GRANT SELECT ON spring5web_prod.* TO 'spring_prod_user'@'%';
-- GRANT INSERT ON spring5web_prod.* TO 'spring_prod_user'@'%';
-- GRANT DELETE ON spring5web_prod.* TO 'spring_prod_user'@'%';
-- GRANT UPDATE ON spring5web_prod.* TO 'spring_prod_user'@'%';