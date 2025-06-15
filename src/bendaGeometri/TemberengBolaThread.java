package bendaGeometri;


import javax.swing.JTextArea;

public class TemberengBolaThread extends Thread {
    private TemberengBola tbt;
    private JTextArea output;

    public TemberengBolaThread(TemberengBola tbt, JTextArea output) {
        this.tbt = tbt;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = tbt.hitungVolume();
        double luasPermukaan = tbt.hitungLuasPermukaan();

        output.append("== Tembereng Bola ==\n");
        output.append("Luas: " + volume + "\n");
        output.append("Keliling: " + luasPermukaan + "\n");
    }
}