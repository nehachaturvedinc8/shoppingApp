create table category(

id int,
name VARCHAR(50),
description VARCHAR(255),
image_url VARCHAR(50),
is_active bit,

CONSTRAINT pk_category_id PRIMARY KEY (id)

);