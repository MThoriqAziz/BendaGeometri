package bendaGeometri;

public class CincinBola extends Bola {

    private double jariJariDalam;

    private double jarakDuaBidang;

    private double volume;

    private double luasPermukaan;

    public CincinBola(double jariJari) {
        super(jariJari);
         if (jariJari <= 0) {
            throw new IllegalArgumentException("Jari-jari harus positif");
        }
         this.jariJariDalam = jariJariDalam;
        this.jarakDuaBidang = jarakDuaBidang;
    }

    @Override
    public void hitungVolume() {
         double r = super.getJariJari();
        double h = jarakDuaBidang;
        double a = r;
        double b = jariJariDalam;
        volume =  Math.PI * h * h * (r - h / 3.0);
      
    }

    @Override
    public void hitungLuasPermukaan() {
     luasPermukaan = 2 * Math.PI * jarakDuaBidang * super.getJariJari();
    }
    
    
    public double getVolume() {
        return volume;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }
}
