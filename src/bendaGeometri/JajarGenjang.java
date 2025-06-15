
package bendaGeometri;

public class JajarGenjang extends Benda2D{
    public double alas;
    public double tinggi;
    public double sisiMiring;

    public JajarGenjang(double alas, double tinggi, double sisiMiring) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
    }

    public double getAlas() {
        return alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiMiring() {
        return sisiMiring;
    }

    public void setAlas(double alas) {
        this.alas = alas;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public void setSisiMiring(double sisiMiring) {
        this.sisiMiring = sisiMiring;
    }

    @Override
    public double hitungLuas() {
        return alas * tinggi;
    }

    // Overloading
    public double hitungLuas(double alas, double tinggi) {
        return alas * tinggi;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (alas + sisiMiring);
    }

}
