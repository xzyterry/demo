package com.jawnho.demo;

import java.text.ParseException;
import java.util.concurrent.locks.ReentrantLock;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jawnho
 * @date 2019/7/19
 */
public class Test {


    public static void main(String[] args) throws ParseException, InterruptedException {

       Test test = new Test();
       test.test();
    }

    ReentrantLock lock = new ReentrantLock();

    public void test() throws InterruptedException {
        lock.lock();
        test1();
        lock.unlock();
    }

    public void test1() throws InterruptedException {
        lock.lock();
        System.out.println("test1");
        lock.unlock();
    }

}

@Setter
@Getter
class Student {

    private Course course;
}

@Setter
@Getter
class Course {

    private String name;

    public Course(String name) {
        this.name = name;
    }
}
