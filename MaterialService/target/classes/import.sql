INSERT INTO material_category (category_id, category_name) VALUES ('C001', 'Thread');
INSERT INTO material_category (category_id, category_name) VALUES ('C002', 'Cloth');
INSERT INTO material_category (category_id, category_name) VALUES ('C003', 'Button');


insert into material_type (type_id, type_name, category_id) values('T001','Silk-Thread', 'C001');
insert into material_type (type_id, type_name, category_id) values('T002','Silk-Cloth', 'C002');
insert into material_type (type_id, type_name, category_id) values('T003','Linen-Thread', 'C001');
insert into material_type (type_id, type_name, category_id) values('T004','Linen-Cloth', 'C002');
insert into material_type (type_id, type_name, category_id) values('T005','Silk-Button', 'C003');   
insert into material_type (type_id, type_name, category_id) values('T006','Suit-Button', 'C003');

insert into unit (unit_id, unit_name, category_id) values('U001','Metres','C001');
insert into unit (unit_id, unit_name, category_id) values('U002','Metres','C002');
insert into unit (unit_id, unit_name, category_id) values('U003','Centi Meters','C001');
insert into unit (unit_id, unit_name, category_id) values('U004','Centi Meters','C002');
insert into unit (unit_id, unit_name, category_id) values('U005','Kilo Grams','C003');

-- Please build further queries to add
-- 'MaterialType' and 'Unit' details of this service below.