package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("/users/index");
        mav.addObject("users", userService.findAll());
        return mav;
    }
    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView("/users/create");
        mav.addObject("user", new User());
        return mav;
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/create";
        }
        userService.save(user);
        return "redirect:/users";
    }

}
