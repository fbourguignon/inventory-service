INSERT INTO public.tb_category (id, "name") VALUES (1, 'Consoles');
INSERT INTO public.tb_category (id, "name") VALUES (2, 'Computers');
INSERT INTO public.tb_category (id, "name") VALUES (3, 'Keyboards');
INSERT INTO public.tb_category (id, "name") VALUES (4, 'Mouses');
INSERT INTO public.tb_category (id, "name") VALUES (5, 'TVs');

INSERT INTO public.tb_product ("name", description, price, quantity, category_id, uuid)
VALUES('Playstation 5', 'Sony next generation console', 4799.0, 50, 1, gen_random_uuid());

INSERT INTO public.tb_product ("name", description, price, quantity, category_id, uuid)
VALUES('Xbox Series S', 'Microsoft next generation console', 2200.0, 100, 1, gen_random_uuid());
