-- Inserir um registro na tabela de Estoque
INSERT INTO estoque(qtd_total) 
VALUES (0);

-- Inserir produtos relacionados ao estoque
INSERT INTO produto(nm_produto, cd_produto, vl_unitario, categoria, fabricante, id_estoque)
VALUES 
    ('Refr. Coca-Cola LT 600ml', '5320305', 6.50, 'LIQUIDO', 'Coca-Cola', 1),
    ('Refr. Guarana Antartica PET 2L', '6712485', 10.50, 'LIQUIDO', 'Guarana Antartica', 1),
    ('Deterg. Liquido Ype 400ml neutro', '479315151', 10.50, 'LIMPEZA', 'Ype', 1);
