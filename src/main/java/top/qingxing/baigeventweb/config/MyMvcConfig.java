package top.qingxing.baigeventweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author
 * @date 2019/11/26
 **/

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    /**
     * 配置跨域
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许所有域名的访问
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);

        //registry.allowCredentials(true)设置是否允许客户端发送cookie信息。默认是false
    }

    /**
     * 拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         *  定义一个登陆拦截器,拦截所有请求
         */
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/model/**");

    }

    /**
     * 映射文件路径配置，文件上传存放路径
     * 文件上传后可以通过
     * 如: /file/文件名     即为该文件的url地址
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //文件的路径映射
//        registry.addResourceHandler("/file/**").addResourceLocations(FileCommon.FILE_SAVE_PATH);
    }

    //其它更多全局定制接口
}
