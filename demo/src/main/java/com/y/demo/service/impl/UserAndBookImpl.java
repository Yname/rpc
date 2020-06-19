package com.y.demo.service.impl;

import com.y.demo.dao.UserAndBookDao;
import com.y.demo.entiy.*;
import com.y.demo.service.UserAndBookService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserAndBookImpl implements UserAndBookService {

    @Resource
    private UserAndBookDao dao;

//    String book_book_idA;
//    String book_book_idB;
//    String book_book_idC;

//    @Override
//    public List<String> jumpField5(String userBook) {
//        List<String> list = new ArrayList();
//        book_book_idA = userBook + Constant.ASuffix;
//        book_book_idB = userBook + Constant.BSuffix;
//        book_book_idC = userBook + Constant.CSuffix;
//        list.add(book_book_idA);
//        list.add(book_book_idB);
//        list.add(book_book_idC);
//        return list;
//    }

    @Override
    public int queryNew_User_Id(int user_id) {
        return dao.queryNew_User_Id(user_id);
    }

    @Override
    public void addBook_Book_1(String book_book_id) {
        dao.addBook_Book_1(book_book_id);
    }

    @Override
    public void addBook_Book_2(String book_book_id) {
        dao.addBook_Book_2(book_book_id);
    }

    @Override
    public void addBook_Book_3(String book_book_id) {
        dao.addBook_Book_3(book_book_id);
    }

    @Override
    public void addBook_Id(String book_id) {
        dao.addBook_Id(book_id);
    }

    @Override
    public void updateBook_1(NewBook newBook) {
        dao.updateBook_1(newBook);
    }

    @Override
    public void updateUser_Book(NewUser newUser) {
        dao.updateUser_Book(newUser);
    }

    @Override
    public void addUser(NewUser newUser) {
        dao.addUser(newUser);
    }

    @Override
    public NewUser queryNameAndPwd(int user_id) {
        return dao.queryNameAndPwd(user_id);
    }

    @Override
    public BookBook queryBook1(String book_book_id) {
        return dao.queryBook1(book_book_id);
    }

    @Override
    public BookBook queryBook2(String book_book_id) {
        return dao.queryBook2(book_book_id);
    }

    @Override
    public BookBook queryBook3(String book_book_id) {
        return dao.queryBook3(book_book_id);
    }

    @Override
    public void addBookToBookBook1(BookBook bookBook) {
        dao.addBookToBookBook1(bookBook);
    }

    @Override
    public void addBookToBookBook2(BookBook bookBook) {
        dao.addBookToBookBook2(bookBook);
    }

    @Override
    public void addBookToBookBook3(BookBook bookBook) {
        dao.addBookToBookBook3(bookBook);
    }

    @Override
    public void addBookToBookBook4(BookBook bookBook) {
        dao.addBookToBookBook4(bookBook);
    }

    @Override
    public void addBookToBookBook5(BookBook bookBook) {
        dao.addBookToBookBook5(bookBook);
    }

    @Override
    public void addBookToBookBook11(BookBook bookBook) {
        dao.addBookToBookBook11(bookBook);
    }

    @Override
    public void addBookToBookBook22(BookBook bookBook) {
        dao.addBookToBookBook22(bookBook);
    }

    @Override
    public void addBookToBookBook33(BookBook bookBook) {
        dao.addBookToBookBook33(bookBook);
    }

    @Override
    public void addBookToBookBook44(BookBook bookBook) {
        dao.addBookToBookBook44(bookBook);
    }

    @Override
    public void addBookToBookBook55(BookBook bookBook) {
        dao.addBookToBookBook55(bookBook);
    }

    @Override
    public void addBookToBookBook111(BookBook bookBook) {
        dao.addBookToBookBook111(bookBook);
    }

    @Override
    public void addBookToBookBook222(BookBook bookBook) {
        dao.addBookToBookBook222(bookBook);
    }

    @Override
    public void addBookToBookBook333(BookBook bookBook) {
        dao.addBookToBookBook333(bookBook);
    }

    @Override
    public void addBookToBookBook444(BookBook bookBook) {
        dao.addBookToBookBook444(bookBook);
    }

    @Override
    public void addBookToBookBook555(BookBook bookBook) {
        dao.addBookToBookBook555(bookBook);
    }

    @Override
    public Book queryBook(int bookid) {
        return dao.queryBook(bookid);
    }

    @Override
    public List<Book> queryAllBook() {
        return dao.queryAllBook();
    }

    @Override
    public void deleteBookToUser1(BookBook bookBook) {
        dao.deleteBookToUser1(bookBook);
    }

    @Override
    public void deleteBookToUser2(BookBook bookBook) {
        dao.deleteBookToUser2(bookBook);
    }

    @Override
    public void deleteBookToUser3(BookBook bookBook) {
        dao.deleteBookToUser3(bookBook);
    }

    @Override
    public void deleteBookToUser4(BookBook bookBook) {
        dao.deleteBookToUser4(bookBook);
    }

    @Override
    public void deleteBookToUser5(BookBook bookBook) {
        dao.deleteBookToUser5(bookBook);
    }

    @Override
    public void deleteBookToUser11(BookBook bookBook) {
        dao.deleteBookToUser11(bookBook);
    }

    @Override
    public void deleteBookToUser22(BookBook bookBook) {
        dao.deleteBookToUser22(bookBook);
    }

    @Override
    public void deleteBookToUser33(BookBook bookBook) {
        dao.deleteBookToUser33(bookBook);
    }

    @Override
    public void deleteBookToUser44(BookBook bookBook) {
        dao.deleteBookToUser44(bookBook);
    }

    @Override
    public void deleteBookToUser55(BookBook bookBook) {
        dao.deleteBookToUser55(bookBook);
    }

    @Override
    public void deleteBookToUser111(BookBook bookBook) {
        dao.deleteBookToUser111(bookBook);
    }

    @Override
    public void deleteBookToUser222(BookBook bookBook) {
        dao.deleteBookToUser222(bookBook);
    }

    @Override
    public void deleteBookToUser333(BookBook bookBook) {
        dao.deleteBookToUser333(bookBook);
    }

    @Override
    public void deleteBookToUser444(BookBook bookBook) {
        dao.deleteBookToUser444(bookBook);
    }

    @Override
    public void deleteBookToUser555(BookBook bookBook) {
        dao.deleteBookToUser555(bookBook);
    }


}
