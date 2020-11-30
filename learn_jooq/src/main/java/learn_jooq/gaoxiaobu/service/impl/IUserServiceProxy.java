package learn_jooq.gaoxiaobu.service.impl;

import learn_jooq.gaoxiaobu.service.IUserService;

public class IUserServiceProxy implements IUserService {

    private IUserService target;

    // 通过构造方法传入被代理对象
    public IUserServiceProxy(IUserService target) {
        this.target = target;
    }

    @Override
    public void add(String name) {
        System.out.println("准备向数据库中插入数据");
        target.add(name);
        System.out.println("插入数据库成功");
    }
}
