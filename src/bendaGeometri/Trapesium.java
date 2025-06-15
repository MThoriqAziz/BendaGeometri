package bendaGeometri;

public class Trapesium extends Benda2D {

    public double sisiSejajar1;

    public double sisiSejajar2;

    public double tinggi;

    public double sisiMiring;

    private double luasTrapesium;

    private double kelilingTrapesium;

    public Trapesium(double sisiSejajar1, double sisiSejajar2, double tinggi, double sisiMiring) {
        this.sisiSejajar1 = sisiSejajar1;
        this.sisiSejajar2=sisiSejajar2;
        this.tinggi=tinggi;
        this.sisiMiring=sisiMiring;
    }
    
    @Override
    public double hitungLuas() {
        luasTrapesium = 0.5*(sisiSejajar1 + sisiSejajar2) * tinggi;
        return luasTrapesium;
    }

    @Override
    public double hitungKeliling() {
        kelilingTrapesium = sisiSejajar1 + sisiSejajar2 + 2 * sisiMiring;
        return kelilingTrapesium;
    }
 
}
