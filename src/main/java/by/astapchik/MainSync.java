package by.astapchik;

public class MainSync {
    public static void main(String[] args) {
      //  System.out.println("Main is start");
        CommonResource resource = new CommonResource();
        for (int i = 0; i < 5; i++)
            new TestThread("Thread-" + i, resource).start();
        System.out.println("Main is finish");

    }
}

class CommonResource {
    int x = 0;
}

class TestThread extends Thread {

    private final CommonResource resource;

    public TestThread(String name, CommonResource resource) {
        super(name);

        this.resource = resource;
    }

    @Override
    public  void run() {

        synchronized (resource) {
            System.out.println(Thread.currentThread().getName() + " is started!");

            resource.x = 1;
            for (int i = 1; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + ", x -> " + resource.x);
                resource.x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " is finished!");
        }
    }
}
