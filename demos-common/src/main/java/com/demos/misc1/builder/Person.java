package com.demos.misc1.builder;

/**
 * @author kunpeng.wkp
 * @date 2018/03/02
 **/
public class Person {
    private String name;

    private int age;
    private String address;

    private Person(Builder builder) {
        this.name = builder.name;

        this.age = builder.age;
        this.address = builder.address;
    }

    public static class Builder {

        private String name;

        private int age;
        private String address;

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int val) {
            this.age = val;
            return this;
        }

        public Builder address(String val) {
            this.address = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

        public static void main(String[] args) {
            Person person = (new Builder("wangcai")).age(10).address("124").build();

            System.out.println(person.toString());

            System.out.println(person.getClass());

            System.out.println(1);
        }
    }
}
