package filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "PermissionFilter",urlPatterns = "/*")
public class PermissionFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String flag = (String) session.getAttribute("flag");
        String servletPath = request.getServletPath();
        if (servletPath.equals("/login.jsp")||servletPath.equals("/index.jsp")||servletPath.equals("/login")) {
            chain.doFilter(req, resp);
        } else {
            if (flag != null && flag.equals("success")) {
                chain.doFilter(req, resp);
            } else {
                req.getRequestDispatcher("fail.jsp").forward(req, resp);
            }
        }
    }
    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
