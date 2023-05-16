-- 创建用户表
CREATE TABLE users (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50)
);

-- 创建用户钱包表
CREATE TABLE wallet (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  balance DECIMAL(10, 2) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users (id)
);

-- 创建钱包交易记录表
CREATE TABLE wallet_transaction (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  transaction_type ENUM('CONSUME', 'REFUND', 'WITHDRAW') NOT NULL,
  transaction_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES wallet (id)
);

-- 插入用户数据
INSERT INTO users (name) VALUES ('User 1');
INSERT INTO users (name) VALUES ('User 2');

-- 插入用户钱包测试数据
INSERT INTO wallet (user_id, balance) VALUES (1, 500.0);
INSERT INTO wallet (user_id, balance) VALUES (2, 1000.0);

-- 插入钱包交易记录测试数据
INSERT INTO wallet_transaction (user_id, amount, transaction_type, transaction_time) VALUES (1, 100.0, 'CONSUME', NOW());
INSERT INTO wallet_transaction (user_id, amount, transaction_type, transaction_time) VALUES (1, 50.0, 'CONSUME', NOW());
INSERT INTO wallet_transaction (user_id, amount, transaction_type, transaction_time) VALUES (2, 200.0, 'CONSUME', NOW());

