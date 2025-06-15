package bendaGeometri;


import javax.swing.JTextArea;

public class JuringBolaThread extends Thread {
    private JuringBola jb;
    private JTextArea output;

    public JuringBolaThread(JuringBola jb, JTextArea output) {
        this.jb = jb;
        this.output = output;
    }

    @Override
    public void run() {
        double volume = jb.hitungVolume();
        double luasPermukaan = jb.hitungLuasPermukaan();

        output.append("== Juring Bola ==\n");
        output.append("Luas: " + volume + "\n");
        output.append("Keliling: " + luasPermukaan + "\n");
    }
}