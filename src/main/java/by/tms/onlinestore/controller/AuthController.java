package by.tms.onlinestore.controller;

import by.tms.onlinestore.entity.Person;
import by.tms.onlinestore.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/auth")
public class AuthController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ModelAndView auth(ModelAndView modelAndView) {
        modelAndView.addObject("authUser", new Person());
        modelAndView.setViewName("auth");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView auth(@ModelAttribute("authUser") Person person,
                             ModelAndView modelAndView,
                             HttpServletRequest httpServletRequest) {
        modelAndView.setViewName("redirect:/");
        Person person1 = personService.FindPerson(person);
        httpServletRequest.getSession().setAttribute("currentPerson", person1);
        return modelAndView;
    }
}
