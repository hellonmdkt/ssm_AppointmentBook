/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AppointmentDaoTest
 * Author:   juron
 * Date:     2019/11/7 17:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.xu;

import com.xu.dao.AppointmentDao;
import com.xu.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author juron
 * @create 2019/11/7
 * @since 1.0.0
 */
public class AppointmentDaoTest extends BaseTest{

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment(){
        long  bookId = 1000;
        long studentId = 12345678910L;
        int insert = appointmentDao.insertAppointment(bookId, studentId);
        System.out.println(("insert:"+insert));
    }

    @Test
    public void testQueryByKeyWithBook(){
        long  bookId = 1000;
        long studentId = 12345678910L;
        Appointment appointment =appointmentDao.queryByKeyWithBook(bookId, studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }
}
