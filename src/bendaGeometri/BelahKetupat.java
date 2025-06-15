package bendaGeometri;

public class BelahKetupat extends Benda2D {

    private double diagonal1;

    private double diagonal2;

    private double sisiBk;

    private double luasBelahKetupat;

    private double kelilingBelahKetupat;

    public BelahKetupat(double diagonal1, double diagonal2, double sisi) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiBk = sisi;
        this.luasBelahKetupat = hitungLuas();
        this.kelilingBelahKetupat = hitungKeliling();
        
        
        
    }

    @Override
    public double hitungLuas() {
        return (diagonal1 * diagonal2)/2.0; 
    }

    @Override
    public double hitungKeliling() {
        return 4.0 * sisiBk;
    }
  
}
