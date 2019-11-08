/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RepeatAppointmentException
 * Author:   juron
 * Date:     2019/11/7 15:51
 * Description: 重复预约异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.xu.exception;

/**
 * 〈一句话功能简述〉<br> 
 * 〈重复预约异常〉
 *
 * @author juron
 * @create 2019/11/7
 * @since 1.0.0
 */
public class RepeatAppointmentException extends RuntimeException {

    public RepeatAppointmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepeatAppointmentException(String message) {
        super(message);
    }
}
