package com.demo.util;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulConnection;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.ByteArrayCodec;
import io.lettuce.core.support.ConnectionPoolSupport;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.function.Supplier;

public class RedisConnectionUtil {
    public static final String REDIS_ADDRESS="redis://redis@redis/0";
    public static final int MAX_IDLE=11;
    public static final int MIN_TOTAL=1;
    public static final int MAX_TOTAL=4;
    public static final boolean TEST_ON_BORROW =true;
    private static GenericObjectPool<StatefulRedisConnection<byte[],byte[]>> pool;
    private static final RedisURI REDIS_URI = RedisURI.create(REDIS_ADDRESS);
    private static final ThreadLocal<StatefulRedisConnection<byte[],byte[]>> REDIS_CONNECTION_THREAD_LOCAL=new ThreadLocal<>();
    private static final RedisClient REDIS_CLIENT=RedisClient.create(REDIS_URI);
    static {
        GenericObjectPoolConfig config=new GenericObjectPoolConfig();
        config.setMaxIdle(MAX_IDLE);
        config.setMinIdle(MIN_TOTAL);
        config.setMaxTotal(MAX_TOTAL);
        config.setTestOnBorrow(TEST_ON_BORROW);
        pool = ConnectionPoolSupport.createGenericObjectPool(new Supplier<StatefulConnection<byte[], byte[]>>() {
            @Override
            public StatefulConnection<byte[], byte[]> get() {
                return REDIS_CLIENT.connect(new ByteArrayCodec());
            }
        },config);
    }
    public static StatefulRedisConnection getConnection(){
        StatefulRedisConnection<byte[],byte[]> connection=REDIS_CONNECTION_THREAD_LOCAL.get();
        if(connection==null){
            connection= build();
            REDIS_CONNECTION_THREAD_LOCAL.set(connection);
        }
        return connection;
    }
    public static void close(){
        StatefulRedisConnection<byte[],byte[]> connection=REDIS_CONNECTION_THREAD_LOCAL.get();
        if(connection!=null){
            connection.close();
            REDIS_CONNECTION_THREAD_LOCAL.remove();
        }
    }
    public static StatefulRedisConnection build(){
        try {
            return pool.borrowObject();
        } catch (Exception e) {
            return null;
        }
    }
}
