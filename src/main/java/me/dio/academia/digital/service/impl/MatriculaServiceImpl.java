package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.data.Matricula;
import me.dio.academia.digital.data.form.MatriculaForm;
import me.dio.academia.digital.data.form.MatriculaFormUpdate;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

  @Autowired
  private MatriculaRepository repository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public Matricula create(MatriculaForm form) {
    Matricula matricula = new Matricula();
    matricula.setAluno(alunoRepository.findById(form.getAlunoId()).get());

    return repository.save(matricula);
  }

  @Override
  public Matricula get(Long id) {
    return repository.findById(id).get();
  }

  @Override
  public Matricula update(Long id, MatriculaFormUpdate formUpdate) {
    Matricula matricula = repository.findById(id).get();
    matricula.setAluno(alunoRepository.findById(formUpdate.getAlunoId()).get());

    return repository.save(matricula);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  public List<Matricula> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

}
