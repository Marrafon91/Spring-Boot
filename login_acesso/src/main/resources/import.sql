INSERT INTO tb_user (name, email, phone, birth_date, password) VALUES ('Alex', 'alex@gmail.com', '999999999', '2001-04-21', '123456')
INSERT INTO tb_user (name, email, phone, birth_date, password) VALUES ('Maria', 'maria@gmail.com', '888888888', '1991-10-30', '123456')

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_product (name) VALUES ('TV');
INSERT INTO tb_product (name) VALUES ('Computer');