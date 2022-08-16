package com.nie.service;

import com.nie.pojo.Books;

import java.util.List;

public interface BooksService {
    //    1. 通过id查询
    Books selectById(int bookId);

    //    2. 查询全部
    List<Books> selectAll();

    //    3. 插入一个Books
    int insertByBook(Books books);

    //    4. 通过id删除
    int deleteById(int bookId);

    //    5. 通过id更新
    int updateById(Books books);

    Books selectByName(String bookName);
}
