package com.tatsam.priority.service.impl;

import com.tatsam.priority.dao.RoleDao;
import com.tatsam.priority.dto.RoleData;
import com.tatsam.priority.model.RoleModel;
import com.tatsam.priority.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RoleData addRole(String name) {
        RoleData roleData = new RoleData();
        roleData.setName(name);
        return convertToDto(roleDao.save(convertToEntity(roleData)));
    }

    private RoleData convertToDto(RoleModel roleModel) {
        RoleData roleData = modelMapper.map(roleModel, RoleData.class);
        return roleData;
    }

    private RoleModel convertToEntity(RoleData roleData) throws ParseException {
        RoleModel roleModel = modelMapper.map(roleData, RoleModel.class);
        return roleModel;
    }
}
