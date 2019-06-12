package com.codegym.sevice.Impl;

import com.codegym.model.Employees;
import com.codegym.repository.EmployeesRepository;
import com.codegym.sevice.EmployeessSevice;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeesSeviceImpl implements EmployeessSevice {
    @Autowired
    private EmployeesRepository employeesRepository;
    @Override
    public Iterable<Employees> fillAll() {
        return employeesRepository.findAll();
    }

    @Override
    public Employees findById(Long id) {
        return employeesRepository.findOne(id);
    }

    @Override
    public void save(Employees employees) {
        employeesRepository.save(employees);

    }

    @Override
    public void delete(Employees employees) {
        employeesRepository.delete(employees);

    }
}
