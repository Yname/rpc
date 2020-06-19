package com.y.demo.controller;

import com.y.demo.entiy.*;
import com.y.demo.service.NewGameService;
import com.y.demo.service.UserAndBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/NUser")
public class UserController implements Constant {

    String book_book_idA;
    String book_book_idB;
    String book_book_idC;
    String Friend_FriendA;
    String Friend_FriendB;
    String Friend_FriendC;
    String book_id;

    @Resource
    private UserAndBookService userAndBookService;
    @Resource
    private NewUser newUser;
    @Resource
    private NewBook newBook;
    @Resource
    private Book book;
    @Resource
    private NewFriend newFriend;
    @Resource
    private NewGameService newGameService;


//
//    public UserAndBookService getHandler(){
//        InvocationHandler handler = new GameHandler(userAndBookService);
//        userAndBookService =
//                (UserAndBookService) Proxy.newProxyInstance(userAndBookService.getClass().getClassLoader(),
//                        userAndBookService.getClass().getInterfaces(), handler);
//        return userAndBookService;
//    }


//  这一块太过于臃肿了 ，后续要改进
    @RequestMapping("/register")
    public String register(@RequestParam("Id")Integer user_id,
                           @RequestParam("Name")String user_name,
                           @RequestParam("Pwd")String user_pwd,
                           Model model, HttpSession session){

        long start = System.currentTimeMillis();
        int i = userAndBookService.queryNew_User_Id(user_id);
        if (i >= 1){
            String success = "账号已存在！";
            model.addAttribute("error",success);
            return "error";
        }
//        book_book_idA = user_id.toString() + Constant.ASuffix;
//        book_book_idB = user_id.toString() + Constant.BSuffix;
//        book_book_idC = user_id.toString() + Constant.CSuffix;
//        添加外键book_book_id外键
//        userAndBookService.addBook_Book_1(strings.get(0));
//        userAndBookService.addBook_Book_2(strings.get(1));
//        userAndBookService.addBook_Book_3(strings.get(2));
//        book_id = user_id.toString();
//        userAndBookService.addBook_Id(book_id);
//        外键链接更新  book_book_1(book_book_id) -> newbook(book_1)
//        newBook.setBook_id(book_id);
//        newBook.setBook_1(strings.get(0));
//        newBook.setBook_2(strings.get(1));
//        newBook.setBook_3(strings.get(2));
//        userAndBookService.updateBook_1(newBook);
        //        userAndBookService.addUser(newUser);
//        newUser.setUser_book(book_id);
//        userAndBookService.updateUser_Book(newUser);
//        获取book_book_idABC不同的值
        List<String> strings = jumpField5(user_id.toString());
//        List<String> friend55 = jumpFriend55(user_id.toString());

        book_id = user_id.toString();
        addFriend(book_id);
//        Friend_FriendA = book_id + Constant.ASuffix;
//        newGameService.addFriend_Friend(Friend_FriendA);
//        newGameService.addFriend_Id(book_id);
//        newFriend.setFriend_id(book_id);
//        newFriend.setFriend_1(Friend_FriendA);
//        newGameService.updateNewFriend(newFriend);

//      根据不同的表添加不同的book_book_idABC
        addBook_Book(strings,book_id);
//        for (int j = 1; j <= 3; j++) {
//            switch (j){
//                case 1 :
//                    newGameService.addFriend_Friend(friend55.get(0));
//                case 2:
//                    newGameService.addFriend_Friend(friend55.get(1));
//                case 3:
//                    newGameService.addFriend_Friend(friend55.get(2));
//            }
//        }
//        newGameService.addFriend_Id(book_id);
//        设置newBook的值并更新
        insertAndUpdateBook(book_id,strings);

//        insertAndUpdateFriend55(book_id,friend55);

        newUser.setUser_id(user_id);
        newUser.setUser_name(user_name);
        newUser.setUser_pwd(user_pwd);
//      添加，设置newUser的值，更新newUser中user_book的值
        addAndUpdate(newUser,book_id);
        session.setAttribute("PhoneId",user_id);
        String success = "注册成功!欢迎你的加入！";
        model.addAttribute("success",success);
        long end = System.currentTimeMillis();
        System.out.println("注册用时"+(end - start));
        return "success";
    }
//根据不同的表添加不同的book_book_idABC
    public void addBook_Book(List<String> strings,String user_id){
        userAndBookService.addBook_Book_1(strings.get(0));
        userAndBookService.addBook_Book_2(strings.get(1));
        userAndBookService.addBook_Book_3(strings.get(2));
        userAndBookService.addBook_Id(user_id);
    }

