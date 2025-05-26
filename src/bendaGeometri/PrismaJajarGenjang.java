package bendaGeometri;

public class PrismaJajarGenjang extends JajarGenjang {

    public double tinggiPrisma;
    private double volumePrismaJajarGenjang;
    private double luasPermukaanPrismaJajarGenjang;

    public PrismaJajarGenjang(double alas, double tinggiAlas, double sisiMiring, double tinggiPrisma) {
        super(alas, tinggiAlas, sisiMiring);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public void hitungVolume() {
        double luasAlas = hitungLuas(); // dari superclass
        volumePrismaJajarGenjang = luasAlas * tinggiPrisma;
        System.out.println("Volume Prisma Jajar Genjang: " + volumePrismaJajarGenjang);
    }

    @Override
    public void hitungLuasPermukaan() {
        double luasAlas = hitungLuas();
        double kelilingAlas = hitungKeliling();
        luasPermukaanPrismaJajarGenjang = 2 * luasAlas + kelilingAlas * tinggiPrisma;
        System.out.println("Luas Permukaan Prisma Jajar Genjang: " + luasPermukaanPrismaJajarGenjang);
    }

    // opsional
    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public double getVolume() {
        return volumePrismaJajarGenjang;
    }

    public double getLuasPermukaan() {
        return luasPermukaanPrismaJajarGenjang;
    }
}
