package com.controller;

import com.entity.BookBooking;
import com.github.pagehelper.PageInfo;
import com.service.IBookBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: MrLiu
 * Date: 2019/11/7
 */
@Controller
@RequestMapping("/bookBooking")
public class BookBookingController {
@Resource(name = "bookBookingService")
private IBookBookingService iBookBookingService;


    @RequestMapping("/test")
    public String test(BookBooking bookBooking){
        Date date=new Date();
        bookBooking.setBookingTime(date);
iBookBookingService.insert(bookBooking);
        return "succ";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(name = "currpage",required = false) Integer currpage, Model model){
        if (currpage==null){
            currpage=1;
        }
        List<BookBooking> list=iBookBookingService.findAllBookBookingByPage(currpage);
        PageInfo<BookBooking> pageInfo=new PageInfo<BookBooking>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "show";
    }
}
