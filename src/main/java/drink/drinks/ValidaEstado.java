/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drink.drinks;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Bianca
 */
@Target(
        {
            ElementType.FIELD,
            ElementType.METHOD,
            ElementType.ANNOTATION_TYPE
        }
)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorEstado.class)
@Documented
public @interface ValidaEstado {
    
    String message() default "{exemplo.main.java.com.mycompany.idrink.Endereco.estado}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
