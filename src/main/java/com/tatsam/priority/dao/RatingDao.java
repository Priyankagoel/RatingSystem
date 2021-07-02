package com.tatsam.priority.dao;

import com.tatsam.priority.model.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingDao extends JpaRepository<RatingModel, Long> {

}
