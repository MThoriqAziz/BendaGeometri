package bendaGeometri;

public class TabungThread extends Lingkaran {
    private double tinggi;

    public TabungThread(double jariJari, double tinggi) {
        super(jariJari); // Memanggil konstruktor Lingkaran
        this.tinggi = tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        // Volume Tabung = π * r^2 * t
        return Math.PI * Math.pow(getJariJari(), 2) * tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        // Luas Permukaan = 2πr (r + t)
        return 2 * Math.PI * getJariJari() * (getJariJari() + tinggi);
    }
}
