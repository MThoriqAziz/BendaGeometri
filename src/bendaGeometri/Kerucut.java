package bendaGeometri;

public class Kerucut extends Lingkaran {

    private double tinggiKerucut;
    
    private double volumeKerucut;
    
    private double luasPermukaanKerucut;

    public Kerucut(double jariJari, double tinggiKerucut) {
        super(jariJari);
        this.tinggiKerucut = tinggiKerucut;
    }

    @Override
    public double hitungVolume() {
        volumeKerucut = (1.0 / 3) * Math.PI * jariJari * jariJari * tinggiKerucut;
        return volumeKerucut;
    }

    @Override
    public double hitungLuasPermukaan() {
        // s = √(r^2 + t^2)
        double sisiMiring = Math.sqrt((jariJari * jariJari) + (tinggiKerucut * tinggiKerucut));
        // L = π * r * (r + s)
        luasPermukaanKerucut = Math.PI * jariJari * (jariJari + sisiMiring);
        return luasPermukaanKerucut;
    }
}