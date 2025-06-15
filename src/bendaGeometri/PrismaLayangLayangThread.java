package bendaGeometri;

import javax.swing.JTextArea;

public class PrismaLayangLayangThread extends Thread {
    private PrismaLayangLayang prisma;
    private JTextArea output;

    public PrismaLayangLayangThread(PrismaLayangLayang prisma, JTextArea output) {
        this.prisma = prisma;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = prisma.hitungVolume();
        double luasPermukaan = prisma.hitungLuasPermukaan();

        output.append("== Prisma Layang-Layang ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }
}
