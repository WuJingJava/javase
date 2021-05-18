package com.javastudy.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: StatiDynamicProxycProxy2
 * @Description: 动态代理
 * @Author liujiexin
 * @Date 2021/5/7 下午5:10
 */
public class DynamicProxy {
    public static void main(String[] args) {
        // 创建目标对象
        DynamicTicket dynamicRailwayStation = new DynamicRailwayStation();
        // 将需要代理的对象创建
        DynamicTicket proxyTicke = (DynamicTicket) new DynamicProxyTicke(dynamicRailwayStation).getProxyInstance();
        proxyTicke.salesTicket();
    }
}


interface DynamicTicket {
    /**
    * @Description: 售票
    * @Param: []
    * @return: void
    * @Author: liujiexin
    * @Date: 2021/5/7
    */
    void salesTicket();


}

class DynamicRailwayStation implements DynamicTicket {
    @Override
    public void salesTicket() {
        System.out.println("火车站售票");
    }

}


class DynamicProxyTicke{

    private Object dynamicTicket;

    public DynamicProxyTicke(DynamicTicket dynamicTicket)
    {
        this.dynamicTicket = dynamicTicket;
    }


    public Object getProxyInstance()
    {
        return Proxy.newProxyInstance(dynamicTicket.getClass().getClassLoader(),
                dynamicTicket.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object invoke = method.invoke(dynamicTicket, args);
                        return invoke;
                    }
                }
        );

    }
}


