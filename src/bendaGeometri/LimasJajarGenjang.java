package bendaGeometri;

public class LimasJajarGenjang extends JajarGenjang {
    protected double tinggiLimas;
    protected double tinggiSisiTegak;
    
    private double volume;
    private double luasPermukaan;

    public LimasJajarGenjang(double alas, double tinggiAlas, double sisiMiring, double tinggiLimas, double tinggiSisiTegak) {
        super(alas, tinggiAlas, sisiMiring);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSisiTegak = tinggiSisiTegak;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public double getTinggiSisiTegak() {
        return tinggiSisiTegak;
    }

    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    @Override
    public double hitungVolume() {
        double luasAlas = super.hitungLuas();
        volume = (1.0 / 3.0) * luasAlas * tinggiLimas;
        return volume;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();
        double luasSisiTegak = 2 * super.alas * tinggiSisiTegak + 2 * super.sisiMiring * tinggiSisiTegak;
        luasSisiTegak = 0.5 * luasSisiTegak;
        luasPermukaan = luasAlas + luasSisiTegak;
        return luasPermukaan;
    }

    // Metode tambahan (bukan override) untuk menghitung luas satu sisi tegak
    public double hitungLuasSisiTegak() {
        return 0.5 * super.alas * tinggiSisiTegak;
    }
}
