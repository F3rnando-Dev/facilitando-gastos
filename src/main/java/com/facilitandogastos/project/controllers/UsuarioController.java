package com.facilitandogastos.project.controllers;

import com.facilitandogastos.project.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
}
