/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BookController
 * Author:   juron
 * Date:     2019/11/8 9:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.xu.web;

import com.xu.dto.AppointExecution;
import com.xu.dto.Result;
import com.xu.entity.Book;
import com.xu.enums.AppointStateEnum;
import com.xu.exception.NoNumberExcception;
import com.xu.exception.RepeatAppointmentException;
import com.xu.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author juron
 * @create 2019/11/8
 * @since 1.0.0
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model){
        List<Book> list = bookService.getList();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "{bookId}/detail",method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model){
        if(bookId == null){
            return "redirect:book/list";
        }
        Book book = bookService.getById(bookId);
        if(book == null){
            return "forward:book/list";
        }
        model.addAttribute("book",book);
        return "detail";
    }

    @ResponseBody
    @RequestMapping(value = "{bookId}/appoint", produces = {
            "application/json; charset=utf-8" })//produces:    指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
    private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId){
        if(studentId == null || studentId.equals("")){
            return new Result<>(false, "学号不能为空");
        }

        AppointExecution execution = null;
        try {
            execution = bookService.appoint(bookId,studentId);
        }catch (NoNumberExcception e1){
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        }catch (RepeatAppointmentException e2){
            execution = new AppointExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
        }catch (Exception e){
            execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }

            return new Result<AppointExecution>(true, execution);
    }

}
