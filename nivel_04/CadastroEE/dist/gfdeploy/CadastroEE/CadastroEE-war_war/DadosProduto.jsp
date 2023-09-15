<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Integrando Sistemas - Mundo3_N3 - Incluir Produto</title>
        <!-- Adicione os links para os arquivos Bootstrap -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="d-flex flex-column justify-content-center align-items-center">
                <form action="CadastroFC" method="post">
                    <input type="hidden" name="acao" value="incProdExec"/>
                    <div class="container mt-3">
                        <div class="row">
                            <div class="col-12">
                                <h3 class="my-5">Cadastrar Novo Produto</h3>
                                <p>Ao término do cadastramento, basta clicar em cadastrar.</p>
                                <div class="mb-3">
                                    <label for="nome" class="form-label">Nome do Produto:</label>
                                    <input type="text" name="nome" id="nome" class="form-control" required/>
                                </div>
                                <div class="mb-3">
                                    <label for="quantidade" class="form-label">Quantidade:</label>
                                    <input type="number" name="quantidade" id="quantidade" class="form-control" required/>
                                </div>

                                <div class="mb-3">
                                    <label for="precoVenda" class="form-label">Preço Venda:</label>
                                    <input type="number" step="0.01" name="precoVenda" id="precoVenda" class="form-control" required/> <!-- Adicione o campo de preço de venda -->
                                </div>
                                <!-- Remova a linha abaixo se você não quiser definir um valor fixo para o codProduto -->
                                <input type="hidden" name="codProduto" value="4"/> <!-- Adicione este campo -->
                            </div>
                        </div>
                        <div class="mb-3">
                            <input type="submit" value="Cadastrar" class="btn btn-primary"/>
                            <a href="ListaProduto.jsp" class="btn btn-secondary">Voltar</a>
                        </div>
                    </div>
                </form>

            </div>
        </div>

        <!-- Adicione os scripts do Bootstrap -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>