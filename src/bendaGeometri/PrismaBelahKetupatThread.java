package bendaGeometri;


import javax.swing.JTextArea;

public class PrismaBelahKetupatThread extends Thread {
    private PrismaBelahKetupat pbk;
    private JTextArea output;

    public PrismaBelahKetupatThread(PrismaBelahKetupat pbk, JTextArea output) {
        this.pbk = pbk;
        this.output = output;
    }

  @Override
    public void run() {
        double volume = pbk.hitungVolume();
        double luasPermukaan = pbk.hitungLuasPermukaan();

        output.append("== Prisma Belah Ketupat ==\n");
        output.append("Luas: " + volume + "\n");
        output.append("Keliling: " + luasPermukaan + "\n");
    }
}