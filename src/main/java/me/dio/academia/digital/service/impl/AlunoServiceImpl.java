package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.data.Aluno;
import me.dio.academia.digital.data.AvaliacaoFisica;
import me.dio.academia.digital.data.form.AlunoForm;
import me.dio.academia.digital.data.form.AlunoFormUpdate;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

  @Autowired
  private AlunoRepository repository;

  @Override
  public Aluno create(AlunoForm form) {
    Aluno aluno = new Aluno();
    aluno.setNome(form.getNome());
    aluno.setCpf(form.getCpf());
    aluno.setBairro(form.getBairro());
    aluno.setDataDeNascimento(form.getDataDeNascimento());

    return repository.save(aluno);
  }

  @Override
  public Aluno get(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public Aluno update(Long id, AlunoFormUpdate formUpdate) {
    Aluno aluno = repository.findById(id).get();

    aluno.setNome(formUpdate.getNome());
    aluno.setBairro(formUpdate.getBairro());
    aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());

    return repository.save(aluno);
  }

  @Override
  public void delete(Long id) {
  }

  @Override
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

    Aluno aluno = repository.findById(id).get();

    return aluno.getAvaliacoes();

  }

  @Override
  public List<Aluno> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

}