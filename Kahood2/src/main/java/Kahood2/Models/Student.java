package Kahood2.Models;

import Kahood2.Services.IIdGenerator;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(name = "Name")
    String Name;
    @Column(name = "LastName")
    String LastName;
    @Column(name = "UserName")
    String UserName;
    @Column(name = "Password")
    String Password;
    @Column(name = "StudentNumber")
    Long StudentNumber;

    public Number getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        StudentNumber = studentNumber;
    }

    public Number getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Student(IIdGenerator idGen){
        this.setStudentNumber(idGen.generateId());
    }

    public Student(){

    }
}
