package bendaGeometri;

public class PrismaSegitiga extends Segitiga {
    private double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaSegitiga(double alas, double tinggiSegitiga, double sisiA, double sisiB, double sisiC, double tinggiPrisma) {
        super(alas, tinggiSegitiga, sisiA, sisiB, sisiC);
        this.tinggiPrisma = tinggiPrisma;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
    }

    // Hitung Volume = Luas alas segitiga × tinggi prisma
    public double hitungVolume() {
        volume = super.hitungLuas() * tinggiPrisma;
        return volume;
    }

    // Hitung Luas Permukaan:
    // 2 × Luas alas + keliling alas × tinggi prisma
    public double hitungLuasPermukaan() {
        luasPermukaan = 2 * super.hitungLuas() + super.hitungKeliling() * tinggiPrisma;
        return luasPermukaan;
    }
}
