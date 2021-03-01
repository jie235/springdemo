package com.jie.springbootlogin.controller;

import com.jie.springbootlogin.bean.Book;
import com.jie.springbootlogin.service.BookService;
import com.jie.springbootlogin.service.BookServiceXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author: jie
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookServiceXml bookServiceXml;

    @RequestMapping(value="/ops/addBook", method = RequestMethod.POST)
    @ResponseBody
    public String addBook(@RequestBody Book book){
        if(book==null)return null;
        if(StringUtils.isEmptyOrWhitespace(book.getAuthor()) || StringUtils.isEmptyOrWhitespace(book.getTitle())){
            return "please fill in a valid title and author field";
        }
        bookService.addBook(book);
        return "success";
    }

    @RequestMapping(value = "/ops/updateBook",method = RequestMethod.POST)
    @ResponseBody
    public void updateBook(HttpServletRequest request, HttpServletResponse response){
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String publishDate = request.getParameter("puslishDate");
        Date date = new Date("yyyy-mm-dd");
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setPublisher(publisher);
        book.setPublishDate(publishDate);
        book.setInstoreDate(new java.sql.Date(date.getTime()).toString());
        bookServiceXml.updateBook(book);
    }
}
