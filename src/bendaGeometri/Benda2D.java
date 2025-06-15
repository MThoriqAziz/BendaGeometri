package bendaGeometri;

public abstract class Benda2D implements BendaGeometri {

    public abstract double hitungLuas();
    public abstract double hitungKeliling();
    
    @Override
    public void hitungVolume() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void hitungLuasPermukaan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
