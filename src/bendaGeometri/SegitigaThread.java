package bendaGeometri;

import javax.swing.JTextArea;

public class SegitigaThread extends Thread {
    private Segitiga segitiga;
    private JTextArea output;

    public SegitigaThread(Segitiga segitiga, JTextArea output) {
        this.segitiga = segitiga;
        this.output = output;
    }

    @Override
    public void run() {
        double luas = segitiga.hitungLuas();
        double keliling = segitiga.hitungKeliling();

        output.append("== Segitiga ==\n");
        output.append("Luas: " + luas + "\n");
        output.append("Keliling: " + keliling + "\n");
    }
}
