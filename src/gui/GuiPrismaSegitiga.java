package gui;

import main.main;
import bendaGeometri.PrismaSegitiga;
import bendaGeometri.Segitiga;

import javax.swing.*;
import java.awt.*;

public class GuiPrismaSegitiga {
    public GuiPrismaSegitiga() {
        JFrame frame = new JFrame("Prisma Segitiga");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 420);

        JPanel panel = new JPanel(new GridLayout(8, 2));
        JRadioButton rbParent = new JRadioButton("Gunakan data dari Segitiga");
        JRadioButton rbManual = new JRadioButton("Input data dari awal");
        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbManual);

        JTextField tfAlas = new JTextField();
        JTextField tfTinggiSegitiga = new JTextField();
        JTextField tfSisiA = new JTextField();
        JTextField tfSisiB = new JTextField();
        JTextField tfSisiC = new JTextField();
        JTextField tfTinggiPrisma = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(rbParent); panel.add(rbManual);
        panel.add(new JLabel("Alas:")); panel.add(tfAlas);
        panel.add(new JLabel("Tinggi Segitiga:")); panel.add(tfTinggiSegitiga);
        panel.add(new JLabel("Sisi A:")); panel.add(tfSisiA);
        panel.add(new JLabel("Sisi B:")); panel.add(tfSisiB);
        panel.add(new JLabel("Sisi C:")); panel.add(tfSisiC);
        panel.add(new JLabel("Tinggi Prisma:")); panel.add(tfTinggiPrisma);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        rbParent.addActionListener(e -> {
            Segitiga segitiga = SharedData.getSegitiga();
            if (segitiga != null) {
                tfAlas.setText(String.valueOf(segitiga.getAlas()));
                tfTinggiSegitiga.setText(String.valueOf(segitiga.getTinggi()));
                tfSisiA.setText(String.valueOf(segitiga.getSisiA()));
                tfSisiB.setText(String.valueOf(segitiga.getSisiB()));
                tfSisiC.setText(String.valueOf(segitiga.getSisiC()));

                tfAlas.setEditable(false);
                tfTinggiSegitiga.setEditable(false);
                tfSisiA.setEditable(false);
                tfSisiB.setEditable(false);
                tfSisiC.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Belum ada data dari Segitiga!");
                group.clearSelection();
            }
        });

        rbManual.addActionListener(e -> {
            tfAlas.setText(""); tfTinggiSegitiga.setText("");
            tfSisiA.setText(""); tfSisiB.setText(""); tfSisiC.setText("");

            tfAlas.setEditable(true);
            tfTinggiSegitiga.setEditable(true);
            tfSisiA.setEditable(true);
            tfSisiB.setEditable(true);
            tfSisiC.setEditable(true);
        });

        btnHitung.addActionListener(e -> {
            try {
                double tinggiPrisma = Double.parseDouble(tfTinggiPrisma.getText());
                PrismaSegitiga prisma;

                if (rbParent.isSelected()) {
                    Segitiga segitiga = SharedData.getSegitiga();
                    if (segitiga == null) throw new IllegalStateException("Belum ada data dari Segitiga");

                    prisma = new PrismaSegitiga(
                        segitiga.getAlas(), segitiga.getTinggi(),
                        segitiga.getSisiA(), segitiga.getSisiB(), segitiga.getSisiC(),
                        tinggiPrisma
                    );
                } else if (rbManual.isSelected()) {
                    double alas = Double.parseDouble(tfAlas.getText());
                    double tinggi = Double.parseDouble(tfTinggiSegitiga.getText());
                    double sisiA = Double.parseDouble(tfSisiA.getText());
                    double sisiB = Double.parseDouble(tfSisiB.getText());
                    double sisiC = Double.parseDouble(tfSisiC.getText());

                    prisma = new PrismaSegitiga(alas, tinggi, sisiA, sisiB, sisiC, tinggiPrisma);
                } else {
                    throw new IllegalStateException("Pilih metode input terlebih dahulu");
                }

                output.setText("Volume: " + prisma.hitungVolume() + "\nLuas Permukaan: " + prisma.hitungLuasPermukaan());

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
