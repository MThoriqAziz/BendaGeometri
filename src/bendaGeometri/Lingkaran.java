package bendaGeometri;

public class Lingkaran extends Benda2D {

    public double jariJari;

    private double luasLingkaran;

    private double kelilingLingkaran;
    
    public final double PI = 3.14;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    @Override
    public double hitungLuas() {
        luasLingkaran = Math.PI * jariJari * jariJari;
        return luasLingkaran;
    }

    @Override
    public double hitungKeliling() {
        kelilingLingkaran = 2 * Math.PI * jariJari;
        return kelilingLingkaran;
    }
    
    public double getJariJari() {
        return jariJari;
    }
}