use [Loja];
GO

-- Tabela Usuario
CREATE TABLE [Usuario] (
  idUsuario INT IDENTITY(1,1) PRIMARY KEY,
  Login VARCHAR(20) NULL,
  Senha VARCHAR(20) NULL
);
GO

-- Inserindo dados na tabela Usuario
INSERT INTO [Usuario] (Login, Senha)
VALUES ('op1', 'op1'), ('op2', 'op2');

SELECT * FROM [Usuario];
GO



/*======================================================================================================================*/

-- Tabela Produto
CREATE TABLE [Produto] (
  idProduto INT IDENTITY(1,1) NOT NULL,
  nome VARCHAR(255) NULL,
  quantidade INT NULL,
  precoVenda FLOAT,
  PRIMARY KEY (idProduto)
);

-- Inserindo dados na tabela Produto
INSERT INTO [Produto] (nome, quantidade, precoVenda)
VALUES ('Banana', 100, 5.01),
       ('Laranja', 500, 2.02),
       ('Manga', 800, 4.03);

SELECT * FROM [Produto];
GO

/*======================================================================================================================*/

-- Tabela Pessoa
CREATE TABLE [Pessoa] (
  idPessoa INT IDENTITY(1,1) NOT NULL,
  nome VARCHAR(255) NULL,
  logradouro VARCHAR(255) NULL,
  cidade VARCHAR(255) NULL,
  estado CHAR(2) NULL,
  telefone VARCHAR(11) NULL,
  email VARCHAR(255) NULL,
  PRIMARY KEY (idPessoa)
);

-- Inserindo dados na tabela Pessoa
INSERT INTO [Pessoa] (nome, logradouro, cidade, estado, telefone, email)
VALUES ('Wallace Felipe Tavares', 'Rua Chile', 'Rio de Janeiro', 'RJ', '11991876543', 'wfelipe@gmail.com'),
       ('Felipe Wallace Tavares', 'Rua Chile', 'Rio de Janeiro', 'RJ', '12345678909', 'wfeli@gmail.com'),
       ('Bingo Trêsbolas', 'Rua Ana Augusta', 'Rio de Janeiro', 'RJ', '11991098789', 'wfee@gmail.com'),
       ('Padaria Norte', 'Rua México', 'Rio de Janeiro', 'RJ', '11909878654', 'lipe@gmail.com');

DROP TABLE IF EXISTS [Pessoa];
DROP TABLE [Pessoa];
SELECT * FROM [Pessoa];
GO


/*======================================================================================================================*/

-- Tabela PessoaJuridica
CREATE TABLE [PessoaJuridica] (
  idPessoaJuridica INT IDENTITY(1,1) NOT NULL,
  idPessoa INT NOT NULL,
  nome VARCHAR(255) NULL,
  logradouro VARCHAR(255) NULL,
  cidade VARCHAR(255) NULL,
  estado CHAR(2) NULL,
  telefone VARCHAR(11) NULL,
  email VARCHAR(255) NULL,
  CNPJ VARCHAR(14) NULL,
  PRIMARY KEY (idPessoaJuridica),
  CONSTRAINT FK_PessoaJuridica_Pessoa 
  FOREIGN KEY (idPessoa)
  REFERENCES [Pessoa] (idPessoa)
);

-- Inserindo dados na tabela PessoaJuridica
INSERT INTO [PessoaJuridica] (idPessoa, nome, logradouro, cidade, estado, telefone, email, CNPJ)
VALUES (1, 'Nome PJ 1', 'Rua PJ 1', 'Cidade PJ 1', 'RJ', '12345678901', 'emailpj1@gmail.com', '18263258000146'),
       (2, 'Nome PJ 2', 'Rua PJ 2', 'Cidade PJ 2', 'RJ', '12345678902', 'emailpj2@gmail.com', '18263258000146');


-- Atualização dos dados na PessoaJuridica com os CNPJ
UPDATE [PessoaJuridica]
SET CNPJ = '18263258000146'
WHERE idPessoaJuridica = 1;

UPDATE [PessoaJuridica]
SET CNPJ = '18263258000146'
WHERE idPessoaJuridica = 2;

DROP TABLE IF EXISTS [PessoaJuridica];
DROP TABLE [PessoaJuridica];
SELECT * FROM [PessoaJuridica];
GO

/*======================================================================================================================*/

-- Tabela PessoaFisica
CREATE TABLE [PessoaFisica] (
  idPessoaFisica INT IDENTITY(1,1) NOT NULL,
  idPessoa INT NOT NULL,
  nome VARCHAR(255) NULL,
  logradouro VARCHAR(255) NULL,
  cidade VARCHAR(255) NULL,
  estado CHAR(2) NULL,
  telefone VARCHAR(11) NULL,
  email VARCHAR(255) NULL,
  CPF VARCHAR(14) NULL,
  PRIMARY KEY(idPessoaFisica),
  CONSTRAINT FK_PessoaFisica_Pessoa 
  FOREIGN KEY (idPessoa)
  REFERENCES [Pessoa] (idPessoa)
);

INSERT INTO [PessoaFisica] (idPessoa, nome, logradouro, cidade, estado, telefone, email, CPF)
VALUES (3, 'Nome PF 1', 'Rua PF 1', 'Cidade PF 1', 'RJ', '12345678903', 'emailpf1@gmail.com',  '022094775-40'),
       (4, 'Nome PF 2', 'Rua PF 2', 'Cidade PF 2', 'RJ', '12345678904', 'emailpf2@gmail.com', '022055785-50');


-- Atualização dos dados na tabela PessoaFisica com os CPF
UPDATE [PessoaFisica]
SET CPF = '022094775-40'
WHERE idPessoaFisica = 1;

UPDATE [PessoaFisica]
SET CPF = '022055785-50'
WHERE idPessoaFisica = 2;

DROP TABLE IF EXISTS [PessoaFisica];
DROP TABLE [PessoaFisica];
SELECT * FROM [PessoaFisica];
GO

/*======================================================================================================================*/

-- Tabela Movimentacao
CREATE TABLE [Movimentacao] (
  id_movimento INT IDENTITY(1,1) NOT NULL,
  idUsuario INT NULL,
  idPessoa INT NULL,
  idProduto INT NULL,
  quantidade INT NOT NULL,
  tipo CHAR(1) NULL,
  valor_unitario FLOAT NULL,
  CONSTRAINT PK_Movimentacao PRIMARY KEY (id_movimento),
  CONSTRAINT FK_Usuario FOREIGN KEY (idUsuario)
    REFERENCES [Usuario] (idUsuario),
  CONSTRAINT FK_Pessoa FOREIGN KEY (idPessoa)
    REFERENCES [Pessoa] (idPessoa),
  CONSTRAINT FK_Produto FOREIGN KEY (idProduto)
    REFERENCES [Produto] (idProduto)
);

-- Inserindo dados na tabela Movimentacao
INSERT INTO [Movimentacao] (idUsuario, idPessoa, idProduto, quantidade, tipo, valor_unitario)
VALUES (1, 1, 1, 150, 'E', 8.90),
       (2, 2, 2, 150, 'S', 8.90);

DROP TABLE IF EXISTS [Movimentacao];
DROP TABLE [Movimentacao];
SELECT * FROM [Movimentacao];