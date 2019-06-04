package com.beamon.api;

import com.beamon.service.RiddleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RiddleZolverController {

    @Autowired
    RiddleService riddleService;

    @GetMapping(value="/oneLitreSolution", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getOneLitreSolution() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(riddleService.getOneLitreSolution());
    }

    @GetMapping(value="/fourLitreSolution", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getFourLitreSolution() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(riddleService.getFourLitreSolution());
    }
}
