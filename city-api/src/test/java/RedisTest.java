import com.lyc.city.utils.RedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author lyc
 * @date 2020/7/22 15:38
 */

public class RedisTest {

    @Test
    public void GetJedisTest(){
        Jedis jedis = RedisUtil.getJedis();
        System.out.println(jedis);
    }

    @Test
    public void Setex(){
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.setex("test",60,"test");
        String test = RedisUtil.get("test");
        System.out.println(test);
    }

}
