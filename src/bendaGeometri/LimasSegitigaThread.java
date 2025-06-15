package bendaGeometri;

import javax.swing.JTextArea;

public class LimasSegitigaThread extends Thread {
    private LimasSegitiga limas;
    private JTextArea output;

    public LimasSegitigaThread(LimasSegitiga limas, JTextArea output) {
        this.limas = limas;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = limas.hitungVolume();
        double luasPermukaan = limas.hitungLuasPermukaan();

        output.append("== Limas Segitiga ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }
}
