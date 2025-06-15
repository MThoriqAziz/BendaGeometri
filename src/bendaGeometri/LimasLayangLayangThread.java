package bendaGeometri;

import javax.swing.JTextArea;

public class LimasLayangLayangThread extends Thread {
    private LimasLayangLayang limas;
    private JTextArea output;

    public LimasLayangLayangThread(LimasLayangLayang limas, JTextArea output) {
        this.limas = limas;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = limas.hitungVolume();
        double luasPermukaan = limas.hitungLuasPermukaan();

        output.append("== Limas Layang-Layang ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }
}
