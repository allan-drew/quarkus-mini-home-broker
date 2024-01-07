-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;



-- ESCRITURADORES
INSERT INTO t_escrituradores (id, nome_escriturador) VALUES
	(1, 'Bradesco'),
	(2, 'Banco do Brasil S.A.'),
	(3, 'Itau Corretora de Acoes'),
	(4, 'Banco Mercantil do Brasil S.A.'),
	(5, 'Banco do Nordeste do Brasil S.A.'),
	(6, 'Itau Unibanco S.A');

-- INVESTIDORES
INSERT INTO t_investidores (id, nome, sobrenome, email, anoNascimento) VALUES
	(1, 'Miguel', 'Fernandes' , 'miguel.almeida@gmail.com', '1994'),
	(2, 'Gael', 'Alves', 'gael.alves@gmail.com','2004'),
	(3, 'Maria', 'Barros', 'mariaaabarros@yahoo.com','1980'),
	(4, 'Arthur', 'Andrade', 'ar.thurr@gmail.com','1970'),
	(5, 'Helena', 'Oliveira', 'helena.oliv93@hotmail.com','1993'),
	(6, 'Heitor', 'Barbosa', 'heitorbarbosasilveira@gmail.com','2005'),
	(7, 'Alice', 'Ribeiro', 'alic1998ribeiro@gmail.com','1998'),
	(8, 'Theo', 'Duarte', 'theoduarte@gmail.com','1995'),
	(9, 'Laura', 'Almeida', 'laura.almeida@gmail.com','1985'),
	(10, 'Davi', 'Gomes', 'davi.gomes@gmail.com','2002'),
	(11, 'Samuel', 'Pereira', 'samu.capereira@hotmail.com','1987'),
	(12, 'Bernardo', 'Silva', 'bersilvaaa@gmail.com','1990'),
	(13, 'Gabriel', 'Silva', 'gabisi89@gmail.com','1989'),
	(14, 'Ravi', 'Reis', 'ravireis@gmail.com','2001'),
	(15, 'João', 'Miranda', 'joaooomiranda@yahoo.com','1975'),
	(16, 'Cecilia', 'Lima', 'eucecilialima@gmail.com','1997'),
	(17, 'Maite', 'Moura', 'maitemoura@hotmail.com','1991'),
	(18, 'Lucas', 'Lopes', 'lukazlopes@gmail.com','1988'),
	(19, 'Heloisa', 'Cruz', 'helocruz@gmail.com','1994'),
	(20, 'Tiago', 'Marques', 'timarques@bol.com','1971');

-- INVESTIMENTO (ACOES)
INSERT INTO t_investimentos (DTYPE, id, precoUnitario, descricao, tipo_da_acao, ticker, empresa, escriturador_fk) VALUES
	('Acoes', 1, 39.20, 'acao petrobras', 'ACAO_ON', 'PETR3', 'Petróleo Brasileiro S.A', 1),
	('Acoes', 2, 54.94, 'acao BB', 'ACAO_ON', 'BBAS3', 'Banco do Brasil S.A', 2),
	('Acoes', 3, 76.6, 'acao vale', 'ACAO_ON', 'VALE3', 'Vale S.A.', 1),
	('Acoes', 4, 16.88, 'acao bradesco preferencial', 'ACAO_PN', 'BBDC4', 'Banco Bradesco S.A.', 1),
	('Acoes', 5, 17.58, 'acao lojas renner', 'ACAO_ON', 'LREN3', 'Petróleo Brasileiro S.A', 1),
	('Acoes', 6, 20.20, 'acao banco mercantil', 'ACAO_ON', 'BMEB3', 'Banco Mercantil do Brasil S.A.', 4),
	('Acoes', 7, 33.61, 'acao BB seguridade', 'ACAO_ON', 'BBSE3', 'BB Seguridade Participacoes S.A.', 2),
	('Acoes', 8, 28.64, 'acao itau', 'ACAO_ON', 'ITUB3', 'Itau Unibanco Holding S.A.', 3),
	('Acoes', 9, 10.38, 'acao itausa', 'ACAO_ON', 'ITSA3', 'Itausa S.A', 3),
	('Acoes', 10, 11.79, 'acao odontoprev', 'ACAO_ON', 'ODPV3', 'Odontoprev S.A.', 1),
	('Acoes', 11, 29.00, 'acao porto seguro', 'ACAO_ON', 'PSSA3', 'Porto Seguro S.A', 3),
	('Acoes', 12, 33.53, 'acao totvs', 'ACAO_ON', 'TOTS3', 'Totvs S.A', 3),
	('Acoes', 13, 44.79, 'acao engie', 'ACAO_ON', 'EGIE3', 'Engie Brasil Energia S.A.', 3);


