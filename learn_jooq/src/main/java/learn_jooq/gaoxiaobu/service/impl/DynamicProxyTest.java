package learn_jooq.gaoxiaobu.service.impl;

import learn_jooq.gaoxiaobu.service.IUserService;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        IUserService iUserService = new IUserServiceImpl ();

        MyInvocationHandler handler = new MyInvocationHandler (iUserService);

        IUserService instance = (IUserService)Proxy.newProxyInstance (DynamicProxyTest.class.getClassLoader (), iUserService.getClass ().getInterfaces (), handler);

        instance.add ("陈奕迅");
    }
}
