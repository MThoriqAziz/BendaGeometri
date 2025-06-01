package bendaGeometri;

public class LimasSegitiga extends Segitiga {

    private double tinggiLimas;
    
    private double volumeLimasSegitiga;

    private double luasPermukaanLimasSegitiga;

    public LimasSegitiga(double tinggiLimas, double alas, double tinggiSegitiga,double sisi) {
        super(alas, tinggiSegitiga,sisi);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public void hitungVolume() {
        volumeLimasSegitiga = (1.0 / 3.0) * super.hitungLuas() * tinggiLimas;
    }

    @Override
    public void hitungLuasPermukaan(){
        double luasAlas = super.hitungLuas();
        double luasSisiTegak = 3 * luasAlas; 
        luasPermukaanLimasSegitiga = luasAlas + luasSisiTegak;
    }

    public double getVolumeLimasSegitiga() {
        return volumeLimasSegitiga;
    }

    public double getLuasPermukaanLimasSegitiga() {
        return luasPermukaanLimasSegitiga;
    }
}
