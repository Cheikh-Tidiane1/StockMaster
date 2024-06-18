package com.tid.StockMaster.controller.api;

import com.tid.StockMaster.dto.VentesDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface VentesApi {
    @PostMapping(APP_ROOT + "/ventes/create")
    VentesDto save(@RequestBody VentesDto dto);

    @GetMapping(APP_ROOT + "/ventes/{idVente}")
    VentesDto findById(@PathVariable("idVente") Integer id);

    @GetMapping(APP_ROOT + "/ventes/{codeVente}")
    VentesDto findByCode(@PathVariable("codeVente") String code);

    @GetMapping(APP_ROOT + "/ventes/all")
    List<VentesDto> findAll();

    @DeleteMapping(APP_ROOT + "/ventes/delete/{idVente}")
    void delete(@PathVariable("idVente") Integer id);
}
