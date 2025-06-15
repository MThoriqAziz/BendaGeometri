package bendaGeometri;


import javax.swing.JTextArea;

public class CincinBolaThread extends Thread {
    private CincinBola cb;
    private JTextArea output;

    public CincinBolaThread(CincinBola cb, JTextArea output) {
        this.cb = cb;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = cb.hitungVolume();
        double luasPermukaan = cb.hitungLuasPermukaan();

        output.append("== Cincin Bola ==\n");
        output.append("Luas: " + volume + "\n");
        output.append("Keliling: " + luasPermukaan + "\n");
    }
}