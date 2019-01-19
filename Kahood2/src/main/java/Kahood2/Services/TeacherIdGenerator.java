package Kahood2.Services;

public class TeacherIdGenerator implements IIdGenerator{

    @Override
    public Long generateId() {
        return Long.valueOf(random.nextInt(9999) + 20000);
    }
}
