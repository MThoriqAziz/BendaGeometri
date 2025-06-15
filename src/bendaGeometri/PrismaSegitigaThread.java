package bendaGeometri;

import javax.swing.JTextArea;

public class PrismaSegitigaThread extends Thread {
    private PrismaSegitiga prisma;
    private JTextArea output;

    public PrismaSegitigaThread(PrismaSegitiga prisma, JTextArea output) {
        this.prisma = prisma;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = prisma.hitungVolume();
        double luasPermukaan = prisma.hitungLuasPermukaan();

        output.append("== Prisma Segitiga ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }
}
