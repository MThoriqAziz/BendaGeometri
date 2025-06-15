package bendaGeometri;

public class LimasPersegiPanjang extends PersegiPanjang {
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggiLimas) {
        super(panjang, lebar);
        this.tinggiLimas = tinggiLimas;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public double hitungVolume() {
        volume = (1.0 / 3.0) * super.hitungLuas() * tinggiLimas;
        return volume;
    }

    @Override
    public double hitungLuasPermukaan() {
        // Asumsi: sisi tegak terdiri dari dua pasang segitiga
        double panjang = getPanjang();
        double lebar = getLebar();

        // Asumsi tinggi segitiga sisi tegak = tinggi limas
        double luasSisiTegak = 2 * (0.5 * panjang * tinggiLimas) + 2 * (0.5 * lebar * tinggiLimas);
        luasPermukaan = super.hitungLuas() + luasSisiTegak;
        return luasPermukaan;
    }
}
