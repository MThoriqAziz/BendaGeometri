package bendaGeometri;

public class PrismaLayangLayang extends LayangLayang {

    private double tinggiPrismaLayangLayang;

    private double volumePrismaLayangLayang;
    
    private double luasPermukaanPrismaLayangLayang;

    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisi1, double sisi2, double tinggiPrismaLayangLayang) {
        super(diagonal1, diagonal2, sisi1, sisi2);
        this.tinggiPrismaLayangLayang = tinggiPrismaLayangLayang;
    }

    @Override
    public void hitungVolume() {
        volumePrismaLayangLayang = super.hitungLuas() * tinggiPrismaLayangLayang;
    }

    @Override
    public void hitungLuasPermukaan() {
        luasPermukaanPrismaLayangLayang = 
            2 * super.hitungLuas() + super.hitungKeliling() * tinggiPrismaLayangLayang;
    }
}
