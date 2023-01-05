create schema customer;
create table customer.details(order_id int, customerid int, phone_no bigint, customer_name varchar(30),address varchar(100),pincode int);
insert customer.details values(001, 10, 9963852100, 'gopinath', 'uthangarai', 635207),
(002,23,7871738320,'harikiran','anna_nagar',600028),
(003,47,9398654102,'karthick','tirupathur',636202),
(004,56,7808945916,'jeeva','uthangarai',635207),
(005,63,9843441002,'prem','salem',636502);
select*from customer.details;
-- drop table customer.details;

create table customer.order(orderid int,productid int, order_date date, shippeddate date, product_name varchar(20), 
status_of_delivery varchar(100),quantity int, price_of_product int);
insert customer.order values(001,11,'2022-4-11','2022-4-13','headphone','delivered',2,2300),
(002,12,'2022-4-23','2022-4-25','laptop','delivered',1,55000),
(003,13,'2022-5-6','2022-5-8','trimmer','delivered',1,1500),
(004,14,'2022-5-8','2022-5-10','laptop','not_yet_delivered',1,48000),
(005,15,'2022-5-9','2022-5-10','shampoo','not_yet_delivered',1,600);                                 
-- drop table customer.order;
select*from customer.order;
select*from customer.details c inner join customer.order o where c.order_id = o.orderid;
select phone_no from customer.details c inner join customer.order o on c.order_id=o.orderid where o.product_name='laptop' ;
select customer_name from customer.details c inner join customer.order o on c.order_id=o.orderid where o.order_date  between '2022-4-30' and '2022-5-30';