package com.demos.misc1.optional;

import java.util.Collections;
import java.util.Optional;

/**
 * @author kunpeng.wkp
 * @date 2017/09/01
 **/
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("123");

        System.out.println(optional.hashCode());
        System.out.println(optional.isPresent());

        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        System.out.println(Collections.EMPTY_MAP);
        System.out.println(Collections.EMPTY_LIST);
        System.out.println(Collections.EMPTY_SET);
    }
}
