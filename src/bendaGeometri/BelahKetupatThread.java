package bendaGeometri;


import javax.swing.JTextArea;

public class BelahKetupatThread extends Thread {
    private BelahKetupat bk;
    private JTextArea output;

    public BelahKetupatThread(BelahKetupat bk, JTextArea output) {
        this.bk = bk;
        this.output = output;
    }

    @Override
    public void run() {
        double luas = bk.hitungLuas();
        double keliling = bk.hitungKeliling();

        output.append("== Belah Ketupat ==\n");
        output.append("Luas: " + luas + "\n");
        output.append("Keliling: " + keliling + "\n");
    }
}