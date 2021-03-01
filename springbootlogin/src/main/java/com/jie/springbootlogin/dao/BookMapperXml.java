package com.jie.springbootlogin.dao;

import com.jie.springbootlogin.bean.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: jie
 */
@Mapper
public interface BookMapperXml {
    //使用xml的方式
    int updateBook(Book book);
}
