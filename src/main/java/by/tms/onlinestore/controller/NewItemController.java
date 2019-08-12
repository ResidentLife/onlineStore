package by.tms.onlinestore.controller;

import by.tms.onlinestore.entity.Item;
import by.tms.onlinestore.entity.Person;
import by.tms.onlinestore.entity.Role;
import by.tms.onlinestore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Controller
@RequestMapping(path = "/newitem")
public class NewItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ModelAndView newItem(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {
        Person person = new Person();
        if (httpServletRequest.getSession().isNew()) {
            person.setRole(null);
        }else {
            person = (Person)httpServletRequest.getSession().getAttribute("currentPerson");
        }
        if (person.getRole() == Role.user || person.getRole() == null) {
            modelAndView.setViewName("index");
            return modelAndView;
        }else {
            modelAndView.addObject("newItem", new Item());
            modelAndView.setViewName("newitem");
            return modelAndView;
        }
    }

    @PostMapping
    public ModelAndView post(@ModelAttribute("newItem") Item item,
                             ModelAndView modelAndView) {
        BigDecimal price = item.getPrice();
        itemService.create(item);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
