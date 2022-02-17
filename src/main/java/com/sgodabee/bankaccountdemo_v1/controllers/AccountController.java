package com.sgodabee.bankaccountdemo_v1.controllers;

import com.sgodabee.bankaccountdemo_v1.generator.GenAccountNumber;
import com.sgodabee.bankaccountdemo_v1.model.User;
import com.sgodabee.bankaccountdemo_v1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/create_account")
    public String createAccount(@RequestParam("account_name") String accountName,
                                @RequestParam("account_type") String accountType,
                                RedirectAttributes redirectAttributes,
                                HttpSession session)
    {
        // 1: Check for empty Strings
        if (accountName.isEmpty()||accountType.isEmpty())
        {
            redirectAttributes.addFlashAttribute("error","account Name cannot be empty");
            return "redirect:/app/dashboard";

        }


        // generate account Number
        User user = (User) session.getAttribute("user");

        int genAccountNumber = GenAccountNumber.generateAccountNumber();
        String bankAccountNumber = Integer.toString(genAccountNumber);

        accountRepository.createBankAccount(user.getUser_id(),bankAccountNumber,accountName,accountType);

        //Success Message
        redirectAttributes.addFlashAttribute("Success","Account Created Successfully");
       return "/redirect:/app/dashboard" ;

    }
}
