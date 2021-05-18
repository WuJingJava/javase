package com.javastudy.designpattern.decorater;


public class Decorate {

    public static void main(String[] args) {
        Decoration decoration = new Rectangle();

        decoration = new Cement(decoration);
        System.out.println(decoration.getDes());
        System.out.println(decoration.cost());

    }

}

/**
 Decoration.java 装修
*/
 abstract class Decoration{
     /**
      * 描述
      */
     private String des;
     private float price = 0.0f;


    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}

class Shape extends Decoration{
    @Override
    public float cost() {
        return super.getPrice();
    }
}

/**
 * 具体的形状
 Rectangle.java 长方形
 */
class Rectangle extends Shape {

    public Rectangle() {
        super.setDes("长方形");
        super.setPrice(100f);
    }

}

/** Circle.java 圆*/
class Circle extends Shape {

    public Circle() {
        super.setDes("圆");
        super.setPrice(50f);
    }
}





/**
 * 装修材料
 */
class DecorateMaterial extends Decoration{

    // 为什么要引用， 可以实现多重装饰
    private Decoration decoration;

    public DecorateMaterial(Decoration decoration) {
        this.decoration = decoration;
    }

    @Override
    public String getDes() {
        return super.getDes() + " 费用：" + getPrice();
    }

    @Override
    public float cost() {
        return decoration.getPrice() + getPrice();
    }
}


/**
 Cement.java 水泥
 */
class Cement extends DecorateMaterial {
    public Cement(Decoration decoration) {
        super(decoration);
        super.setDes("刮水泥");
        super.setPrice(50f);
    }

}

/**
 *  Lime.java 石灰
 */
class Lime extends DecorateMaterial {
    public Lime(Decoration decoration) {
        super(decoration);
        super.setDes("粉刷石灰");
        super.setPrice(30f);
    }
}

/**
Paint.java 油漆
 */
class Paint extends DecorateMaterial {
    public Paint(Decoration decoration) {
        super(decoration);
        super.setDes("刷油漆");
        super.setPrice(80f);
    }
}

/**
OilPainting.java 油画
 */
class OilPainting extends DecorateMaterial {
    public OilPainting(Decoration decoration) {
        super(decoration);
        super.setDes("挂油画");
        super.setPrice(150f);
    }
}
