package bendaGeometri;

public class JajarGenjang extends Benda2D {

    public double alas;

    public double tinggi;

    private double luasJajarGenjang;

    private double kelilingJajarGenjang;

    public double sisiMiringJajarGenjang;

    public JajarGenjang(double alas, double tinggi, double sisiMiringJajarGenjang) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiringJajarGenjang = sisiMiringJajarGenjang;
    }

    @Override
    public double hitungLuas() {
        luasJajarGenjang = alas * tinggi;
        return luasJajarGenjang;
    }

    @Override
    public double hitungKeliling() {
        kelilingJajarGenjang = 2 * (alas * sisiMiringJajarGenjang);
        return kelilingJajarGenjang;
    }
    
    @Override
    public void hitungVolume(){}
    
    @Override
    public void hitungLuasPermukaan(){}
}
