package com.javastudy.designpattern.visitor;

/**
 * @ClassName: VisitorPattern
 * @Description: 访问者模式
 *
 * 访问者设计模式：是指在结构不变的情况下，动态改变对于内部元素的动作
 *
 * 示例：模拟组装电脑，不同类型购买
 *
 * @Author liujiexin
 * @Date 2021/5/13 上午10:54
 */
public class VisitorPattern {

    public static void main(String[] args) {

        CompanyVister personalVister = new CompanyVister();
        new Computer().acccept(personalVister);
        System.out.println(personalVister.getTotalPrice());

    }
}

class Computer{
    ComputerPart cpu = new Cpu();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void acccept(Vister vister){
        this.cpu.accpet(vister);
        this.memory.accpet(vister);
        this.board.accpet(vister);
    }

}


interface ComputerPart{
    abstract void accpet(Vister vister);
    abstract double getPrice();
}

/** 
 * @Description:  cpu 
 * @Param: null 
 * @return: 
 * @Author: liujiexin
 * @Date: 2021/5/15 下午3:55
 */
class Cpu implements ComputerPart{

    @Override
    public void accpet(Vister vister) {
        vister.visterCpu(this);
    }

    @Override
    public double getPrice() {
        return 100;
    }
}

/** 
 * @Description: 内存
 * @Param: null 
 * @return: 
 * @Author: liujiexin
 * @Date: 2021/5/15 下午3:55
 */
class Memory implements ComputerPart{

    @Override
    public void accpet(Vister vister) {
        vister.visterMemory(this);
    }

    @Override
    public double getPrice() {
        return 150;
    }
}
/**
 * @Description:  主板
 * @Param: null
 * @return:
 * @Author: liujiexin
 * @Date: 2021/5/15 下午3:56
 */
class Board implements ComputerPart{

    @Override
    public void accpet(Vister vister) {
        vister.visterBoard(this);
    }

    @Override
    public double getPrice() {
        return 200;
    }
}


interface Vister{
    void visterCpu(Cpu cpu);
    void visterMemory(Memory memory);
    void visterBoard(Board board);

}


/**
 * @Description: 个人购买者
 * @Param: null
 * @return:
 * @Author: liujiexin
 * @Date: 2021/5/15 下午4:06
 */
class PersonalVister implements  Vister{
    private double totalPrice = 0.0;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public void visterCpu(Cpu cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    public void visterMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.8;
    }

    @Override
    public void visterBoard(Board board) {
        totalPrice += board.getPrice() * 0.5;
    }
}

/**
 * @Description: 个人购买者
 * @Param: null
 * @return:
 * @Author: liujiexin
 * @Date: 2021/5/15 下午4:06
 */
class CompanyVister implements  Vister{
    private double totalPrice = 0.0;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public void visterCpu(Cpu cpu) {
        totalPrice += cpu.getPrice() * 0.8;
    }

    @Override
    public void visterMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.6;
    }

    @Override
    public void visterBoard(Board board) {
        totalPrice += board.getPrice() * 0.4;
    }
}
