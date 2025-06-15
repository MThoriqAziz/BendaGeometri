package bendaGeometri;


import javax.swing.JTextArea;

public class LingkaranThread extends Thread {
    private Lingkaran Lgn;
    private JTextArea output;

    public LingkaranThread(Lingkaran Lgn, JTextArea output) {
        this.Lgn = Lgn;
        this.output = output;
    }

    @Override
    public void run() {
        double luas = Lgn.hitungLuas();
        double keliling = Lgn.hitungKeliling();

        output.append("== Lingkaran ==\n");
        output.append("Luas: " + luas + "\n");
        output.append("Keliling: " + keliling + "\n");
    }
}