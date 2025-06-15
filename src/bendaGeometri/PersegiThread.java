package bendaGeometri;

import javax.swing.JTextArea;

public class PersegiThread extends Thread {
    private Persegi persegi;
    private JTextArea output;

    public PersegiThread(Persegi persegi, JTextArea output) {
        this.persegi = persegi;
        this.output = output;
    }

    @Override
    public void run() {
        double luas = persegi.hitungLuas();
        double keliling = persegi.hitungKeliling();

        output.append("== Persegi ==\n");
        output.append("Sisi: " + persegi.sisi + " cm\n");
        output.append("Luas: " + luas + " cm²\n");
        output.append("Keliling: " + keliling + " cm\n\n");
    }
}