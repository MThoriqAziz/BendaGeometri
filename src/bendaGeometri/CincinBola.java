package bendaGeometri;

public class CincinBola extends Bola {

    private double jariJariDalam;

    private double jarakDuaBidang;

    private double volumeCincinBola;

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
    public double hitungVolume() {
         double r = super.getJariJari();
        double h = jarakDuaBidang;
        double a = r;
        double b = jariJariDalam;
        volumeCincinBola =  Math.PI * h * h * (r - h / 3.0);
      return volumeCincinBola;
    }

    @Override
    public double hitungLuasPermukaan() {
     luasPermukaan = 2 * Math.PI * jarakDuaBidang * super.getJariJari();
     return luasPermukaan;
    }
    
    
    public double getVolume() {
        return volumeCincinBola;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }
}