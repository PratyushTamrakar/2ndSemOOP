package kfa.worker;
import java.util.Random;

public class ReportWorker implements Runnable {
    private final String reportName;
    private final Random random = new Random();

    public ReportWorker(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public void run() {
        System.out.println("Started nightly report: " + reportName +
                " on thread " + Thread.currentThread().getName());

        try {
            // random delay (500-1000ms)
            int delay = 500 + random.nextInt(1001);
            Thread.sleep(delay);

            System.out.println("Completed nightly report: " + reportName +
                    " on thread " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Nightly report interrupted: " + reportName);
        }
    }
}
