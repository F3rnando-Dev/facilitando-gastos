package com.facilitandogastos.project.controllers;

import com.facilitandogastos.project.dtos.DespesaRecordDto;
import com.facilitandogastos.project.models.DespesaModel;
import com.facilitandogastos.project.repositories.DespesaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @GetMapping("/despesas")
    public ResponseEntity<List<DespesaModel>> getAllDespesas(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(despesaRepository.findAll());
    }

    @GetMapping("/despesas/{id}")
    public ResponseEntity<Object> getOneDespesa(@PathVariable(value = "id") Long id){
        Optional<DespesaModel> despesaOpt = despesaRepository.findById(id);
        if (despesaOpt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Despesa não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(despesaOpt.get());
    }

    @PutMapping("/despesas/{id}")
    public ResponseEntity<Object> updateDespesa(@PathVariable(value = "id") Long id,
                                                @RequestBody @Valid DespesaRecordDto despesaRecordDto){
        Optional<DespesaModel> despesaOpt = despesaRepository.findById(id);
        if (despesaOpt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Despesa não encontrada");
        }

        var despesaModel = despesaOpt.get();
        BeanUtils.copyProperties(despesaRecordDto, despesaModel);

        return ResponseEntity.status(HttpStatus.OK)
                .body(despesaRepository.save(despesaModel));
    }

    @DeleteMapping("/despesas/{id}")
    public ResponseEntity<Object> deleteDespesa(@PathVariable(value = "id") Long id){
        Optional<DespesaModel> despesaOpt = despesaRepository.findById(id);
        if (despesaOpt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Despesa não encontrada!");
        }

        despesaRepository.delete(despesaOpt.get());
        return ResponseEntity.status(HttpStatus.OK)
                .body("Despesa deletada com sucesso!");
    }



}
