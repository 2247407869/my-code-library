
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @program: arithmatictest
 * @description: TODO
 * @author: LLS
 * @create: 2019-03-02 16:20
 **/
public class TestOrderMain {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        RedisTemplate r = context.getBean(RedisTemplate.class);;
        User user = new User();
        user.setName("冯吉荣");
        user.setAge("22");
        user.setSex("男");
        r.opsForValue().set("user_1", user);
        User user1 = (User)r.opsForValue().get("user_1");
        user1.print();
    }
}
