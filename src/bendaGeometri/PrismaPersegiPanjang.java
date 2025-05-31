package bendaGeometri;

public class PrismaPersegiPanjang extends PersegiPanjang {

    private double tinggi;
    private double volume;
    private double luasPermukaanPrismaPersegiPanjang;

    public PrismaPersegiPanjang(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }
    
    @Override
    public void hitungVolume() {
        double luasAlas = hitungLuas();
        volume = luasAlas * tinggi;
        System.out.println("Volume Balok (Prisma Persegi Panjang): " + volume);
    }
    @Override
    public void hitungLuasPermukaan() {
        luasPermukaanPrismaPersegiPanjang = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
        System.out.println("Luas Permukaan Balok (Prisma Persegi Panjang): " + luasPermukaanPrismaPersegiPanjang);
    }
}
