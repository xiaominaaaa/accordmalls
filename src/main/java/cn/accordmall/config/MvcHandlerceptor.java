package cn.accordmall.config;

import cn.accordmall.util.IPKit;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MvcHandlerceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MvcHandlerceptor.class);
    /**
     * 预处理 ctroller 执行前,false 不执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri =request.getRequestURI();
        LOGGER.info("User-Agent: {}",request.getHeader("User-Agent"));
        LOGGER.info("请求地址: {},请求来源: {}",uri, IPKit.getRealAddress(request));

        return true;
    }


    /**
     * 后处理，视图跳转前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    /**
     * 后执行，视图跳转后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
