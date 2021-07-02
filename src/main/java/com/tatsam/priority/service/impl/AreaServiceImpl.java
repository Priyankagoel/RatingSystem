package com.tatsam.priority.service.impl;

import com.tatsam.priority.dao.AreaDao;
import com.tatsam.priority.dto.AreaData;
import com.tatsam.priority.model.AreaModel;
import com.tatsam.priority.service.AreaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AreaData> addAreas(List<String> areas) {

        List<AreaModel> areaModels = new ArrayList<>();
        for (String area: areas) {
            AreaModel areaModel = new AreaModel();
            areaModel.setName(area);
            areaModels.add(areaModel);
        }

        //List<AreaModel> areaModels = areas.stream().map(area -> new AreaModel().setName(area)).collect(Collectors.toList());
        List<AreaModel> response =   areaDao.saveAll(areaModels);

        return response.stream().map(areaModel -> convertToDto(areaModel)).collect(Collectors.toList());
    }

    @Override
    public List<AreaData> getAllareas() {
        return areaDao.findAll().stream().map(areaModel -> convertToDto(areaModel)).collect(Collectors.toList());
    }

    private AreaData convertToDto(AreaModel areaModel) {
        AreaData areaData = modelMapper.map(areaModel, AreaData.class);
        return areaData;
    }

    private AreaModel convertToEntity(AreaData areaData) throws ParseException {
        AreaModel areaModel = modelMapper.map(areaData, AreaModel.class);
        return areaModel;
    }
}
