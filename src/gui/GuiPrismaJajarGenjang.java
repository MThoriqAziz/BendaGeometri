
package gui;

import main.main;

import javax.swing.*;
import java.awt.*;
import bendaGeometri.JajarGenjang;
import bendaGeometri.PrismaJajarGenjang;

public class GuiPrismaJajarGenjang {
    public GuiPrismaJajarGenjang() {
        JFrame frame = new JFrame("Prisma Jajar Genjang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(7, 2));
        JRadioButton rbParent = new JRadioButton("Gunakan data dari Jajar Genjang");
        JRadioButton rbManual = new JRadioButton("Input data dari awal");
        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbManual);

        JTextField tfAlas = new JTextField();
        JTextField tfTinggiAlas = new JTextField();
        JTextField tfSisiMiring = new JTextField();
        JTextField tfTinggiPrisma = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(rbParent); panel.add(rbManual);
        panel.add(new JLabel("Alas:")); panel.add(tfAlas);
        panel.add(new JLabel("Tinggi Alas:")); panel.add(tfTinggiAlas);
        panel.add(new JLabel("Sisi Miring:")); panel.add(tfSisiMiring);
        panel.add(new JLabel("Tinggi Prisma:")); panel.add(tfTinggiPrisma);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        rbParent.addActionListener(e -> {
            JajarGenjang jg = SharedData.getJajarGenjang();
            if (jg != null) {
                tfAlas.setText(String.valueOf(jg.alas));
                tfTinggiAlas.setText(String.valueOf(jg.tinggi));
                tfSisiMiring.setText(String.valueOf(jg.sisiMiring));

                tfAlas.setEditable(false);
                tfTinggiAlas.setEditable(false);
                tfSisiMiring.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Belum ada data dari Jajar Genjang!");
                group.clearSelection();
            }
        });

        rbManual.addActionListener(e -> {
            tfAlas.setText("");
            tfTinggiAlas.setText("");
            tfSisiMiring.setText("");

            tfAlas.setEditable(true);
            tfTinggiAlas.setEditable(true);
            tfSisiMiring.setEditable(true);
        });

        btnHitung.addActionListener(e -> {
            try {
                double tinggiPrisma = Double.parseDouble(tfTinggiPrisma.getText());

                PrismaJajarGenjang prisma;
                if (rbParent.isSelected()) {
                    JajarGenjang jg = SharedData.getJajarGenjang();
                    if (jg == null) throw new IllegalStateException("Belum ada data dari Jajar Genjang");

                    prisma = new PrismaJajarGenjang(jg.alas, jg.tinggi, jg.sisiMiring, tinggiPrisma);

                } else if (rbManual.isSelected()) {
                    double alas = Double.parseDouble(tfAlas.getText());
                    double tinggiAlas = Double.parseDouble(tfTinggiAlas.getText());
                    double sisi = Double.parseDouble(tfSisiMiring.getText());

                    prisma = new PrismaJajarGenjang(alas, tinggiAlas, sisi, tinggiPrisma);
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
