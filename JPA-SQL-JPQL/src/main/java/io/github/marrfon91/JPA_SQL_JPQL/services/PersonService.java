package io.github.marrfon91.JPA_SQL_JPQL.services;

import io.github.marrfon91.JPA_SQL_JPQL.dto.PersonDTO;
import io.github.marrfon91.JPA_SQL_JPQL.dto.PersonDepartmentDTO;
import io.github.marrfon91.JPA_SQL_JPQL.entities.Department;
import io.github.marrfon91.JPA_SQL_JPQL.entities.Person;
import io.github.marrfon91.JPA_SQL_JPQL.repositories.DepartmentRepository;
import io.github.marrfon91.JPA_SQL_JPQL.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    DepartmentRepository departmentRepository;

    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
        Person entity = new Person();
        copyDtoToEntity(dto, entity);

        Department dept = new Department();
        copyDtoToDepartment(dto, dept);

        entity = repository.save(entity);
        return new PersonDepartmentDTO(entity);
    }

    public PersonDTO insert(PersonDTO dto) {
        Person entity = new Person();
        entity.setName(dto.name());
        entity.setSalary(dto.salary());

        Department dept = departmentRepository.getReferenceById(dto.departmentId());

        entity.setDepartment(dept);
        entity = repository.save(entity);

        return new PersonDTO(entity);
    }

    private void copyDtoToDepartment(PersonDepartmentDTO dto, Department dept) {
        dept.setId(dto.department().id());
        dept.setName(dto.department().name());
    }

    private void copyDtoToEntity(PersonDepartmentDTO dto, Person entity) {
        entity.setName(dto.name());
        entity.setSalary(dto.salary());

        Department dept = departmentRepository.getReferenceById(dto.department().id());
        dept.setId(dto.department().id());

        entity.setDepartment(dept);
    }
}
