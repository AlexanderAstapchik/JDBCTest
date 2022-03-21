package by.astapchik;

import java.sql.SQLOutput;

public class ThreadClient {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread= Thread.currentThread();
//        System.out.println(thread.getName());
//        thread.setName("Custom name");
//        System.out.println(thread.getName());
        System.out.println("thread is started");

        Thread thread=new CustomThread("Thread 2");
        thread.start();
        thread.join();

        System.out.println("thread is finished");
    }
}
 class CustomThread extends Thread {
    public CustomThread(String name){
        super(name);
    }
    @Override
     public void run(){
        System.out.println(Thread.currentThread().getName()+"is started");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName()+"is interrupt");
        }
        System.out.println(Thread.currentThread().getName()+"is finished");
    }
 }