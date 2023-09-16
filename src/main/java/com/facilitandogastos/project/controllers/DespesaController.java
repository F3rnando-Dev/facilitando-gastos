package com.facilitandogastos.project.controllers;

import com.facilitandogastos.project.dtos.DespesaRecordDto;
import com.facilitandogastos.project.models.DespesaModel;
import com.facilitandogastos.project.repositories.DespesaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DespesaController {

    @Autowired
    DespesaRepository despesaRepository;

    @PostMapping("/despesas")
    public ResponseEntity<DespesaModel> saveDespesa(@RequestBody @Valid DespesaRecordDto despesaRecordDto){
        var despesaModel = new DespesaModel();

        BeanUtils.copyProperties(despesaRecordDto, despesaModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(despesaRepository.save(despesaModel));
    }

}
