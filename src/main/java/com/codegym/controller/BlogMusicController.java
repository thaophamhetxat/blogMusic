package com.codegym.controller;

import moduls.BlogMusic;
import moduls.Favourite;
import moduls.TheLoai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.IBlogMusicService;
import service.ITheLoaiService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


@Controller
@SessionAttributes("favourite")
public class BlogMusicController {
    @Autowired
    IBlogMusicService iBlogMusicService;
    @Autowired
    ITheLoaiService iTheLoaiService;


    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }

    @ModelAttribute
    public ArrayList<TheLoai> listTheLoai() {
        return (ArrayList<TheLoai>) iTheLoaiService.findAll();
    }



    @GetMapping("showAdmin")
    public ModelAndView show(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("showAdmin");
        modelAndView.addObject("listTheLoai", new BlogMusic());
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(page, 5, Sort.by("views"))));
        return modelAndView;
    }



    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("listTheLoai", new BlogMusic());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("listTheLoai") BlogMusic blogMusic, @RequestParam MultipartFile uppImg, @RequestParam MultipartFile uppMusic) {
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
        ModelAndView modelAndView = new ModelAndView("edit", "listTheLoai", iTheLoaiService.findAll());
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
        ModelAndView modelAndView = new ModelAndView("/playBlog");
        iBlogMusicService.views(id);
//        modelAndView.addObject("listSortViews",iBlogMusicService.SortMaxViews());
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("list", iBlogMusicService.findById(id));
        return modelAndView;
    }

    @GetMapping("/blog")
    public ModelAndView blog(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("blog");
//        modelAndView.addObject("listSortViews",iBlogMusicService.SortMaxViews());
        modelAndView.addObject("listRemix", iBlogMusicService.findAllByNameRemix());
        modelAndView.addObject("listPop", iBlogMusicService.findAllByNamePop());
        modelAndView.addObject("listUs", iBlogMusicService.findAllByNameUs());
        modelAndView.addObject("list", iBlogMusicService.findAll(PageRequest.of(page, 6)));
        return modelAndView;
    }


    //login
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @GetMapping("/admin")
    public ModelAndView admin() {

        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return new ModelAndView("/showAdmin");
    }


    //thêm vào list yêu thích
    @GetMapping("add/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute Favourite favourite, @RequestParam("action") String action) {
        Optional<BlogMusic> blogMusicOptional = iBlogMusicService.findByIdo(id);
        if (!blogMusicOptional.isPresent()) {
            return "/error";
        }
        if (action.equals("show")) {
            favourite.addFavourite(blogMusicOptional.get());
            return "redirect:/favourite-add";
        }
        favourite.addFavourite(blogMusicOptional.get());
        return "redirect:/playBlog";
    }



    @ModelAttribute("favourite")
    public Favourite setupCart() {
        return new Favourite();
    }


}
