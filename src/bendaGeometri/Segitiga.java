package bendaGeometri;

public class Segitiga extends Benda2D {

    public double alas;

    public double tinggi;
    
    public double sisi;

    private double luasSegitiga;

    private double kelilingSegitiga;

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungKeliling() {
        kelilingSegitiga = sisi + sisi + alas;
        return kelilingSegitiga;
    }

    @Override
    public double hitungLuas() {
         luasSegitiga =  0.5 * alas * tinggi;
         return luasSegitiga;
    }
        @Override
    public void hitungVolume(){}
    
    @Override
    public void hitungLuasPermukaan(){}
}
