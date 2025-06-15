
package bendaGeometri;

import javax.swing.JTextArea;

public class KerucutTerpacungThread extends Thread {
    private KerucutTerpancung krcttpg;
    private JTextArea output;

    public KerucutTerpacungThread(KerucutTerpancung krcttpg, JTextArea output) {
        this.krcttpg = krcttpg;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = krcttpg.hitungVolume();
        double luasPermukaan = krcttpg.hitungLuasPermukaan();

        output.append("== Kerucut Terpancung ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }    
}