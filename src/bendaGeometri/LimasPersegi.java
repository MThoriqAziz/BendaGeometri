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
    public double hitungVolume() {
        return (1.0 / 3.0) * super.hitungLuas() * tinggiLimas;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();
        double luasSisiTegak = 0.5 * super.sisi * tinggiSisiTegak;
        luasPermukaanLimas = luasAlas + 4 * luasSisiTegak;
        return luasPermukaanLimas;
    }

    // Getter opsional untuk ambil hasil perhitungan
    public double getVolumeLimas() {
        return volumeLimas;
    }

    public double getLuasPermukaanLimas() {
        return luasPermukaanLimas;
    }
}
