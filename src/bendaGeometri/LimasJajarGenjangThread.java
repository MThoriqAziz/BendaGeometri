
package bendaGeometri;

import javax.swing.JTextArea;

public class LimasJajarGenjangThread extends Thread {
    private LimasJajarGenjang Limas;
    private JTextArea output;

    public LimasJajarGenjangThread(LimasJajarGenjang limas, JTextArea output) {
        this.Limas = limas;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = Limas.hitungVolume();
        double luasPermukaan = Limas.hitungLuasPermukaan();

        output.append("== Limas Jajar Genjang ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }    
}
