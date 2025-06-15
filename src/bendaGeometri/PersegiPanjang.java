package bendaGeometri;

public class PersegiPanjang extends Benda2D {

    public double panjang;

    public double lebar;

    private double luasPersegiPanjang;

    private double kelilingPersegiPanjang;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double hitungLuas() {
       luasPersegiPanjang = panjang * lebar;
       return luasPersegiPanjang;
    }

    @Override
    public double hitungKeliling() {
        kelilingPersegiPanjang = 2 * (panjang + lebar);
        return kelilingPersegiPanjang;
    }
    
}
