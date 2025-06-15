package bendaGeometri;

public abstract class Benda2D implements BendaGeometri {

    @Override
    public abstract double hitungLuas();
    
    @Override
    public abstract double hitungKeliling();
    
    @Override
    public double hitungVolume() {
        return 0;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 0;
    }

}
