package br.com.senior.boy.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import br.com.senior.boy.util.RequestContext;

/**
 * The RequestContextInitializationFilter is executed for every web request. The
 * filter initializes the RequestContext for the current thread, preventing
 * leaking of RequestContext attributes from the previous thread's execution.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestContextInitializationFilter extends GenericFilterBean {

    /**
     * The Logger for this class.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        logger.info("> doFilter");

        RequestContext.init();

        chain.doFilter(req, resp);
        logger.info("< doFilter");
    }

}
