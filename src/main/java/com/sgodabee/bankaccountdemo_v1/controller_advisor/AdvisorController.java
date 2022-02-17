package com.sgodabee.bankaccountdemo_v1.controller_advisor;

import com.sgodabee.bankaccountdemo_v1.model.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class AdvisorController {

        @ModelAttribute("registerUser")
    public User getUserDefaults()
        {
            return new User();

        }

}
