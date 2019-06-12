package com.codegym.sevice.Impl;

import com.codegym.model.Office;
import com.codegym.repository.OfficeRepository;
import com.codegym.sevice.OfficeSevice;
import org.springframework.beans.factory.annotation.Autowired;

public class OfficeSeviceImpl implements OfficeSevice {
    @Autowired
    private OfficeRepository officeRepository;
    @Override
    public Iterable<Office> fillAll() {
        return officeRepository.findAll();
    }

    @Override
    public Office findById(Long id) {
        return officeRepository.findOne(id);
    }

    @Override
    public void save( Office office) {
        officeRepository.save(office);

    }

    @Override
    public void delete(Long id) {
        officeRepository.delete(id);

    }
}
