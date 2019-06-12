package com.codegym.sevice;

import com.codegym.model.Employees;

public interface EmployeessSevice {
    Iterable<Employees>fillAll();
    Employees findById(Long id);
    void save(Employees employees);
    void delete(Employees employees);
}
