package bendaGeometri;

public class LimasSegitiga extends Segitiga {
    private double tinggiLimas;

    public LimasSegitiga(double alas, double tinggiSegitiga, double sisiA, double sisiB, double sisiC, double tinggiLimas) {
        super(alas, tinggiSegitiga, sisiA, sisiB, sisiC);
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
        // Volume limas = 1/3 * luas alas * tinggi limas
        return (1.0 / 3.0) * super.hitungLuas() * tinggiLimas;
    }

    @Override
    public double hitungLuasPermukaan() {
        // Luas permukaan = luas alas + luas 3 sisi tegak
        // Diasumsikan sisi tegak berbentuk segitiga juga dan sisiA, sisiB, sisiC adalah sisi alas segitiga
        double luasAlas = super.hitungLuas();

        // Hitung tinggi sisi tegak (luas segitiga samping tidak diketahui secara eksplisit)
        // Diasumsikan: tinggi sisi tegak sudah bisa dihitung dari sisiA, sisiB, sisiC
        // Di sini kita ambil pendekatan sederhana dengan asumsi tinggi dari sisi samping = tinggi limas
        double luasSisiTegak1 = 0.5 * sisiA * tinggiLimas;
        double luasSisiTegak2 = 0.5 * sisiB * tinggiLimas;
        double luasSisiTegak3 = 0.5 * sisiC * tinggiLimas;

        return luasAlas + luasSisiTegak1 + luasSisiTegak2 + luasSisiTegak3;
    }
}
