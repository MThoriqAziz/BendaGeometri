
package bendaGeometri;

import javax.swing.JTextArea;

public class KerucutThread extends Thread {
    private Kerucut krct;
    private JTextArea output;

    public KerucutThread(Kerucut krct, JTextArea output) {
        this.krct = krct;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = krct.hitungVolume();
        double luasPermukaan = krct.hitungLuasPermukaan();

        output.append("== Kerucut ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }    
}