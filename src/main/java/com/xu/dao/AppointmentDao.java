package com.xu.dao;

import com.xu.entity.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentDao {

    /**
     * 插入预约图书记录
     * @param bookId
     * @param studentId
     * @return 插入的行数
     */
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    /**
     *
     * @param bookId
     * @param studentId
     * @return
     */
    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
}
