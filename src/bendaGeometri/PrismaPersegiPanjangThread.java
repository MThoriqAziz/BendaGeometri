package bendaGeometri;

import javax.swing.JTextArea;

public class PrismaPersegiPanjangThread extends Thread {
    private PrismaPersegiPanjang prisma;
    private JTextArea output;

    public PrismaPersegiPanjangThread(PrismaPersegiPanjang prisma, JTextArea output) {
        this.prisma = prisma;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = prisma.hitungVolume();
        double luasPermukaan = prisma.hitungLuasPermukaan();

        output.append("== Prisma Persegi Panjang ==\n");
        output.append("Volume: " + volume + "\n");
        output.append("Luas Permukaan: " + luasPermukaan + "\n");
    }
}
