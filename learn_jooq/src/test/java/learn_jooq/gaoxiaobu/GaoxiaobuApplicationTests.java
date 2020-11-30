package learn_jooq.gaoxiaobu;

import com.gaoxiaobu.pojo.Person;
import learn_jooq.gaoxiaobu.pojo.PersonCountry;
import learn_jooq.gaoxiaobu.service.IUserService;
import learn_jooq.gaoxiaobu.service.ManagerService;
import learn_jooq.gaoxiaobu.service.impl.IUserServiceImpl;
import learn_jooq.gaoxiaobu.service.impl.IUserServiceProxy;
import learn_jooq.gaoxiaobu.service.impl.MyInvocationHandler;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

       /* S1User s1User = managerService.selectOne (1);
        System.out.println("用户名："+s1User.getUsername ()+"--用户邮箱："+s1User.getEmail ());*/

        String ids = " ahs kda , dah od sha sd , ad su das ,da his du aid,h dai sdi a";
        List<String> dataSetIds = new ArrayList<String>();

        Stream.of(ids.split(",")).map(s -> s.trim()).forEach(dataSetIds::add);

        //Stream.of (ids.split (",")).forEach (dataSetIds::add);

        Iterator<String> iterator = dataSetIds.iterator ();

        while (iterator.hasNext ()) {
            String next = iterator.next ();
            System.out.println(next);
        }
    }

    @Test
    public void testStream(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person ("欧阳雪",18,"中国",'F'));
        personList.add(new Person("Tom",24,"美国",'M'));
        personList.add(new Person("Harley",22,"英国",'F'));
        personList.add(new Person("向天笑",20,"中国",'M'));
        personList.add(new Person("李康",22,"中国",'M'));
        personList.add(new Person("小梅",20,"中国",'F'));
        personList.add(new Person("何雪",21,"中国",'F'));
        personList.add(new Person("李康",22,"中国",'M'));

        // 1）找到年龄大于18岁的人并输出；
        personList.stream().filter((p) -> p.getAge() > 18).forEach(System.out::println);

        System.out.println("-------------------------------------------");

        // 2）找出所有中国人的数量
        long chinaPersonNum = personList.stream().filter((p) -> p.getCountry().equals("中国")).count();
        System.out.println("中国人有：" + chinaPersonNum);

        // limit
        personList.stream().filter((p) -> p.getSex() == 'F').limit(2).forEach(System.out::println);
        System.out.println();
        // skip
        personList.stream().filter((p) -> p.getSex() == 'F').skip(1).forEach(System.out::println);

        // distinct
        personList.stream().filter((p) -> p.getSex() == 'M').distinct().forEach(System.out::println);

        // map
        personList.stream().map((p) -> {
            PersonCountry personName = new PersonCountry();
            personName.setCountry(p.getCountry());
            return personName;
        }).distinct().forEach(System.out::println);

        // map2
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","ddd");

        /*final Stream<Stream<Character>> streamStream
                = list.stream().map(testStream::getCharacterByString);
//        streamStream.forEach(System.out::println);
        streamStream.forEach(sm -> sm.forEach(System.out::print));

        // flatMap
        final Stream<Character> characterStream = list.stream().flatMap(testStream::getCharacterByString);
        characterStream.forEach(System.out::print);*/

        // sort
        final Stream<Person> sorted = personList.stream().sorted((p1, p2) -> {

            if (p1.getAge().equals(p2.getAge())) {
                return p1.getName().compareTo(p2.getName());
            } else {
                return p1.getAge().compareTo(p2.getAge());
            }
        });
        sorted.forEach(System.out::println);

        // allMatch
        final Stream<Person> stream = personList.stream();
        final boolean adult = stream.allMatch(p -> p.getAge() >= 18);
        System.out.println("是否都是成年人：" + adult);

        final boolean chinaese = personList.stream().allMatch(p -> p.getCountry().equals("中国"));
        System.out.println("是否都是中国人：" + chinaese);

        // max min
        final Optional<Person> maxAge = personList.stream().max((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
        System.out.println("年龄最大的人信息：" + maxAge.get());

        final Optional<Person> minAge = personList.stream().min((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
        System.out.println("年龄最小的人信息：" + minAge.get());

        // reduce
        List<Integer> integerList = new ArrayList<>(100);
        for(int i = 1;i <= 100;i++) {
            integerList.add(i);
        }
        final Integer reduce = integerList.stream().reduce(0, (x, y) -> x + y);
        System.out.println("结果为：" + reduce);

        final Optional<Integer> totalAge = personList.stream().map(Person::getAge).reduce(Integer::sum);
        System.out.println("年龄总和：" + totalAge);

        // collect
        final List<String> collect = personList.stream().map(p -> p.getCountry()).distinct().collect(Collectors.toList());
        System.out.println(collect);

        final Double collect1 = personList.stream().collect(Collectors.averagingInt(p -> p.getAge()));
        System.out.println("平均年龄为：" + collect1);

        final Optional<Integer> maxAge2 = personList.stream().map(Person::getAge).collect(Collectors.maxBy(Integer::compareTo));
        System.out.println(maxAge2.get());

        try(final Stream<Integer> integerStream = personList.stream().map(Person::getAge)) {
            final Optional<Integer> minAge2 = integerStream.collect(Collectors.minBy(Integer::compareTo));
            System.out.println(minAge2.get());
        }
    }

    public static Stream<Character> getCharacterByString(String str) {

        List<Character> characterList = new ArrayList<>();

        for (Character character : str.toCharArray()) {
            characterList.add(character);
        }

        return characterList.stream();
    }

    @Test
    public void testProxy(){
        IUserService target = new IUserServiceImpl ();
        IUserServiceProxy proxy = new IUserServiceProxy (target);
        proxy.add("陈粒");
    }

}
