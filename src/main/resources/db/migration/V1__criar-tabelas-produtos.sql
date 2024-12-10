-- Tabela de Fornecedores
CREATE TABLE fornecedor (
    id_fornecedor INT AUTO_INCREMENT PRIMARY KEY,
    nome_fornecedor VARCHAR(100) NOT NULL,
    pessoa_contato VARCHAR(100),
    telefone VARCHAR(20),
    email VARCHAR(100),
    endereco TEXT
);

-- Tabela de Clientes
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(100) NOT NULL,
    pessoa_contato VARCHAR(100),
    telefone VARCHAR(20),
    email VARCHAR(100),
    endereco TEXT
);

-- Tabela de Estoque
CREATE TABLE estoque (
    id_estoque INT AUTO_INCREMENT PRIMARY KEY,
    qtd_total INT NOT NULL DEFAULT 0,
    dt_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dt_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de Produtos
CREATE TABLE produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nm_produto VARCHAR(200) NOT NULL,
    cd_produto VARCHAR(50) UNIQUE NOT NULL,
    vl_unitario DECIMAL(10, 2) NOT NULL,
    categoria VARCHAR(100),
    fabricante VARCHAR(100),
    qtd_produto INT NOT NULL DEFAULT 0,
    dt_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dt_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_estoque INT NOT NULL,
    CONSTRAINT fk_estoque FOREIGN KEY (id_estoque) REFERENCES estoque(id_estoque),
    CHECK (vl_unitario >= 0)
);

-- Tabela de Pedidos de Compra
CREATE TABLE pedido_compra (
    id_pedido_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_fornecedor INT NOT NULL,
    data_pedido DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'Pendente',  -- Usando VARCHAR e uma restrição CHECK se necessário
    custo_total DECIMAL(12, 2) NOT NULL,
    CONSTRAINT fk_fornecedor FOREIGN KEY (id_fornecedor) REFERENCES fornecedor(id_fornecedor),
    CHECK (custo_total >= 0)
);

-- Tabela de Itens do Pedido de Compra
CREATE TABLE item_pedido_compra (
    id_item_pedido_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido_compra INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_pedido_compra FOREIGN KEY (id_pedido_compra) REFERENCES pedido_compra(id_pedido_compra),
    CONSTRAINT fk_produto FOREIGN KEY (id_produto) REFERENCES produto(id_produto),
    CHECK (quantidade > 0),
    CHECK (preco_unitario >= 0)
);

-- Tabela de Pedidos de Venda
CREATE TABLE pedido_venda (
    id_pedido_venda INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    data_pedido DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'Pendente',  -- Usando VARCHAR e uma restrição CHECK se necessário
    valor_total DECIMAL(12, 2) NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    CHECK (valor_total >= 0)
);

-- Tabela de Itens do Pedido de Venda
CREATE TABLE item_pedido_venda (
    id_item_pedido_venda INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido_venda INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_pedido_venda FOREIGN KEY (id_pedido_venda) REFERENCES pedido_venda(id_pedido_venda),
    CONSTRAINT fk_produto_venda FOREIGN KEY (id_produto) REFERENCES produto(id_produto),
    CHECK (quantidade > 0),
    CHECK (preco_unitario >= 0)
);
