package bendaGeometri;

public class LimasPersegiPanjang extends PersegiPanjang {

    private double tinggiLimas;
    private double volumeLimas;
    private double luasPermukaanLimas;

    private double tinggiSegitigaDepan;
    private double tinggiSegitigaSamping;

    public LimasPersegiPanjang(double panjang, double lebar, double tinggiLimas, double tinggiSegitigaDepan, double tinggiSegitigaSamping) {
        super(panjang, lebar);
        this.tinggiLimas = tinggiLimas;
        this.tinggiSegitigaDepan = tinggiSegitigaDepan;
        this.tinggiSegitigaSamping = tinggiSegitigaSamping;
    }

    @Override
    public void hitungVolume(){
        volumeLimas = (1.0 / 3.0) * panjang * lebar * tinggiLimas;
    }

    @Override
    public void hitungLuasPermukaan() {
        double luasAlas = panjang * lebar;

        double luasSegitigaDepan = (panjang * tinggiSegitigaDepan) / 2;
        double luasSegitigaBelakang = luasSegitigaDepan;

        double luasSegitigaKanan = (lebar * tinggiSegitigaSamping) / 2;
        double luasSegitigaKiri = luasSegitigaKanan;

        luasPermukaanLimas = luasAlas + luasSegitigaDepan + luasSegitigaBelakang + luasSegitigaKanan + luasSegitigaKiri;
    }

    public double getVolumeLimas() {
        return volumeLimas;
    }

    public double getLuasPermukaanLimas() {
        return luasPermukaanLimas;
    }
}
