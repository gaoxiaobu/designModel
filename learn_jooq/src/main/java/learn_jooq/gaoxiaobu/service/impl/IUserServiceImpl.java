package learn_jooq.gaoxiaobu.service.impl;

import learn_jooq.gaoxiaobu.service.IUserService;

public class IUserServiceImpl implements IUserService {

    @Override
    public void add(String name) {
        System.out.println(name);
    }
}
