/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BookServiceImplTest
 * Author:   juron
 * Date:     2019/11/7 17:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.xu.service.impl;

import com.xu.BaseTest;
import com.xu.dto.AppointExecution;
import com.xu.service.BookService;
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
public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint(){
        long bookId = 1001;
        long studentId = 12345678910L;

        AppointExecution appointExecution = bookService.appoint(bookId, studentId);
        System.out.println(appointExecution);
    }
}
