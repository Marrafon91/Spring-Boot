package io.github.marrafon91.salary_java.services;

import io.github.marrafon91.salary_java.entities.Employee;

public class SalaryService {

//Forma errada

//    @Autowired
    private TaxService taxService;
//    @Autowired
    private PensionService pensionService;

    public SalaryService(TaxService taxService, PensionService pensionService) {
        this.taxService = taxService;
        this.pensionService = pensionService;
    }

    public double netSalary(Employee employee) {
        return  employee.getGrossSalary() - taxService.tax(employee.getGrossSalary())
                - pensionService.discount(employee.getGrossSalary());
    }
}
