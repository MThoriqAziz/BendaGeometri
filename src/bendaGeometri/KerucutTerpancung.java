package bendaGeometri;

public class KerucutTerpancung extends Kerucut {

    private double jariJariAtas; // r
    private double jariJariBawah; // R
    private double tinggi; // t
    private double volumeKerucutTerpancung;
    private double luasPermukaanKerucutTerpancung;

    public KerucutTerpancung(double jariJariBawah, double jariJariAtas, double tinggi) {
        super(jariJariBawah,tinggi); // panggil konstruktor Kerucut agar tidak error
        this.jariJariBawah = jariJariBawah;
        this.jariJariAtas = jariJariAtas;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        // Volume = (1/3) * π * t * (R² + Rr + r²)
        volumeKerucutTerpancung = (1.0 / 3) * Math.PI * tinggi *
                (Math.pow(jariJariBawah, 2) + jariJariBawah * jariJariAtas + Math.pow(jariJariAtas, 2));
        return volumeKerucutTerpancung;
    }

    @Override
    public double hitungLuasPermukaan() {
        // s = √((R - r)² + t²)
        double selimut = Math.sqrt(Math.pow(jariJariBawah - jariJariAtas, 2) + Math.pow(tinggi, 2));
        // Luas permukaan = π * (R + r) * s + π * R² + π * r²
        luasPermukaanKerucutTerpancung = Math.PI * (jariJariBawah + jariJariAtas) * selimut
                + Math.PI * Math.pow(jariJariBawah, 2) + Math.PI * Math.pow(jariJariAtas, 2);
        return luasPermukaanKerucutTerpancung;
    }

    public double getVolumeKerucutTerpancung() {
        return volumeKerucutTerpancung;
    }

    public double getLuasPermukaanKerucutTerpancung() {
        return luasPermukaanKerucutTerpancung;
    }
}