package bendaGeometri;

public class JuringBola extends Bola {

    private double theta;
    
    private double luasJuring;
    
    private double volumeJuring;

    public JuringBola(double jariJari, double theta) {
        super(jariJari);
        this.theta = theta;
    }

    public double hitungLuas() {
        // Rumus: L = 2 * π * r^2 * (θ / 360°) jika dalam derajat
        // Jika theta dalam radian: L = 2 * π * r^2 * (θ / 2π) = r^2 * θ
        luasJuring = jariJari * jariJari * theta;
        return luasJuring;
    }

    @Override
    public void hitungVolume() {
        // V = (2/3) * π * r^3 * (θ / 2π) = (1/3) * r^3 * θ
        volumeJuring = (1.0 / 3.0) * Math.pow(jariJari, 3) * theta;
    }

    public double getVolumeJuring() {
        return volumeJuring;
    }
}
