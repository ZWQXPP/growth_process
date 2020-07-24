package com.leyou.item.biz;

public class Text1 {

/*// 1.继承Thread类
 public static void main(String[] args) {
        A a = new A();
        a.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("main线程" + i);
        }
    }

}

class A extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("线程启动" + i);
        }

    }*/


//2  实现Runnable接口
    public static void main(String[] args) {
        A a = new A();
        new Thread(a).start();
        for(int i=1;i<=10;i++) {
            System.out.println("main线程"+i);
        }
    }

}
class A implements Runnable {
    @Override
    public void run() {
        for(int i=1;i<=10;i++) {
            System.out.println("线程启动"+i);
        }

    }


}
