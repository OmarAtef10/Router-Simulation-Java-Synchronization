class Semaphore {

    protected int counter = 0;

    protected Semaphore() {
        counter = 0;
    }

    protected Semaphore(int initial) {
        counter = initial;
    }

    public synchronized void Wait() {
        counter--;
        if (counter < 0) {
            try {
                System.out.println("Current Counter " + counter);
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void Signal() {
        counter++;
        if (counter >= 0) notify();
    }
}

