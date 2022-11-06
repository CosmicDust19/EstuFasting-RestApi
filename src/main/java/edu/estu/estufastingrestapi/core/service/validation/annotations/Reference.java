package edu.estu.estufastingrestapi.core.service.validation.annotations;

import edu.estu.estufastingrestapi.core.model.entities.abstracts.Entity;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
import edu.estu.estufastingrestapi.core.service.validation.validators.ReferenceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ReferenceValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Reference.List.class)
public @interface Reference {

    /**
     * Entity class which wanted to be validated.
     */
    Class<? extends Entity> entity();

    /**
     * Field name of the entity which wanted to be validated.
     */
    String fieldName() default "id";

    String message() default Msg.NOT_EXIST;

    Class<? extends Payload>[] payload() default {};

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @interface List {
        Reference[] value();
    }

}