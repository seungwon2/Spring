package firstProject.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//여기에 qualifier 이름 설정
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
