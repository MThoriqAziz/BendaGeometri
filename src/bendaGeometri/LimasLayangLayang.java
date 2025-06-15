package bendaGeometri;

public class LimasLayangLayang extends LayangLayang {
    private double tinggiLimas;
    private double volume;
    private double luasPermukaan;

    public LimasLayangLayang(double d1, double d2, double sisiPendek, double sisiPanjang, double tinggiLimas) {
        super(d1, d2, sisiPendek, sisiPanjang);
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
        // Asumsi: empat sisi tegak adalah segitiga yang berbagi sisi dengan sisi layang-layang
        double luasSisiTegak = 2 * (getSisiPendek() * tinggiLimas / 2) + 2 * (getSisiPanjang() * tinggiLimas / 2);
        luasPermukaan = super.hitungLuas() + luasSisiTegak;
        return luasPermukaan;
    }
}
