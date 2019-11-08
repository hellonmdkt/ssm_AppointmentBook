/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BookService
 * Author:   juron
 * Date:     2019/11/7 15:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.xu.service;

import com.xu.dto.AppointExecution;
import com.xu.entity.Book;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author juron
 * @create 2019/11/7
 * @since 1.0.0
 */
public interface BookService {
    /**
     * 查询一本图书
     */
     Book getById(long bookId);

    /**
     * 查询所有图书
     */
    List<Book> getList();

    /**
     * 预约图书
     * @param bookId
     * @param studentId
     * @return
     */
    AppointExecution appoint(long bookId, long studentId);
}
