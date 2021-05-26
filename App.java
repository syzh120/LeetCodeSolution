import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * @Author: ybchen
 * @Date: 2021/4/23 14:10
 */
public class App implements SignalHandler {

    private void signalCallback(Signal sn) {
        System.out.println(sn.getName() + "is recevied.");
    }

    @Override
    public void handle(Signal signalName) {
        signalCallback(signalName);
    }

    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        Signal sig = new Signal("ILL");
        Signal.handle(sig, app);
        Thread.sleep(15000);
    }

}
