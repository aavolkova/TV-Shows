package me.anna.demo.controllers;

import me.anna.demo.models.TVShow;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class MainController {




    // Display the home page
    @GetMapping("/")
    public String showIndex(Model model)
    {
        String myMessage = "Welcome to TV Show Database";
        model.addAttribute("message", myMessage);
        return "index";
    }


    // Allow user to enter information about new TV Show
    @GetMapping("/entertvshow")
    public String addTVShow(Model model)
    {
        model.addAttribute("newTVShow", new TVShow());
        return "entertvshow";
    }


    // Validate entered information and if it is valid display the result
    @PostMapping("/resultenter")
    public String postUser(@Valid @ModelAttribute("newUser") TVShow tvshow, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return "entertvshow";
        }

//        // Allow user to leave the end date empty (assume he/she is still employed)
//        long employedDays;
//        if(user.getEndDate() == null)
//        {
//            user.setEndDate(LocalDate.now());
//            user.setEmployedDays(ChronoUnit.DAYS.between(user.getStartDate(), user.getEndDate()));
//        }
//        // If dates entered, do not accept the end date before the start date
//        else if(user.getEndDate().compareTo(user.getStartDate())< 0)
//        {
        return "resultenter";
//        }

    }


}
