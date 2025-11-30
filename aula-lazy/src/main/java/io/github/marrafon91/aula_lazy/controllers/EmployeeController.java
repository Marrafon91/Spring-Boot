package io.github.marrafon91.aula_lazy.controllers;

import io.github.marrafon91.aula_lazy.dto.EmployeeDepartmentDTO;
import io.github.marrafon91.aula_lazy.dto.EmployeeMinDTO;
import io.github.marrafon91.aula_lazy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/{id}/min")
    public ResponseEntity<EmployeeMinDTO> findByIdMin(@PathVariable Long id) {
        EmployeeMinDTO obj = service.findByIdMin(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDepartmentDTO> findByIdWithDepartment(@PathVariable Long id) {
        EmployeeDepartmentDTO obj = service.findByIdWithDepartment(id);
        return ResponseEntity.ok(obj);
    }

    //@GetMapping
    public ResponseEntity<List<EmployeeDepartmentDTO>> findEmployeesWithDepartments() {
        List<EmployeeDepartmentDTO> list = service.findEmployeesWithDepartments();
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeMinDTO>> findByName
            (@RequestParam(name = "name", defaultValue =  "") String name) {
        List <EmployeeMinDTO> result = service.findByName(name);
        return ResponseEntity.ok(result);
    }
}
