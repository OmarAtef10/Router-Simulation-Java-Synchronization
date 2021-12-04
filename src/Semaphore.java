class Semaphore {

    protected int counter = 0;

    public Semaphore(int initial) {
        counter = initial;
    }

    public synchronized void Wait() {
        while (counter <= 0) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        counter--;
    }

    public synchronized void Signal() {
        counter++;
        if (counter > 0) notifyAll();
    }
}