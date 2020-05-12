package com.demo.util;

import io.lettuce.core.api.StatefulRedisConnection;
import org.apache.ibatis.cache.Cache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyBatisRedisCache implements Cache {
    private StatefulRedisConnection<byte[], byte[]> connection = RedisConnectionUtil.getConnection();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private String id;

    public MyBatisRedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        this.connection.sync().set(Serializableutli.serialize(key), Serializableutli.serialize(value));
    }

    @Override
    public Object getObject(Object key) {
        byte[] data = this.connection.sync().get(Serializableutli.serialize(key));
        if (data == null) {
            return null;
        }
        return Serializableutli.deserialize(data);
    }

    @Override
    public Object removeObject(Object key) {
        return this.connection.sync().del(Serializableutli.serialize(key));
    }

    @Override
    public void clear() {
        this.connection.sync().flushdb();
    }

    @Override
    public int getSize() {
        return this.connection.sync().dbsize().intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.lock;
    }

    private static class Serializableutli {
        public static byte[] serialize(Object object) {
            byte[] result = null;
            ObjectOutputStream oos = null;
            ByteArrayOutputStream bos = null;
            try {
                bos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(bos);
                oos.writeObject(object);
                result = bos.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (oos!=null){
                    try {
                        oos.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(bos!=null){
                    try{
                        bos.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }
        public static Object deserialize(byte[] data) {
            Object result = null;
            ByteArrayInputStream bis = null;
            ObjectInputStream ois = null;
            try {
                bis = new ByteArrayInputStream(data);
                ois = new ObjectInputStream(bis);
                result = ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(bis!=null){
                    try{
                        bis.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(ois!=null){
                    try{
                        ois.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }
    }
}