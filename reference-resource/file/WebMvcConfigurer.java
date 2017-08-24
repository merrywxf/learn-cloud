package ig.erp.task.service.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 扫描配置类
 *
 * @MapperScan 每次只能扫描到一个包, 所有写了两个(不知道为什么只扫描到一个包)
 * </p>
 * 可以对@MapperScan 重写
 */
@Component
@MapperScan(basePackages = "ig.erp.task.domain.repository", nameGenerator = MyBeanNameGenerator.class)
@ImportResource("classpath:springaop.xml")
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {

            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {

                System.out.println(request.getRequestURL() + "=================url======");
                response.setContentType("textml;charset=UTF-8");
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
                response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
                response.setHeader("Access-Control-Max-Age", "0");
                response.setHeader("Access-Control-Allow-Headers",
                        "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("XDomainRequestAllowed", "1");
                return true;
            }
        }).addPathPatterns("/**");
    }
}
