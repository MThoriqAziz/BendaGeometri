package bendaGeometri;

public class Segitiga extends Benda2D {

    public double alas;

    public double tinggiSegitiga;
    
    public double sisi;

    private double luasSegitiga;

    private double kelilingSegitiga;

    public Segitiga(double alas, double tinggiSegitiga) {
        this.alas = alas;
        this.tinggiSegitiga = tinggiSegitiga;
    }

    @Override
    public double hitungKeliling() {
        kelilingSegitiga = sisi + sisi + alas;
        return kelilingSegitiga;
    }

    @Override
    public double hitungLuas() {
         luasSegitiga =  0.5 * alas * tinggiSegitiga;
         return luasSegitiga;
    }
        @Override
    public void hitungVolume(){}
    
    @Override
    public void hitungLuasPermukaan(){}
}
