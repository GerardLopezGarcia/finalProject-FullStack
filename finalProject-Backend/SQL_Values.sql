INSERT INTO user (name,password,role) VALUES
('reciencasados','ironhack','USER'),
('mujerilusionada','ironhack1','USER'),
('padresconhijos','ironhack2','USER'),
('grupodeamigos','ironhack3','USER'),
('estudianteindeciso','ironhack4','USER'),
('trabajadorconderechos','administrador1','ADMIN'),
('trabajadorempedernido','administrador2','ADMIN');

INSERT INTO guest_user (city,house_address,street,date_of_birth,user_status,name) VALUES
('Barcelona','1º 2ª','Aribau','1990-01-01','ONLINE','reciencasados'),
('Barcelona','6º 2ª','Mallorca','1987-07-13','ONLINE','mujerilusionada'),
('Barcelona','12º 1ª','Bailén','1965-09-22','ONLINE','padresconhijos'),
('Barcelona','3º 4ª','Diagonal','1994-05-05','ONLINE','grupodeamigos'),
('Barcelona','1º 4ª','Girona','1995-07-23','ONLINE','estudianteindeciso');

INSERT INTO admin (name) VALUES
('trabajadorconderechos'),
('trabajadorempedernido');

INSERT INTO house (country,house_address,bathrooms,bedrooms,beds,guests,image_url,price,score,status,guest_id) VALUES
('España','Bolvir',2,3,6,6,'https://a0.muscache.com/im/pictures/monet/Luxury-54140085/original/367a21ea-6714-4b4b-b897-4a147ed75633?im_w=1440',170,4.5,'AVALIABLE',NULL),
('España','Bellver',3,4,7,7,'https://images.adsttc.com/media/images/546a/c924/e58e/cea7/5a00/0108/slideshow/PORTADA.jpg?1416284445',120,4.3,'AVALIABLE',NULL),
('España','Llaés',4,4,8,9,'https://a0.muscache.com/im/pictures/miso/Hosting-2328455/original/a4506c8c-70d8-4016-bc57-d64abbf2702d.jpeg?im_w=960',210,5.0,'AVALIABLE',NULL),
('España','Calpe',2,1,1,2,'https://a0.muscache.com/im/pictures/90b74311-6f55-41ea-8649-e0556b5c3e3e.jpg?im_w=720',160,4.95,'AVALIABLE',NULL),
('Francia','Saint-Victor-la-Coste',2,1,1,2,'https://a0.muscache.com/im/pictures/monet/Select-14078693/original/c77d8ab0-68d5-4fb0-b68f-c5f13de9cdcc?im_w=1200',297,4.94,'AVALIABLE',NULL),
('España','Alaró',10,10,10,16,'https://a0.muscache.com/im/pictures/monet/Luxury-681893103779865400/original/9bfe944c-bf7d-492e-b717-6a5ab1648b87?im_w=1200',9000,4.9,'AVALIABLE',NULL);



INSERT INTO house_images (url,house_id) VALUES
('https://a0.muscache.com/im/pictures/monet/Luxury-54140085/original/367a21ea-6714-4b4b-b897-4a147ed75633?im_w=1440',1),
('https://dismobel.es/decora/wp-content/uploads/2018/09/20.jpg',1),
('https://dismobel.es/decora/wp-content/uploads/2018/09/8.jpg',1),
('https://dismobel.es/decora/wp-content/uploads/2018/09/9.jpg',1),
('https://dismobel.es/decora/wp-content/uploads/2018/09/15.jpg',1),

('https://images.adsttc.com/media/images/546a/c924/e58e/cea7/5a00/0108/slideshow/PORTADA.jpg?1416284445',2),
('https://images.adsttc.com/media/images/546a/c8f2/e58e/cea7/5a00/0106/slideshow/_MG_8063_copia.jpg?1416284393',2),
('https://images.adsttc.com/media/images/546a/c91d/e58e/ce7d/2500/0119/slideshow/_MG_8174.jpg?1416284438',2),
('https://images.adsttc.com/media/images/546a/c7bc/e58e/ce7d/2500/0114/slideshow/_MG_7737.jpg?1416284083',2),

