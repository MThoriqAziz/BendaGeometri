package bendaGeometri;

public class PersegiPanjang extends Benda2D {
    private double panjang;
    private double lebar;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    // Getter
    public double getPanjang() {
        return panjang;
    }

    public double getLebar() {
        return lebar;
    }

    // Setter
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    @Override
    public double hitungLuas() {
        return panjang * lebar;
    }

    // Overloading method
    public double hitungLuas(double p, double l) {
        return p * l;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (panjang + lebar);
    }
}
