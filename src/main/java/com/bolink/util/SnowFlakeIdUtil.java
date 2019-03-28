package com.bolink.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Random;

/**
 * id生成器
 * Created by waynelu on 2017/12/28.
 */
public class SnowFlakeIdUtil {

    /**
     * 起始的时间戳
     */
    private final static long START_STMP = 1480166465631L;

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 12; //序列号占用的位数
    private final static long MACHINE_BIT = 5;   //机器标识占用的位数
    private final static long DATACENTER_BIT = 5;//数据中心占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    //    private long datacenterId;  //数据中心
    private long machineId;     //机器标识
    private long sequence = 0L; //序列号
    private long lastStmp = -1L;//上一次时间戳

    private final static  long carNosencepaySeq = 1;
    private final static  long unionPrepayOrderSeq = 2;
    private final static  long qrCodeSeq = 3;
    private final static  long redPacketSeq = 4;
    private final static  long MobileRechargeSeq = 5;
    private final static  long ThirdUnifiedOrderSeq = 6;
    private final static  long unionOrderUnpaySeq = 7;
    public final static  long parkPayTypeAnlysis = 8;
    public final static  long operatorInfo = 9;
    public final static  long userInfo = 10;
    public final static  long unionProfitShare = 11;
    public final static  long parkComponent = 12;

    private SnowFlakeIdUtil() {
    }

    private static volatile SnowFlakeIdUtil instance;

    public synchronized static SnowFlakeIdUtil getInstance() {
        SnowFlakeIdUtil generator = instance;
        try{
            if (instance == null) {
                generator = instance;
                if (generator == null) {
                    generator = new SnowFlakeIdUtil();
                    generator.machineId = SnowFlakeIdUtil.getMachineId();
                    instance = generator;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return generator;
    }

    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized long nextId(long datacenterId) {
        long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStmp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStmp = currStmp;

        return (currStmp - START_STMP) << TIMESTMP_LEFT //时间戳部分
                | datacenterId << DATACENTER_LEFT       //数据中心部分
                | machineId << MACHINE_LEFT             //机器标识部分
                | sequence;                             //序列号部分
    }
    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized long nextId() {
        long currStmp = getNewstmp();
        currStmp = currStmp*1000+new Random().nextInt(1000);
        return currStmp;

    }
    private long getNextMill() {
        long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    private long getNewstmp() {
        return System.currentTimeMillis();
    }

    public static long getMachineId() {
        long id = 1;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            if (network == null) {
                id = 1;
            } else {
                byte[] mac = network.getHardwareAddress();
                id =
                        ((0x000000FF & (long) mac[mac.length - 1]) |
                                (0x0000FF00 & (((long) mac[mac.length - 2]) << 8))) >> 6;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return id;
    }
}
