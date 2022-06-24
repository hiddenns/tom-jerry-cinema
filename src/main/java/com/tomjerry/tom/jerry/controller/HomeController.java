package com.tomjerry.tom.jerry.controller;

import com.tomjerry.tom.jerry.Season;
import com.tomjerry.tom.jerry.SelectSeriesDto;
import com.tomjerry.tom.jerry.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private StreamingService streamingService;

    @ModelAttribute
    public void addSeasons(Model model) {
        model.addAttribute("allSeasons", streamingService.getAllSeasons());
    }

    @RequestMapping("/tom&jerry")
    public String showHome(@ModelAttribute("season") SelectSeriesDto season, Model model) {
        if (season.getSeason() == null){
            season = new SelectSeriesDto();
        }

        Season currSeason = streamingService.getAllSeasons().get(Integer.parseInt(season.getSeason())-1);
        model.addAttribute("currentSeason", currSeason);
        return "home";
    }

    @GetMapping("/")
    public String getNameSeries(Model model) {
        return "redirect:/tom&jerry";
    }

}
