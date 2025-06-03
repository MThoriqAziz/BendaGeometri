package  bendaGeometri;

public class Tabung extends Lingkaran {

    private double tinggi;

    private double volumeSilinder;

    private double luasPermukaanSilinder;

     public Tabung(double jariJari, double tinggi) {
        super(jariJari); // Kirim jari-jari ke class Lingkaran
        this.tinggi = tinggi;
    }

    @Override
    public void  hitungVolume() {
        volumeSilinder = Math.PI * getJariJari() * getJariJari() * tinggi;
     }

    @Override
    public void  hitungLuasPermukaan() {
       double r = getJariJari();
        luasPermukaanSilinder = 2 * Math.PI * r * r + 2 * Math.PI * r * tinggi;
    }
    
        public double getTinggi() {
        return tinggi;
    }
}
