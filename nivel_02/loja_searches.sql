/* ========================== Foi solicitado que fosse feito as seguintes consultas nas tabelas da Loja ========================= */

------------------------------------------------------------------------------------------------------------------------


-- 1-  Dados completos de pessoas físicas.
SELECT * FROM PessoaFisica; -- Já apresentados no relatório quando da criação das mesmas.

------------------------------------------------------------------------------------------------------------------------


-- 2-  Dados completos de pessoas jurídicas.
SELECT * FROM PessoaJuridica; -- Já apresentados no relatório quando da criação das mesmas.

------------------------------------------------------------------------------------------------------------------------

-- 3- Movimentações de entrada, com produto, fornecedor, quantidade, preço unitário e valor total.
SELECT p.nome, m.idProduto, m.idPessoa, m.quantidade, m.valor_unitario, (m.quantidade * m.valor_unitario) AS valor_total
FROM Movimentacao AS m
JOIN Pessoa AS p ON m.idPessoa = p.idPessoa
WHERE m.tipo = 'E';

------------------------------------------------------------------------------------------------------------------------

-- 4-  Movimentações de saída, com produto, cliente, quantidade, preço unitário e valor total.
SELECT p.nome, m.idProduto, m.idPessoa, m.quantidade, m.valor_unitario, (m.quantidade * m.valor_unitario) AS valor_total
FROM Movimentacao AS m
JOIN Pessoa AS p ON m.idPessoa = p.idPessoa
WHERE m.tipo = 'S';

------------------------------------------------------------------------------------------------------------------------

-- 5-  Valor total das entradas agrupadas por produto.
SELECT idProduto, SUM(quantidade * valor_unitario) AS ValorTotalEntrada
FROM Movimentacao
WHERE tipo = 'E'
GROUP BY idProduto;

------------------------------------------------------------------------------------------------------------------------

-- 6-  Valor total das saídas agrupadas por produto.
SELECT idProduto, SUM(quantidade * valor_unitario) AS ValorTotalSaida
FROM Movimentacao
WHERE tipo = 'S'
GROUP BY idProduto;

------------------------------------------------------------------------------------------------------------------------

-- 7-  Operadores que não efetuaram movimentações de entrada (compra).
SELECT *
FROM Usuario
WHERE idUsuario NOT IN (SELECT DISTINCT idUsuario FROM Movimentacao WHERE tipo = 'E');

------------------------------------------------------------------------------------------------------------------------

-- 8- Valor total de entrada, agrupado por operador.
SELECT m.idUsuario, u.login, SUM(m.quantidade * m.valor_unitario) AS ValorTotalEntrada
FROM Movimentacao m
JOIN Usuario u ON m.idUsuario = u.idUsuario
WHERE m.tipo = 'E'
GROUP BY m.idUsuario, u.login;

------------------------------------------------------------------------------------------------------------------------


-- 9- Valor total de saída, agrupado por operador.
SELECT p.nome AS operador, SUM(m.quantidade * m.valor_unitario) AS valor_total_saida
FROM Movimentacao AS m
JOIN Pessoa AS p ON m.idPessoa = p.idPessoa
WHERE m.tipo = 'S'
GROUP BY p.nome;

------------------------------------------------------------------------------------------------------------------------

---10- Valor médio de venda por produto, utilizando média ponderada.
SELECT idProduto, SUM(quantidade * valor_unitario) / SUM(quantidade) AS ValorMedioVenda
FROM Movimentacao
WHERE tipo = 'S'
GROUP BY idProduto;