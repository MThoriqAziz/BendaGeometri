package bendaGeometri;

public class LimasBelahKetupat extends BelahKetupat {

    private double volumeLimasBk;

    private double luasPermukaanLimasBk;

    private double tinggiLimasBk;

    private double tinggiSisiTegakBk;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double sisiBk, double tinggiLimasBk, double tinggiSisiTegakBk) {
        super(diagonal1, diagonal2, sisiBk);
        if (diagonal1 <= 0 || diagonal2 <= 0 || sisiBk <= 0 || tinggiLimasBk <= 0 || tinggiSisiTegakBk <= 0) {
            throw new IllegalArgumentException("semua parameter harus positif ya");
        }
        this.tinggiLimasBk = tinggiLimasBk;
        this.tinggiSisiTegakBk = tinggiSisiTegakBk;
        this.volumeLimasBk = hitungVolumeBk();
        this.luasPermukaanLimasBk = hitungLuasPermukaanBk();
    
    }

    public double hitungVolumeBk() {
        return (1.0 / 3.0) * super.hitungLuas() * tinggiLimasBk;
    }

    public double hitungLuasPermukaanBk() {
        double luasAlas = super.hitungLuas();
        double luasSisiTegak = (1.0 / 2.0) * super.hitungKeliling() / 4 * tinggiSisiTegakBk;
        return luasAlas + 4 * luasSisiTegak;
    }
}
