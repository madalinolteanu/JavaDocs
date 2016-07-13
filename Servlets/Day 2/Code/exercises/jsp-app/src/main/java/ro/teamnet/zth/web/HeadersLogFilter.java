package ro.teamnet.zth.web;
import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by user on 7/14/2016.
 */
public class HeadersLogFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("HeadersLogFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Enumeration enumeration = ((HttpServletRequest) request ).getHeaderNames();
        while(enumeration.hasMoreElements()){
            String headerName = (String) enumeration.nextElement();
            LogFileWriter.logHeader(headerName , ((HttpServletRequest) request).getHeader(headerName));
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
