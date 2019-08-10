package by.tms.onlinestore.controller;

import by.tms.onlinestore.entity.Person;
import by.tms.onlinestore.entity.Role;
import by.tms.onlinestore.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/reg")
public class RegController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        modelAndView.addObject("newPerson", new Person());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView index(@Valid @ModelAttribute("newPerson") Person person, ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/");
        Person person1 = new Person(person.getLogin(), person.getPassword(), Role.user);
        personService.savePerson(person1);
        return modelAndView;
    }
}
