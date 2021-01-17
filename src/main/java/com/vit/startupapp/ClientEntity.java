package com.vit.startupapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email", nullable = false)
    private String emailId;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "dobAD", nullable = false)
    private String dobAD;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "role", nullable = false)
    private String role;

    public ClientEntity() {

    }

    public ClientEntity(Integer id, String firstName, String lastName, String password, String address, String emailId, String phoneNumber, String dobAD, String city, String country, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.dobAD = dobAD;
        this.city = city;
        this.country = country;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDobAD() {
        return dobAD;
    }

    public void setDobAD(String dobAD) {
        this.dobAD = dobAD;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dobAD='" + dobAD + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}