package bendaGeometri;

public class Persegi extends Benda2D {

    public double sisi;

    private double luasPersegi;

    private double kelilingPersegi;

    public Persegi(double sisi) {
        this.sisi = sisi; // ini penting agar atribut sisi terisi!
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

}
