/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BookDaoTest
 * Author:   juron
 * Date:     2019/11/7 13:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.xu;

import com.xu.dao.BookDao;
import com.xu.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author juron
 * @create 2019/11/7
 * @since 1.0.0
 */
public class BookDaoTest extends BaseTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryById(){
        long bookId = 1000;
        Book book = bookDao.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void testQueryAll(){
        List<Book> books = bookDao.queryAll(0,4);
        for (Book book:books){
            System.out.println(book);
        }
    }

    @Test
    public void testReduceNumber(){
        long bookId = 1000;
        int update = bookDao.reduceNumber(bookId);
        System.out.println("update:"+ update);
    }
}
