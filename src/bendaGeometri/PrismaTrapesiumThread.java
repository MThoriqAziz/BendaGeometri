package bendaGeometri;

import javax.swing.JTextArea;

public class PrismaTrapesiumThread extends Thread {
    private PrismaTrapesium PrisTR;
    private JTextArea output;

    public PrismaTrapesiumThread(PrismaTrapesium PrisTR, JTextArea output) {
        this.PrisTR = PrisTR;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = PrisTR.hitungVolume();
        double luasPermukaan = PrisTR.hitungLuasPermukaan();

        output.append("== Prisma Trapesium ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }    
}