package bendaGeometri;

public class PrismaSegitiga extends Segitiga {

    private double tinggiPrismaSegitiga;
   
    private double volumePrismaSegitiga;
    
    private double luasPermukaanPrismaSegitiga;

    public PrismaSegitiga(double alas, double tinggiSegitiga, double sisiMiring, double tinggiPrismaSegitiga) {
        super(alas, tinggiSegitiga, sisiMiring);
        this.tinggiPrismaSegitiga = tinggiPrismaSegitiga;
    }

    @Override
    public void hitungVolume() {
        double luasAlas = super.hitungLuas();
        volumePrismaSegitiga = luasAlas * tinggiPrismaSegitiga;
    }

    @Override
    public void hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();
        double kelilingAlas = super.hitungKeliling();
        luasPermukaanPrismaSegitiga = 2 * luasAlas + kelilingAlas * tinggiPrismaSegitiga;
    }

    public double getVolumePrismaSegitiga() {
        return volumePrismaSegitiga;
    }

    public double getLuasPermukaanPrismaSegitiga() {
        return luasPermukaanPrismaSegitiga;
    }
}
