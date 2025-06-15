package bendaGeometri;

public class JuringLingkaran extends Lingkaran {
    private double sudut; 
    
    private double luasJuringLingkaran;
    
    private double kelilingJuringLingkaran;

    public JuringLingkaran(double jariJari, double sudut) {
        super(jariJari); // panggil konstruktor Lingkaran
        this.sudut = sudut;
    }

    @Override
    public double hitungLuas() {
        luasJuringLingkaran = (sudut / 360.0) * Math.PI * jariJari * jariJari;
        return luasJuringLingkaran;
    }

    @Override
    public double hitungKeliling() {
        double panjangBusur = (sudut / 360.0) * 2 * Math.PI * jariJari;
        kelilingJuringLingkaran = panjangBusur + 2 * jariJari;
        return kelilingJuringLingkaran;
    }
}