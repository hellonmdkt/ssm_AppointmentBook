/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AppointStateEnum
 * Author:   juron
 * Date:     2019/11/7 15:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.xu.enums;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author juron
 * @create 2019/11/7
 * @since 1.0.0
 */
public enum  AppointStateEnum {

    SUCCESS(1, "预约成功"), NO_NUMBER(0, "库存不足"), REPEAT_APPOINT(-1, "重复预约"), INNER_ERROR(-2, "系统异常");

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    AppointStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static AppointStateEnum stateOf(int index){
        for(AppointStateEnum state : values()){
            if(state.getState() == index){
                return state;
            }
        }
        return  null;
    }
}
