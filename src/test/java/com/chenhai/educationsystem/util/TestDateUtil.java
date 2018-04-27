package com.chenhai.educationsystem.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestDateUtil {

    private DateUtil dateUtil= new DateUtil();

    @Test
    public void test(){
        System.out.println(dateUtil.getTomorrowBegin());
        System.out.println(dateUtil.getTomorrowEnd());
    }
}
