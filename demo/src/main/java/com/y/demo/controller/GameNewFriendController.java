package com.y.demo.controller;

import com.y.demo.entiy.Constant;
import com.y.demo.service.NewGameService;
import com.y.demo.service.impl.GameServiceImpl;
import com.y.demo.service.impl.NewGameServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Controller
@RequestMapping("/NNUser")
public class GameNewFriendController {

    @Resource
    NewGameService newGameService;
//    NewGameService gameService = (NewGameService) Proxy.newProxyInstance(newGameService.getClass().getClassLoader(),
//            newGameService.getClass().getInterfaces(), new InvocationHandler() {
//                @Override
//                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                    method.invoke(gameService,args);
//                    return null;
//                }
//            });
//    使用自定义的动态代理会绕过spring的代理，导致spring的代理与自己的代理无法统一
public NewGameService getHandler(){
    NewGameService gameService = new NewGameServiceImpl();
    return (NewGameService) Proxy.newProxyInstance(gameService.getClass().getClassLoader(),
            gameService.getClass().getInterfaces(),
            (proxy, method, args) -> method.invoke(gameService, args));
}

    @RequestMapping("/name")
    public String tests(){
        long start = System.currentTimeMillis();
//        newGameService.addFriendField();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return "success";
    }
    @RequestMapping("/columns")
    public String queryColumnS(){
        long start = System.currentTimeMillis();
        int columnS = newGameService.queryColumnS("new_book");
        long end = System.currentTimeMillis();
        System.out.println(columnS);
        System.out.println(end - start);
        return "success";
    }
//
    @RequestMapping("/table")
    public String addField(){
//        long start = System.currentTimeMillis();
//        List<String> strings = newGameService.queryTableName();
//        for (String s : strings
//             ) {
//            if (s.endsWith("d_1")){
//                int columnS = newGameService.queryColumnS(s);
//                newGameService.addFriendField(columnS);
//            }
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//        newGameService.addField();
        int columnS = newGameService.queryColumnSImpl();
        newGameService.addFriendField(columnS);
        return "success";
    }

    @RequestMapping("/expandC")
    public String expandCCapacity(HttpSession session, Model model){
        long start = System.currentTimeMillis();
        int length = 5;
        Integer phoneId = (Integer) session.getAttribute("PhoneId");
        String expandCapacity =
                newGameService.expandCapacity(length, phoneId.toString()+ Constant.ASuffix);
        if (expandCapacity.equals("error")){
            String error = "亲！您的栏位已经是最大值！请充值vip或者增加栏位！";
            model.addAttribute("error",error);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            return "error";
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return "success";
    }

}
