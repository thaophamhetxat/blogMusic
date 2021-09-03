package com.codegym.controller;

import moduls.Favourite;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FavouriteController {
    @ModelAttribute("favourite")
    public Favourite setupCart() {
        return new Favourite();
    }

    @GetMapping("/favourite-add")
    public ModelAndView showCart (@SessionAttribute("favourite") Favourite favourite){
        ModelAndView modelAndView = new ModelAndView("favourite");
        modelAndView.addObject("favourite",favourite);
        return modelAndView;
    }
}
