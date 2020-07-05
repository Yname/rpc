package com.game.game.controller;

import com.game.game.dao.UserMapper;
import com.game.game.entity.User;
import com.game.game.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/User")
public class UserController {

    @Resource
    private UserService uSerService;
    @Resource
    private User user1;
    @Resource
    private UserMapper userMapper;



    @RequestMapping("/register")
    public String addUser(User user, HttpSession session, Model model){
        user.setVip(0);
        String result = uSerService.addUser(user);
        if (result == null){
            return "error";
        }
        session.setAttribute("USERID",user.getUser_id());
        model.addAttribute("USERID",user.getUser_id());

        return "success";
    }

    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model){

        String login = uSerService.login(user,session);
        if (login.equals("error")){
            String error = "名字或密码不正确！";
            model.addAttribute("TEXT",error);
            return "error";
        }
        String welcome = "欢迎"+user.getUser_id()+"登录！";
        if (login.equals("vip")){
            model.addAttribute("USERID",welcome);
//            没有设置vip界面
            return "vip/success";
        }
        model.addAttribute("USERID",welcome);
        return "success";
    }

//    @RequestMapping("/add")
//    public void addUserAll(){
//        long start = System.currentTimeMillis();
//        for (Integer i = 70667; i < 100000 ; i++) {
//            user1.setUser_id(i.toString());
//            user1.setUser_name(i.toString());
//            user1.setUser_pwd(i.toString());
//            user1.setVip(0);
//            uSerService.addUser(user1);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("login:用时"+(end-start));
//    }

    @RequestMapping("/equip")
    public String addEquip(HttpSession session,Model model,HttpServletResponse response,
                           HttpServletRequest request) throws ServletException, IOException {

        String result = uSerService.addEquip(session);
        if (result.equals("error")){
            String error = "亲，没有这件装备！";
            model.addAttribute("TEXT",error);
            return "error";
        }
        if (result.equals("full")){
            String already = "您的装备栏已经满了！您可以成为VIP增加栏位！";
            model.addAttribute("TEXT",already);
            request.getRequestDispatcher("/User/manageAllEquip").forward(request,response);
            return "equip/AllUserEquip";
        }
        if (result.equals("AllFull")){
            String already = "您的装备栏已经达上限！";
            model.addAttribute("TEXT",already);
            request.getRequestDispatcher("/User/manageAllEquip").forward(request,response);
            return "equip/AllUserEquip";
        }
        String already = "添加完成！";
        model.addAttribute("TEXT",already);
        request.getRequestDispatcher("/User/manageAllEquip").forward(request,response);
        return "equip/AllUserEquip";
    }

    @RequestMapping("/AddEquip")
    public String jumpAddEquip(@RequestParam("ID")String equip_id, HttpServletRequest request,
                               HttpServletResponse response,HttpSession session) throws ServletException, IOException {
        session.setAttribute("EQUIPID",equip_id);

        request.getRequestDispatcher("/User/equip").forward(request,response);
        return "error";
    }
    //  对所有的装备进行分页
    @RequestMapping("/manageAllEquip")
    public String manageAllEquip(@RequestParam(defaultValue = "1")int  pageNum,
                                 @RequestParam(defaultValue = "20")int  pageSize,
                                 Model model,HttpSession session){

        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo = uSerService.getAllEquipPageInfo(session);
        model.addAttribute("pageInfo",pageInfo);
        return "equip/AllUserEquip";
    }

    @RequestMapping("/addVip")
    public String becomeVip(HttpSession session,Model model,@RequestParam("Id")int vip){

        if (vip != 1){
            String already = "验证码不正确！";
            model.addAttribute("TEXT",already);
            return "success";
        }
        String vip1 = uSerService.becomeVip(session,vip);
        if (vip1.equals("already")){
            String already = "您已经是vip了！";
            model.addAttribute("TEXT",already);
            return "success";
        }
        String success = "恭喜您成为VIP！";
        model.addAttribute("TEXT",success);
        return "success";
    }


    @RequestMapping("/delete")
    public String deleteOneEquip(@RequestParam("Id")String equip_id,HttpSession session,Model model) {

        String userid = (String) session.getAttribute("USERID");
        String result = uSerService.deleteEquip(userid, equip_id);
        if (result.equals("error")){
            String already = "您还没有这件装备！";
            model.addAttribute("TEXT",already);
            return "error";
        }
        String already = "删除成功！";
        model.addAttribute("TEXT",already);
        return "success";
    }

    @RequestMapping("/deleteAll")
    public String deleteAllEquip(HttpSession session,Model model){
        String equip = uSerService.deleteAllEquip(session);
        if (equip.equals("error")){
            String already = "您还没有装备！";
            model.addAttribute("TEXT",already);
            return "error";
        }
        String already = "已删除所有装备！";
        model.addAttribute("TEXT",already);
        return "success";
    }

    @RequestMapping("/ByName")
    public String queryUserByName(@RequestParam("Name")String user_name,HttpSession session,
                                    HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {

        session.setAttribute("TempName",user_name);
        request.getRequestDispatcher("/User/manageAll").forward(request,response);
//        PageInfo object = getObject(session);
////        model.addAttribute("USERS",object);

        return "vip/Edit";
    }


//    public PageInfo getObject(HttpSession session){
//        int pageNum = 1;
//        int pageSize = 20;
//        PageHelper.startPage(pageNum,pageSize);
//        String tempName = (String) session.getAttribute("TempName");
//        List<User> users = userDao.queryUserByName(tempName);
//        PageInfo pageInfo = new PageInfo(users);
////        model.addAttribute("USERS",pageInfo);
//        return   pageInfo;
//    }
//  管理页面分页
    @RequestMapping("/manageAll")
    public String manageAllUser(@RequestParam(defaultValue = "1")int  pageNum,
                                @RequestParam(defaultValue = "20")int  pageSize,
                                Model model,HttpSession session){

        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo = uSerService.getUserPageInfo(session);
        model.addAttribute("pageInfo",pageInfo);
        return "vip/all";
    }
//  对用户的所有装备进行分页
    @RequestMapping("/manageEquip")
    public String manageUserEquip(@RequestParam(defaultValue = "1")int  pageNum,
                                @RequestParam(defaultValue = "20")int  pageSize,
                                Model model,HttpSession session){

        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo = uSerService.getEquipPageInfo(session);
        model.addAttribute("pageInfo",pageInfo);
        return "equip/allEquip";
    }

    @RequestMapping("/cancelLogin")
    public String cancelLogin(HttpSession session){
        session.removeAttribute("USERID");
        return "index";
    }

//    @RequestMapping("/index")
//    public String jumpIndex(){
//        return "index";
//    }

    @RequestMapping("/Edit")
    public String jumpVipEdit(@RequestParam("userId")String user_id,
                              @RequestParam("userName")String user_name, Model model){

        model.addAttribute("USERID",user_id);
        model.addAttribute("USERNAME",user_name);
        return "vip/Edit";
    }

    @RequestMapping("/deleteID")
    public String jumpDeleteUser(@RequestParam("ID")String user_id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userMapper.deleteUserByUserId(user_id);
        request.getRequestDispatcher("/User/manageAll").forward(request,response);
        return "error";
    }

    @RequestMapping("/modify")
    public String jumpUpdateUserMessage(@RequestParam("userId")String user_id,
                             @RequestParam("userName")String user_name,
                             HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        System.out.println(user_id);
        request.getRequestDispatcher("/User/manageAll").forward(request,response);
        return "error";
    }

    @RequestMapping("/DeleteEquip")
    public String jumpDeleteEquip(@RequestParam("Name")String equip_name,
                                        HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userMapper.deleteEquipForEName(equip_name);
        request.getRequestDispatcher("/User/manageEquip").forward(request,response);
        return "error";
    }


}
