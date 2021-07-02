package com.tatsam.priority.controller;

import com.tatsam.priority.dto.AddAreaData;
import com.tatsam.priority.dto.AreaData;
import com.tatsam.priority.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping("/api/v1/get/area")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @ResponseBody
    public List<AreaData> getAllareas(){
        return areaService.getAllareas();
    }

    @PostMapping("/api/v1/add/area")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public List<AreaData> addArea(@RequestBody(required = true) final AddAreaData req) throws Exception{
        return areaService.addAreas(req.getAreas());
    }
}
