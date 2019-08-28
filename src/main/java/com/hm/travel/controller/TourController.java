package com.hm.travel.controller;

import com.hm.travel.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TourController {
    @Autowired
    TourService tourService;
    @GetMapping("getAllTour")
    public String Tourlist(Model model){
        model.addAttribute("tours",tourService.findAll());
        return "/adminPage/tourlist";
    }

}
