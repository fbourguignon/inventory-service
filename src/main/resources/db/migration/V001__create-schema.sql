CREATE TABLE public.tb_category (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	"name" varchar(255) NULL,
	CONSTRAINT tb_category_pkey PRIMARY KEY (id)
);

CREATE TABLE public.tb_product (
	id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	description varchar(255) NULL,
	name varchar(255) NULL,
	price float8 NULL,
	quantity int4 NULL,
	uuid uuid NULL,
	category_id int8 NOT NULL,
	CONSTRAINT tb_product_pkey PRIMARY KEY (id),
	CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES public.tb_category(id)
);