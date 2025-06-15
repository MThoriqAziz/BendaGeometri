package bendaGeometri;

import javax.swing.JTextArea;

public class TemberengLingkaranThread extends Thread {
    private TemberengLingkaran tlt;
    private JTextArea output;

    public TemberengLingkaranThread(TemberengLingkaran tlt, JTextArea output) {
        this.tlt = tlt;
        this.output = output;
    }

    @Override
    public void run() {
        double luas = tlt.hitungLuas();
        double keliling = tlt.hitungKeliling();

        output.append("== Tembereng Lingkaran ==\n");
        output.append("Luas: " + luas + "\n");
        output.append("Keliling: " + keliling + "\n");
    }
}