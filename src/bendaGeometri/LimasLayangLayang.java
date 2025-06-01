package bendaGeometri;

public class LimasLayangLayang extends LayangLayang {

    private double tinggiLimas;

    private double tinggiSisiTegak1;
    
    private double tinggiSisiTegak2;

    private double volumeLimasLayangLayang;
    
    private double luasPermukaanLimasLayangLayang;

    public LimasLayangLayang(double diagonal1, double diagonal2, double sisi1, double sisi2,
                             double tinggiLimas, double tinggiSisiTegak1, double tinggiSisiTegak2) {
        super(diagonal1, diagonal2, sisi1, sisi2);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSisiTegak1 = tinggiSisiTegak1;
        this.tinggiSisiTegak2 = tinggiSisiTegak2;
    }

    @Override
    public void hitungVolume() {
        volumeLimasLayangLayang = (1.0 / 3) * super.hitungLuas() * tinggiLimas;
    }

    @Override
    public void hitungLuasPermukaan() {
        double luasSisiTegak1 = 0.5 * sisi1 * tinggiSisiTegak1;
        double luasSisiTegak2 = 0.5 * sisi2 * tinggiSisiTegak2;
        luasPermukaanLimasLayangLayang = super.hitungLuas() + 2 * (luasSisiTegak1 + luasSisiTegak2);
    }

    public double getVolume() {
        return volumeLimasLayangLayang;
    }

    public double getLuasPermukaan() {
        return luasPermukaanLimasLayangLayang;
    }
}
