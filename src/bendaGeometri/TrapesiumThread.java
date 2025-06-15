package bendaGeometri;


import javax.swing.JTextArea;

public class TrapesiumThread extends Thread {
    private Trapesium tr;
    private JTextArea output;

    public TrapesiumThread(Trapesium tr, JTextArea output) {
        this.tr = tr;
        this.output = output;
    }

    @Override
    public void run() {
        double luas = tr.hitungLuas();
        double keliling = tr.hitungKeliling();

        output.append("== Trapesium ==\n");
        output.append("Luas: " + luas + "\n");
        output.append("Keliling: " + keliling + "\n");
    }
}