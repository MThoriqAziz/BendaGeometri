package bendaGeometri;

import javax.swing.JTextArea;

public class LayangLayangThread extends Thread {
    private LayangLayang layang;
    private JTextArea output;

    public LayangLayangThread(LayangLayang layang, JTextArea output) {
        this.layang = layang;
        this.output = output;
    }

    @Override
    public void run() {
        double luas = layang.hitungLuas();
        double keliling = layang.hitungKeliling();

        output.append("== Layang-Layang ==\n");
        output.append("Luas: " + luas + "\n");
        output.append("Keliling: " + keliling + "\n");
    }
}
