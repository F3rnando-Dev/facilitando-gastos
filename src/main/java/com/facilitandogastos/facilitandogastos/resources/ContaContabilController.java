package com.facilitandogastos.facilitandogastos.resources;

import com.facilitandogastos.facilitandogastos.models.ContaContabil;
import com.facilitandogastos.facilitandogastos.repositories.ContaContabilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ContaContabilController {

    @Autowired
    ContaContabilRepository contaContabilRepository;

    @GetMapping("/contas-contabeis")
    public List<ContaContabil> listaContasContabeis(){

        return contaContabilRepository.findAll();
    }

    @GetMapping("/contas-contabeis/{id}")
    public ContaContabil listaContaContabil(@PathVariable(value = "id") long id){

        return contaContabilRepository.findById(id);
    }

    @PostMapping("/contas-contabeis")
    public ContaContabil salvaContaContabil(@RequestBody ContaContabil contaContabil){
        return contaContabilRepository.save(contaContabil);
    }

}
