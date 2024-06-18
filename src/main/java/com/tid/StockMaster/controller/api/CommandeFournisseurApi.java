package com.tid.StockMaster.controller.api;
import com.tid.StockMaster.dto.CommandeFournisseurDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.tid.StockMaster.utils.Constants.APP_ROOT;

public interface CommandeFournisseurApi {

    @PostMapping(APP_ROOT + "/commandesfournisseurs/create")
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

    @GetMapping(APP_ROOT + "/commandesfournisseurs/{idCommandeFournisseur}")
    CommandeFournisseurDto findById(@PathVariable("idCommandeFournisseur") Integer id);

    @GetMapping(APP_ROOT + "/commandesfournisseurs/filter/{codeCommandeFournisseur}")
    CommandeFournisseurDto findByCode(@PathVariable("codeCommandeFournisseur") String code);

    @GetMapping(APP_ROOT + "/commandesfournisseurs/all")
    Iterable<CommandeFournisseurDto> findAll();

    @DeleteMapping(APP_ROOT + "/commandesfournisseurs/delete/{idCommandeFournisseur}")
    void delete(@PathVariable("idCommandeFournisseur") Integer id);
}
