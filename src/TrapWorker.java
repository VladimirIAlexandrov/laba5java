import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class TrapWorker implements Runnable {
    private final int start;
    private final int end;
    private double result;
    double dataA;
    double dataB; //= recIntegral.getDataB();
    double dataC; //= recIntegral.getDataC();
    public TrapWorker(int start, int end, double dataB, double dataC, double dataA) {
        this.start = start;
        this.end = end;
        this.dataA=dataA;
        this.dataB=dataB;
        this.dataC=dataC;
    }

    @Override
    public void run() {
        double localResult = 0;
        RecIntegral recIntegral = new RecIntegral();
        for (int i = start; i <= end; i++) {
            localResult += recIntegral.InFunction(this.dataB + this.dataC * i);
        }

        setResult(this.dataC * localResult);
    }

    public double getDataB() {

        return end;
    }

    public synchronized double getResult() {

        return result;
    }




    public synchronized void setResult(double result) {
        this.result = result;
    }
}