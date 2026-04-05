-- create_table_item_menu

CREATE TABLE IF NOT EXISTS item_menu (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    uuid UUID NOT NULL,
    base_64_image TEXT NOT NULL,
    descricao_alt_image VARCHAR(255) NOT NULL,
    nome VARCHAR(155) NOT NULL,
    descricao VARCHAR(155) NOT NULL,
    categoria VARCHAR(30) NOT NULL,
    ativo BOOL NOT NULL,
    data_criacao TIMESTAMP NOT NULL
);