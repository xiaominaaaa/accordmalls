package cn.accordmall.util;

import javax.servlet.http.HttpServletRequest;

/**
 * ip地址工具包
 */
public class IPKit {
    /**
     * 回调地址
     */
    private static final String LOOPBACK_ADDRESS = "127.0.0.1";
    /**
     * IPV6 地址
     */
    private static final String IPV6_ADDRESS = "0:0:0:0:0:0:0:1";

    /**
     * 获取真实地址
     * 要跨过服务器
     * @return
     */
    public static String getRealAddress(HttpServletRequest request){
        String ip = null;
        ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("Proxy-Client-IP");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("WL-Proxy-Client-IP");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("HTTP_CLIENT_IP");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
            ip = request.getRemoteAddr(); //也许是没有代理服务器
        if(ip.equals(IPV6_ADDRESS))
            return LOOPBACK_ADDRESS;
        return ip;
    }
}
