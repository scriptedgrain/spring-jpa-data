package me.dio.academia.digital.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.data.Matricula;
import me.dio.academia.digital.data.form.MatriculaForm;
import me.dio.academia.digital.data.form.MatriculaFormUpdate;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    
  @Autowired
  private MatriculaServiceImpl service;

  @PostMapping
  public Matricula create(@Valid @RequestBody MatriculaForm form) {
    return service.create(form);
  }

  @PutMapping("/{id}")
  public Matricula update(Long id, @Valid @RequestBody MatriculaFormUpdate form) {
    return service.update(id, form);
  }

}
