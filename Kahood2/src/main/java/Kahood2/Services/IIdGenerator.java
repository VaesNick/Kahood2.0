package Kahood2.Services;

import java.util.Random;

public interface IIdGenerator {
    static Random random = new Random();
    public Long generateId();
}
