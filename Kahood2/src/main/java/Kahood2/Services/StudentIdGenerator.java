package Kahood2.Services;

import java.util.Random;

public class StudentIdGenerator implements IIdGenerator {
    private static StudentIdGenerator  studentIdGenerator= new StudentIdGenerator();

    public static StudentIdGenerator getStudentIdGenerator(){
        return studentIdGenerator;
    }

    @Override
    public Long generateId() {
        return Long.valueOf(random.nextInt(9999));
    }
}
