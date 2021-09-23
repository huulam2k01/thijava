class MultiThread {
    int counter = 0;

    static int N;

    public void printOddNumber() {
        synchronized (this) {
            while (counter < 100) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("--" + counter);
                System.out.println("--" + (counter + 2));
                counter++;
                notify();
            }
        }
    }

    public void printEvenNumber() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(counter);

                counter++;

                notify();
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
        N = 10;

        MultiThread mt = new MultiThread();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                mt.printEvenNumber();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                mt.printOddNumber();
            }
        });

        t1.start();
        t2.start();
    }
}

class bai2 {

}
