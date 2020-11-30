package learn_jooq.gaoxiaobu.service.impl;

import learn_jooq.gaoxiaobu.service.IUserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    public MyInvocationHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备向数据库中插入数据");
        Object returnValue = method.invoke(obj, args);
        System.out.println("插入数据库成功");

        return returnValue;
    }
}
