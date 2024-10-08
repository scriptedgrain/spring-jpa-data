package me.dio.academia.digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.data.AvaliacaoFisica;
import me.dio.academia.digital.data.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.data.form.AvaliacaoFisicaFormUpdate;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }
    @PutMapping("/{id}")
    public AvaliacaoFisica update(Long id, @RequestBody AvaliacaoFisicaFormUpdate form) {
        return service.update(id, form);
    }
}
