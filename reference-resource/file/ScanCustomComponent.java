package ig.erp.task.service.config;

import ig.erp.task.service.data.Logger;
import ig.erp.task.service.data.StateMessage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


/**
 * 扫描配置类
 */
@Component
@ComponentScan(basePackages = "ig.erp.task.application.query.basis,ig.erp.task.application.command.basis,ig.erp.task.domain.service.basis", includeFilters = {
        @Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)})
@MapperScan(basePackages = "ig.erp.task.repository.repository", nameGenerator = MyBeanNameGenerator.class)
public class ScanCustomComponent {
    @Autowired
    private Environment environment;

    @Bean
    public Logger logger() {
        return new Logger();
    }
    @Bean
    public StateMessage message() {
        return new StateMessage();
    }
}
