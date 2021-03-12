package com.rpc.myrpc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.text.ParseException;

@Configuration
@EnableAspectJAutoProxy
public class Test {


    public static void main(String[] args) throws ParseException, InstantiationException, IllegalAccessException {

//        context.getBean()

//        SpringApplication.run(new Class[]{Test.class,Test.BB.class},args);
//
//        bb.postProcessBeforeInitialization(a,"start");
//        String strDateFormat = "yyyy-MM-dd";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);
//        String format = simpleDateFormat.format("");
//
//        simpleDateFormat.parse(format);
//
//        System.out.println(format);



        System.out.println(A.class.getSimpleName());
//        A a = new A("yzz");


    }

//    @Component
//    class BB implements BeanPostProcessor{
//
//        @Order(value = 6)
//        @Override
//        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//            System.out.println("BBBBBBB");
//            return bean;
//        }
//
//        @PostConstruct
//        void start(){
//
//            System.out.println("start");
//        }
//
//        @PreDestroy
//        void stop(){
//            System.out.println("stop");
//        }
//
//
//    }
//
//
//    @Component
//     class A implements MethodReplacer {
//
//        A(){
//            System.out.println("AAA");
//         }
//         @Override
//         public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
//             return null;
//         }
//
//         @PostConstruct
//         void start(){
//             System.out.println("start");
//         }
//
//
//         @PreDestroy
//         void destroy(){
//             System.out.println("destroy");
//         }
//
//
//     }

    static class A{

        private String name ;
        A(String name){

            System.out.println(getName());
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }






}
