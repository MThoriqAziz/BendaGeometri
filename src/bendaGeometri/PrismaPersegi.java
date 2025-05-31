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
    public void hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();
        double kelilingAlas = super.hitungKeliling();
        luasPermukaanPrisma = 2 * luasAlas + kelilingAlas * tinggiPrisma;
    }

    @Override
    public void hitungVolume() {
        volumePrisma = super.hitungLuas() * tinggiPrisma;
    }

    // Getter untuk ambil hasil hitungan (opsional)
    public double getLuasPermukaanPrisma() {
        return luasPermukaanPrisma;
    }

    public double getVolumePrisma() {
        return volumePrisma;
    }
}
