CREATE SCHEMA ecommerce;

CREATE TABLE ecommerce.categorie ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	nom                  varchar(15)  NOT NULL    ,
	id_parent            int      
 ) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

CREATE TABLE ecommerce.hibernate_sequence ( 
	next_val             bigint      
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE ecommerce.produit ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	nom                  varchar(60)  NOT NULL    ,
	prix                 float  NOT NULL    ,
	description          text      
 ) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

CREATE TABLE ecommerce.produit_categorie ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	idproduit            int  NOT NULL    ,
	idcategorie          int  NOT NULL    ,
	CONSTRAINT unq_produit_categorie_idproduit UNIQUE ( idproduit ) ,
	CONSTRAINT fk_produit_categorie_categorie FOREIGN KEY ( idcategorie ) REFERENCES ecommerce.categorie( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT fk_produit_categorie_produit FOREIGN KEY ( idproduit ) REFERENCES ecommerce.produit( id ) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

CREATE TABLE ecommerce.produit_image ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	idproduit            int  NOT NULL    ,
	nomimage             varchar(26)  NOT NULL    ,
	CONSTRAINT fk_produit_image_produit_categorie FOREIGN KEY ( idproduit ) REFERENCES ecommerce.produit_categorie( idproduit ) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE ecommerce.produit_produit_categorie ( 
	`Produit_id`         int  NOT NULL    ,
	list_categorie_id    int  NOT NULL    ,
	listcategorie_id     int  NOT NULL    ,
	CONSTRAINT pk_produit_produit_categorie PRIMARY KEY ( `Produit_id`, list_categorie_id ),
	CONSTRAINT `UK_ra68f5qrydqq9ch2j8uxsljfd` UNIQUE ( list_categorie_id ) ,
	CONSTRAINT `UK_m55kpwb5la8pu3kx2bymdxpga` UNIQUE ( listcategorie_id ) ,
	CONSTRAINT `FKgatnef6cukl8iotv8ovq5i7t5` FOREIGN KEY ( list_categorie_id ) REFERENCES ecommerce.produit_categorie( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT `FKismhnhe1hgjmhkxti62rpllqh` FOREIGN KEY ( `Produit_id` ) REFERENCES ecommerce.produit( id ) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT `FKsubpbt9u3c05i7dn186nbff3v` FOREIGN KEY ( listcategorie_id ) REFERENCES ecommerce.produit_categorie( id ) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE INDEX fk_produit_categorie_categorie ON ecommerce.produit_categorie ( idcategorie );

CREATE INDEX fk_produit_image_produit_categorie ON ecommerce.produit_image ( idproduit );

INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 1, 'pantalon', null);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 2, 'vêtement', null);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 3, 'chaussure', null);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 4, 'tennis', 3);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 5, 'pulle', 2);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 6, 'short', 1);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 7, 'class', 1);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 8, 'jogging', 1);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 9, 'blouson', 2);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 10, 'impermeable', 2);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 11, 'polo', 2);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 12, 'botte', 3);
INSERT INTO ecommerce.categorie( id, nom, id_parent ) VALUES ( 13, 'nike', 3);
INSERT INTO ecommerce.hibernate_sequence( next_val ) VALUES ( 22);
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 1, 'chemise', 29090.0, 'Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu.');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 2, 'pantalon', 48073.0, 'lobortis, nisi nibh lacinia orci, consectetuer euismod est arcu ac orci. Ut semper pretium neque. Morbi quis');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 3, 't-shirt', 118723.0, 'magna nec quam. Curabitur vel lectus. Cum sociis natoque penatibus et magnis dis');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 4, 'tennis', 155441.0, 'tempus scelerisque, lorem ipsum sodales purus, in molestie tortor nibh sit amet');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 5, 'tennis', 136914.0, 'Pellentesque ut ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 6, 'pantalon', 22583.0, 'non enim commodo hendrerit. Donec porttitor tellus non magna. Nam ligula elit, pretium et,');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 7, 'basket', 12683.0, 'sagittis placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla ante, iaculis nec, eleifend non, dapibus rutrum,');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 8, 'tennis', 11557.0, 'Nulla facilisi. Sed neque. Sed eget lacus. Mauris non dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu.');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 9, 'basket', 155364.0, 'Curae Donec tincidunt. Donec vitae erat vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 10, 'basket', 215262.0, 'mauris sit amet lorem semper auctor. Mauris vel turpis. Aliquam adipiscing lobortis risus. In');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 11, 'jupe', 166907.0, 'metus. Vivamus euismod urna. Nullam lobortis quam a felis ullamcorper viverra.');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 12, 't-shirt', 179970.0, 'pretium neque. Morbi quis urna. Nunc quis arcu vel quam dignissim pharetra.');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 13, 'robe', 198501.0, 'non, lobortis quis, pede. Suspendisse dui. Fusce diam nunc, ullamcorper eu, euismod ac, fermentum vel, mauris. Integer');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 14, 'chemise', 171792.0, 'augue, eu tempor erat neque non quam. Pellentesque habitant morbi tristique senectus et netus');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 15, 't-shirt', 81693.0, 'lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec luctus aliquet odio. Etiam ligula tortor, dictum');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 16, 't-shirt', 14914.0, 'mauris. Integer sem elit, pharetra ut, pharetra sed, hendrerit a, arcu. Sed et libero. Proin mi. Aliquam gravida');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 17, 'bottes', 204865.0, 'ultrices a, auctor non, feugiat nec, diam. Duis mi enim, condimentum eget, volutpat ornare, facilisis eget,');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 18, 'jupe', 226920.0, 'Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque.');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 19, 'basket', 69842.0, 'Maecenas mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate, lacus. Cras interdum. Nunc sollicitudin');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 20, 'tennis', 156563.0, 'vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aliquam auctor,');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 21, 'sweat', 236064.0, 'risus odio, auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum nec, euismod');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 22, 'short', 95164.0, 'sed dictum eleifend, nunc risus varius orci, in consequat enim diam vel arcu. Curabitur ut odio vel');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 23, 'bottes', 96048.0, 'tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam fringilla cursus purus. Nullam scelerisque neque');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 24, 't-shirt', 229408.0, 'vitae risus. Duis a mi fringilla mi lacinia mattis. Integer eu');
INSERT INTO ecommerce.produit( id, nom, prix, description ) VALUES ( 25, 'robe', 110902.0, 'sit amet ornare lectus justo eu arcu. Morbi sit amet massa. Quisque porttitor');
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 1, 1, 2);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 2, 2, 1);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 3, 3, 2);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 4, 4, 3);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 5, 5, 3);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 6, 6, 1);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 7, 7, 2);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 8, 8, 2);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 9, 9, 2);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 10, 10, 2);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 11, 11, 2);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 12, 12, 3);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 13, 13, 2);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 14, 14, 3);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 15, 15, 3);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 16, 16, 1);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 17, 17, 1);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 18, 18, 3);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 19, 19, 3);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 20, 20, 1);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 21, 21, 1);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 22, 22, 2);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 23, 23, 2);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 24, 24, 2);
INSERT INTO ecommerce.produit_categorie( id, idproduit, idcategorie ) VALUES ( 25, 25, 2);