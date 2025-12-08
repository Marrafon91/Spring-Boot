package io.github.marrafon91.uri.repository;

import io.github.marrafon91.uri.dto.EmpregadoDepDTO;
import io.github.marrafon91.uri.entities.Empregado;
import io.github.marrafon91.uri.projection.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, String> {

    @Query(nativeQuery = true, value = """
            SELECT empregados.cpf, empregados.enome, departamentos.dnome
            FROM empregados
            INNER JOIN departamentos ON empregados.dnumero = departamentos.dnumero
            WHERE empregados.cpf NOT IN (
            	SELECT empregados.cpf
            	FROM empregados
            	INNER JOIN trabalha ON trabalha.cpf_emp = empregados.cpf
            )
            ORDER BY empregados.cpf;
            """)
    List<EmpregadoDeptProjection> search1();

    @Query(value = """
            SELECT new io.github.marrafon91.uri.dto.EmpregadoDepDTO(obj.cpf, obj.enome, obj.departamento.dnome)
            FROM Empregado obj
            WHERE obj.cpf NOT IN (
            	SELECT obj.cpf
            	FROM Empregado obj
            	INNER JOIN obj.projetosOndeTrabalha
            )
            ORDER BY obj.cpf
            """)
    List<EmpregadoDepDTO> search2();

    @Query(nativeQuery = true, value = """            
            SELECT empregados.cpf, empregados.enome, departamentos.dnome
            FROM empregados
            INNER JOIN departamentos ON empregados.dnumero = departamentos.dnumero
            LEFT JOIN trabalha ON trabalha.cpf_emp = empregados.cpf
            WHERE trabalha.cpf_emp IS NULL
            ORDER BY empregados.cpf;
            """)
    List<EmpregadoDeptProjection> search3();
}
