-- create database
create database sms;
use sms;

-- create table
create table Customer (
	customer_id int auto_increment primary key,
    customer_name varchar(255) not null
);

create table Employee (
	employee_id int auto_increment primary key,
    employee_name varchar(255) not null,
    salary decimal(10,2) not null,
    supervisor_id int null,
    foreign key(supervisor_id) references Employee(employee_id)
);

create table Product (
	product_id int auto_increment primary key,
    product_name varchar(255) not null,
    list_price decimal(10,2) not null
);

create table Orders (
	order_id int auto_increment primary key,
    customer_id int not null,
    foreign key(customer_id) references Customer(customer_id),
    employee_id int not null,
    foreign key(employee_id) references Employee(employee_id),
    order_date datetime not null,
    total decimal(10,2)
);

create table LineItem (
    order_id int not null,
    product_id int not null,
    quantity int not null,
    price decimal(10, 2),
    primary key (order_id, product_id),
    foreign key (order_id) references Orders(order_id),
	foreign key (product_id) references Product(product_id)
);

-- insert records to test
insert into customer(customer_name) values ('Nguyen Van A'), ('Nguyen Van B'), ('Nguyen Van C'),
('Nguyen Van D'), ('Nguyen Van E');

insert into employee (employee_id, employee_name, salary, supervisor_id) values (2,'Tran Minh B', 30000000, NULL);
insert into employee (employee_id, employee_name, salary, supervisor_id) values 
(1,'Tran Minh A', 10000000, 2), (3,'Tran Minh C', 12000000, 2), (4,'Tran Minh D', 7000000, 1);

insert into orders (order_date, customer_id, employee_id, total) values
('2024-12-28 10:30:00', 1, 2, 0), ('2024-12-27 14:15:00', 2, 3, 0), ('2024-12-26 09:45:00', 1, 2, 0),
('2024-12-25 16:20:00', 3, 1, 0), ('2024-12-24 11:00:00', 2, 3, 0);

insert into product(product_name, list_price) values ('pen', 9000), ('book', 10000), 
('eraser', 12000), ('wooden ruler', 20000), ('bag', 150000);

insert into lineitem(order_id, product_id, quantity, price) values (2, 4, 1, 25000), (1, 3, 2, 24000),
(4, 5, 1, 150000), (3, 1, 6, 54000), (3, 4, 3, 60000);

-- q1
select distinct c.customer_id, c.customer_name 
from customer c
inner join orders o on c.customer_id = o.customer_id;

-- q2
select o.order_id, o.customer_id, o.employee_id,o.order_date, o.total 
from orders o
inner join customer c on o.customer_id = c.customer_id
where o.customer_id = 3;

-- q3
select order_id, product_id, quantity, price 
from lineitem 
where order_id = 1;

-- q4
drop function if exists caculate_order_total;

delimiter //
create function caculate_order_total(p_order_id int)
returns decimal(10,2)
reads sql data
begin 
	declare order_total decimal(10,2);
    
    select sum(quantity * price)
    into order_total
    from LineItem
    where order_id=p_order_id;
    
    return order_total;
end //
delimiter ;

select caculate_order_total(3);

-- q5
delimiter //
create procedure add_customer(in p_customer_id int, in p_customer_name varchar(255))
begin
	insert into Customer(customer_id, customer_name)
    values (p_customer_id, p_customer_name);
end //
delimiter ;

call add_customer(6, 'Nguyen Van F');

-- q6
delimiter //
create procedure delete_customer(in p_customer_id int)
begin
	start transaction;
    
    delete li from LineItem li
    inner join Orders o on li.order_id = o.order_id
    where o.customer_id = p_customer_id;
    
    delete from Orders where customer_id = p_customer_id;
    
    delete from Customer where customer_id = p_customer_id;
    
    commit;
end //
delimiter ;

call delete_customer(1);

-- q7
delimiter //
create procedure update_customer (in p_customer_id int, in p_customer_name varchar(255))
begin
update Customer
set customer_name = p_customer_name
where customer_id = p_customer_id;
end//
delimiter ;

call update_customer(2, 'Nguyen Van Ba');

-- q8
delimiter //
create procedure create_order(in p_order_id int , in p_customer_id int, 
in p_employee_id int, in p_order_date datetime, in p_total decimal(10,2))
begin
	insert into Orders(order_id, customer_id, employee_id, order_date, total)
    values(p_order_id, p_customer_id, p_employee_id, p_order_date, p_total);
end//
delimiter ;

call create_order(6, 5, 4, '2024-12-28 10:15:00', 0);

-- q9
delimiter //
create procedure create_lineitem(in p_order_id int, in p_product_id int, 
in p_quantity int, in p_price decimal(10,2))
begin
	insert into LineItem (order_id, product_id, quantity, price)
    values (p_order_id, p_product_id, p_quantity, p_price);
end//
delimiter ;

call create_lineitem(5, 2, 3, 30000);

-- q10
delimiter //
create procedure update_order_total(in p_order_id int)
begin
	declare update_total decimal(10, 2);
	set update_total = caculate_order_total(p_order_id);
    
    update Orders
    set total = update_total
    where order_id = p_order_id;
end//
delimiter ;

call update_order_total(2);
