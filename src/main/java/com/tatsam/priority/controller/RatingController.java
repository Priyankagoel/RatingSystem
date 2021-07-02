package com.tatsam.priority.controller;

import com.tatsam.priority.dto.RatingData;
import com.tatsam.priority.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/api/v1/user/{userId}/rating")
    @ResponseBody
    public List<RatingData> addRating(@RequestBody(required = true) final List<RatingData> ratingData, @PathVariable("userId") String userId){
        return ratingService.addRatings(ratingData, userId);

    }
}
