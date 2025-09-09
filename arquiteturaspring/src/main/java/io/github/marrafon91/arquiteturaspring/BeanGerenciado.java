package io.github.marrafon91.arquiteturaspring;

import io.github.marrafon91.arquiteturaspring.todos.TodoEntity;
import io.github.marrafon91.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {

    @Autowired
    private TodoValidator validator;

    public void utilizar() {
        var todo = new TodoEntity();
        validator.validar(todo);
    }
}
