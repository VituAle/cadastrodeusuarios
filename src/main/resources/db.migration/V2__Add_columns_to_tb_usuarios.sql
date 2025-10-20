-- V2__Add_columns_to_tb_usuarios.sql
-- Adiciona as colunas cpf, telefone e endereco à tabela de usuários

ALTER TABLE tb_usuarios
ADD COLUMN cpf VARCHAR(14) NOT NULL UNIQUE AFTER email,
ADD COLUMN telefone VARCHAR(20) NULL AFTER cpf,
ADD COLUMN endereco VARCHAR(255) NULL AFTER telefone;
