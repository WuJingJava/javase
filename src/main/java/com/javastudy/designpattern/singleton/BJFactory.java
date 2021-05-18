/*
package com.atguigu.factory.absfactory.pizzastore.order;


import com.atguigu.factory.absfactory.pizzastore.pizza.Pizza;

//一个抽象工厂模式的抽象层(接口)

public interface AbsFactory {
    //让下面的工厂子类来 具体实现
    public Pizza createPizza(String orderType);
}


//这是工厂子类
public class BJFactory implements AbsFactory {


    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if(orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}


public class LDFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}


public class OrderPizza {


    AbsFactory factory;

    // 构造器
    public OrderPizza(AbsFactory factory) {
        setFactory(factory);
    }

    private void setFactory(AbsFactory factory) {
        Pizza pizza = null;
        String orderType = ""; //  用户输入
        this.factory = factory;
        // factory  可能是北京的工厂子类，也可能是伦敦的工厂子类
        pizza = factory.createPizza(orderType);
        if (pizza != null) { // 订 购 ok
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } else {
            System.out.println("订购失败");
        }
    }

    public static void main(String[] args) {
        BJFactory bjFactory = new BJFactory();
        bjFactory.createPizza("cheese");
        new OrderPizza(bjFactory);



    }
}

*/
