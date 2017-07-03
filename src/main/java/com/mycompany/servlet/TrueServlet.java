package com.mycompany.servlet;

import com.mycompany.bean.CommonImplItemBean;
import com.mycompany.bean.CommonImplListBean;
import com.mycompany.conv.BeanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author starfucker
 * See this servlet mapping in web.xml
 * You must catch an all exceptions inside this servlet
 */
@SuppressWarnings("WeakerAccess")
public class TrueServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(TrueServlet.class);

    public TrueServlet() {
        LOG.debug("True servlet created");
    }

    @Override
    public void init() {
        LOG.debug("True servlet init");
    }

    private void processRequest(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_JSON);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try {
            final CommonImplListBean<String> bean = new CommonImplListBean<>();
            bean.setData(Arrays.asList("abc", "cde", "zxc"));

            BeanService.getInstance().toJson(bean, response.getOutputStream());
        } catch (Throwable e) {
            LOG.error("Error while request processing", e);
        }
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {
        processRequest(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "This is true servlet implementation";
    }
}
