public interface Staff extends Runnable{
    void next() throws InterruptedException;
    void end();
    @Override
    void run();
}
