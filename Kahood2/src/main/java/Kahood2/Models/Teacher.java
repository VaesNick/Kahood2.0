package Kahood2.Models;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long Id;

    @Column(name = "Name")
    String Name;
    @Column(name = "LastName")
    String LastName;
    @Column(name = "UserName")
    String UserName;
    @Column(name = "Password")
    String Password;
    @Column(name = "TeacherId")
    Long TeacherNumber;

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

    public Number getTeacherNumber() {
        return TeacherNumber;
    }

    public void setTeacherNumber(Long teacherNumber) {
        TeacherNumber = teacherNumber;
    }
}
