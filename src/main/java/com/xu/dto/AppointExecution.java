/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AppointExecution
 * Author:   juron
 * Date:     2019/11/7 15:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.xu.dto;

import com.xu.entity.Appointment;
import com.xu.enums.AppointStateEnum;

/**
 * 〈封装预约执行后结果〉<br>
 * 〈〉
 *
 * @author juron
 * @create 2019/11/7
 * @since 1.0.0
 */
public class AppointExecution {

    private long bookId;

    //预约结果状态
    private int state;

    //状态标识
    private String stateInfo;

    //预约成功对象
    private Appointment appointment;

    public AppointExecution() {
    }

    //预约失败的构造器
    public AppointExecution(long bookId, AppointStateEnum stateEnum){
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //预约成功的构造器
    public AppointExecution(long bookId, AppointStateEnum stateEnum, Appointment appointment){
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "AppointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", appointment=" + appointment +
                '}';
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