    public void addFriend(String book_id){
        Friend_FriendA = book_id + Constant.ASuffix;
//        List<String> friend55 = jumpFriend55(book_id);
        newGameService.addFriend_Friend(Friend_FriendA);
        newGameService.addFriend_Id(book_id);
        newFriend.setFriend_id(book_id);
        newFriend.setFriend_1(Friend_FriendA);
        newGameService.updateNewFriend(newFriend);
    }
    public void addFriend_Friend_ID(List<String> strings,String user_id){
//        userAndBookService.addBook_Book_1(strings.get(0));
//        userAndBookService.addBook_Book_2(strings.get(1));
//        userAndBookService.addBook_Book_3(strings.get(2));
        newGameService.addFriend_Friend(strings.get(0));
        userAndBookService.addBook_Id(user_id);
    }
//    设置newBook的值并更新
    public void insertAndUpdateBook(String book_id,List<String> strings){
        newBook.setBook_id(book_id);
        newBook.setBook_1(strings.get(0));
        newBook.setBook_2(strings.get(1));
        newBook.setBook_3(strings.get(2));
        userAndBookService.updateBook_1(newBook);
    }
    public void insertAndUpdateFriend55(String book_id,List<String> strings){
        newFriend.setFriend_id(book_id);
        newFriend.setFriend_1(strings.get(0));
        newFriend.setFriend_2(strings.get(1));
        newFriend.setFriend_3(strings.get(2));
        newGameService.updateNewFriend(newFriend);
    }
    //    FriendFriend
    public List<String> jumpFriend55(String userBook){
        List<String> list = new ArrayList();
        Friend_FriendA = userBook + Constant.ASuffix;
        Friend_FriendB = userBook + Constant.BSuffix;
        Friend_FriendC = userBook + Constant.CSuffix;
        list.add(Friend_FriendA);
        list.add(Friend_FriendB);
        list.add(Friend_FriendC);
        return list;
    }
//    添加，设置newUser的值，更新newUser中user_book的值
    public void addAndUpdate(NewUser newUser,String book_id){
        userAndBookService.addUser(newUser);
        newUser.setUser_book(book_id);
        newUser.setUser_friend(book_id);
        userAndBookService.updateUser_Book(newUser);
    }


    @RequestMapping("/login")
    public String login(@RequestParam("Id")Integer user_id,
                           @RequestParam("Name")String user_name,
                           @RequestParam("Pwd")String user_pwd,
                           Model model, HttpSession session){

        long start = System.currentTimeMillis();
        int i = userAndBookService.queryNew_User_Id(user_id);
        newUser = userAndBookService.queryNameAndPwd(user_id);
        if (i == 0 || !newUser.getUser_pwd().equals(user_pwd) || !newUser.getUser_name().equals(user_name)){
            String success = "密码或账号不正确！";
            model.addAttribute("error",success);
            return "error";
        }
        session.setAttribute("PhoneId",user_id);
        session.setAttribute("UserBook",newUser.getUser_book());
        long end = System.currentTimeMillis();
        System.out.println("登录用时"+(end - start));
        return "success";
    }


//有一个问题，表最开始默认为null，后续中以是否为0进行判断，执行时，会全部初始一个表中的为null值的栏位，造成卡顿
//   1 改进方法，可以将表值，设置为String，用null来判断
//   2 在注册的时候分配0值
    @RequestMapping("/addBook")
    public String addBook(@RequestParam("BookId")Integer bookid,HttpSession session,Model model){

        long start = System.currentTimeMillis();
//        jumpField3用于获取book_book_idA.B.C的值
        List<String> strings = jumpField3(session);
//        jumpField4用于获取BookBook1.2.3的对象
        List<BookBook> bookList = jumpField4(strings);
//        用于轮询jumpField2，jumpBook
        String s = jumpField1(bookList, bookid, strings);
        if (s == null){
            String error = "栏位已沾满！请及时清理！";
            model.addAttribute("error",error);
            long end = System.currentTimeMillis();
            System.out.println("addBook用时："+(end - start));
            return "error";
        }
        String success = "添加成功！";
        model.addAttribute("success",success);
        long end = System.currentTimeMillis();
        System.out.println("addBook用时："+(end - start));
        return "success";
    }
//    用的是顺序查询
//    从上下文中获取NewUser表中的User_Book
    public List<String> jumpField3(HttpSession session){
//        List<String> list = new ArrayList();
        String userBook = (String) session.getAttribute("UserBook");
//        List<String> string =
//        book_book_idA = userBook + Constant.ASuffix;
//        book_book_idB = userBook + Constant.BSuffix;
//        book_book_idC = userBook + Constant.CSuffix;
//        list.add(book_book_idA);
//        list.add(book_book_idB);
//        list.add(book_book_idC);
        return jumpField5(userBook);
    }
//    用于输出book_book_idABC不同的值
//    BookBook
    public List<String> jumpField5(String userBook){
        List<String> list = new ArrayList();
        book_book_idA = userBook + Constant.ASuffix;
        book_book_idB = userBook + Constant.BSuffix;
        book_book_idC = userBook + Constant.CSuffix;
        list.add(book_book_idA);
        list.add(book_book_idB);
        list.add(book_book_idC);
        return list;
    }

