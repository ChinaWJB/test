package com.wjb.test_concurrent;

import java.util.Arrays;
import java.util.Collections;  
import java.util.HashSet;  
import java.util.Set;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
import java.util.concurrent.Semaphore;  
  
public class TestSemaphore {  
  
    public static void main(String[] args) {  
        ExecutorService exec = Executors.newCachedThreadPool();  
        TestSemaphore t = new TestSemaphore();  
        final BoundedHashSet<String> set = t.getSet();  
//        Arrays.sort(a);
//        Collections.sort(list);
        for (int i = 0; i < 3; i++) {//�����߳�ͬʱ����add  
            exec.execute(new Runnable() {  
                public void run() {  
                    try {  
                        set.add(Thread.currentThread().getName());  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            });  
        }  
  
        for (int j = 0; j < 3; j++) {//�����߳�ͬʱ����remove  
            exec.execute(new Runnable() {  
                public void run() {  
                    set.remove(Thread.currentThread().getName());  
                }  
            });  
        }  
        exec.shutdown();  
    }  
  
    public BoundedHashSet<String> getSet() {  
        return new BoundedHashSet<String>(2);//����һ���߽�Լ��Ϊ2���߳�  
    }  
  
    class BoundedHashSet<T> {  
        private final Set<T> set;  
        private final Semaphore semaphore;  
  
        public BoundedHashSet(int bound) {  
            this.set = Collections.synchronizedSet(new HashSet<T>());  
            this.semaphore = new Semaphore(bound, true);  
        }  
  
        public void add(T o) throws InterruptedException {  
            semaphore.acquire();//�ź������ƿɷ��ʵ��߳���Ŀ  
            set.add(o);  
            System.out.printf("add:%s%n",o);  
        }  
  
        public void remove(T o) {  
            if (set.remove(o))  
                semaphore.release();//�ͷŵ��ź���  
            System.out.printf("remove:%s%n",o);  
        }  
    } 
    
} 