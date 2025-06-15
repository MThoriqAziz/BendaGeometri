package gui;

import bendaGeometri.*;

public class SharedData {
    private static JajarGenjang jg;
    private static Segitiga sg;
    private static LayangLayang ly;
    private static PersegiPanjang pp;
    private static BelahKetupat bk;
    private static Trapesium t;
    private static Lingkaran l;

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
    
    public static void setLayanglayang(LayangLayang layangLayang){
        ly = layangLayang;
    }
    
    public static LayangLayang getLayanglayang(){
        return ly;
    }
    
    public static void setPersegiPanjang(PersegiPanjang p) {
        pp = p; 
    }
    
    public static PersegiPanjang getPersegiPanjang() {
        return pp; 
    }
    
    public static void setBelahKetupat(BelahKetupat belahKetupat) {
        bk = belahKetupat; 
    }
    
    public static BelahKetupat getBelahKetupat() {
        return bk; 
    }
    
    public static void setTrapesium(Trapesium trapesium) {
        t = trapesium; 
    }
    
    public static Trapesium getTrapesium() {
        return t; 
    }
    
    public static void setLingkaran(Lingkaran lingkaran) {
        l = lingkaran; 
    }
    
    public static Lingkaran getLingkaran() {
        return l; 
    }
    
}
