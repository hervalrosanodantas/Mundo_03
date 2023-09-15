<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Integrando Sistemas - Mundo3_N3 - Editar Produto</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="d-flex justify-content-center align-items-center">
                <form action="CadastroFC" method="post">
                    <input type="hidden" name="acao" value="editProdExec"/>
                    <input type="hidden" name="codProduto" value="${produtoEdit.idProduto}"/>
                    <div class="container mt-3 col-12">
                        <div class="row">
                            <div class="col-12">
                                <h3 class="my-5">Você escolheu alterar o produto abaixo!</h3>
                                <p>Basta clicar em salvar para concluir a alteração</p>
                                <div class="mb-3">
                                    <label for="nome" class="form-label">Nome do Produto:</label>
                                    <input type="text" name="nome" id="nome" class="form-control" value="${produtoEdit.nome}" required/>
                                </div>
                                <div class="mb-3">
                                    <label for="quantidade" class="form-label">Quantidade:</label>
                                    <input type="number" name="quantidade" id="quantidade" class="form-control" value="${produtoEdit.quantidade}" required/>
                                </div>
                                <div class="mb-3">
                                    <label for="precoVenda" class="form-label">Preço de Venda:</label>
                                    <input type="number" step="0.01" name="precoVenda" id="precoVenda" class="form-control" value="${produtoEdit.precoVenda}" required/>
                                </div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <input type="submit" value="Salvar" class="btn btn-success"/>
                            <a href="CadastroFC?acao=listaProd" class="btn btn-secondary">Cancelar</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>