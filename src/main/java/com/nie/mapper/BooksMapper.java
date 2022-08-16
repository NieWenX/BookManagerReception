package com.nie.mapper;

import com.nie.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BooksMapper {
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

    //    6.通过书籍名查询
    Books selectByName(String bookName);
}
