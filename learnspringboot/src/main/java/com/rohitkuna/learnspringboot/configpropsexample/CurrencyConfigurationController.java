package com.rohitkuna.learnspringboot.configpropsexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // to register this as controller
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyConfiguration currencyConfiguration;

    @RequestMapping("/currency-details") // to map path
    public CurrencyConfiguration getCurrencyConfiguration(){
        return currencyConfiguration; // json mapping happens auto
    }
}
