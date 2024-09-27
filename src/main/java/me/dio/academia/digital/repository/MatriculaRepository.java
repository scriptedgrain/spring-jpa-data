package me.dio.academia.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import me.dio.academia.digital.data.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
