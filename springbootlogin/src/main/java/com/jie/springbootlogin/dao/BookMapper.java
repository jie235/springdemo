package com.jie.springbootlogin.dao;

import com.jie.springbootlogin.bean.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: jie
 */
@Mapper
public interface BookMapper {
    //这种使用注解的方式不需要前端提供所有的字段（必须的字段除外），如此处的三个变量，其中三个是可空的
    //语句左边是数据库中字段的变量名，右边是bean中字段的变量名
    //前端传过来的变量需要和这里同名（大小写敏感），后端才能接收到参数
    @Insert("insert into book_table(title, author, publisher, publish_date, instore_date) values(#{title}, #{author}, #{publisher}, #{publishDate}, #{instoreDate})")
    int addBook(Book book);
}
