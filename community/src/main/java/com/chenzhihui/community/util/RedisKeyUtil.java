package com.chenzhihui.community.util;

/**
 * RedisKeyUtil
 *
 * @Author: ChenZhiHui
 * @DateTime: 2023/7/18 14:17
 **/
public class RedisKeyUtil {

    public static final String SPLIT = ":";
    public static final String  PREFIX_ENTITY_LIKE = "like:entity";
    public static final String  PREFIX_USER_LIKE = "like:user";
    public static final String PREFIX_FOLLOWEE = "followee";
    public static final String PREFIX_FOLLOWER = "follower";


    // 某个实体的赞
    // like:entity:entityType:entityId -> set(userId)
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + entityType + SPLIT + entityId;
    }

    // 用户收到的点赞 like:user:userId -> int
    public static String getUserLikeKey(int userId) {
        return PREFIX_USER_LIKE + SPLIT + userId;
    }

    // 某个用户关注的实体 followee:userId:entityType -> zset(entityId, now)
    public static String getFolloweeKey(int userId, int entityType) {
        return PREFIX_FOLLOWEE + SPLIT + userId + SPLIT + entityType;
    }

    // 某个实体拥有的粉丝 follower:userId:entityType -> zset(userId, now)
    public static String getFollowerKey(int entityType, int entityId) {
        return PREFIX_FOLLOWER + SPLIT + entityType + SPLIT + entityId;
    }


}