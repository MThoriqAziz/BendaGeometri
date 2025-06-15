package bendaGeometri;

import javax.swing.JTextArea;

public class LimasTrapesiumThread extends Thread {
    private LimasTrapesium LimTR;
    private JTextArea output;

    public LimasTrapesiumThread(LimasTrapesium LimTR, JTextArea output) {
        this.LimTR = LimTR;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = LimTR.hitungVolume();
        double luasPermukaan = LimTR.hitungLuasPermukaan();

        output.append("== Limas Trapesium ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }    
}