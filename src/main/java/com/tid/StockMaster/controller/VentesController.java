package com.tid.StockMaster.controller;

import com.tid.StockMaster.controller.api.VentesApi;
import com.tid.StockMaster.dto.VentesDto;
import com.tid.StockMaster.services.VentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VentesController implements VentesApi {

    private VentesService vesService;
    @Autowired
    public VentesController(VentesService vesService) {
        this.vesService = vesService;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        return vesService.save(dto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return vesService.findById(id);
    }

    @Override
    public VentesDto findByCode(String code) {
        return vesService.findByCode(code);
    }

    @Override
    public List<VentesDto> findAll() {
        return vesService.findAll();
    }

    @Override
    public void delete(Integer id) {
        vesService.delete(id);
    }
}
