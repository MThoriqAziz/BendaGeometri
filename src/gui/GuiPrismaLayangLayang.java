package gui;

import main.main;
import bendaGeometri.LayangLayang;
import bendaGeometri.PrismaLayangLayang;

import javax.swing.*;
import java.awt.*;

public class GuiPrismaLayangLayang {
    public GuiPrismaLayangLayang() {
        JFrame frame = new JFrame("Prisma Layang-Layang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 420);

        JPanel panel = new JPanel(new GridLayout(8, 2));

        JRadioButton rbParent = new JRadioButton("Gunakan data dari Layang-Layang");
        JRadioButton rbManual = new JRadioButton("Input data manual");
        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbManual);

        JTextField tfD1 = new JTextField();
        JTextField tfD2 = new JTextField();
        JTextField tfSisiPendek = new JTextField();
        JTextField tfSisiPanjang = new JTextField();
        JTextField tfTinggiPrisma = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(rbParent); panel.add(rbManual);
        panel.add(new JLabel("Diagonal 1:")); panel.add(tfD1);
        panel.add(new JLabel("Diagonal 2:")); panel.add(tfD2);
        panel.add(new JLabel("Sisi Pendek:")); panel.add(tfSisiPendek);
        panel.add(new JLabel("Sisi Panjang:")); panel.add(tfSisiPanjang);
        panel.add(new JLabel("Tinggi Prisma:")); panel.add(tfTinggiPrisma);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        rbParent.addActionListener(e -> {
            LayangLayang ly = SharedData.getLayanglayang();
            if (ly != null) {
                tfD1.setText(String.valueOf(ly.getDiagonal1()));
                tfD2.setText(String.valueOf(ly.getDiagonal2()));
                tfSisiPendek.setText(String.valueOf(ly.getSisiPendek()));
                tfSisiPanjang.setText(String.valueOf(ly.getSisiPanjang()));

                tfD1.setEditable(false);
                tfD2.setEditable(false);
                tfSisiPendek.setEditable(false);
                tfSisiPanjang.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Belum ada data dari Layang-Layang!");
                group.clearSelection();
            }
        });

        rbManual.addActionListener(e -> {
            tfD1.setText("");
            tfD2.setText("");
            tfSisiPendek.setText("");
            tfSisiPanjang.setText("");

            tfD1.setEditable(true);
            tfD2.setEditable(true);
            tfSisiPendek.setEditable(true);
            tfSisiPanjang.setEditable(true);
        });

        btnHitung.addActionListener(e -> {
            try {
                double tinggiPrisma = Double.parseDouble(tfTinggiPrisma.getText());

                PrismaLayangLayang prisma;
                if (rbParent.isSelected()) {
                    LayangLayang ll = SharedData.getLayanglayang();
                    if (ll == null) throw new IllegalStateException("Belum ada data dari Layang-Layang");

                    prisma = new PrismaLayangLayang(
                        ll.getDiagonal1(), ll.getDiagonal2(),
                        ll.getSisiPendek(), ll.getSisiPanjang(),
                        tinggiPrisma
                    );

                } else if (rbManual.isSelected()) {
                    double d1 = Double.parseDouble(tfD1.getText());
                    double d2 = Double.parseDouble(tfD2.getText());
                    double sisiPendek = Double.parseDouble(tfSisiPendek.getText());
                    double sisiPanjang = Double.parseDouble(tfSisiPanjang.getText());

                    if (d1 <= 0 || d2 <= 0 || sisiPendek <= 0 || sisiPanjang <= 0 || tinggiPrisma <= 0) {
                        throw new IllegalArgumentException("Semua nilai harus lebih dari 0");
                    }

                    prisma = new PrismaLayangLayang(d1, d2, sisiPendek, sisiPanjang, tinggiPrisma);

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

        btnKembali.addActionListener(e -> {
            new main().showMainView();
            frame.dispose();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
