package startMethod;

public class Practice {

    public static void main(String[] args) {
        //** 1. 최대 사용 가능한 Thread 개수  */        
        getMaximumActiveThreadCnt();

        //** 2. Thread 생성  - 1 초간 대기  */
        Thread thread1 = new Thread(new WaitASecondThread(1000L));
        thread1.start();

        //** 3. Thread Run 직접 돌리기  - 2 초만 대기 */
        Thread thread2 = new Thread(new WaitASecondThread(2L));
        thread2.run();

    }

    public static class WaitASecondThread implements Runnable{

        private Long waitTime;

        public WaitASecondThread(Long waitTime){
            this.waitTime = waitTime;
        }

        @Override
        public void run() {
            System.out.println();
            System.out.println("Hi! Waiting Time : "+waitTime);
            getCurrentActiveThreadCnt();
            System.out.println();
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println();
            System.out.println("Waiting Time : "+waitTime+" is Over");
            getCurrentActiveThreadCnt();
            System.out.println();
        }

    }

    public static void getMaximumActiveThreadCnt(){
        int maxThreadCnt = Runtime.getRuntime().availableProcessors();
        System.out.println("Maximum Active Thread Count : "+maxThreadCnt);
    }

    public static void getCurrentActiveThreadCnt(){
        int activeThreadCnt = Thread.activeCount();
        System.out.println("Current Active Thread Count : "+activeThreadCnt);
    }
}
