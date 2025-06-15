
package bendaGeometri;


public class PrismaJajarGenjang extends JajarGenjang {
    protected double tinggiPrisma;
    private double volume;
    private double luasPermukaan;

    public PrismaJajarGenjang(double alas, double tinggiAlas, double sisiMiring, double tinggiPrisma) {
        super(alas, tinggiAlas, sisiMiring);
        this.tinggiPrisma = tinggiPrisma;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
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