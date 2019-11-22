package com.burning8393.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TankTimeInteceptor());
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}

class TankTimeInteceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println("method start...");
        Object result = null;
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("method end");
        return result;
    }
}

class Tank {
    public void move() {
        System.out.println("tank moving kalakala...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}