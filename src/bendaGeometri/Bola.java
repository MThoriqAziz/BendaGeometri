package bendaGeometri;

public class Bola extends Lingkaran {

    private Lingkaran lingkaran;
    private double volumeBola;
    private double luasPermukaanBola;

    public Bola(double jariJari) {
        super(jariJari);
         double r = lingkaran.getJariJari();
        if (jariJari <= 0) {
            throw new IllegalArgumentException("Jari-jari harus positif");
        }
    }

    @Override
    public void hitungVolume() {
        volumeBola = (4.0 / 3.0) * Math.PI * Math.pow(jariJari, 3);
    }

    @Override
    public void hitungLuasPermukaan() {
        luasPermukaanBola = 4 * Math.PI * jariJari * jariJari;
    }
    
    @Override
      public double getJariJari() {
        return lingkaran.getJariJari();
    }
      
}
