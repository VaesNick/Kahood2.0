package Kahood2.Models;

import Kahood2.Services.IIdGenerator;

public class Teacher {
    public Long teacherNumber;

    public Teacher(IIdGenerator idGen){
        this.setTeacherNumber(idGen.generateId());
    }

    public Long getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(Long teacherNumber) {
        this.teacherNumber = teacherNumber;
    }
}
