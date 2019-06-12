package com.codegym.sevice;

import com.codegym.model.Office;

public interface OfficeSevice {
    Iterable<Office>fillAll();
    Office findById(Long id);
    void save(Office office);
    void delete(Long id);
}
