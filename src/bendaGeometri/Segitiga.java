package bendaGeometri;

public class Segitiga extends Benda2D {
    public double alas;
    public double tinggi;
    public double sisiA;
    public double sisiB;
    public double sisiC;

    public Segitiga(double alas, double tinggi, double sisiA, double sisiB, double sisiC) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
    }

    // Getter
    public double getAlas() {
        return alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public double getSisiA() {
        return sisiA;
    }

    public double getSisiB() {
        return sisiB;
    }

    public double getSisiC() {
        return sisiC;
    }

    // Setter
    public void setAlas(double alas) {
        this.alas = alas;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    public void setSisiA(double sisiA) {
        this.sisiA = sisiA;
    }

    public void setSisiB(double sisiB) {
        this.sisiB = sisiB;
    }

    public void setSisiC(double sisiC) {
        this.sisiC = sisiC;
    }

    // Override metode abstrak
    @Override
    public double hitungLuas() {
        return 0.5 * alas * tinggi;
    }

    // Overloading hitungLuas
    public double hitungLuas(double alas, double tinggi) {
        return 0.5 * alas * tinggi;
    }

    @Override
    public double hitungKeliling() {
        return sisiA + sisiB + sisiC;
    }
}
