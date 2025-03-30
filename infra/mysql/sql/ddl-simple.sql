CREATE DATABASE IF NOT EXISTS `likelion`;
USE `likelion`;

SET NAMES utf8mb4;

-- CREATE TABLE IF NOT EXIST
DROP TABLE IF EXISTS `orders`;
CREATE TABLE orders (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        customer_id BIGINT NOT NULL,
                        order_number VARCHAR(36) NOT NULL UNIQUE,
                        total_amount INT NOT NULL,
                        created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO orders (customer_id, order_number, total_amount) VALUES
                                                                 (1, UUID(), 20000),
                                                                 (2, UUID(), 15000);
SELECT * FROM orders;

SELECT * FROM orders WHERE total_amount > 19000;

UPDATE orders SET total_amount = 25000 WHERE id = 2;

DELETE FROM orders WHERE id = 1;