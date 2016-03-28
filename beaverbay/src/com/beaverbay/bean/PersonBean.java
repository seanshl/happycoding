package com.beaverbay.bean;

import java.util.Date;

import com.beaverbay.model.Person;

public class PersonBean {
    private Long personId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private Date createDate;
    private Date editDate;
    private Date lastLogin;
    private String occupation;
    private String gender;
    private Date birthDate;
    private String statusCd;
    
    
    public PersonBean() {}
    
    public PersonBean(Person person) {
        this.personId = person.getPersonId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.userName = person.getUserName();
        this.password = person.getPassword();
        this.email = person.getEmail();
        this.phone = person.getPhone();
        this.createDate = person.getCreateDate();
        this.editDate = person.getEditDate();
        this.lastLogin = person.getLastLogin();
        this.occupation = person.getOccupation();
        this.gender = person.getGender();
        this.birthDate = person.getBirthDate();
        this.statusCd = person.getStatusCd();
    }

    public Long getPersonId() {
        return personId;
    }


    public void setPersonId(Long id) {
        this.personId = id;
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


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Date getCreateDate() {
        return createDate;
    }


    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public Date getEditDate() {
        return editDate;
    }


    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }


    public Date getLastLogin() {
        return lastLogin;
    }


    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }


    public String getOccupation() {
        return occupation;
    }


    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public Date getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public String getStatusCd() {
        return statusCd;
    }


    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    @Override
    public String toString() {
        return "PersonBean [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", userName=" + userName + ", password=" + password + ", email=" + email + ", phone=" + phone
                + ", createDate=" + createDate + ", editDate=" + editDate + ", lastLogin=" + lastLogin + ", occupation="
                + occupation + ", gender=" + gender + ", birthDate=" + birthDate + ", statusCd=" + statusCd + "]";
    }
    
    
}