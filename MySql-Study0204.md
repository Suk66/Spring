**Dbeaver**

- MySQL 데이터베이스 생성 및 테이블 생성.

- customer 테이블 생성 및 데이터 삽입

```java
CREATE TABLE customer (
    customer_id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    customer_name VARCHAR(20) NOT NULL,
    customer_address VARCHAR(60),
    customer_email VARCHAR(40)
);

// 데이터 삽입
INSERT INTO customer(customer_name, customer_address, customer_email)
	VALUES ('김일', '서울시', 'kim1@gmail.com'),
		   ('김이', '부산시', 'kim2@gmail.com'),
		   ('김삼', '대전시', 'kim3@gmail.com'),
		   ('김사', '인천시', 'kim4@gmail.com'),
		   ('김오', '대구시', 'kim5@gmail.com');

```


- product 테이블 생성 및 데이터 삽입

  ```java
  CREATE TABLE product (
    product_id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    product_name VARCHAR(40) NOT NULL,
    product_description VARCHAR(200),
    product_price INTEGER NOT NULL CHECK(product_price > 0)
  );
  // data insert
  INSERT INTO product(product_name, product_description, product_price)
	VALUES ('제품1', '제품1설명', 10000),
		   ('제품2', '제품2설명', 20000),
		   ('제품3', '제품3설명', 30000),
		   ('제품4', '제품4설명', 40000),
		   ('제품5', '제품5설명', 50000);

  ```

- inventory

  ```java
  CREATE TABLE inventory (
    product_id INTEGER PRIMARY KEY,
    inventory_quantity INTEGER NOT NULL,
    CONSTRAINT fk_inventory_product_id FOREIGN KEY (product_id)
    REFERENCES product (product_id)
    ON DELETE CASCADE
  );

  INSERT INTO inventory
	VALUES (1, 1000),
		   (2, 2000),
		   (3, 3000),
		   (4, 4000),
		   (5, 5000);

  ```

  
 - orders

  ```java
    CREATE TABLE orders (
    order_id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    customer_id INTEGER,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_order_customer_id FOREIGN KEY (customer_id)
    REFERENCES customer (customer_id)
    ON DELETE CASCADE
  	);

   INSERT INTO orders(customer_id)
	VALUES (1), (2), (3), (4), (5);


   ```

 - order_item

  ```java
   CREATE TABLE order_item (
    order_item_id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    product_id INTEGER,
    order_item_quantity INTEGER NOT NULL,
    order_id INTEGER,
    CONSTRAINT fk_order_item_product_id FOREIGN KEY (product_id)
    REFERENCES product (product_id)
    ON DELETE CASCADE,
    CONSTRAINT fk_order_id FOREIGN KEY (order_id)
    REFERENCES orders (order_id)
    ON DELETE CASCADE
  );

  INSERT INTO order_item(product_id, order_item_quantity, order_id)
	VALUES (1, 1, 1),
		   (2, 2, 1),
		   (3, 3, 1),
		   (4, 4, 2),
		   (5, 5, 2),
		   (1, 10, 3),
		   (2, 20, 3),
		   (3, 30, 4),
		   (4, 40, 4),
		   (5, 50, 4),
		   (1, 100, 5),
		   (2, 200, 5),
		   (3, 300, 5),
		   (4, 400, 5),
		   (5, 500, 5);

  ```
