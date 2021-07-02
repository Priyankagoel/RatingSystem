package com.tatsam.priority.service.impl;

import com.tatsam.priority.dao.RatingDao;
import com.tatsam.priority.dao.UserDao;
import com.tatsam.priority.dto.RatingData;
import com.tatsam.priority.model.RatingModel;
import com.tatsam.priority.model.UserModel;
import com.tatsam.priority.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RatingDao ratingDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RatingData> addRatings(List<RatingData> ratingData, String userId) {
        Long user_Id = Long.parseLong(userId);
        Optional<UserModel> userModel =  userDao.findById(user_Id);
        List<RatingModel> ratingModels = ratingData.stream().map(rating -> convertToEntity(rating)).collect(Collectors.toList());

        List<RatingModel> response = ratingDao.saveAll(ratingModels);
        if(userModel.isPresent())
        {
            userModel.get().setRatings(response);
            userDao.save(userModel.get());
        }

        return response.stream().map(ratingModel -> convertToDto(ratingModel)).collect(Collectors.toList());
    }

    private RatingData convertToDto(RatingModel ratingModel) {
        RatingData ratingData = modelMapper.map(ratingModel, RatingData.class);
        return ratingData;
    }

    private RatingModel convertToEntity(RatingData ratingData) throws ParseException {
        RatingModel ratingModel = modelMapper.map(ratingData, RatingModel.class);
        return ratingModel;
    }
}
