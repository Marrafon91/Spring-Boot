package io.github.marrafon91.arquiteturaspring;

import io.github.marrafon91.arquiteturaspring.todos.TodoEntity;
import io.github.marrafon91.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Lazy(false)
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Scope(WebApplicationContext.SCOPE_APPLICATION)
//@Scope("request")
//@Scope("session")
//@Scope("application")
public class BeanGerenciado {

    @Autowired
    private TodoValidator validator;

    @Autowired
    private AppProperties properties;

    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar() {
        var todo = new TodoEntity();
        validator.validar(todo);
    }
}
