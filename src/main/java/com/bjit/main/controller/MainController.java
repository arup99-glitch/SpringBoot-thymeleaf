package com.bjit.main.controller;

import com.bjit.main.model.Candidate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/welcome")
    public ModelAndView welcomePage(ModelAndView model) {
        model.setViewName("WelcomePage.html");
        return model;
    }

    @PostMapping("/receive")
    public ModelAndView receiveData(@ModelAttribute Candidate candidate, ModelAndView model) {
        model.setViewName("CandidatePage.html");
        model.addObject("candidate", candidate);

        return model;
    }

    @GetMapping("allCandidates")
    public ModelAndView getAllCandidates(ModelAndView model) {
        Candidate candidate1 = new Candidate("101", "A", "Java");
        Candidate candidate2 = new Candidate("102", "B", "Java");
        Candidate candidate3 = new Candidate("103", "C", "Java");
        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate1);
        candidateList.add(candidate2);
        candidateList.add(candidate3);

        model.setViewName("AllCandidatePage.html");
        model.addObject("candidateList", candidateList);

        return model;
    }
}
