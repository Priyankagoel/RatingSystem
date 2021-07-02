package com.tatsam.priority.dao;

import com.tatsam.priority.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<RoleModel, Long> {
    RoleModel findByName(String name);
}
