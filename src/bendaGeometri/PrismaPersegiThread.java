
package bendaGeometri;

import javax.swing.JTextArea;

public class PrismaPersegiThread extends Thread {
    private PrismaPersegi prisPG;
    private JTextArea output;

    public PrismaPersegiThread(PrismaPersegi prisPG, JTextArea output) {
        this.prisPG = prisPG;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = prisPG.hitungVolume();
        double luasPermukaan = prisPG.hitungLuasPermukaan();

        output.append("== Prisma Persegi ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }    
}