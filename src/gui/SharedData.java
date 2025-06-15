package gui;

import bendaGeometri.JajarGenjang;
import bendaGeometri.Segitiga;

public class SharedData {
    private static JajarGenjang jg;
    private static Segitiga sg;

    public static void setJajarGenjang(JajarGenjang jajarGenjang) {
        jg = jajarGenjang;
    }

    public static JajarGenjang getJajarGenjang() {
        return jg;
    }
    
    public static void setSegitiga(Segitiga segitiga) {
        sg = segitiga;
    }
    
    public static Segitiga getSegitiga() {
    return sg;
    }
}
