INSERT INTO partido (id, nome, sigla)
VALUES (DEFAULT, 'Partido dos Trabalhadores', 'PT'),
        (DEFAULT, 'Partido Liberal', 'PL'),
        (DEFAULT, 'Republicanos', 'PRB'),
        (DEFAULT, 'União Brasil', 'UNIAO'),
        (DEFAULT, 'Partido da Social Democracia Brasileira', 'PSDB'),
        (DEFAULT, 'Solidariedade', 'Solidariedade'),
        (DEFAULT, 'Movimento Democrático Brasileiro', 'MDB'),
        (DEFAULT, 'Partido Socialista Brasileiro', 'PSB'),
        (DEFAULT, 'Partido Renovador Trabalhista Brasileiro', 'PRTB');

INSERT INTO candidato (id, cargo, nome, num_cand, sigla_uf, partido_id)
VALUES (DEFAULT, 'PRESIDENTE', 'Lula', '13', NULL, 1),
       (DEFAULT, 'PRESIDENTE', 'Bolsonaro', '22', NULL, 2),

       (DEFAULT, 'GOVERNADOR', 'Tarcisio', '10', 'SP', 3),
       (DEFAULT, 'GOVERNADOR', 'Fernando Haddad', '13', 'SP', 1),

       (DEFAULT, 'GOVERNADOR', 'Jeronimo', '13', 'BA', 1),
       (DEFAULT, 'GOVERNADOR', 'Acm Neto', '44', 'BA', 4),

       (DEFAULT, 'GOVERNADOR', 'Raquel Lyra', '45', 'PE', 5),
       (DEFAULT, 'GOVERNADOR', 'Marilia Arraes', '77', 'PE', 6),

       (DEFAULT, 'GOVERNADOR', 'Paulo Dantas', '15', 'AL', 7),
       (DEFAULT, 'GOVERNADOR', 'Rodrigo Cunha', '44', 'AL', 4),

       (DEFAULT, 'GOVERNADOR', 'Wilson Lima', '44', 'AM', 4),
       (DEFAULT, 'GOVERNADOR', 'Eduardo Braga', '15', 'AM', 7),

       (DEFAULT, 'GOVERNADOR', 'Renato Casagrande', '40', 'ES', 8),
       (DEFAULT, 'GOVERNADOR', 'Manato', '22', 'ES', 2),

       (DEFAULT, 'GOVERNADOR', 'Eduardo Riedel', '45', 'MS', 5),
       (DEFAULT, 'GOVERNADOR', 'Capitão Contar', '28', 'MS', 9),

       (DEFAULT, 'GOVERNADOR', 'João', '40', 'PB', 8),
       (DEFAULT, 'GOVERNADOR', 'Pedro Cunha Lima', '45', 'PB', 5),

       (DEFAULT, 'GOVERNADOR', 'Coronel Marcos Rocha', '44', 'RO', 4),
       (DEFAULT, 'GOVERNADOR', 'Marcos Rogerio', '22', 'RO', 2),

       (DEFAULT, 'GOVERNADOR', 'Eduardo Leite', '45', 'RS', 5),
       (DEFAULT, 'GOVERNADOR', 'Onyx Lorenzoni', '22', 'RS', 2),

       (DEFAULT, 'GOVERNADOR', 'Jorginho Mello', '22', 'SC', 2),
       (DEFAULT, 'GOVERNADOR', 'Décio Lima', '13', 'SC', 1);




