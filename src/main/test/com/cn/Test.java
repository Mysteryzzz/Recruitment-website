package com.cn;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @version: 1.0
 * @author: shuo.liu@hand-china.com
 * @date: 2019/5/3
 */
public class Test {

    @org.junit.Test
    public void test()
    {
        System.out.println(System.getProperty(" ") );
        System.out.println(this.getClass().getClassLoader().getResource(".").getPath());
    }
}
