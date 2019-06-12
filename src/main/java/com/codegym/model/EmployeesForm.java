package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;
public class EmployeesForm {

    private Long id;
    private String name;
    private String yearOld;
    private String phoneNumber;
    private String email;
    private String address;
    private MultipartFile image;

    public EmployeesForm(Long id, String name, String yearOld, String phoneNumber, String email, String address, Office office,MultipartFile image) {
        this.id = id;
        this.name = name;
        this.yearOld = yearOld;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.image = image;
        this.office = office;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    private Office office;
    public EmployeesForm(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOld() {
        return yearOld;
    }

    public void setYearOld(String yearOld) {
        this.yearOld = yearOld;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
