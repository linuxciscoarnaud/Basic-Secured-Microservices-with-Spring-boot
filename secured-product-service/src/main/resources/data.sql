
-- Create categories for products

insert into category (category_id, name) values ('5C1D0cB93Y', 'Computer Hardware & Software');
insert into category (category_id, name) values ('wJr3uVF2OL', 'Machinery');
insert into category (category_id, name) values ('Vp1eeLc05v', 'Food & Beverage');
insert into category (category_id, name) values ('YkV6zzOpo7', 'Cosmetic');


-- Create products

insert into product (product_id, name, unit_price, description, units_in_stock, category_id) values ('LXRh6tUETb', 'NIVEA', 250, 'Produit de beaute avec creme amincissante', 10, 'YkV6zzOpo7');
insert into product (product_id, name, unit_price, description, units_in_stock, category_id) values ('omBEw8gWj2', 'Desktop Dell 1021', 550, 'Computer equipped with NVIDIA GPU', 25, '5C1D0cB93Y');



