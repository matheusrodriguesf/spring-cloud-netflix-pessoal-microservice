CREATE TABLE IF NOT EXISTS tb_produto(
    id_produto SERIAL primary key,
    nome_produto VARCHAR(100) NOT NULL,
    descricao_produto VARCHAR(100) NOT NULL,
    preco_produto DECIMAL(10,2) NOT NULL,
    estoque_produto INT NOT NULL
);
