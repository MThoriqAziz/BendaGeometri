package bendaGeometri;

public class LayangLayang extends Benda2D {
    private double diagonal1;
    private double diagonal2;
    private double sisiPendek;
    private double sisiPanjang;

    public LayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiPendek = sisiPendek;
        this.sisiPanjang = sisiPanjang;
    }

    // Getter
    public double getDiagonal1() {
        return diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    public double getSisiPendek() {
        return sisiPendek;
    }

    public double getSisiPanjang() {
        return sisiPanjang;
    }

    // Setter
    public void setDiagonal1(double diagonal1) {
        this.diagonal1 = diagonal1;
    }

    public void setDiagonal2(double diagonal2) {
        this.diagonal2 = diagonal2;
    }

    public void setSisiPendek(double sisiPendek) {
        this.sisiPendek = sisiPendek;
    }

    public void setSisiPanjang(double sisiPanjang) {
        this.sisiPanjang = sisiPanjang;
    }

    @Override
    public double hitungLuas() {
        return 0.5 * diagonal1 * diagonal2;
    }

    // Overloading method
    public double hitungLuas(double d1, double d2) {
        return 0.5 * d1 * d2;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (sisiPendek + sisiPanjang);
    }
}
