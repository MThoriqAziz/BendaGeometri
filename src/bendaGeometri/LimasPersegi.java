package bendaGeometri;

public class LimasPersegi extends Persegi {

    private double tinggiLimas;
    private double tinggiSisiTegak;
    private double volumeLimas;
    private double luasPermukaanLimas;

    public LimasPersegi(double sisi, double tinggiLimas, double tinggiSisiTegak) {
        super(sisi);
        if (sisi <= 0 || tinggiLimas <= 0 || tinggiSisiTegak <= 0) {
            throw new IllegalArgumentException("Semua parameter harus positif ya");
        }
        this.tinggiLimas = tinggiLimas;
        this.tinggiSisiTegak = tinggiSisiTegak;
    }

    @Override
    public void hitungVolume() {
        volumeLimas = (1.0 / 3.0) * super.hitungLuas() * tinggiLimas;
    }

    @Override
    public void hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();
        // luas sisi tegak (segitiga sama kaki) = 1/2 * alas * tinggi segitiga
        // alas segitiga sisi = sisi persegi (alas limas)
        double luasSisiTegak = 0.5 * super.sisi * tinggiSisiTegak;
        luasPermukaanLimas = luasAlas + 4 * luasSisiTegak;
    }

    // Getter opsional untuk ambil hasil perhitungan
    public double getVolumeLimas() {
        return volumeLimas;
    }

    public double getLuasPermukaanLimas() {
        return luasPermukaanLimas;
    }
}
