package io.github.marrafon91.salary_java.services;

import io.github.marrafon91.salary_java.entities.Employee;

public class SalaryService {

    //Forma errada
    TaxService taxService = new TaxService();
    PensionService pensionService = new PensionService();


    public double netSalary(Employee employee) {
        return  employee.getGrossSalary() - taxService.tax(employee.getGrossSalary())
                - pensionService.discount(employee.getGrossSalary());
    }
}
