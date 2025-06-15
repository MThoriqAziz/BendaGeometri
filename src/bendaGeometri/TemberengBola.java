package bendaGeometri;
        
public class TemberengBola extends Bola {

    private double theta;

    private double luasTembereng;

    private double kelilingTembereng;

    public TemberengBola(double jariJari, double theta) {
         super(jariJari);
        this.theta = theta;
    }

    @Override
    public double hitungLuas() {
 double r = getJariJari();
        double h = r * (1 - Math.cos(Math.toRadians(theta / 2.0)));
        luasTembereng = 2 * Math.PI * r * h;
        return luasTembereng;
    }

    @Override
    public double hitungKeliling() {
       double r = getJariJari();
        kelilingTembereng = 2 * Math.PI * r * (theta / 360.0);
        return kelilingTembereng;
    }
    
    public double getTheta() {
        return theta;
    }

    public double getLuasTembereng() {
        return luasTembereng;
    }

    public double getKelilingTembereng() {
        return kelilingTembereng;
    }
}