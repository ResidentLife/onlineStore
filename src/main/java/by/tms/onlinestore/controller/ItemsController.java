package by.tms.onlinestore.controller;

import by.tms.onlinestore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/items")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("viewitems");
        modelAndView.addObject("items", itemService.getAll());
        return modelAndView;
    }
}
