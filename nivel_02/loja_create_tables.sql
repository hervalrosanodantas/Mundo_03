use [Loja];
/*======================================================================================================================*/

-- =============== Criando Tabela Usuário

CREATE TABLE [Usuario] (
  idUsuario INT IDENTITY(1,1) PRIMARY KEY,
  Login VARCHAR(20) NULL,
  Senha VARCHAR(20) NULL
); 

-- =============== Inserindo dados na tabela Usuario
INSERT INTO [Usuario] (Login, Senha)
VALUES ('op1', 'op1'), ('op2', 'op2');


SELECT * FROM [Usuario];


/*======================================================================================================================*/

-- =============== Criando Tabela Produto
CREATE TABLE [Produto] (
  idProduto INT IDENTITY(1,1) NOT NULL,
  nome VARCHAR(255) NULL,
  quantidade INT NULL,
  precoVenda FLOAT,
  PRIMARY KEY (idProduto)
);

-- =============== Inserindo dados na tabela Produto
INSERT INTO [Produto] (nome, quantidade, precoVenda)
VALUES ('Banana', 200, 7.30),
       ('Manga', 300, 8.90),
       ('Laranja', 600, 5.50),
       ('Maçã', 200, 3.00),
       ('Jaca', 50, 10.00),
       ('Goiaba', 400, 3.50),
       ('Pitomba', 100, 2.00);

SELECT * FROM [Produto];



/*======================================================================================================================*/

-- =============== Tabela Pessoa
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

-- =============== Inserindo dados na tabela Pessoa
INSERT INTO [Pessoa] (nome, logradouro, cidade, estado, telefone, email)
VALUES ('Herval Rosano Dantas', 'Rua Ituverava 866', 'Rio de Janeiro', 'RJ', '21991870000', 'hervaldantas@gmail.com'),
       ('Angela Agostinho da C. Dantas', 'Rua Araguaia 111', 'Rio de Janeiro', 'RJ', '11133328909', 'angeladantas@gmail.com'),
       ('Antonio Dantas', 'Rua Tirol 777', 'Rio de Janeiro', 'RJ', '11991098789', 'antoniodantas@gmail.com'),
       ('Renato Dantas', 'Rua México', 'Rio de Janeiro', 'RJ', '11909872222', 'renatodantas@gmail.com'),
        ('Rosângela Dantas', 'Rua Jose Venâncio 596', 'Rio de Janeiro', 'RJ', '33448822545', 'rosangeladantas@gmail.com'),
       ('Rossana Daguia Dantas', 'Rua Jose Venâncio 596', 'Rio de Janeiro', 'RJ', '4446786666', 'rossanadaguia@gmail.com'),
       ('Rosânia Cristina Dantas', 'Rua Jose Venâncio 596', 'Rio de Janeiro', 'RJ', '12345678444', 'rosaniacris@gmail.com'),
       ('Francisca Natália Dantas', 'Rua Jose Venâncio 596', 'Rio de Janeiro', 'RJ', '12345678111', 'chica@gmail.com'),
       ('Francisco Rafael Dantas', 'Rua Cascavel  2', 'Rio de Janeiro', 'RJ', '12345678904', 'ronsilsondantas2@gmail.com');

DROP TABLE IF EXISTS [Pessoa];
DROP TABLE [Pessoa];
SELECT * FROM [Pessoa];



/*======================================================================================================================*/

-- =============== Criando Tabela PessoaFisica
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

 -- =============== Inserindo Tabela PessoaFisica 
