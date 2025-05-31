package bendaGeometri;

public class LimasSegitiga extends Segitiga {

    private double tinggiLimas;

    private double alas;

    private double volumeLimasSegitiga;

    private double luasPermukaanLimasSegitiga;

    public LimasSegitiga(double tinggiLimas, double alas, double tinggiSegitiga) {
            super(alas, tinggiSegitiga);
            this.tinggiLimas = tinggiLimas;
    }

    @Override
    public void hitungVolume() {
        volumeLimasSegitiga =  (1.0/3) * super.hitungLuas() * tinggiLimas;
        return volumeLimasSegitiga;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanLimasSegitiga = luasSegitiga * 3;
        return   luasPermukaanLimasSegitiga;
        
    }
}
