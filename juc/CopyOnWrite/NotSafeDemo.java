package day02.ArrayList;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ZHURUI
 *
 * 1. 故障现象
 *      java.util.ConcurrentModificationException   并发修改错误
 * 2. 导致原因
 *      对Vector、ArrayList在迭代的时候如果同时对其进行修改就会抛出java.util.ConcurrentModificationException异常。
 *
 * 3. 解决办法
 *      使用Vector<>() 实现List接口
 *      使用Collections.synchronizedList(new ArrayList<>()) 实现List接口
 *      使用CopyOnWriteArrayList<>()  实现List接口  （JUC包下的） 写时复制ArrayList
 *              1. 读写分离
 *              2. add方法采用内置监控器（ReentrantLock也可），对读写进行监控，当需要添加数据时，对当前进程加锁
 *              3. 当前进程add完过程中其他进程等待，直到add成功才解锁，这个时候其他进程继续
 *              4. 其中在add的时候，每add一个之前扩充一下其中的数组（length++）
 * 4. 优化建议（同样的错误不犯第二次）
 *
 */
public class NotSafeDemo {



    public static void main(String[] args) {

        mapNotSafe();
     }

    public static void listNotSafe(){
        //List<String> list = new ArrayList<>();  线程不安全
        List<String> list=new Vector<>();  //线程安全
        //List<String> list= Collections.synchronizedList(new ArrayList<>());
        //List<String> list= new CopyOnWriteArrayList<>();
        for (int i = 0; i <= 3; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();

        }
    }

    public static void setNotSafe(){
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i <= 3; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    public static void mapNotSafe(){
        Map<String,Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i <= 3; i++) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(0,8),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

}
