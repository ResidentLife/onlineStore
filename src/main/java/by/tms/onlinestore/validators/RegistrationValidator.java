package by.tms.onlinestore.validators;

import by.tms.onlinestore.entity.Person;
import by.tms.onlinestore.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator implements Validator {

    @Autowired
    private PersonService personService;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "errorLogin");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "errorPassword");

        if (!errors.hasFieldErrors("login")){
            if (personService.isLoginExist(person.getLogin())){
                errors.rejectValue("login", "wrongLogin");
            }
        }
    }
}
