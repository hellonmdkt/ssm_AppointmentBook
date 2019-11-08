package com.xu.dao;

import com.xu.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    /**
     * 通过id查询单本图书
     */
    Book queryById(Long id);

    /**
     *
     * @param offest 查询起始位置
     * @param limit 查询条数
     * @return
     */
    List<Book> queryAll(@Param("offest") int offest, @Param("limit") int limit);

    int reduceNumber(long bookId);
}
