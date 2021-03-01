package com.jie.springbootlogin.service.imp;

import com.jie.springbootlogin.bean.Book;
import com.jie.springbootlogin.dao.BookMapperXml;
import com.jie.springbootlogin.service.BookServiceXml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: jie
 */
@Service
public class BookServiceXmlImp implements BookServiceXml {

    @Autowired
    private BookMapperXml bookMapperXml;

    @Override
    public int updateBook(Book book){
        return bookMapperXml.updateBook(book);
    }
}
