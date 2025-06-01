package bendaGeometri;

public class KerucutTerpancung extends Kerucut {

    private double jariJariAtas; // r
    private double jariJariBawah; // R
    private double tinggi; // t
    private double volumeKerucutTerpancung;
    private double luasPermukaanKerucutTerpancung;

    public KerucutTerpancung(double jariJariBawah, double jariJariAtas, double tinggi) {
        super(double jarijari,double tinggiKerucut); 
        this.jariJariBawah = jariJariBawah;
        this.jariJariAtas = jariJariAtas;
        this.tinggi = tinggi;
    }

    public void hitungVolume() {
        // Volume = (1/3) * π * t * (R² + Rr + r²)
        volumeKerucutTerpancung = (1.0 / 3) * Math.PI * tinggi *
                (jariJariBawah * jariJariBawah + jariJariBawah * jariJariAtas + jariJariAtas * jariJariAtas);
    }

    public void hitungLuasPermukaan() {
        // s = √((R - r)² + t²)
        double selimut = Math.sqrt(Math.pow(jariJariBawah - jariJariAtas, 2) + Math.pow(tinggi, 2));
        // Luas permukaan = π * (R + r) * s + π * R² + π * r²
        luasPermukaanKerucutTerpancung = Math.PI * (jariJariBawah + jariJariAtas) * selimut
                + Math.PI * jariJariBawah * jariJariBawah + Math.PI * jariJariAtas * jariJariAtas;
    }
}
