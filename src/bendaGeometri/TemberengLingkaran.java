package bendaGeometri;

public class TemberengLingkaran extends Lingkaran {

    private double taliBusur;

    private double busur;

    private double jariJari;

    private double sudut;

    private double luasTemberengLingkaran;

    private double kelilingTemberengLingkaran;

    public TemberengLingkaran(double taliBusur, double busur, double jariJari, double sudut) {
        super(jariJari);
        this.taliBusur = taliBusur;
        this.jariJari = jariJari;
        this.sudut = sudut;

        // Hitung panjang busur berdasarkan sudut
        this.busur = (sudut / 360.0) * 2 * Math.PI * jariJari;
    }

    @Override
    public double hitungLuas() {
        double luasJuring = (sudut / 360.0) * Math.PI * jariJari * jariJari;
        double sudutRad = Math.toRadians(sudut);
        double luasSegitiga = 0.5 * jariJari * jariJari * Math.sin(sudutRad);
        luasTemberengLingkaran = luasJuring - luasSegitiga;
        return luasTemberengLingkaran;
    }

    @Override
    public double hitungKeliling() {
        kelilingTemberengLingkaran = busur + taliBusur;
        return kelilingTemberengLingkaran;
    }
    
    
    public double getLuasTemberengLingkaran() {
        return luasTemberengLingkaran;
    }

    public double getKelilingTemberengLingkaran() {
        return kelilingTemberengLingkaran;
    }
}
