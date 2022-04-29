package com.wenjin.algorithm.test;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author huangwj.
 * @date 2021/6/29
 */
public class Test {
    public static void main(String[] args) {
//        if (ProductEnum.DaWanQu.equals(ProductEnum.DaWanQu)) {
//            System.out.printf("true");
//        }

//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime data_1999 = LocalDateTime.of(1999, 9, 9, 1, 1);
//        long l = Duration.between(data_1999, now).toDays();
//        System.out.println(l);

        int DEFAULT = 0; //默认类型

        int ANNUITY = 1; //年金险

        int LIFE = 2; //人寿险

        int MEDICAL = 3; //医疗险

        int ACCIDENT = 4; //意外险

        int SEVERE_DISEASE = 5; //重疾险

        int ONE_YEAR = 32; //重疾险


        int type = 33;
        System.out.println(type & ANNUITY);
        System.out.println(type & ONE_YEAR);

    }


}
