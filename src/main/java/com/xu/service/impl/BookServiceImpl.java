/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BookServiceImpl
 * Author:   juron
 * Date:     2019/11/7 16:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.xu.service.impl;

import com.xu.dao.AppointmentDao;
import com.xu.dao.BookDao;
import com.xu.dto.AppointExecution;
import com.xu.entity.Appointment;
import com.xu.entity.Book;
import com.xu.enums.AppointStateEnum;
import com.xu.exception.AppointException;
import com.xu.exception.NoNumberExcception;
import com.xu.exception.RepeatAppointmentException;
import com.xu.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author juron
 * @create 2019/11/7
 * @since 1.0.0
 */
@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入service依赖
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookDao.queryAll(0,1000);
    }

    @Override
    @Transactional
    public AppointExecution appoint(long bookId, long studentId) {

        try {
            //减库存
            int update = bookDao.reduceNumber(bookId);
            if (update <= 0) {
                throw new NoNumberExcception("no number");
            } else {
                //执行预约结果
                int insert = appointmentDao.insertAppointment(bookId, studentId);
                if (insert <= 0) {//重复预约
                    throw new RepeatAppointmentException("repeat appoint");
                } else {//预约成功
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
        } catch (NoNumberExcception e1) {
            throw e1;
        } catch (RepeatAppointmentException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppointException("appoint inner error:"+e.getMessage());
        }

    }
}
