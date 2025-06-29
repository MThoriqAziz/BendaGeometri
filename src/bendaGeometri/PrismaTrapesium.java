
package bendaGeometri;

public class PrismaTrapesium extends Trapesium {

    private double tinggiPrismaTrapesium;

    private double volumePrismaTrapesium;

    private double luasPermukaanPrismaTrapesium;

    public PrismaTrapesium(double sisiSejajar1, double sisiSejajar2, int tinggi, double sisiMiring, double tinggiPrismaTrapesium) {
        super(sisiSejajar1, sisiSejajar2, tinggi, sisiMiring);

        if (sisiSejajar1 <= 0 || sisiSejajar2 <= 0 || tinggi <= 0 || sisiMiring <= 0 || tinggiPrismaTrapesium <= 0) {
            throw new IllegalArgumentException("parameter harus positif");
        }

        this.tinggiPrismaTrapesium = tinggiPrismaTrapesium;
    }

    @Override
    public double hitungVolume() {
        volumePrismaTrapesium = super.hitungLuas() * tinggiPrismaTrapesium;
        return volumePrismaTrapesium;
    }

    @Override
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();
        double keliling = super.hitungKeliling();
        luasPermukaanPrismaTrapesium = 2 * luasAlas + keliling * tinggiPrismaTrapesium;
        return luasPermukaanPrismaTrapesium;
    }
}
