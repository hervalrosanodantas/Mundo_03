package servlet;




import fcontroller.Strategy;
import fcontroller.ProdutoStrategy;
import cadastroee.controller.ProdutoFacadeLocal;
import java.io.IOException;

import java.util.HashMap;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wfeli
 */
@WebServlet(name = "CadastroFC", urlPatterns = {"/CadastroFC"})
public class CadastroFC extends HttpServlet {

    @EJB
    ProdutoFacadeLocal produtoFacade;

    private final HashMap<String, Strategy> estrategia
            = new HashMap<>();
    private final HashMap<String, String> acoes = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();

        estrategia.put("produto", new ProdutoStrategy(
                produtoFacade));

        String[] acoesProduto = {"listaProd", "incProd", "incProdExec", "excProdExec", "editProd", "editProdExec"}; // Adicione "editProdExec"
        for (String acao : acoesProduto) {
            acoes.put(acao, "produto");
        }

    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao == null) {
            throw new ServletException("Parâmetro acao requerido");
        }
        Strategy st = estrategia.get(acoes.get(acao));
        request.getRequestDispatcher(st.executar(acao, request)).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
