package com.codegym.controller;

import moduls.BlogMusic;
import moduls.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import javax.validation.Valid;
import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;


@Controller
public class BlogMusicController {
    @Autowired
    IBlogMusicService iBlogMusicService;
    @Autowired
    IPersonService iPersonService;
//    @Autowired
//    ValidateAge validateAge;

    @GetMapping("showAdmin")
    public ModelAndView show(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "5") int sizePage) {
        ModelAndView modelAndView = new ModelAndView("showAdmin");
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(pageNumber, sizePage)));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("list", new BlogMusic());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute BlogMusic blogMusic, @RequestParam MultipartFile uppImg, @RequestParam MultipartFile uppMusic) {
        String nameImg = uppImg.getOriginalFilename();
        String nameMusic = uppMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\MD4-JPA\\BlogMusic\\src\\main\\webapp\\image/" + nameImg));
            FileCopyUtils.copy(uppMusic.getBytes(), new File("D:\\MD4-JPA\\BlogMusic\\src\\main\\webapp\\music/" + nameMusic));
            String urlImg = "/image/" + nameImg;
            String urlMusic = "/music/" + nameMusic;
            blogMusic.setFileImage(urlImg);
            blogMusic.setFileMusic(urlMusic);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }

        iBlogMusicService.save(blogMusic);
        ModelAndView modelAndView = new ModelAndView("redirect:/showAdmin");
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("list", iBlogMusicService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute BlogMusic blogMusic, @RequestParam MultipartFile uppImg, @RequestParam MultipartFile uppMusic) {
        String nameImg = uppImg.getOriginalFilename();
        String nameMusic = uppMusic.getOriginalFilename();
        try {
            FileCopyUtils.copy(uppImg.getBytes(), new File("D:\\MD4-JPA\\BlogMusic\\src\\main\\webapp\\image/" + nameImg));
            FileCopyUtils.copy(uppMusic.getBytes(), new File("D:\\MD4-JPA\\BlogMusic\\src\\main\\webapp\\music/" + nameMusic));
            String urlImg = "/image/" + nameImg;
            String urlMusic = "/music/" + nameMusic;
            blogMusic.setFileImage(urlImg);
            blogMusic.setFileMusic(urlMusic);
        } catch (IOException e) {
            System.err.println("chưa uppload file");
        }
        iBlogMusicService.edit(blogMusic);
        return new ModelAndView("redirect:/showAdmin");
    }


    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("showAdmin");
        modelAndView.addObject("list", iBlogMusicService.findAllByName(findName));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        iBlogMusicService.delete(iBlogMusicService.findById(id));
        return new ModelAndView("redirect:/showAdmin");
    }


    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("list", iBlogMusicService.findById(id));
        return modelAndView;
    }


    //    blog
    @GetMapping("/playBlog/{id}")
    public ModelAndView showBlog(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("playBlog");
        modelAndView.addObject("list", iBlogMusicService.findById(id));
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("listPerson", iPersonService.findAll());
        return modelAndView;
    }

    @GetMapping("blog")
    public ModelAndView blog(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("blog");
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(page, 6)));
        return modelAndView;
    }


}
