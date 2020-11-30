package learn_jooq.gaoxiaobu;

import learn_jooq.gaoxiaobu.generated.tables.pojos.S1User;
import learn_jooq.gaoxiaobu.service.ManagerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RunWith (SpringRunner.class)
@SpringBootTest(classes = {GaoxiaobuApplication.class})
class GaoxiaobuApplicationTests {
    
    @Autowired
    private ManagerService managerService;

    private LocalDateTime now = LocalDateTime.now ();

    @Test
    void contextLoads() {

        /*managerService.update (new S1User (3,"高小布","1282314694@qq.com","北京",now,now));*/

        /*

        managerService.save (new S1User (3,"高小布","1282314694@qq.com","帝都",now,now));*/

        //managerService.updateDetach (new S1User (3,"高小布","gaoxiaobu@com.bonc.cn","帝都",now,now));

        /*managerService.delete (3);*/

        /*List<S1User> s1Users = managerService.s_1_userList ();
        for (S1User s1User: s1Users) {
            System.out.println(s1User.getUsername ());
            System.out.println(s1User.getAddress ());
            System.out.println(s1User.getCreateTime ());
            System.out.println(s1User.getUpdateTime ());
            System.out.println(s1User.getEmail ());
        }*/

        S1User s1User = managerService.selectOne (1);
        System.out.println("用户名："+s1User.getUsername ()+"--用户邮箱："+s1User.getEmail ());

    }

}
