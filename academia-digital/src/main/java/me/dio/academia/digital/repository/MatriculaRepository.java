package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

	//Esta é uma segunda forma, consultado pela query
	/**
	 *
	 * @param bairro bairro referência para o filtro
	 * @return lista de alunos matriculados que residem no bairro passado como
	 *         parâmetro
	 */
	@Query(value = "SELECT * FROM tb_matriculas m " + "INNER JOIN tb_alunos a ON m.aluno_id = a.id "
			+ "WHERE a.bairro = :bairro", nativeQuery = true)
	// @Query("FROM Matricula m WHERE m.aluno.bairro = :bairro ")
	List<Matricula> findAlunosMatriculadosBairro(String bairro);

	// Aluno é uma entidade dentro de matricula, e bairro pelo parametro da entidade
	// List<Matricula> findByAlunoBairro(String bairro);

}
