-- Criação da tabela
CREATE TABLE tb_usuarios (
    id BINARY(16) NOT NULL PRIMARY KEY,
    nomedousuario VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);