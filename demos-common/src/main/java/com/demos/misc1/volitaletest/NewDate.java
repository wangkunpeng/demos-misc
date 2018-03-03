package com.demos.misc1.volitaletest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author kunpeng.wkp
 * @date 2017/11/09
 **/
public class NewDate {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHH");
        LocalDateTime from = LocalDateTime.parse("2017110415", formatter);
        LocalDate  localDate =LocalDate.parse("2017110415", formatter);

        from = from.plusHours(48);

        System.out.println(from);
        System.out.println(localDate);
    }
}
