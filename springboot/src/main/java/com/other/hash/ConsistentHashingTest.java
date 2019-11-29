package com.other.hash;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author tanshaojun
 * @version 1.0
 * @date 2019/11/25 16:52
 */
public class ConsistentHashingTest {
    /**
     * 真实缓存地址
     */
    private final String[] cacheServers = {"192.168.56.101:11211", "192.168.56.102:11211", "192.168.56.103:11211"};

    /**
     * 保存虚拟节点
     */
    private final SortedMap<Long, String> nodes = new TreeMap<>();

    /**
     * 每个虚拟节点的数量
     */
    private final int VIRTUAL_NODE_NUM = 3;

    public ConsistentHashingTest() {
        //初始化
        for (String eachServer : cacheServers) {
            this.addNode(eachServer);
        }
    }

    /**
     * 创建虚拟节点
     *
     * @param nodeKey
     */
    public void addNode(String nodeKey) {
        //为每一个实体节点创建3个虚拟节点
        for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
            long eachHashCode = this.hash(nodeKey + ":" + i);
            nodes.put(eachHashCode, nodeKey);
        }
    }

    /**
     * hash 函数 可以使用 md5, sha-1, sha-256 等
     * 虽然 md5, sha-1 哈希算法在签名领域已经不再安全，但运算速度比较快，在非安全领域是可以使用的。
     * DigestUtils 是来自于 apache 中的 org.apache.commons.codec.digest 中的工具类
     *
     * @param key
     * @return
     */
    private long hash(String key) {
        String md5key = DigestUtils.md5Hex(key);
        return Long.parseLong(md5key.substring(0, 15), 16) % ((long) Math.pow(2, 32));
    }

    /**
     * 按照同一个方向寻找
     *
     * @param key
     * @return
     */
    public String getRealServer(String key) {
        long hashCode = this.hash(key);
        SortedMap<Long, String> tailMap = nodes.tailMap(hashCode);
        long serverKey = tailMap.isEmpty() ? nodes.firstKey() : tailMap.firstKey();
        return nodes.get(serverKey);
    }

    public static void main(String[] args) {
        ConsistentHashingTest t = new ConsistentHashingTest();
        System.out.println(t.getRealServer("my-cache-key"));
    }
}
