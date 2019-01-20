package Kahood2.Services;

public class TeacherIdGenerator implements IIdGenerator{
    private static TeacherIdGenerator  teacherIdGenerator= new TeacherIdGenerator();

    public static TeacherIdGenerator getTeacherIdGenerator(){
        return teacherIdGenerator;
    }


    @Override
    public Long generateId() {
        return Long.valueOf(random.nextInt(9999) + 20000);
    }
}
