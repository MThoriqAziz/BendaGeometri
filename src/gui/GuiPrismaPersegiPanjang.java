package gui;

import main.main;
import bendaGeometri.PersegiPanjang;
import bendaGeometri.PrismaPersegiPanjang;

import javax.swing.*;
import java.awt.*;

public class GuiPrismaPersegiPanjang {
    public GuiPrismaPersegiPanjang() {
        JFrame frame = new JFrame("Prisma Persegi Panjang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JRadioButton rbParent = new JRadioButton("Gunakan data dari Persegi Panjang");
        JRadioButton rbManual = new JRadioButton("Input data manual");
        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbManual);

        JTextField tfPanjang = new JTextField();
        JTextField tfLebar = new JTextField();
        JTextField tfTinggiPrisma = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(rbParent); panel.add(rbManual);
        panel.add(new JLabel("Panjang:")); panel.add(tfPanjang);
        panel.add(new JLabel("Lebar:")); panel.add(tfLebar);
        panel.add(new JLabel("Tinggi Prisma:")); panel.add(tfTinggiPrisma);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        // Aksi tombol radio "gunakan parent"
        rbParent.addActionListener(e -> {
            PersegiPanjang pp = SharedData.getPersegiPanjang();
            if (pp != null) {
                tfPanjang.setText(String.valueOf(pp.getPanjang()));
                tfLebar.setText(String.valueOf(pp.getLebar()));

                tfPanjang.setEditable(false);
                tfLebar.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Belum ada data dari Persegi Panjang!");
                group.clearSelection();
            }
        });

        // Aksi tombol radio "manual"
        rbManual.addActionListener(e -> {
            tfPanjang.setText("");
            tfLebar.setText("");

            tfPanjang.setEditable(true);
            tfLebar.setEditable(true);
        });

        // Tombol Hitung
        btnHitung.addActionListener(e -> {
            try {
                double tinggi = Double.parseDouble(tfTinggiPrisma.getText());

                PrismaPersegiPanjang prisma;
                if (rbParent.isSelected()) {
                    PersegiPanjang pp = SharedData.getPersegiPanjang();
                    if (pp == null) throw new IllegalStateException("Belum ada data dari Persegi Panjang");
                    prisma = new PrismaPersegiPanjang(pp.getPanjang(), pp.getLebar(), tinggi);
                } else if (rbManual.isSelected()) {
                    double panjang = Double.parseDouble(tfPanjang.getText());
                    double lebar = Double.parseDouble(tfLebar.getText());
                    prisma = new PrismaPersegiPanjang(panjang, lebar, tinggi);
                } else {
                    throw new IllegalStateException("Pilih metode input terlebih dahulu");
                }

                output.setText("Volume: " + prisma.hitungVolume() +
                        "\nLuas Permukaan: " + prisma.hitungLuasPermukaan());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Input tidak valid: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // Tombol Kembali
        btnKembali.addActionListener(e -> {
            new main().showMainView();
            frame.dispose();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
