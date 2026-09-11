class ZeroEvenOdd {
    private int n;
    private int count = 1;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (count != 1) {
                wait();
            }

            printNumber.accept(0);
            count = (i % 2 == 1) ? 2 : 3;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (count != 3) {
                wait();
            }

            printNumber.accept(i);
            count = 1;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (count != 2) {
                wait();
            }

            printNumber.accept(i);
            count = 1;
            notifyAll();
        }
    }
}