    public List<BookBook> jumpField4(List<String> strings){
        BookBook bookBook1 = userAndBookService.queryBook1(strings.get(0));
        BookBook bookBook2 = userAndBookService.queryBook2(strings.get(1));
        BookBook bookBook3 = userAndBookService.queryBook3(strings.get(2));
        List<BookBook> bookList = new ArrayList<>();
        bookList.add(bookBook1);
        bookList.add(bookBook2);
        bookList.add(bookBook3);
        return bookList;
    }
    public String jumpField1(List<BookBook> bookList, Integer bookid, List<String> strings){
        for (int i = 0; i < bookList.size(); i++) {
            BookBook bookBook = bookList.get(i);
//            用于轮询空的栏位，并返回空栏位的位数
            List<Object> objects = jumpField2(bookBook, bookid);
            if (objects != null){
//                获取了位于 次级的 第几个的
                int L = (int) objects.get(1);
//                轮询jumpFieldA.B.C,在newbook表中 依序 查询
                String s = jumpBook(i,bookList, strings);
                if (s != null){
                    switch (s){
                        case "1":
                            jumpFieldA(L,bookBook);
                            return "1";
                        case "2":
                            jumpFieldB(L,bookBook);
                            return "2";
                        case "3":
                            jumpFieldC(L,bookBook);
                            return "3";
                        default:
                            return null;
                    }

                }
            }
        }
        return null;
    }
    public List<Object> jumpField2(BookBook bookBook,int bookid){
        List<Object> objects = new ArrayList();
        objects.add(bookBook);
        if (bookBook.getBook_book_field1() == 0){
            bookBook.setBook_book_field1(bookid);
            objects.add(1);
        }else if (bookBook.getBook_book_field2() == 0){
            bookBook.setBook_book_field2(bookid);
            objects.add(2);
        }else if (bookBook.getBook_book_field3() == 0){
            bookBook.setBook_book_field3(bookid);
            objects.add(3);
        }else if (bookBook.getBook_book_field4() == 0){
            bookBook.setBook_book_field4(bookid);
            objects.add(4);
        }else if (bookBook.getBook_book_field5() == 0){
            bookBook.setBook_book_field5(bookid);
            objects.add(5);
        }else {
            return null;
        }
        return objects;
    }
    public String jumpBook(int i, List<BookBook> bookList, List<String> strings){
//        此处L为次级表中的栏位的列数
        switch (i){
            case 0:
                bookList.get(0).setBook_book_id(strings.get(0));
//                jumpFieldA(L,bookBook);
                return "1";
            case 1:
                bookList.get(1).setBook_book_id(strings.get(1));
//                jumpFieldB(L,bookBook);
                return "2";
            case 2:
                bookList.get(2).setBook_book_id(strings.get(2));
//                jumpFieldC(L,bookBook);
                return "3";
            default:
                return null;
        }

    }
    public void jumpFieldA(int i, BookBook bookBook){
        switch (i){
            case 1:
                userAndBookService.addBookToBookBook1(bookBook);
            case 2:
                userAndBookService.addBookToBookBook2(bookBook);
            case 3:
                userAndBookService.addBookToBookBook3(bookBook);
            case 4:
                userAndBookService.addBookToBookBook4(bookBook);
            case 5:
                userAndBookService.addBookToBookBook5(bookBook);
        }
    }
    public void jumpFieldB(int i, BookBook bookBook){
        switch (i){
            case 1:
                userAndBookService.addBookToBookBook11(bookBook);
            case 2:
                userAndBookService.addBookToBookBook22(bookBook);
            case 3:
                userAndBookService.addBookToBookBook33(bookBook);
            case 4:
                userAndBookService.addBookToBookBook44(bookBook);
            case 5:
                userAndBookService.addBookToBookBook55(bookBook);
            default:
        }
    }
    public void jumpFieldC(int i, BookBook bookBook){
        switch (i){
            case 1:
                userAndBookService.addBookToBookBook111(bookBook);
            case 2:
                userAndBookService.addBookToBookBook222(bookBook);
            case 3:
                userAndBookService.addBookToBookBook333(bookBook);
            case 4:
                userAndBookService.addBookToBookBook444(bookBook);
            case 5:
                userAndBookService.addBookToBookBook555(bookBook);

        }
    }


