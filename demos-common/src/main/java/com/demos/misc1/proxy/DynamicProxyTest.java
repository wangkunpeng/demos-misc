package com.demos.misc1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kunpeng.wkp
 * @date 2017/12/31
 **/
public class DynamicProxyTest {

    interface Subject {
        void request();
    }

    /**
     * 委托类
     */
    static class RealSubject implements Subject {
        public void request() {
            System.out.println("====RealSubject Request====");
        }
    }

    /**
     * 代理类的调用处理器
     */
    static class ProxyHandler implements InvocationHandler {
        private Subject subject;

        public ProxyHandler(Subject subject) {
            this.subject = subject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("====before====");//定义预处理的工作，当然你也可以根据 method 的不同进行不同的预处理工作

            Object result = method.invoke(subject, args);

            System.out.println("====after====");

            return result;
        }

    }

    static class ProxyHandler1 implements InvocationHandler {

        private Subject subject;

        public ProxyHandler1(Subject sub) {
            this.subject = sub;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = method.invoke(proxy, args);
            return result;
        }

    }

    public static void main(String[] args) {

        RealSubject realSubject = new RealSubject();    //1.创建委托对象

        ProxyHandler handler = new ProxyHandler(realSubject);   //2.创建调用处理器对象

        Subject proxySubject = (Subject)Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
            RealSubject.class.getInterfaces(), handler);    //3.动态生成代理对象

        proxySubject.request(); //4.通过代理对象调用方法

        //Subject proxySubject1 = (Subject)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
        //RealSubject.class.getInterfaces(), handler);
        // System.out.println(RealSubject.class.getClassLoader() == Thread.currentThread().getContextClassLoader());
        //System.out.println(RealSubject.class.getClassLoader());
        //proxySubject1.request();
    }
}


