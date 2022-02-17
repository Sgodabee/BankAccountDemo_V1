package com.sgodabee.bankaccountdemo_v1.controllers;

import com.sgodabee.bankaccountdemo_v1.model.Account;
import com.sgodabee.bankaccountdemo_v1.model.User;
import com.sgodabee.bankaccountdemo_v1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/App")
public class ApplicationController {

 @Autowired
 private AccountRepository accountRepository;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session) {

        ModelAndView dashBoardPage = new ModelAndView("dashboard");
        User user = (User) session.getAttribute("user");

        //get The Account Of The logged In User:

       // List<Account> getUserAccount = accountRepository.getUserAccountsById(user.getUser_id());

        //Get the Balance of the accounts
      //  BigDecimal totAccBal = accountRepository.getTotalBalance(user.getUser_id());

        //get Objects:
     //  dashBoardPage.addObject("UserAccounts",getUserAccount);
      //  dashBoardPage.addObject("UserAccounts",totAccBal);
        return dashBoardPage;
    }
}
