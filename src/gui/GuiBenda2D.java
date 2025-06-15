package gui;

import javax.swing.*;
import java.awt.*;
import main.main;

public class GuiBenda2D {

    public GuiBenda2D() {
        JFrame frame = new JFrame("Pilih Benda 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 1));

        JButton btnJajarGenjang = new JButton("Jajar Genjang");
        JButton btnSegitiga = new JButton("Segitiga");
        JButton btnLayangLayang = new JButton("Layang Layang");
        JButton btnPersegiPanjang = new JButton("PersegiPanjang");
        JButton btnBelahKetupat = new JButton("Belah Ketupat");
        JButton btnTrapesium = new JButton("Trapesium");
        JButton btnLingkaran = new JButton("Lingkaran");
        JButton btnJuringLingkaran = new JButton("Juring Lingkaran");
        JButton btnPersegi = new JButton("Persegi");
        JButton btnTemberengLingkaran = new JButton("Tembereng Lingkaran");
         


        JButton btnKembali = new JButton("Kembali ke Main View");

        frame.add(btnJajarGenjang);
        frame.add(btnSegitiga);
        frame.add(btnLayangLayang);
        frame.add(btnBelahKetupat);
        frame.add(btnTrapesium);
        frame.add(btnPersegiPanjang);
        frame.add(btnLingkaran);
        frame.add(btnJuringLingkaran);
        frame.add(btnPersegi);
        frame.add(btnTemberengLingkaran);
        
        frame.add(btnKembali);

        btnJajarGenjang.addActionListener(e -> {
            new GuiJajarGenjang();
            frame.dispose();
        });
        
        btnSegitiga.addActionListener(e -> {
            new GuiSegitiga();
            frame.dispose();
        });
        
        btnLayangLayang.addActionListener(e -> {
            new GuiLayangLayang();
            frame.dispose();
        });
        
        btnPersegiPanjang.addActionListener(e -> {
            new GuiPersegiPanjang();
            frame.dispose();
        });
        
        btnBelahKetupat.addActionListener(e -> {
            new GuiBelahKetupat();
            frame.dispose();
        });
        
        btnTrapesium.addActionListener(e -> {
            new GuiTrapesium();
            frame.dispose();
        });

        btnLingkaran.addActionListener(e -> {
            new GuiLingkaran();
            frame.dispose();
        });

        btnJuringLingkaran.addActionListener(e -> {
            new GuiJuringLingkaran();
            frame.dispose();
        });
        
        btnPersegi.addActionListener(e -> {
            new GuiPersegi();
            frame.dispose();
        });
        
        btnTemberengLingkaran.addActionListener(e -> {
            new GuiTemberengLingkaran();
            frame.dispose();
        });
        
        btnKembali.addActionListener(e -> {
            new main().showMainView();
            frame.dispose();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}