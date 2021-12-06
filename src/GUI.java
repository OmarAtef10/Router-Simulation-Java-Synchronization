public class GUI {
    public static void main(String[] args) {
        InterfaceCreator.semaphore = new Semaphore(0);
        InterfaceCreator.create();
    }
}
