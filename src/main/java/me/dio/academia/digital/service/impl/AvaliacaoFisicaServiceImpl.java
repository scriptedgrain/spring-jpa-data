package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.data.AvaliacaoFisica;
import me.dio.academia.digital.data.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.data.form.AvaliacaoFisicaFormUpdate;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import me.dio.academia.digital.data.Aluno;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService{

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);       
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaFormUpdate formUpdate) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id).get();
        
        avaliacaoFisica.setPeso(formUpdate.getPeso());
        avaliacaoFisica.setAltura(formUpdate.getAltura());
        
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
