package bendaGeometri;

public class PrismaBelahKetupat extends BelahKetupat {

    private double tinggiPrismaBk;

    private double volumePrismaBk;

    private double luasPermukaanBk;

    public PrismaBelahKetupat(double diagonal1, double diagonal2, double sisiBk, double tinggiPrismaBk) {
    
    super(diagonal1, diagonal2, sisiBk);
        if (diagonal1 <= 0 || diagonal2 <= 0 || sisiBk <= 0 || tinggiPrismaBk <= 0) {
            throw new IllegalArgumentException("parameter harus positif");
        }
        this.tinggiPrismaBk = tinggiPrismaBk;

        
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();
        double keliling = super.hitungKeliling();
        luasPermukaanBk = 2 * luasAlas + keliling * tinggiPrismaBk;
        return luasPermukaanBk;
    }

    @Override
    public double hitungVolume() {
        volumePrismaBk = super.hitungLuas() * tinggiPrismaBk;
        return volumePrismaBk;
    }
}