package bendaGeometri;

public class LimasJajarGenjang extends JajarGenjang {

    private double volumeLimasJajarGenjang;
    private double luasPermukaanLimasJajarGenjang;
    public double tinggiLimas;
    public double tinggiSisiTegak;

    public LimasJajarGenjang(double alas, double tinggiAlas, double sisiMiring, double tinggiLimas, double tinggiSisiTegak) {
        super(alas, tinggiAlas, sisiMiring);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSisiTegak = tinggiSisiTegak;
    }

    @Override
    public void hitungVolume() {
        double luasAlas = hitungLuas(); // menggunakan metode dari superclass
        volumeLimasJajarGenjang = (1.0 / 3.0) * luasAlas * tinggiLimas;
        System.out.println("Volume Limas Jajar Genjang: " + volumeLimasJajarGenjang);
    }

    @Override
    public void hitungLuasPermukaan() {
        double luasAlas = hitungLuas();
        double luasSisiTegak = 2 * getAlas() * tinggiSisiTegak + 2 * getSisiMiring() * tinggiSisiTegak;
        luasSisiTegak = 0.5 * luasSisiTegak;
        luasPermukaanLimasJajarGenjang = luasAlas + luasSisiTegak;
        System.out.println("Luas Permukaan Limas Jajar Genjang: " + luasPermukaanLimasJajarGenjang);
    }

    public void hitungLuasSisiTegak() {
        double luasSisi = 0.5 * getAlas() * tinggiSisiTegak;
        System.out.println("Luas satu sisi tegak: " + luasSisi);
    }

    public double getAlas() {
        return this.alas;
    }

    public double getSisiMiring() {
        return this.sisiMiringJajarGenjang;
    }
}
