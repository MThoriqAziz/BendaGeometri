package bendaGeometri;


import javax.swing.JTextArea;

public class JajarGenjangThread extends Thread {
    private JajarGenjang jg;
    private JTextArea output;

    public JajarGenjangThread(JajarGenjang jg, JTextArea output) {
        this.jg = jg;
        this.output = output;
    }

    @Override
    public void run() {
        double luas = jg.hitungLuas();
        double keliling = jg.hitungKeliling();

        output.append("== Jajar Genjang ==\n");
        output.append("Luas: " + luas + "\n");
        output.append("Keliling: " + keliling + "\n");
    }
}
