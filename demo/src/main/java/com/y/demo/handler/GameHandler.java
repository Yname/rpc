package com.y.demo.handler;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GameHandler implements InvocationHandler {

    Object object;
    public GameHandler(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(object,args);
        return null;
    }




//    public GameService gameHandler(){
//        GameService service = new GameServiceImpl();
//        InvocationHandler handler = new GameHandler(service);
//        service = (GameService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
//                service.getClass().getInterfaces(), handler);
//        return  service;
//    }
//
//    public static void main(String[] args) {
//        GameService service = new GameServiceImpl();
//        GameHandler handler = new GameHandler(service);
//        GameService service1 = (GameService) handler.gameHandler();
//        GameUser gameUser = service1.queryByUserId(963);
//        System.out.println(gameUser.getUser_name());
//        System.out.println(service1.getClass().getName());
//    }



//    interface A{
//        void print();
//    }
//
//    static class B implements A{
//        @Override
//        public void print() {
//            System.out.println("A");
//        }
//    }
//
//
//
//    public static void main(String[] args) {
//        GameDao dao = new GameDaoImpl();
//        InvocationHandler handler = new GameHandler(dao);
////        Proxy.getInvocationHandler(GameHandler.class).
//        GameDao o = (GameDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), handler);
//        o.queryByUserId(963);
//    }
}
