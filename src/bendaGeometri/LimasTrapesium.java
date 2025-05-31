package bendaGeometri;

public class LimasTrapesium extends Trapesium {

    private double tinggiLimasTrapesium;
    private double volumeLimasTrapesium;
    private double luasPermukaanLimasTrapesium;

    public LimasTrapesium(double sisiSejajar1, double sisiSejajar2, double tinggi, double sisiMiring, double tinggiLimasTrapesium) {
        super(sisiSejajar1, sisiSejajar2, tinggi, sisiMiring);

        if (sisiSejajar1 <= 0 || sisiSejajar2 <= 0 || tinggi <= 0 || sisiMiring <= 0 || tinggiLimasTrapesium <= 0) {
            throw new IllegalArgumentException("parameter harus positif");
        }

        this.tinggiLimasTrapesium = tinggiLimasTrapesium;
    }

    @Override
    public void hitungVolume() {
        double luasAlas = super.hitungLuas();
        volumeLimasTrapesium = (1.0 / 3.0) * luasAlas * tinggiLimasTrapesium;
    }

    @Override
    public void hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();

        // Anggap setiap sisi samping berupa segitiga, kita pakai perkiraan luas segitiga ½ × alas × tinggiSisi
        // Di sini kita anggap tinggiSisi (limas) sebagai tinggi untuk tiap segitiga, dan keliling dipakai untuk keliling alas
        double kelilingAlas = super.hitungKeliling();

        // Karena tidak ada tinggi sisi segitiga masing-masing, maka disederhanakan (jika ingin akurat harus pakai tinggi sisi segitiga per sisi)
        double luasSisiSamping = 0.5 * kelilingAlas * tinggiLimasTrapesium;

        luasPermukaanLimasTrapesium = luasAlas + luasSisiSamping;
    }

    public double getVolumeLimasTrapesium() {
        return volumeLimasTrapesium;
    }

    public double getLuasPermukaanLimasTrapesium() {
        return luasPermukaanLimasTrapesium;
    }
}