    @RequestMapping("/queryUserBooK")
    public String queryUserBooK(HttpSession session,Model model){

        long start = System.currentTimeMillis();
        String userBook = (String) session.getAttribute("UserBook");
//        获取book_book_idABC
        List<String> strings = jumpField5(userBook);
//        获取book_book_1,2,3表
        List<BookBook> bookList = jumpField4(strings);
//        轮询
        List<Object> objects = queryField1(bookList);
//        List<Book> listBook = new ArrayList<>();
//        book_book_id = userBook + Constant.ASuffix;
//        bookBook = userAndBookService.queryBook1(book_book_id);
//        if (bookBook.getBook_book_field1() != 0){
//            book = userAndBookService.queryBook(bookBook.getBook_book_field1());
//            listBook.add(book);
//        }
//        if (bookBook.getBook_book_field2() != 0){
//            book = userAndBookService.queryBook(bookBook.getBook_book_field2());
//            listBook.add(book);
//        }
//        if (bookBook.getBook_book_field3() != 0){
//            book = userAndBookService.queryBook(bookBook.getBook_book_field3());
//            listBook.add(book);
//        }
//        if (bookBook.getBook_book_field4() != 0){
//            book = userAndBookService.queryBook(bookBook.getBook_book_field4());
//            listBook.add(book);
//        }
//        if (bookBook.getBook_book_field5() != 0){
//            book = userAndBookService.queryBook(bookBook.getBook_book_field5());
//            listBook.add(book);
//        }
        model.addAttribute("Book",objects);
        long end = System.currentTimeMillis();
        System.out.println("queryUserBooK用时："+(end - start));
        return "success";
    }
    public List<Object> queryField1(List<BookBook> bookList){
//      轮询book_book_1,2,3表
        List<Object> bookArray = new ArrayList();
        for (BookBook bookBook : bookList) {
            bookArray.addAll(queryField2(bookBook));
        }
//        for (int i = 0; i <bookList.size() ; i++) {
//            BookBook bookBook = bookList.get(i);
//            bookArray.addAll(queryField2(bookBook));
//        }
        return bookArray;
    }
//    顺序查询book_book_1中的所有非0的值(即所有书本)
    public List<Object> queryField2(BookBook bookBook){
        List<Object> objects = new ArrayList();
        if (bookBook.getBook_book_field1() != 0){
            book = userAndBookService.queryBook(bookBook.getBook_book_field1());
            objects.add(book);
        }
        if (bookBook.getBook_book_field2() != 0){
            book = userAndBookService.queryBook(bookBook.getBook_book_field2());
            objects.add(book);
        }
        if (bookBook.getBook_book_field3() != 0){
            book = userAndBookService.queryBook(bookBook.getBook_book_field3());
            objects.add(book);
        }
        if (bookBook.getBook_book_field4() != 0){
            book = userAndBookService.queryBook(bookBook.getBook_book_field4());
            objects.add(book);
        }
        if (bookBook.getBook_book_field5() != 0){
            book = userAndBookService.queryBook(bookBook.getBook_book_field5());
            objects.add(book);
        }
        return objects;
    }



