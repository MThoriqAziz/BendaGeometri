package bendaGeometri;

public class PrismaLayangLayang extends LayangLayang {
    protected double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaLayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang, double tinggiPrisma) {
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
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
        luasPermukaan = 2 * super.hitungLuas() + super.hitungKeliling() * tinggiPrisma;
        return luasPermukaan;
    }
}