('https://a0.muscache.com/im/pictures/miso/Hosting-2328455/original/a4506c8c-70d8-4016-bc57-d64abbf2702d.jpeg?im_w=960',3),
('https://a0.muscache.com/im/pictures/miso/Hosting-2328455/original/d9f84fca-cdd4-49cc-b25c-0cda22f20a59.jpeg?im_w=1200',3),
('https://a0.muscache.com/im/pictures/miso/Hosting-2328455/original/40d9f3ac-7105-4436-9816-69e608127d23.jpeg?im_w=1200',3),
('https://a0.muscache.com/im/pictures/miso/Hosting-2328455/original/5337661e-84aa-480e-8bce-8a9bde843c5f.jpeg?im_w=1200',3),
('https://a0.muscache.com/im/pictures/dcea5986-2dba-4d00-a241-25b993dc8d9c.jpg?im_w=1200',3),

('https://a0.muscache.com/im/pictures/90b74311-6f55-41ea-8649-e0556b5c3e3e.jpg?im_w=720',4),
('https://a0.muscache.com/im/pictures/aec9cf69-4895-4d50-9d98-6058e6d17e2d.jpg?im_w=1200',4),
('https://a0.muscache.com/im/pictures/526bad60-5ca9-41e0-bc1b-93f801f6fa34.jpg?im_w=1200',4),
('https://a0.muscache.com/im/pictures/8bb7b751-3ddd-4278-9c9b-f5740397d091.jpg?im_w=1200',4),

('https://a0.muscache.com/im/pictures/monet/Select-14078693/original/c77d8ab0-68d5-4fb0-b68f-c5f13de9cdcc?im_w=1200',5),
('https://a0.muscache.com/im/pictures/15a04524-f84c-48ad-8018-935d669f9c18.jpg?im_w=1200',5),
('https://a0.muscache.com/im/pictures/monet/Select-14078693/original/bf7f8ae4-284d-4168-b9eb-c272a10f3e5e?im_w=1200',5),
('https://a0.muscache.com/im/pictures/monet/Select-14078693/original/7cef60aa-1d70-4f46-97b9-6577883e683e?im_w=1200',5),
('https://a0.muscache.com/im/pictures/04d4cb8e-1711-469e-abdb-4ca8bac85f16.jpg?im_w=1200',5),

('https://a0.muscache.com/im/pictures/monet/Luxury-681893103779865400/original/9bfe944c-bf7d-492e-b717-6a5ab1648b87?im_w=1200',6),
('https://a0.muscache.com/im/pictures/monet/Luxury-681893103779865400/original/5bfd128a-5eff-4db1-8cf5-d8990b8d7ea4?im_w=1200',6),
('https://a0.muscache.com/im/pictures/monet/Luxury-681893103779865400/original/a5c08c83-29d1-409a-8607-cc1296efa725?im_w=720',6),
('https://a0.muscache.com/im/pictures/monet/Luxury-681893103779865400/original/1c5d9ed9-7d3f-4b3a-b345-e486104cc934?im_w=720',6);

INSERT INTO tags (tag) VALUES 
('En el campo'),
('Con vistas'),
('Diseño'),
('Viñedos'),
('Popular'),
('Piscina'),
('En la playa'),
('Mansion');

INSERT INTO tags_house (tags_tag,house_id) VALUES
('En el campo',1),
('Con vistas',1),
('Diseño',1),
('Viñedos',1),

('Piscina',2),
('Con vistas',2),
('En el campo',2),
('Popular',2),

('En el campo',3),
('Con vistas',3),
('Diseño',3),

('En la playa',4),
('Con vistas',4),
('Diseño',4),
('Popular',4),

('En el campo',5),
('Con vistas',5),
('Mansion',5),
('Diseño',5),
('Viñedos',5),

('Piscina',6),
('Con vistas',6),
('En el campo',6),
('Popular',6)
;

