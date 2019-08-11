package by.tms.onlinestore.controller;

import by.tms.onlinestore.entity.Item;
import by.tms.onlinestore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/newitem")
public class NewItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ModelAndView newItem(ModelAndView modelAndView) {
        modelAndView.addObject("newItem", new Item());
        modelAndView.setViewName("newitem");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView post(@ModelAttribute("newItem") Item item,
                             ModelAndView modelAndView) {
        itemService.create(item);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
