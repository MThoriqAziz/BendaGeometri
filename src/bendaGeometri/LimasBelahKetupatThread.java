package bendaGeometri;


import javax.swing.JTextArea;

public class LimasBelahKetupatThread extends Thread {
    private LimasBelahKetupat bk;
    private JTextArea output;

    public LimasBelahKetupatThread(LimasBelahKetupat bk, JTextArea output) {
        this.bk = bk;
        this.output = output;
    }

  @Override
    public void run() {
        double volume = bk.hitungVolume();
        double luasPermukaan = bk.hitungLuasPermukaan();

        output.append("== Limas Belah Ketupat ==\n");
        output.append("Luas: " + volume + "\n");
        output.append("Keliling: " + luasPermukaan + "\n");
    }
}