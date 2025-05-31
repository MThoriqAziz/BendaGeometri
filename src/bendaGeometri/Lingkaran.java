package bendaGeometri;

public class Lingkaran extends Benda2D {

    public double jariJari;

    private double luasLingkaran;

    private double kelilingLingkaran;

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

    @Override
    public void hitungVolume() {
        // Lingkaran 2D tidak memiliki volume
    }

    @Override
    public void hitungLuasPermukaan() {
        // Lingkaran 2D tidak memiliki luas permukaan
    }
}
