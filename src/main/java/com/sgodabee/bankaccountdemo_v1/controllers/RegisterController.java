package com.sgodabee.bankaccountdemo_v1.controllers;

import com.sgodabee.bankaccountdemo_v1.generator.EmailHTML;
import com.sgodabee.bankaccountdemo_v1.generator.Token;
import com.sgodabee.bankaccountdemo_v1.mailMessenger.MailMessenger;
import com.sgodabee.bankaccountdemo_v1.model.User;
import com.sgodabee.bankaccountdemo_v1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Random;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ModelAndView getRegister() {
        ModelAndView getRegisterPage = new ModelAndView("register");
        getRegisterPage.addObject("PageTittle","Register");
        System.out.println("in register Controller");
        return getRegisterPage;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("registerUser") User user, BindingResult result,
                                 @RequestParam("first_name") String first_name,
                                 @RequestParam("last_name") String last_name,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirm_password") String confirm_password) throws MessagingException {


        ModelAndView registrationPage = new ModelAndView("register");
        if(result.hasErrors()&& confirm_password.isEmpty())
        {
            registrationPage.addObject("confirm_pass","The confirm field is required");
            return registrationPage;
        }

        // TODO: CHECK FOR PASSWORD MATCH:
             if (!password.equals(confirm_password)){
                 registrationPage.addObject("passwordMisMatch","Passwords do not match");
                 return registrationPage;
             }

        //TODO: GET TOKEN STRING:
        String token = Token.generateToken();


        // GENERATE RANDOM CODE:
        Random random = new Random();
        int bound =123;
        int code = bound *random.nextInt(bound);

        // GET EMAIL HTML BODY
        String emailBody = EmailHTML.htmlEmailTemp(token,code);


        // HASH PASSWORD:
        String hashed_password= BCrypt.hashpw(password,BCrypt.gensalt());

        // REGISTER USER:
            userRepository.registerUser(first_name,last_name,email,hashed_password,token,Integer.toString(code));


        //  SEND EMAIL NOTIFICATION:
        MailMessenger.htmlEmailMessage("no-reply@somecompany.com",email,"Verify Account",emailBody);

        // RETURN TO REGISTER PAGE:
        registrationPage.addObject("Success","Account Registered Successfully, please check your email");

        return registrationPage;
    }



}
