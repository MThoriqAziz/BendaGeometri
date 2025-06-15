package bendaGeometri;


import javax.swing.JTextArea;

public class BolaThread extends Thread {
    private Bola bl;
    private JTextArea output;

    public BolaThread(Bola bl, JTextArea output) {
        this.bl = bl;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = bl.hitungVolume();
        double luasPermukaan = bl.hitungLuasPermukaan();

        output.append("== Bola ==\n");
        output.append("Luas: " + volume + "\n");
        output.append("Keliling: " + luasPermukaan + "\n");
    }
}