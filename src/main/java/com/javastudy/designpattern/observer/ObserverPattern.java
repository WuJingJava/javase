package com.javastudy.designpattern.observer;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName: ObserverPattern
 * @Description: 观察设计模式
 * @Author liujiexin
 * @Date 2021/5/17 12:57 上午
 */
public class ObserverPattern {

    private static Logger logger = LoggerFactory.getLogger(ObserverPattern.class);

    public static void main(String[] args) {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.doDraw("2765789109876");
        logger.info("测试结果：{}", result.toString());
    }
}


class MinibusTargetService {

    /**
     * 模拟摇号，但不是摇号算法
     * @param uId 用户编号
     * @return 结果
     */
    public String lottery(String uId) {
        return Math.abs(uId.hashCode()) % 2 == 0 ? "恭喜你，编码".concat(uId).concat("在本次摇号中签") : "很遗憾，编码".concat(uId).concat("在本次摇号未中签或摇号资格已过期");
    }

}


interface LotteryService{
    public LotteryResult doDraw(String uId);
}


class LotteryResult {
    private String uId;
    private String lottery;
    private Date date;
    private String msg;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getLottery() {
        return lottery;
    }

    public void setLottery(String lottery) {
        this.lottery = lottery;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMsg() {
        return Math.abs(uId.hashCode()) % 2 == 0 ? "恭喜你，编码".concat(uId).concat("在本次摇号中签") : "很遗憾，编码".concat(uId).concat("在本次摇号未中签或摇号资格已过期");
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private Logger logger = LoggerFactory.getLogger(LotteryResult.class);

    public LotteryResult(String uId, String lottery, Date date) {
        this.uId = uId;
        this.lottery = lottery;
        this.date = date;
    }

    @Override
    public String toString() {
        return "LotteryResult{" +
                "uId='" + uId + '\'' +
                ", lottery='" + lottery + '\'' +
                ", date=" + date +
                '}';
    }
}

@Service
class LotteryServiceImpl implements LotteryService {

    private Logger logger = LoggerFactory.getLogger(LotteryServiceImpl.class);

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    public LotteryResult doDraw(String uId) {
        // 摇号
        String lottery = minibusTargetService.lottery(uId);
        // 发短信
        logger.info("给用户 {} 发送短信通知(短信)：{}", uId, lottery);
        // 发MQ消息
        logger.info("记录用户 {} 摇号结果(MQ)：{}", uId, lottery);
        // 结果
        return new LotteryResult(uId, lottery, new Date());
    }

}