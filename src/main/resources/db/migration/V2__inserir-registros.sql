INSERT INTO estoque(id_estoque) VALUES (1);

INSERT INTO produto(nm_produto, cd_produto, vl_unitario, categoria, fabricante, qtd_produto, id_estoque)
VALUES 
    ('Refr. Coca-Cola LT 600ml', '5320305', 6.50, 'LIQUIDO', 'Coca-Cola', 10, 1),
    ('Refr. Guarana Antartica PET 2L', '6712485', 10.50, 'LIQUIDO', 'Guarana Antartica', 15, 1),
    ('Deterg. Liquido Ype 400ml neutro', '479315151', 10.50, 'LIMPEZA', 'Ype', 5, 1);
