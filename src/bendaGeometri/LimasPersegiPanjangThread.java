package bendaGeometri;

import javax.swing.JTextArea;

public class LimasPersegiPanjangThread extends Thread {
    private LimasPersegiPanjang limas;
    private JTextArea output;

    public LimasPersegiPanjangThread(LimasPersegiPanjang limas, JTextArea output) {
        this.limas = limas;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = limas.hitungVolume();
        double luasPermukaan = limas.hitungLuasPermukaan();

        output.append("== Limas Persegi Panjang ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }
}
