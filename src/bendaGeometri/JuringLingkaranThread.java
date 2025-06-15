package bendaGeometri;


import javax.swing.JTextArea;

public class JuringLingkaranThread extends Thread {
    private JuringLingkaran jrglng ;
    private JTextArea output;

    public JuringLingkaranThread(JuringLingkaran jrglng, JTextArea output) {
        this.jrglng = jrglng;
        this.output = output;
    }

    @Override
    public void run() {
        double luas = jrglng.hitungLuas();
        double keliling = jrglng.hitungKeliling();

        output.append("== Juring Lingkaran ==\n");
        output.append("Luas: " + luas + "\n");
        output.append("Keliling: " + keliling + "\n");
    }
}