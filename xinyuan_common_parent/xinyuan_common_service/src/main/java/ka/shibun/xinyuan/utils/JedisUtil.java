/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: JedisUtil
 * Author:   shibun
 * Date:     2019/3/1 19:51
 * Description: 获取Jedis连接池
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ka.shibun.xinyuan.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 * 获取Jedis连接池
 *
 * @author shibun
 * @create 2019/3/1
 * @since 1.0.0
 */
public class JedisUtil {

    static JedisPool jedisPool = null;

    static {
        //连接词的配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);//最大连接数
        jedisPoolConfig.setMaxIdle(5);//空闲最大连接数
        jedisPoolConfig.setMaxWaitMillis(2*1000);//最大连接等待时间
        jedisPoolConfig.setTestOnBorrow(true);//在借用资源的时候，进行测试时否正常
        String host = "www.eureka-7001.com";
        int port = 6379;
        int timeout = 2000;
        String password="shibun";
        jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,password);
    }

    /**
     * 获取连接池
     * @return 连接池
     */
    public static JedisPool getJedisPool(){
        return jedisPool;
    }

    /**
     * 进行设置操作
     * @param key
     * @param value
     */
    public static void set(String key,String value){
        //获取jedis实例
        Jedis resource = jedisPool.getResource();
        try {
            resource.set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resource.close();
        }
    }

    /**
     * 获取存入的值
     * @param key
     * @return
     */
    public static String get(String key){
        Jedis resource = jedisPool.getResource();
        try {
            return resource.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            resource.close();
        }
    }
    //测试连接
    public static void main(String[] args) {
        JedisPool jedisPool = JedisUtil.getJedisPool();
        Jedis resource = jedisPool.getResource();
        String set = resource.set("name", "asdf");
        String name = resource.get("name");
        resource.close();

    }


}