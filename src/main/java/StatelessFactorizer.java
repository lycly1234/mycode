import net.jcip.annotations.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;

@ThreadSafe
public class StatelessFactorizer implements Servlet {

    //不同步下会产生线程安全问题
    private long count  = 0;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //无状态的对象一定是i线程安全

        //非原子增加
        ++count;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
