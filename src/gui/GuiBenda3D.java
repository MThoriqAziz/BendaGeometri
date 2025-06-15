package gui;

import javax.swing.*;
import java.awt.*;
import main.main;

public class GuiBenda3D {

    public GuiBenda3D() {
        JFrame frame = new JFrame("Pilih Benda 3D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(23, 1)); // Karena ada 23 tombol + kembali

        JButton btnBola = new JButton("Bola");
        JButton btnPrismaJajarGenjang = new JButton("Prisma Jajar Genjang");
        JButton btnLimasJajarGenjang = new JButton("Limas Jajar Genjang");
        JButton btnPrismaLayangLayang = new JButton("Prisma Layang Layang");
        JButton btnLimasLayangLayang = new JButton("Limas Layang Layang");
        JButton btnPrismaPersegiPanjang = new JButton("Prisma Persegi Panjang");
        JButton btnLimasPersegiPanjang = new JButton("Limas Persegi Panjang");
        JButton btnPrismaSegitiga = new JButton("Prisma Segitiga");
        JButton btnLimasSegitiga = new JButton("Limas Segitiga");
        JButton btnCincinBola = new JButton("Cincin Bola");
        JButton btnJuringBola = new JButton("Juring Bola");
        JButton btnKerucut = new JButton("Kerucut");
        JButton btnKerucutTerpancung = new JButton("Kerucut Terpancung");
        JButton btnLimasBelahKetupat = new JButton("Limas Belah Ketupat");
        JButton btnPrismaBelahKetupat = new JButton("Prisma Belah Ketupat");
        JButton btnPrismaPersegi = new JButton("Prisma Persegi");
        JButton btnLimasPersegi = new JButton("Limas Persegi");
        JButton btnPrismaTrapesium = new JButton("Prisma Trapesium");
        JButton btnLimasTrapesium = new JButton("Limas Trapesium");
        JButton btnTabung = new JButton("Tabung");
        JButton btnTemberengBola = new JButton("Tembereng Bola");
        JButton btnKembali = new JButton("Kembali ke Main View");

        // Menambahkan semua tombol ke frame
        frame.add(btnBola);
        frame.add(btnPrismaJajarGenjang);
        frame.add(btnLimasJajarGenjang);
        frame.add(btnPrismaLayangLayang);
        frame.add(btnLimasLayangLayang);
        frame.add(btnPrismaPersegiPanjang);
        frame.add(btnLimasPersegiPanjang);
        frame.add(btnPrismaSegitiga);
        frame.add(btnLimasSegitiga);
        frame.add(btnCincinBola);
        frame.add(btnJuringBola);
        frame.add(btnKerucut);
        frame.add(btnKerucutTerpancung);
        frame.add(btnLimasBelahKetupat);
        frame.add(btnPrismaBelahKetupat);
        frame.add(btnPrismaPersegi);
        frame.add(btnLimasPersegi);
        frame.add(btnPrismaTrapesium);
        frame.add(btnLimasTrapesium);
        frame.add(btnTabung);
        frame.add(btnTemberengBola);
        frame.add(btnKembali);

        // Action Listener untuk masing-masing tombol
        btnBola.addActionListener(e -> {
            new GuiBola();
            frame.dispose();
        });

        btnPrismaJajarGenjang.addActionListener(e -> {
            new GuiPrismaJajarGenjang();
            frame.dispose();
        });

        btnLimasJajarGenjang.addActionListener(e -> {
            new GuiLimasJajarGenjang();
            frame.dispose();
        });

        btnPrismaLayangLayang.addActionListener(e -> {
            new GuiPrismaLayangLayang();
            frame.dispose();
        });

        btnLimasLayangLayang.addActionListener(e -> {
            new GuiLimasLayangLayang();
            frame.dispose();
        });

        btnPrismaPersegiPanjang.addActionListener(e -> {
            new GuiPrismaPersegiPanjang();
            frame.dispose();
        });

        btnLimasPersegiPanjang.addActionListener(e -> {
            new GuiLimasPersegiPanjang();
            frame.dispose();
        });

        btnPrismaSegitiga.addActionListener(e -> {
            new GuiPrismaSegitiga();
            frame.dispose();
        });

        btnLimasSegitiga.addActionListener(e -> {
            new GuiLimasSegitiga();
            frame.dispose();
        });

        btnCincinBola.addActionListener(e -> {
            new GuiCincinBola();
            frame.dispose();
        });

        btnJuringBola.addActionListener(e -> {
            new GuiJuringBola();
            frame.dispose();
        });

        btnKerucut.addActionListener(e -> {
            new GuiKerucut();
            frame.dispose();
        });

        btnKerucutTerpancung.addActionListener(e -> {
            new GuiKerucutTerpancung();
            frame.dispose();
        });

        btnLimasBelahKetupat.addActionListener(e -> {
            new GuiLimasBelahKetupat();
            frame.dispose();
        });

        btnPrismaBelahKetupat.addActionListener(e -> {
            new GuiPrismaBelahKetupat();
            frame.dispose();
        });

        btnPrismaPersegi.addActionListener(e -> {
            new GuiPrismaPersegi();
            frame.dispose();
        });

        btnLimasPersegi.addActionListener(e -> {
            new GuiLimasPersegi();
            frame.dispose();
        });

        btnPrismaTrapesium.addActionListener(e -> {
            new GuiPrismaTrapesium();
            frame.dispose();
        });

        btnLimasTrapesium.addActionListener(e -> {
            new GuiLimasTrapesium();
            frame.dispose();
        });

        btnTabung.addActionListener(e -> {
            new GuiTabung();
            frame.dispose();
        });

        btnTemberengBola.addActionListener(e -> {
            new GuiTemberengBola();
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