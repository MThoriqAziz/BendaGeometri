package bendaGeometri;

public class Bola extends Lingkaran {

    private double volumeBola;
    private double luasPermukaanBola;

    public Bola(double jariJari) {
    super(jariJari);
    this.jariJari = jariJari; // karena jariJari di Lingkaran protected
    if (jariJari <= 0) {
        throw new IllegalArgumentException("Jari-jari harus positif");
    }
}


    @Override
    public double hitungVolume() {
        volumeBola = (4.0 / 3.0) * Math.PI * Math.pow(jariJari, 3);
        return volumeBola;
    }

    @Override
    public double hitungLuasPermukaan() {
        luasPermukaanBola = 4 * Math.PI * jariJari * jariJari;
        return luasPermukaanBola;
    }
    
    @Override
      public double getJariJari() {
        return jariJari;
    }
      
}