/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AppointException
 * Author:   juron
 * Date:     2019/11/7 15:52
 * Description: 预约业务异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.xu.exception;

/**
 * 〈一句话功能简述〉<br> 
 * 〈预约业务异常〉
 *
 * @author juron
 * @create 2019/11/7
 * @since 1.0.0
 */
public class AppointException extends RuntimeException {
    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
