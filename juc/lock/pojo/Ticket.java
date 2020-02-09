package day01.pojo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {//资源类 = 实例变量+实例方法
    private int number = 30;

    // List list=new ArrayList();
    //根据其实现类 ReentrantLock  可重入锁
    //实现此接口

    Lock lock=new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第： "+(number--)+"\t 还剩下： "+number);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

}
