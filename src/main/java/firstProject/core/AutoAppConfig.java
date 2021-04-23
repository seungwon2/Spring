package firstProject.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//기존 Appconfig랑 충돌나니까 Configuration을 제외, 저 지난 appconfig 이런거 없으면 안해도 됨
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))

public class AutoAppConfig {

}
