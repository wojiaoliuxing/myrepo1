package com.service.impl;


import com.dao.BookBookingMapper;
import com.entity.BookBooking;
import com.github.pagehelper.PageHelper;
import com.service.IBookBookingService;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: MrLiu
 * Date: 2019/11/7
 */
@Service("bookBookingService")
public class BookBookingServiceimpl implements IBookBookingService {
    @Resource(name = "bookBookingMapper")
    private BookBookingMapper bookBookingMapper;






    @Override
    public int insert(BookBooking bookBooking) {
        return bookBookingMapper.insert(bookBooking);
    }

    @Override
    public int insertList(List<BookBooking> bookBookingList) {
        return bookBookingMapper.insertList(bookBookingList);
    }

    @Override
    public int delete(Integer bid, Integer rid) {
        return bookBookingMapper.delete(bid,rid);
    }

    @Override
    public int deleteList(Map<Integer, Integer> d) {
        return bookBookingMapper.deleteList(d);
    }



    @Override
    public List<BookBooking> findBookBookingbyrid(Integer rid) {
        return bookBookingMapper.findBookBookingbyrid(rid);
    }

    @Override
    public List<BookBooking> findBookBookingbybid(Integer bid) {
        return bookBookingMapper.findBookBookingbybid(bid);
    }

    @Override
    public List<BookBooking> findAllBookBooking() {
        return bookBookingMapper.findAllBookBooking();
    }

    @Override
    public List<BookBooking> findAllBookBookingByPage(Integer pageNo) {
        PageHelper.startPage(pageNo,5);
        List<BookBooking> list=bookBookingMapper.findAllBookBooking();
        return list;

    }

    @Override
    public int BookingNum(Integer bid) {
      return   bookBookingMapper.findBookBookingbybid(bid).size();

    }


}
