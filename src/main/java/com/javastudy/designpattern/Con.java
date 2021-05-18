package com.javastudy.designpattern;

import java.util.ArrayList;
import java.util.List;

public class Con {
}

 class Client {


    public static void main(String[] args) {
// TODO Auto-generated method stub

//从大到小创建对象 学校
        OrganizationComponent university = new University("清华大学", " 中国顶级大学 ");

//创建 学院
        OrganizationComponent computerCollege = new College(" 计 算 机 学 院 ", " 计 算 机 学 院 "); OrganizationComponent infoEngineercollege = new College("信息工程学院", " 信息工程学院 ");



//创建各个学院下面的系(专业)
        computerCollege.add(new Department("软件工程", " 软件工程不错 ")); computerCollege.add(new Department("网络工程", " 网络工程不错 "));
        computerCollege.add(new Department("计算机科学与技术", " 计算机科学与技术是老牌的专业 "));


//
        infoEngineercollege.add(new Department("通信工程", " 通信工程不好学 ")); infoEngineercollege.add(new Department("信息工程", " 信息工程好学 "));

//将学院加入到 学校university.add(computerCollege); university.add(infoEngineercollege);


//university.print(); infoEngineercollege.print();
    }


}


class College extends OrganizationComponent {

    //List 中 存放的 Department
    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    // 构造器
    public College(String name, String des) { super(name, des);
// TODO Auto-generated constructor stub
    }

    // 重 写 add
     @Override
    protected void add(OrganizationComponent organizationComponent) {
// TODO Auto-generated method stub


//	将来实际业务中，Colleage  的  add  和	University add 不一定完全一样
        organizationComponents.add(organizationComponent);
    }

    // 重 写 remove
     @Override
    protected void remove(OrganizationComponent organizationComponent) {
// TODO Auto-generated method stub
  organizationComponents.remove(organizationComponent);
    }


    @Override
    public String getName() {
// TODO Auto-generated method stub
  return super.getName();
    }


    @Override
    public String getDes() {
// TODO Auto-generated method stub
  return super.getDes();
    }

    // print 方法，就是输出 University  包含的学院
    @Override
    protected void print() {

        System.out.println("--------------" + getName() + "--------------");
//遍历 organizationComponents
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }



}

class Department extends OrganizationComponent {

//没有集合


    public Department(String name, String des) {
        super(name, des);
// TODO Auto-generated constructor stub
    }



//add , remove 就不用写了，因为他是叶子节点


    @Override


    public String getName() {
// TODO Auto-generated method stub
  return super.getName();
    }


    @Override
    public String getDes() {
// TODO Auto-generated method stub
  return super.getDes();
    }


    @Override
    protected void print() {
// TODO Auto-generated method stub
  System.out.println(getName());
    }


}


abstract class OrganizationComponent {
    private String name; // 名 字
    private String des; // 说 明


    protected void add(OrganizationComponent organizationComponent) {
//默认实现
        throw new UnsupportedOperationException();
    }


    protected void remove(OrganizationComponent organizationComponent) {
//默认实现
        throw new UnsupportedOperationException();
    }

    //构造器
    public OrganizationComponent(String name, String des) {
        super();
        this.name = name;
        this.des = des;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDes() {


        return des;
    }


    public void setDes(String des) {
        this.des = des;
    }

    //方法 print,  做成抽象的,  子类都需要实现
    protected abstract void print();


}
//University 就是 Composite ,  可以管理 College
class University extends OrganizationComponent {


    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    // 构造器
    public University(String name, String des) {
        super(name, des);

    }

    // 重 写 add @Override
    @Override
    protected void add(OrganizationComponent organizationComponent) {
  organizationComponents.add(organizationComponent);
    }

    // 重 写 remove @Override
    @Override
    protected void remove(OrganizationComponent organizationComponent) {
// TODO Auto-generated method stub
  organizationComponents.remove(organizationComponent);
    }


    @Override
    public String getName() {
    // TODO Auto-generated method stub
        return super.getName();
    }


    @Override
    public String getDes() {

 return super.getDes();
    }

    // print 方法，就是输出 University  包含的学院
    @Override
    protected void print() {
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }


}
