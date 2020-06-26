package com.codebysuraj.useraccountregistration.controller;

import com.codebysuraj.useraccountregistration.model.User;
import com.codebysuraj.useraccountregistration.repository.UserRepository;
import com.codebysuraj.useraccountregistration.service.EmailService;
import com.codebysuraj.useraccountregistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {


    @Autowired
    UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailService emailService;

    // Function to display login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage(ModelAndView modelAndView, User user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("login");
        return modelAndView;
    }


    // Function to handle the login process
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView processLoginForm(ModelAndView modelAndView, User user, HttpServletRequest request) {
        User existingUser = userService.findByEmail(user.getEmail());
        if(existingUser!=null) {
            //Use encoder.matches to compare raw password with encrypted password
            if(bCryptPasswordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
                modelAndView.addObject("message", "Successfully logged in!");
                modelAndView.setViewName("successlogin");
            } else {
                modelAndView.addObject("notmessage", "Incorrect password. Try again.");
                modelAndView.setViewName("login");
            }
        }
        else {
            modelAndView.addObject("notmessages", "The email provided does not exist!");
            modelAndView.setViewName("login");

        }
        return modelAndView;
    }




}

