package com.codegym.controller;

import moduls.BlogMusic;
import moduls.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.IBlogMusicService;
import service.IPersonService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class PersonController {
    @Autowired
    IPersonService iPersonService;

    @Autowired
    IBlogMusicService iBlogMusicService;

    @ModelAttribute("userName")
    public Person setUpUserForm() {
        return new Person();
    }

//    @RequestMapping("/login")
//    public String Index(@CookieValue(value = "setUserName", defaultValue = "") String setUserName, Model model) {
//        Cookie cookie = new Cookie("setUserName", setUserName);
//        model.addAttribute("cookieValue", cookie);
//        return "/blog";
//    }




    @PostMapping("/login")
    public ModelAndView doLogin(@ModelAttribute("user") Person person, Model model, @CookieValue(value = "setUserName", defaultValue = "") String setUserName,
                          HttpServletResponse response, HttpServletRequest request) {

        //implement business logic
        if (person.getEmail().equals("admin@gmail.com") && person.getPassWord().equals("123456")) {
            if (person.getEmail() != null)
                setUserName = person.getEmail();

            // create cookie and set it in response
            Cookie cookie = new Cookie("setUserName", setUserName);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            //get all cookies
            Cookie[] cookies = request.getCookies();
            //iterate each cookie
            for (Cookie ck : cookies) {
                //display only the cookie with the name 'setUser'
                if (ck.getName().equals("setUserName")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
            ModelAndView modelAndView = new ModelAndView("blog");
            return modelAndView;
        } else {
            person.setEmail("");
            Cookie cookie = new Cookie("setUserName", setUserName);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }



    @PostMapping("/register")
    public ModelAndView create(@ModelAttribute Person person, @RequestParam MultipartFile avatar) {
        String nameImgAvatar = avatar.getOriginalFilename();
        try {
            FileCopyUtils.copy(nameImgAvatar.getBytes(), new File("D:\\MD4-JPA\\BlogMusic\\src\\main\\webapp\\avatar/" + nameImgAvatar));
            String urlImgAvatar = "/avatar/" + nameImgAvatar;
            person.setImagePerson(urlImgAvatar);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }

        iPersonService.save(person);
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        return modelAndView;
    }



}
