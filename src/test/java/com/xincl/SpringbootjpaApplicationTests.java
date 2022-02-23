package com.xincl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.stream.Stream;

@SpringBootTest
class SpringbootjpaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testLombda1(){
        Stream<Integer> integerStream = Stream.of(2,2,100,5);
        Integer max = integerStream.max(Integer::compareTo).get();
        System.out.println(max);
    }

    @Test
    void testLombda2(){
        Stream<Integer> integerStream = Stream.of(2,2,100,5);
        Comparator<Integer> comparator = (x,y)->(x.intValue()<(y.intValue())) ? -1 : ((x.equals(y)) ? 0 : 1);
        Integer max = integerStream.max(comparator).get();
        System.out.println(max);
    }

}
