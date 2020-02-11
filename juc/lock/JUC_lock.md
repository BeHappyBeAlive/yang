1. JUC （java.util.concurrent）并发
	1.1 进程/线程
		进程：后台运行的程序 线程：进程中的简单执行单元
		例子：windows任务管理器中的 xx.exe就是运行的进程
			一些软件自带的容灾功能就是其线程
		
	2.2 并发/并行
		高并发：多个线程抢同一个资源，抢票
		并行：在一段时间，多个进程并行，比如边听歌边喝水
2. 三个包
	java.util.concurrent
	java.util.concurrent.atomic
	java.util.concurrent.locks


3. synchronized
	1. 同步的，加锁的
	2. 代表此方法加锁，当一个进程运行到synchronized方法时，需要观察是否有其他的线程正在使用该方法，如果有则等待该进程，否则锁定调用者，执行方法

4. 匿名内部类
	1. 表面上意思就是没有名字的内部类
	2. 像实现特殊类，比如接口的时候，就是匿名内部类的形式
		
		`
			
			new ParentName(){
		
				...// 内部类的定义
		
			}
		`
5. λ表达式

    `new Thread(() ->{ for (int i = 1; i <=30; i++) ticket.sale();},"A").start();  //让线程就绪状态
     `

6. 三个售票员卖票  30张
	##线程

    `
		


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



	`

	##资源类
	`
			
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


	`