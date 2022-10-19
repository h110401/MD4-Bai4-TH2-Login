package rikkei.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.Login;
import rikkei.academy.model.User;
import rikkei.academy.service.UserService;

@Controller
public class UserController {
    @GetMapping({"/", "/home"})
    public ModelAndView home() {
        return new ModelAndView("home", "login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute Login login) {
        User user = UserService.checkLogin(login);
        ModelAndView mnv;
        if (user == null) {
            mnv = new ModelAndView("error");
        } else {
            mnv = new ModelAndView("user");
            mnv.addObject("user", user);
        }
        return mnv;
    }
}
