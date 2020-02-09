package day01;


import day01.pojo.Ticket;

/**
 * @author  zhurui
 *
 * 题目：三个售票员     卖出          30张票
 * 笔记：如何编写企业级的多线程代码
 *  固定的编程套路+模板是什么？
 *      1. 在高内聚 低耦合的前提下，线程      操作      资源类
 *          1.1 一言不合，先创建一个资源类
 *
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {// 主线程，一切程序的入口
        //资源类
        Ticket ticket=new Ticket();
        new Thread(() ->{ for (int i = 1; i <=30; i++) ticket.sale();},"A").start();  //让线程就绪状态
        new Thread(() ->{ for (int i = 1; i <=30; i++) ticket.sale();},"B").start();  //让线程就绪状态
        new Thread(() ->{ for (int i = 1; i <=30; i++) ticket.sale();},"C").start();  //让线程就绪状态
        // Thread(Runnable target, String name) Allocates a new Thread object.
        /*new Thread(new Runnable() { //匿名内部类
            @Override
            public void run() {
                for (int i = 1; i <=30; i++) {
                    *//*
                        多线程的几种状态
                        NEW
                        RUNNABLE
                        WAITING
                        TIMED_WAITING
                        TERMINATED
                     *//*
                    ticket.sale();
                }
            }
        }, "A").start();    //让线程就绪状态
        new Thread(new Runnable() { //匿名内部类
            @Override
            public void run() {
                for (int i = 1; i <=30; i++) {
                    *//*
                        多线程的几种状态
                        NEW
                        RUNNABLE
                        WAITING
                        TIMED_WAITING
                        TERMINATED
                     *//*
                    ticket.sale();
                }
            }
        }, "B").start();    //让线程就绪状态
        new Thread(new Runnable() { //匿名内部类
            @Override
            public void run() {
                for (int i = 1; i <=30; i++) {
                    *//*
                        多线程的几种状态
                        NEW
                        RUNNABLE
                        WAITING
                        TIMED_WAITING
                        TERMINATED
                     *//*
                    ticket.sale();
                }
            }
        }, "C").start();    //让线程就绪状态*/


    }
}
