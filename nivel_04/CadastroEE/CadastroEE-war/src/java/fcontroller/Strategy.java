package fcontroller;

import javax.servlet.http.HttpServletRequest;

public abstract class Strategy<K> {

    protected final K facade;

    public Strategy(K facade) {
        this.facade = facade;
    }

    public abstract String executar(String acao,
            HttpServletRequest request);
}
