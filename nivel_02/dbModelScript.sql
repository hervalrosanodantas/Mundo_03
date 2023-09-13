-- Criando Banco de dados ==> loja
 DATABASE loja


-- ========== TABELAS ===========

-- Tabela Usuários

CREATE TABLE usuarios (
  id_usuario INTEGER NOT NULL IDENTITY,
  usuario_Login VARCHAR(20),
  usuario_Senha VARCHAR(20),
PRIMARY KEY(id_usuario));
GO


-- Tabela Pessoa
CREATE TABLE pessoa (
  id_Pessoa INTEGER NOT NULL IDENTITY PRIMARY KEY,
  nome VARCHAR(255),
  endereco VARCHAR(255),
  cidade VARCHAR(255),
  estado CHAR(2),
  telefone VARCHAR(15),
  email VARCHAR(255) );
GO

-- Tabela Pessoa Juridica
CREATE TABLE pessoaJuridica (
  id_PJ INTEGER NOT NULL PRIMARY KEY,
  cnpj VARCHAR(20) NOT NULL,
  id_PessoaJuridica INTEGER NOT NULL,
  FOREIGN KEY(id_PessoaJuridica)
    REFERENCES dbo.pessoa(id_Pessoa)
    ON DELETE CASCADE ON UPDATE CASCADE -- Se os dados referente a pessoa for deletado, o cnpj dela tb
);

-- Tabela Pessoa Fisica
CREATE TABLE pessoaFisica (
  id_PF INTEGER NOT NULL IDENTITY PRIMARY KEY,
  cpf VARCHAR(11) NOT NULL,
  id_PessoaFisica INTEGER NOT NULL,
  FOREIGN KEY(id_PessoaFisica)
    REFERENCES dbo.pessoa(id_Pessoa) 
    ON DELETE CASCADE ON UPDATE CASCADE -- Se os dados referente a pessoa for deletado, o cnpj dela tb
);


GO


CREATE INDEX pessoaJuridica_FKIndex1 ON pessoaJuridica (pessoa_id_Pessoa);
GO


CREATE INDEX IFK_fornecedor ON pessoaJuridica (pessoa_id_Pessoa);
GO


CREATE TABLE pessoaFisica (
  pessoa_id_Pessoa INTEGER NOT NULL,
  cpf VARCHAR(11) NOT NULL,
PRIMARY KEY(pessoa_id_Pessoa),
  FOREIGN KEY(pessoa_id_Pessoa)
    REFERENCES pessoa(id_Pessoa));
GO


CREATE INDEX pessoaFisica_FKIndex1 ON pessoaFisica (pessoa_id_Pessoa);
GO


CREATE INDEX IFK_cliente ON pessoaFisica (pessoa_id_Pessoa);
GO

CREATE TABLE produto (
  id_Produto INTEGER NOT NULL,
  nome_Produto VARCHAR(255) NOT NULL,
  quantidade_Produto INTEGER,
  preco_Venda_Produto FLOAT,
PRIMARY KEY(id_Produto));
GO

CREATE TABLE movimento (
  id_movimento INTEGER  NOT NULL   IDENTITY ,
  pessoa_id_Pessoa INTEGER  NOT NULL,
  usuarios_id_usuario INTEGER  NOT NULL,
  produto_id_Produto INTEGER  NOT NULL,
  tipo_movimento CHAR(1),
  valor_Unitario FLOAT  ,
PRIMARY KEY(id_movimento)  ,
  FOREIGN KEY(produto_id_Produto)
    REFERENCES produto(id_Produto),
  FOREIGN KEY(usuarios_id_usuario)
    REFERENCES usuarios(id_usuario),
  FOREIGN KEY(pessoa_id_Pessoa)
    REFERENCES pessoa(id_Pessoa));
GO


CREATE INDEX movimento_FKIndex1 ON movimento (produto_id_Produto);
GO
CREATE INDEX movimento_FKIndex2 ON movimento (usuarios_id_usuario);
GO
CREATE INDEX movimento_FKIndex3 ON movimento (pessoa_id_Pessoa);
GO


CREATE INDEX IFK_ItensMovimentados ON movimento (produto_id_Produto);
GO
CREATE INDEX IFK_Operador ON movimento (usuarios_id_usuario);
GO
CREATE INDEX IFK_Responsavel ON movimento (pessoa_id_Pessoa);
GO


