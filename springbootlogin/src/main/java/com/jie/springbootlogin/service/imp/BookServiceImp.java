package com.jie.springbootlogin.service.imp;

import com.jie.springbootlogin.bean.Book;
import com.jie.springbootlogin.dao.BookMapper;
import com.jie.springbootlogin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: jie
 */
@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public int addBook(Book book){
        return bookMapper.addBook(book);
    }

}
