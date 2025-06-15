package bendaGeometri;

import javax.swing.JTextArea;

public class PersegiPanjangThread extends Thread {
    private PersegiPanjang persegiPanjang;
    private JTextArea output;

    public PersegiPanjangThread(PersegiPanjang persegiPanjang, JTextArea output) {
        this.persegiPanjang = persegiPanjang;
        this.output = output;
    }

    @Override
    public void run() {
        double luas = persegiPanjang.hitungLuas();
        double keliling = persegiPanjang.hitungKeliling();

        output.append("== Persegi Panjang ==\n");
        output.append("Luas: " + luas + "\n");
        output.append("Keliling: " + keliling + "\n");
    }
}
