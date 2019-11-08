/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Result
 * Author:   juron
 * Date:     2019/11/8 9:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.xu.dto;

/**
 * 〈封装json对象，所有返回结果都使用它〉<br>
 * 〈〉
 *
 * @author juron
 * @create 2019/11/8
 * @since 1.0.0
 */
public class Result<T> {

    private boolean success;//标志是否成功
    private T date;//成功时返回的数据
    private String error;//错误信息

    public Result() {
    }
    //成功时的构造器
    public Result(boolean success, T date) {
        this.success = success;
        this.date = date;
    }

    //失败时的构造器
    public Result(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
