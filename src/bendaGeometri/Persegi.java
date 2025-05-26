package bendaGeometri;

public class Persegi extends Benda2D {

    public double sisi;

    private double luasPersegi;

    private double kelilingPersegi;

    public Persegi(double sisi) {
    }
    
    @Override
    public double hitungLuas() {
        luasPersegi = sisi * sisi;
        return luasPersegi;
    }
    
    @Override
    public double hitungKeliling() {
        kelilingPersegi = 4 * sisi;
        return kelilingPersegi;
    }
    
     @Override
    public void hitungVolume(){}
    
    @Override
    public void hitungLuasPermukaan(){}
}