-- INVESTIMENTO (TESOURO DIRETO)
INSERT INTO t_investimentos (DTYPE, id, precoUnitario, descricao, tipo_do_tesouro, data_de_vencimento, rentabilidade_anual_do_titulo, investimento_minimo) VALUES
	('TesouroDireto', 14, 830.82, 'Tesouro Prefixado 2026', 'PREFIXADO', '2026-01-01', 9.63, 33.23),
	('TesouroDireto', 15, 618.21, 'Tesouro Prefixado 2029', 'PREFIXADO', '2029-01-01', 10.13, 30.91),
	('TesouroDireto', 16, 14243.66, 'Tesouro SELIC 2026', 'SELIC', '2026-03-01', 0.0435, 142.43),
	('TesouroDireto', 17, 14138.56, 'Tesouro SELIC 2029', 'SELIC', '2029-03-01', 0.1625, 141.38),
	('TesouroDireto', 18, 3190.97, 'Tesouro IPCA+ 2029', 'IPCA_MAIS', '2029-05-15', 5.17, 31.90),
	('TesouroDireto', 19, 2331.64, 'Tesouro IPCA+ 2035', 'IPCA_MAIS', '2035-05-15', 5.29, 46.63),
	('TesouroDireto', 20, 1338.56, 'Tesouro IPCA+ 2045', 'IPCA_MAIS', '2045-05-15', 5.50, 40.15);



-- ORDEM DE COMPRA
INSERT INTO t_ordem_compra (id, investidor_fk, investimento_fk, data_ordem_de_compra) VALUES
    (1, 3, 14,'2022-06-18'),
    (2, 19, 20,'2023-02-11'),
    (3, 13, 10,'2019-06-10'),
    (4, 1, 3,'2015-06-18'),
    (5, 4, 9,'2014-06-10'),
    (6, 15, 10,'2019-02-02'),
    (7, 3, 19,'2021-06-08'),
    (8, 3, 20,'2023-07-02'),
    (9, 10, 17,'2020-06-01'),
    (10, 12, 9,'2018-10-10'),
    (11, 12, 2,'2019-10-03'),
    (12, 13, 3,'2019-06-06'),
    (13, 18, 7,'2017-05-30'),
    (14, 20, 12,'2021-11-12'),
    (15, 1, 2,'2013-01-07'),
    (16, 2, 10,'2020-09-18'),
    (17, 14, 12,'2019-11-18'),
    (18, 12, 3,'2015-09-18'),
    (19, 20, 2,'2019-06-22'),
    (20, 17, 9,'2018-10-10'),
    (21, 11, 10,'2019-09-18'),
    (22, 6, 19,'2016-05-10'),
    (23, 5, 11,'2017-01-23'),
    (24, 1, 2,'2019-03-18'),
    (25, 14, 2,'2023-08-19');


--ALTER SEQUENCE hibernate_sequence RESTART WITH 600;
ALTER SEQUENCE t_escrituradores_SEQ RESTART WITH 600;
ALTER SEQUENCE t_investimentos_SEQ RESTART WITH 600;
ALTER SEQUENCE t_investidores_SEQ RESTART WITH 600;
ALTER SEQUENCE t_ordem_compra_SEQ RESTART WITH 600;



