 INSERT INTO phone(id, area_code, country_code, number) VALUES (1,641,819,1397) ;

 INSERT INTO role(role_id, role) VALUES (1,'ADMIN');
 INSERT INTO role(role_id, role) VALUES (2,'BUYER');
 INSERT INTO role(role_id, role) VALUES (3,'SELLER');

 INSERT INTO user(u_id, email, f_name, l_name, password, username) VALUES (1,'email@miu.com','souf','ennali','1234','admin');
 INSERT INTO user(u_id, email, f_name, l_name, password, username) VALUES (2,'email@miu.com','Buyerfirstname','Buyerlastname','1234','buyer');
 INSERT INTO user(u_id, email, f_name, l_name, password, username) VALUES (3,'email@miu.com','Munkhundral','Erdenebayar','1234','seller');
 
 INSERT INTO ADMIN  VALUES(1, 1);
 INSERT INTO BUYER(B_ID, POINTS, USER_ID) values (2, 0, 2);
 INSERT INTO SELLER(id, status, user_id) values (3, 'Approved', 3);

 INSERT INTO user_roles(user_id, role_id) VALUES(1,1);
 INSERT INTO user_roles(user_id, role_id) VALUES(2,2);
 INSERT INTO user_roles(user_id, role_id) VALUES(3,3);
 

INSERT INTO product(id, created_on, description, price, rating, status, title,image, number_in_stock, seller_id)
VALUES (1, '2021-09-23' ,'Product description will be here',109.5,'3','APPROVED','Gaming table','https://thermaltake.azureedge.net/pub/media/catalog/product/cache/e4fc6e308b66431a310dcd4dc0838059/0/1/01_6_1.jpg', 100, 3);

INSERT INTO product(id, created_on, description, price, rating, status, title,image, number_in_stock, seller_id)
VALUES (2, '2021-09-23' ,'Product description will be here',100,'5','APPROVED','Chair','https://www.ikea.com/us/en/images/products/millberget-swivel-chair-bomstad-black__0724719_pe734602_s5.jpg', 50, 3);

