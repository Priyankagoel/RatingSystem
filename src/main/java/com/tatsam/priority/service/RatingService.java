package com.tatsam.priority.service;

import com.tatsam.priority.dto.RatingData;
import com.tatsam.priority.model.RatingModel;

import java.util.List;

public interface RatingService {
    List<RatingData> addRatings(List<RatingData> ratingData, String userId);
}
