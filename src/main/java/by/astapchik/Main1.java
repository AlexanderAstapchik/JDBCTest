package by.astapchik;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("thread is started");
        long start=System.currentTimeMillis();
        Thread thread=new Thread(new MyThread(),"My dffggh");
        thread.start();
        thread.join();
        Thread thread1=new Thread(new MyThread(),"My ttttt");
        thread1.start();
        thread.join();
        long end=System.currentTimeMillis();
        System.out.println("Total:"+ (end-start));
        System.out.println("thread is finished");
    }
}
class MyThread implements Runnable {
    @Override
    public void run() {
        print(Thread.currentThread().getName()+"thread is started");
        for (int i=0;i<1000;i++)
            print(Thread.currentThread().getName()+ "->"+i);
        print(Thread.currentThread().getName()+ "is finished");
    }

    private void print(Object o) {
        System.out.println(o);
    }


}