package com.codebysuraj.useraccountregistration.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private int id;

    @Column(name = "first_name")
    @NotEmpty(message = "Please provide your first name")
    private String FirstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Please provide your last name")
    private String LastName;

    @Column(name = "batch")
    @NotBlank(message = "Please mention your batch year")
    private String Batch;

    @Column(name = "Permanent_Address")
    @NotEmpty(message = "Please provide your permanentAddress")
    private String PermanentAddress;

    @Column(name = "Temporary_name")
    @NotEmpty(message = "Please provide your temporaryAddress")
    private String TemporaryAddress;

    @Column(name = "Occupation")
    @NotEmpty(message = "Mention in which occupation you are invloved")
    private String Occupation;


    @OneToOne(targetEntity=User.class,fetch=FetchType.EAGER)
    @JoinColumn(nullable =false, name="id")
    private User user;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String batch) {
        Batch = batch;
    }

    public String getPermanentAddress() {
        return PermanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        PermanentAddress = permanentAddress;
    }

    public String getTemporaryAddress() {
        return TemporaryAddress;
    }

    public void setTemporaryAddress(String temporaryAddress) {
        TemporaryAddress = temporaryAddress;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }



}