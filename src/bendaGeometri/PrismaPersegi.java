package bendaGeometri;

public class PrismaPersegi extends Persegi {

    private double tinggiPrisma;
    private double volumePrisma;
    private double luasPermukaanPrisma;

    public PrismaPersegi(double sisi, double tinggiPrisma) {
        super(sisi);
        if (sisi <= 0 || tinggiPrisma <= 0) {
            throw new IllegalArgumentException("Parameter harus positif");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();
        double kelilingAlas = super.hitungKeliling();
        luasPermukaanPrisma = 2 * luasAlas + kelilingAlas * tinggiPrisma;
        return luasPermukaanPrisma;
    }

    @Override
    public double hitungVolume() {
        volumePrisma = super.hitungLuas() * tinggiPrisma;
        return volumePrisma;
    }

    // Getter untuk ambil hasil hitungan (opsional)
    public double getLuasPermukaanPrisma() {
        return luasPermukaanPrisma;
    }

    public double getVolumePrisma() {
        return volumePrisma;
    }
}