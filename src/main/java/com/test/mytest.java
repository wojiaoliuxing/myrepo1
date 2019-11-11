package com.test;

import com.entity.BookBooking;
import com.service.IBookBookingService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: MrLiu
 * Date: 2019/11/9
 */
public class mytest {
    @Test
    public void test(){

        ApplicationContext ac=new ClassPathXmlApplicationContext("beanxml.xml");
        //获取对象
        IBookBookingService iBookBookingService=(IBookBookingService)ac.getBean("bookBookingService");

        BookBooking bookBooking=new BookBooking();
        bookBooking.setBid(84);
        bookBooking.setRid(2);
        Date date=new Date();
        bookBooking.setBookingTime(date);

        iBookBookingService.insert(bookBooking);
    }
}
