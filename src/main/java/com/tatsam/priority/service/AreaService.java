package com.tatsam.priority.service;

import com.tatsam.priority.dto.AreaData;

import java.util.List;

public interface AreaService {
    List<AreaData> addAreas(List<String> areas);

    List<AreaData> getAllareas();
}
