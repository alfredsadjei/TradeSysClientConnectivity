package com.ClientConnectivity.tradeSystem.utils;

import redis.clients.jedis.Jedis;

public final class ClientConnRedisClient {

    //specify not timeout with the last parameter
    private static final Jedis jedis = new Jedis("redis-17849.c59.eu-west-1-2.ec2.cloud.redislabs.com",17849,0);

    public static Jedis connect() {
        jedis.auth(RedisServer.SERVER_KEY.getKeyVal());
        return jedis;
    }
}
