package ru.team1419.SpringPatterns.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.team1419.SpringPatterns.CoffeService;
import ru.team1419.SpringPatterns.Context;
import ru.team1419.SpringPatterns.ManualData;

@Controller
@CrossOrigin
public class HomeController {
    ManualData manualData = new ManualData();
    @Autowired
    CoffeService coffeService;

    @GetMapping("/action")
    public String action(@RequestParam String name, @RequestParam int amount, @RequestParam Boolean milk)
    {
        //manualData.setData(name, amount, milk);
        Context context = new Context(manualData);
        context.state = coffeService;
        context.Request();
        return "home";
    }

    @GetMapping("/")
    public String home()
    {
        return "here";
    }
}

//spring.jpa.hibernate.naming_strategy=org.hibernate.cfg.ImprovedNamingStrategy