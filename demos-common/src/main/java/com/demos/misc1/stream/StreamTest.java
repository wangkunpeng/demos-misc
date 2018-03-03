package com.demos.misc1.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author kunpeng.wkp
 * @date 2017/08/30
 **/
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int index = 0; index < 10; index++) {
            numbers.add(index);
        }

        numbers.stream().forEach((i) -> {
            System.out.println(i);
        });

        numbers.stream().map((i) -> 999).forEach((i) -> {
            System.out.println(i);
        });

        System.out.println(numbers.stream().map((i) -> 999).count());

        System.out.println(numbers.stream().filter((i) -> i > 5).count());

        System.out.println(numbers.stream().filter((i) -> i < 9).collect(toList()));

        System.out.println(numbers.stream().filter((i) -> i < 9).max(Comparator.comparing((i) -> i)).get());

        System.out.println(numbers.stream().reduce(0, (tt, i) -> tt + i));

        //最后发现numbers 都没有发生变化
        System.out.println(numbers);

    }
}