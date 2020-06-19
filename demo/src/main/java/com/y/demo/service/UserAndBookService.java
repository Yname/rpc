package com.y.demo.service;

import com.y.demo.entiy.Book;
import com.y.demo.entiy.BookBook;
import com.y.demo.entiy.NewBook;
import com.y.demo.entiy.NewUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserAndBookService {


//    List<String> jumpField5(String userBook);


    int queryNew_User_Id(int user_id);
    void addBook_Book_1(String book_book_id);
    void addBook_Book_2(String book_book_id);
    void addBook_Book_3(String book_book_id);



    void addBook_Id(String book_id);
    void updateBook_1(NewBook newBook);
    void updateUser_Book(NewUser newUser);
    void addUser(NewUser newUser);
    NewUser queryNameAndPwd(int user_id);
    BookBook queryBook1(String book_book_id);
    BookBook queryBook2(String book_book_id);
    BookBook queryBook3(String book_book_id);

    //    <!--   添加bookid  写的稀烂  只能一个一个固定的写-->

    void addBookToBookBook1(BookBook bookBook);
    void addBookToBookBook2(BookBook bookBook);
    void addBookToBookBook3(BookBook bookBook);
    void addBookToBookBook4(BookBook bookBook);
    void addBookToBookBook5(BookBook bookBook);

    void addBookToBookBook11(BookBook bookBook);
    void addBookToBookBook22(BookBook bookBook);
    void addBookToBookBook33(BookBook bookBook);
    void addBookToBookBook44(BookBook bookBook);
    void addBookToBookBook55(BookBook bookBook);

    void addBookToBookBook111(BookBook bookBook);
    void addBookToBookBook222(BookBook bookBook);
    void addBookToBookBook333(BookBook bookBook);
    void addBookToBookBook444(BookBook bookBook);
    void addBookToBookBook555(BookBook bookBook);

//
    Book queryBook(int bookid);
    List<Book> queryAllBook();
    void deleteBookToUser1(BookBook bookBook);
    void deleteBookToUser2(BookBook bookBook);
    void deleteBookToUser3(BookBook bookBook);
    void deleteBookToUser4(BookBook bookBook);
    void deleteBookToUser5(BookBook bookBook);

    void deleteBookToUser11(BookBook bookBook);
    void deleteBookToUser22(BookBook bookBook);
    void deleteBookToUser33(BookBook bookBook);
    void deleteBookToUser44(BookBook bookBook);
    void deleteBookToUser55(BookBook bookBook);

    void deleteBookToUser111(BookBook bookBook);
    void deleteBookToUser222(BookBook bookBook);
    void deleteBookToUser333(BookBook bookBook);
    void deleteBookToUser444(BookBook bookBook);
    void deleteBookToUser555(BookBook bookBook);
}