    @RequestMapping("/queryAllBook")
    public String  queryAllBook(Model model){
        long start = System.currentTimeMillis();
        List<Book> listBook = userAndBookService.queryAllBook();
        model.addAttribute("Book",listBook);
        long end = System.currentTimeMillis();
        System.out.println("queryAllBooK用时："+(end - start));
        return "success";
    }


//    优化了一下，任然很庞大复杂
    @RequestMapping("/deleteBookToUser")
    public String  deleteBookToUser(@RequestParam("BookId")Integer book_id,
                                    HttpSession session,Model model){

        long start = System.currentTimeMillis();
        Integer phoneId = (Integer) session.getAttribute("PhoneId");
        List<String> strings = jumpField5(phoneId.toString());
        List<BookBook> bookList = jumpField4(strings);
        String s = deleteField(bookList, book_id, strings);
        if (s == null){
            String success = "你还没有加入这本书，无法删除！";
            model.addAttribute("error",success);
            return "error";
        }
//        book_book_id = phoneId.toString() + Constant.ASuffix;
//        bookBook = userAndBookService.queryBook1(book_book_id);
//        if (bookBook.getBook_book_field1() == book_id){
//            bookBook.setBook_book_field1(0);
//            userAndBookService.deleteBookToUser1(bookBook);
//        }else if (bookBook.getBook_book_field2() == book_id){
//            bookBook.setBook_book_field2(0);
//            userAndBookService.deleteBookToUser2(bookBook);
//        }else if (bookBook.getBook_book_field3() == book_id){
//            bookBook.setBook_book_field3(0);
//            userAndBookService.deleteBookToUser3(bookBook);
//        }else if (bookBook.getBook_book_field4() == book_id){
//            bookBook.setBook_book_field4(0);
//            userAndBookService.deleteBookToUser4(bookBook);
//        }else if (bookBook.getBook_book_field5() == book_id){
//            bookBook.setBook_book_field5(0);
//            userAndBookService.deleteBookToUser5(bookBook);
//        }else {
//            String success = "你还没有这本书！";
//            model.addAttribute("error",success);
//            return "error";
//        }
        String success = "删除成功！";
        model.addAttribute("success",success);
        long end = System.currentTimeMillis();
        System.out.println("删除用时："+(end - start));
        return "success";
    }
    public String deleteField(List<BookBook> bookList, Integer bookid, List<String> strings){
        for (int i = 0; i < bookList.size(); i++) {
            BookBook bookBook = bookList.get(i);
//            用于轮询空的栏位，并返回空栏位的位数
            List<Object> objects = deleteField2(bookBook, bookid);
            if (objects != null){
//                获取了位于 次级的 第几个的
                int L = (int) objects.get(1);
//                轮询jumpFieldA.B.C,在newbook表中 依序 查询
                String s = jumpBook(i,bookList, strings);
                if (s != null){
                    switch (s){
                        case "1":
                            deleteFieldA(L,bookBook);
                            return "1";
                        case "2":
                            deleteFieldB(L,bookBook);
                            return "2";
                        case "3":
                            deleteFieldC(L,bookBook);
                            return "3";
                        default:
                            return null;
                    }

                }
            }
        }
        return null;
    }
    public List<Object> deleteField2(BookBook bookBook,int book_id){
        List<Object> objects = new ArrayList();
        objects.add(bookBook);
        if (bookBook.getBook_book_field1() == book_id){
            bookBook.setBook_book_field1(0);
            objects.add(1);
        }else if (bookBook.getBook_book_field2() == book_id){
            bookBook.setBook_book_field2(0);
            objects.add(2);
        }else if (bookBook.getBook_book_field3() == book_id){
            bookBook.setBook_book_field3(0);
            objects.add(3);
        }else if (bookBook.getBook_book_field4() == book_id){
            bookBook.setBook_book_field4(0);
            objects.add(4);
        }else if (bookBook.getBook_book_field5() == book_id) {
            bookBook.setBook_book_field5(0);
            objects.add(5);
//            userAndBookService.deleteBookToUser5(bookBook);
        }else {
            return null;
        }
        return objects;
    }
    public void deleteFieldA(int i, BookBook bookBook){
        switch (i){
            case 1:
                userAndBookService.deleteBookToUser1(bookBook);
            case 2:
                userAndBookService.deleteBookToUser2(bookBook);
            case 3:
                userAndBookService.deleteBookToUser3(bookBook);
            case 4:
                userAndBookService.deleteBookToUser4(bookBook);
            case 5:
                userAndBookService.deleteBookToUser5(bookBook);
        }
    }
    public void deleteFieldB(int i, BookBook bookBook){
        switch (i){
            case 1:
                userAndBookService.deleteBookToUser11(bookBook);
            case 2:
                userAndBookService.deleteBookToUser22(bookBook);
            case 3:
                userAndBookService.deleteBookToUser33(bookBook);
            case 4:
                userAndBookService.deleteBookToUser44(bookBook);
            case 5:
                userAndBookService.deleteBookToUser55(bookBook);
            default:
        }
    }
    public void deleteFieldC(int i, BookBook bookBook){
        switch (i){
            case 1:
                userAndBookService.deleteBookToUser111(bookBook);
            case 2:
                userAndBookService.deleteBookToUser222(bookBook);
            case 3:
                userAndBookService.deleteBookToUser333(bookBook);
            case 4:
                userAndBookService.deleteBookToUser444(bookBook);
            case 5:
                userAndBookService.deleteBookToUser555(bookBook);

        }
    }



    @RequestMapping("/removeLogin")
    public String removeLogin(HttpSession session){
        session.removeAttribute("PhoneId");
        return "index";
    }



}