INSERT INTO [PessoaFisica] (idPessoa, nome, logradouro, cidade, estado, telefone, email, CPF)
VALUES (1,'Herval Rosano Dantas', 'Rua Ituverava 866', 'Rio de Janeiro', 'RJ', '21991870000', 'hervaldantas@gmail.com', '0111940066-55'),
       (2, 'Angela Agostinho da C. Dantas', 'Rua Araguaia 111', 'Rio de Janeiro', 'RJ', '11133328909', 'angeladantas@gmail.com', '01220066-20'),
       (3, 'Antonio Dantas', 'Rua Tirol 777', 'Rio de Janeiro', 'RJ', '11991098789', 'antoniodantas@gmail.com', '0444494066-50'),
       (4, 'Carlos Ronan Dantas', 'Rua Jose Venâncio 596', 'Rio de Janeiro', 'RJ', '12345678903', 'calosronan@gmail.com', '0122094005-40', '0133940066-560'),
       (5, 'José Ronilson', 'Rua Cascavel  2', 'Rio de Janeiro', 'RJ', '12345678904', 'ronsilsondantas2@gmail.com', '022055785-50'),
       (6, 'Rosângela Dantas', 'Rua Jose Venâncio 596', 'Rio de Janeiro', 'RJ', '33448822545', 'rosangeladantas@gmail.com', '0133940066-70'),
       (7, 'Rossana Daguia Dantas', 'Rua Jose Venâncio 596', 'Rio de Janeiro', 'RJ', '4446786666', 'rossanadaguia@gmail.com', '0244005-33'),
       (8, 'Rosânia Cristina Dantas', 'Rua Jose Venâncio 596', 'Rio de Janeiro', 'RJ', '12345678444', 'rosaniacris@gmail.com', '01356209405-69'),
       (9, 'Francisca Natália Dantas', 'Rua Jose Venâncio 596', 'Rio de Janeiro', 'RJ', '12345678111', 'chica@gmail.com', '012334005-11');


-- =============== Atualizando dados na tabela PessoaFisica 
UPDATE [PessoaFisica]
SET CPF = '022094775-40'
WHERE idPessoaFisica = 1;

UPDATE [PessoaFisica]
SET CPF = '022055785-50'
WHERE idPessoaFisica = 2;

DROP TABLE IF EXISTS [PessoaFisica];
DROP TABLE [PessoaFisica];
SELECT * FROM [PessoaFisica];


/*======================================================================================================================*/

-- =============== Criando Tabela PessoaJuridica
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

-- =============== Inserindo dados na tabela PessoaJuridica
INSERT INTO [PessoaJuridica] (idPessoa, nome, logradouro, cidade, estado, telefone, email, CNPJ)
VALUES (1, 'Digital Minda', 'Rua Ituverava 21', 'Rio de Janeiro', 'RJ', '1111234242', 'digitalmind1@gmail.com', '11163258000146'),
       (2, 'Britex', 'Rua Ituverava 21', 'Rio de Janeiro', 'RJ', '1111234242', 'digitalmind1@gmail.com', '11163258000146'),
       (3, 'Digital Minda', 'Rua Ituverava 21', 'Rio de Janeiro', 'RJ', '1111234242', 'digitalmind1@gmail.com', '11163258000146'),
       (4, 'H2A Design', 'Rua Tirol 2', 'Rio de Janeiro', 'RJ', '12345678902', 'h2adesign@gmail.com', '18263258000146');


-- =============== Atualizando dados na PessoaJuridica 
UPDATE [PessoaJuridica]
SET CNPJ = '18263258000146'
WHERE idPessoaJuridica = 1;

UPDATE [PessoaJuridica]
SET CNPJ = '18263258000146'
WHERE idPessoaJuridica = 2;

DROP TABLE IF EXISTS [PessoaJuridica];
DROP TABLE [PessoaJuridica];
SELECT * FROM [PessoaJuridica];




/*======================================================================================================================*/

-- =============== Criando Tabela Movimentação
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
       (2, 2, 2, 300, 'S', 20.51),
       (1, 3, 2, 250, 'E', 10.22),
       (2, 3, 3, 520, 'S', 6.40),
       (2, 5, 4, 380, 'E', 4.90),
       (1, 5, 4, 200, 'E', 6.90),
       (1, 4, 7, 100, 'S', 3.50),
       (1, 4, 5, 80, 'S', 7.33),
       (2, 7, 1, 450, 'E', 4.44),
       (2, 9, 2, 550, 'S', 5.55);

DROP TABLE IF EXISTS [Movimentacao];
DROP TABLE [Movimentacao];
SELECT * FROM [Movimentacao];


