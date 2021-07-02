package com.tatsam.priority.dao;

import com.tatsam.priority.model.AreaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaDao extends JpaRepository<AreaModel, Long> {
}
