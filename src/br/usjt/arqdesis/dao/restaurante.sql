CREATE SCHEMA restaurante;

USE restaurante;

CREATE TABLE mercadoria
(
	`id`			INT				NOT NULL	AUTO_INCREMENT,
    `descricao`		VARCHAR(100)	NOT NULL,
    `preco`			DECIMAL(10,2)	NOT NULL,
    `tipo`          VARCHAR(100)    NOT NULL,    
    PRIMARY KEY		(`id`)
);

CREATE TABLE compra
(
	`id`			INT				NOT NULL	AUTO_INCREMENT,
    `data`			VARCHAR(10)		NOT NULL,
    PRIMARY KEY		(`id`)
);

CREATE TABLE itemcompra
(
	`id`			INT				NOT NULL	AUTO_INCREMENT,
    `idcompra`		INT				NOT NULL,
    `idmercadoria`	INT				NOT NULL,
    `idtipo`        INT             NOT NULL,
    `quantidade`	INT				NOT NULL,
    PRIMARY KEY		(`id`),
    
    CONSTRAINT		`fk_itemcompra_compra`
    FOREIGN KEY		(`idcompra`)
    REFERENCES		`compra` (`id`),
    
    CONSTRAINT		`fk_itemcompra_mercadoria`
    FOREIGN KEY		(`idmercadoria`)
    REFERENCES		`mercadoria` (`id`)
);

CREATE TABLE pagamento
(
	`id`			INT				NOT NULL	AUTO_INCREMENT,
    `data`			VARCHAR(10)		NOT NULL,
    `valor`			VARCHAR(45)		NOT NULL,
    `idcompra`		INT				NOT NULL,
    PRIMARY KEY		(`id`),
    
    CONSTRAINT		`fk_pagamento_compra`
    FOREIGN KEY		(`idcompra`)
    REFERENCES		`compra` (`id`)
);

insert into mercadoria (id,descricao,preco,tipo) values (1,'filé de frango', 8.70,'prato');
insert into mercadoria (id,descricao,preco,tipo) values (2,'bifé', 8.90,'prato');
insert into mercadoria (id,descricao,preco,tipo) values (3,'picanha', 10.90,'prato');
insert into mercadoria (id,descricao,preco,tipo) values (4,'filé de peixe', 9.70,'prato');
insert into mercadoria (id,descricao,preco,tipo) values (5,'ovos fritos', 2.70,'prato');
insert into mercadoria (id,descricao,preco,tipo) values (6,'macarroni', 5.70,'prato');
insert into mercadoria (id,descricao,preco,tipo) values (7,'carne ao molho', 8.70,'prato');
insert into mercadoria (id,descricao,preco,tipo) values (8,'Suco de laranja 400ml', 3.50,'bebida');
insert into mercadoria (id,descricao,preco,tipo) values (9,'suco de maracujar400ml', 4.10,'bebida');
insert into mercadoria (id,descricao,preco,tipo) values (10,'suco de limão 400ml', 2.99,'bebida');
insert into mercadoria (id,descricao,preco,tipo) values (11,'cerveja lata 350ml', 8.70,'bebida');
insert into mercadoria (id,descricao,preco,tipo) values (12,'pinga 50ml', 4.70,'bebida');
insert into mercadoria (id,descricao,preco,tipo) values (13,'água mineral 500ml', 2.00,'bebida');
insert into mercadoria (id,descricao,preco,tipo) values (14,'ki suco laranja 500ml', 1.70,'bebida');
insert into mercadoria (id,descricao,preco,tipo) values (15,'ki suco maracujar 500ml', 1.70,'bebida');
insert into mercadoria (id,descricao,preco,tipo) values (16,'pudim', 1.99,'sobremesa');
insert into mercadoria (id,descricao,preco,tipo) values (17,'açai tigela ', 7.80,'sobremesa');
insert into mercadoria (id,descricao,preco,tipo) values (18,'bolo no ponte', 3.50,'sobremesa');
insert into mercadoria (id,descricao,preco,tipo) values (19,'sorvete casquinha', 1.70,'sobremesa');
insert into mercadoria (id,descricao,preco,tipo) values (20,'sorvete ponte', 2.70,'sobremesa');











