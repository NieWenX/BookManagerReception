package com.nie.service;

import com.nie.mapper.BooksMapper;
import com.nie.pojo.Books;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService{

    @Autowired
    private BooksMapper booksMapper;

    @Override
    public Books selectById(int bookId) {
        return booksMapper.selectById(bookId);
    }

    @Override
    public List<Books> selectAll() {
        return booksMapper.selectAll();
    }

    @Override
    public Books selectByName(String bookName) {
        return booksMapper.selectByName(bookName);
    }

    @Override
    public int insertByBook(Books books) {
        return booksMapper.insertByBook(books);
    }

    @Override
    public int deleteById(int bookId) {
        return booksMapper.deleteById(bookId);
    }

    @Override
    public int updateById(Books books) {
        return booksMapper.updateById(books);
    }

    //不能有测试注解在springboot的主函数外，不然会有问题
/*    @Test
    public void test(){
        List<Books> list =  booksMapper.selectAll();
        for (Books books:list){
            System.out.println(books);
        }
    }*/
}
