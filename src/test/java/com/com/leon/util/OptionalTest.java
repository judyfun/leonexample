package com.com.leon.util;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * xuchuahao
 * on 2019/1/11.
 */
public class OptionalTest {
    public static final String DEFAULT_VAL = "defualt value";

    public static void main(String[] args) {
        Optional<Object> o = Optional.ofNullable(null);
        Object o1 = o.get();
    }




    @Test
    public void OptionalFilterExample() {
        Integer age = 20;
        boolean b = Optional.of(age).filter(a -> a > 10).isPresent();
        boolean s = Optional.of(age).filter(a -> a < 10).isPresent();
        assertEquals(true, b);
        assertEquals(false, s);
    }

    /**
     * get() method
     */
    @Test
    public void getExample1() {
        String name = "leon";
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("leon", opt.get());
    }

    @Test(expected = NoSuchElementException.class)
    /**
     * 如果包装了 null的值，那么在调用get()的时候，如果是null就会抛异常
     * 所以：
     * 1，Optional.ofNullable(v).orElse(v1);构造的时候需要添加默认值
     * 2，opt.ifPresent(T);
     *    opt.isPresent()  取值之前需要判断
     */
    public void get_givenNullValue() {
        String nullName = null;
        Optional<String> opt = Optional.ofNullable(nullName);
        opt.get();
    }

    @Test
    public void diffWithorElseGetAndOrElseExample() {
        String name = "leon";
        System.out.println("orElseGet :");
        String s = Optional.ofNullable(name).orElseGet(this::getDefaultVal);
        assertEquals("leon", s);

        System.out.println("orElse :");
        String anElse = Optional.ofNullable(name).orElse(getDefaultVal());
        assertEquals("leon", anElse);

    }

    @Test
    /**
     * Optional.isPresent() == true : orElseGet   执行     orElse   执行
     * Optional.isPresent() == false : orElseGet  不执行   orElse   执行
     *
     */
    public void diffWithorElseGetAndOrElseExample1() {
        String nullName = null;
        System.out.println("orElseGet :");
        String s = Optional.ofNullable(nullName).orElseGet(this::getDefaultVal);
        assertEquals(DEFAULT_VAL, s);

        System.out.println("orElse :");
        String anElse = Optional.ofNullable(nullName).orElse(getDefaultVal());
        assertEquals(DEFAULT_VAL, anElse);
    }


    private String getDefaultVal() {
        System.out.println("getDefaultVal is involked...");
        return DEFAULT_VAL;
    }


    @Test
    public void orElseGetExample() {
        String text = "text";
        String s = Optional.ofNullable(text).orElseGet(() -> DEFAULT_VAL);
        assertEquals("text", s);
    }

    @Test
    public void orElseGetExample1() {
        String text = null;
        String s = Optional.ofNullable(text).orElseGet(() -> DEFAULT_VAL);
        assertEquals(DEFAULT_VAL, s);
    }

    @Test
    /**
     * orElse 在参数为null的情况下可以设置默认值
     */
    public void orElseExample() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("leon");
        assertEquals("leon", name);
    }

    @Test
    public void isPresentDemo() {
        String name = "leon";
        Optional<String> opt = Optional.of(name);
        opt.ifPresent(s -> System.out.println(s.length()));

        //代码功能类似于
        if (null != name) {
            System.out.println(name.length());
        }
    }

    @Test
    public void isPresentDemo1() {
        String nullName = null;
        Optional<String> opt = Optional.ofNullable(nullName);
        opt.ifPresent(s -> System.out.println(s.length()));
    }
}
