package by.tms.onlinestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/logout")
public class LogoutController {

    @GetMapping
    public ModelAndView logout(HttpServletRequest request, ModelAndView modelAndView) {
        request.getSession().invalidate();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
