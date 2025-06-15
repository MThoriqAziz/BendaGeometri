package bendaGeometri;

public class Tabung extends Lingkaran {
    private double tinggi;

    public Tabung(double jariJari, double tinggi) {
        super(jariJari); // panggil konstruktor Lingkaran
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
        return Math.PI * Math.pow(getJariJari(), 2) * tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * Math.PI * getJariJari() * (getJariJari() + tinggi);
    }
}
