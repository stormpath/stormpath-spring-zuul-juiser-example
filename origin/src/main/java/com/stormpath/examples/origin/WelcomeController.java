package com.stormpath.examples.origin;

import com.stormpath.juiser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

    @Autowired
    private User user;

    @RequestMapping("/")
    public String welcome(HttpServletRequest request, Model model) {

        model.addAttribute("user", user);

        return "welcome";
    }
}
