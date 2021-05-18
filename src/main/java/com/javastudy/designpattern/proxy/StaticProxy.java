package com.javastudy.designpattern.proxy;

/**
 * @ClassName: StaticProxy2
 * @Description: 静态代理
 * @Author liujiexin
 * @Date 2021/5/7 下午5:10
 */
public class StaticProxy {
    public static void main(String[] args) {
        Ticket railwayStation = new RailwayStation();
        ProxyTicke proxyTicke = new ProxyTicke(railwayStation);
        proxyTicke.salesTicket();
    }
}


interface Ticket {
    /**
    * @Description: 售票
    * @Param: []
    * @return: void
    * @Author: liujiexin
    * @Date: 2021/5/7
    */
    void salesTicket();


}

class RailwayStation implements Ticket {
    @Override
    public void salesTicket() {
        System.out.println("火车站售票");
    }

    /**
     * @Description:
     * @Param: a
    * @Param hhh
     * @return: java.lang.String
     * @Author: liujiexin
     * @Date: 2021/5/7 下午5:57
     */
    String hhhh(String a, String hhh){
        return a;
    }
}


class ProxyTicke implements Ticket {

    private Ticket railwayStation;

    public ProxyTicke(Ticket railwayStation) {
        this.railwayStation = railwayStation;
    }


    @Override
    public void salesTicket() {
        System.out.println("代理售票");
        railwayStation.salesTicket();
    }
}


