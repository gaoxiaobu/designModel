package learn_jooq.gaoxiaobu.service;

import learn_jooq.gaoxiaobu.generated.tables.pojos.S1User;

import java.util.List;

public interface ManagerService {
    //全查詢
    List<S1User> s_1_userList();

    //保存
    String save(S1User user);

    //更新
    int update(S1User user);

    //批量更新
    int updateDetach(S1User user);

    //删除
    int delete(int id);

    //分页查询
    List<S1User> s1_userListAndPage(int page,int offSet);

    //批量删除
    int deleteDetach(List<Integer> ids);

}
