package io.github.marrafon91.aula_lazy.controllers;

import io.github.marrafon91.aula_lazy.dto.DepartmentDTO;
import io.github.marrafon91.aula_lazy.dto.EmployeeMinDTO;
import io.github.marrafon91.aula_lazy.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/{id}")
    private ResponseEntity<DepartmentDTO> findById(@PathVariable Long id) {
        DepartmentDTO obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/{id}/employees")
    public  ResponseEntity<List<EmployeeMinDTO>> findEmployeesByDepartment(@PathVariable Long id) {
        List<EmployeeMinDTO> list = service.findEmployeesByDepartment(id);
        return ResponseEntity.ok(list);
    }
}
