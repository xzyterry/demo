package com.jawnho.demo.reflect;

/**
 * @author jawnho
 * @date 2019/7/22
 */
public class Test {

    public static void main(String[] args) {
        String[] test = test("123,456,789");
        for (String s : test) {
            System.out.println(s);
        }

    }

    public static String[] test(String... strs) {
        return strs;
    }
}
