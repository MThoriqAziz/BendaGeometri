
package bendaGeometri;

import javax.swing.JTextArea;

public class PrismaJajarGenjangThread extends Thread {
    private PrismaJajarGenjang prisma;
    private JTextArea output;

    public PrismaJajarGenjangThread(PrismaJajarGenjang prisma, JTextArea output) {
        this.prisma = prisma;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = prisma.hitungVolume();
        double luasPermukaan = prisma.hitungLuasPermukaan();

        output.append("== Prisma Jajar Genjang ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }    
}
