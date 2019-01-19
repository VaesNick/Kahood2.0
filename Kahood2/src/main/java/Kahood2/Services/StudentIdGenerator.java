package Kahood2.Services;

import java.util.Random;

public class StudentIdGenerator implements IIdGenerator {
    @Override
    public Long generateId() {
        return Long.valueOf(random.nextInt(9999));
    }
}
