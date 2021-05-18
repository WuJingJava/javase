package com.javastudy.designpattern.template;
/**
 * 步骤 1
 * 创建一个抽象类，它的模板方法被设置为 final。
 * TemplatePatternDemo.java
*/

 abstract class Game {
   abstract void initialize();
   abstract void startPlay();
   abstract void endPlay();
   /**
    * 前置准备方法
   */
   abstract void prepare();

   abstract boolean isEnablePrepare();
 
   //模板
   public final void play(){

      // 前置准备方法
      if(isEnablePrepare()){
         prepare();
      }

      //初始化游戏
      initialize();
 
      //开始游戏
      startPlay();
 
      //结束游戏
      endPlay();
   }
}

/**
 * 步骤 2
创建扩展了上述类的实体类。
Cricket.java*/
class Cricket extends Game {
 
   @Override
   void endPlay() {
      System.out.println("Cricket Game Finished!");
   }

   @Override
   void prepare() {
      // System.out.println("没有前置准备方法");
   }

   @Override
   boolean isEnablePrepare() {
      return false;
   }

   @Override
   void initialize() {
      System.out.println("Cricket Game Initialized! Start playing.");
   }
 
   @Override
   void startPlay() {
      System.out.println("Cricket Game Started. Enjoy the game!");
   }
}

class Football extends Game {
 
   @Override
   void endPlay() {
      System.out.println("Football Game Finished!");
   }

   @Override
   void prepare() {
      System.out.println(" 前置准备方法");
   }

   @Override
   boolean isEnablePrepare() {
      return true;
   }

   @Override
   void initialize() {
      System.out.println("Football Game Initialized! Start playing.");
   }
 
   @Override
   void startPlay() {
      System.out.println("Football Game Started. Enjoy the game!");
   }
}
/**
 *步骤 3
使用 Game 的模板方法 play() 来演示游戏的定义方式。

TemplatePatternDemo.java*/
public class TemplatePatternDemo {
   public static void main(String[] args) {
 
      Game game = new Cricket();
      game.play();
      System.out.println();
      game = new Football();
      game.play();      
   }
}

    
    
  