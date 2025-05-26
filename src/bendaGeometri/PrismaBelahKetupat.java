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
        this.volumePrismaBk = hitungVolumePrismaBk();
        this.luasPermukaanBk = hitungLuasPermukaanBk();
        
    }

    public double hitungLuasPermukaanBk() {
        double luasAlas = super.hitungLuas();
        double keliling = super.hitungKeliling();
        return 2 * luasAlas + keliling * tinggiPrismaBk;
    }

    public double hitungVolumePrismaBk() {
        return super.hitungLuas() * tinggiPrismaBk;
        
    }
}
