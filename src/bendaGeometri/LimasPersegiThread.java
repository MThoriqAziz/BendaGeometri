package bendaGeometri;

import javax.swing.JTextArea;

public class LimasPersegiThread extends Thread {
    private LimasPersegi limas;
    private JTextArea output;

    public LimasPersegiThread(LimasPersegi limas, JTextArea output) {
        this.limas = limas;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = limas.hitungVolume();
        double luasPermukaan = limas.hitungLuasPermukaan();

        output.append("== Limas Persegi ==\n");
        output.append("Luas Permukaan: " + luasPermukaan + " cm²\n");
        output.append("Volume: " + volume + " cm³\n\n");
    }
}