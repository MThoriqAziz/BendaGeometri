package bendaGeometri;

public class PrismaPersegiPanjang extends PersegiPanjang {
    protected double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggiPrisma) {
        super(panjang, lebar);
        this.tinggiPrisma = tinggiPrisma;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        volume = super.hitungLuas() * tinggiPrisma;
        return volume;
    }

    @Override
    public double hitungLuasPermukaan() {
        // luasPermukaan = 2 * luas alas + keliling alas * tinggi
        luasPermukaan = 2 * super.hitungLuas() + super.hitungKeliling() * tinggiPrisma;
        return luasPermukaan;
    }
}
