package gui;

import bendaGeometri.Segitiga;
import bendaGeometri.LimasSegitiga;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiLimasSegitiga {
    public GuiLimasSegitiga() {
        JFrame frame = new JFrame("Limas Segitiga");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 460);

        JPanel panel = new JPanel(new GridLayout(8, 2));

        JRadioButton rbParent = new JRadioButton("Gunakan data dari Segitiga");
        JRadioButton rbManual = new JRadioButton("Input data manual");
        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbManual);

        JTextField tfAlas = new JTextField();
        JTextField tfTinggiSegitiga = new JTextField();
        JTextField tfSisiA = new JTextField();
        JTextField tfSisiB = new JTextField();
        JTextField tfSisiC = new JTextField();
        JTextField tfTinggiLimas = new JTextField();

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
        panel.add(new JLabel("Tinggi Limas:")); panel.add(tfTinggiLimas);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        // Aksi: pilih data dari parent
        rbParent.addActionListener(e -> {
            Segitiga s = SharedData.getSegitiga();
            if (s != null) {
                tfAlas.setText(String.valueOf(s.getAlas()));
                tfTinggiSegitiga.setText(String.valueOf(s.getTinggi()));
                tfSisiA.setText(String.valueOf(s.getSisiA()));
                tfSisiB.setText(String.valueOf(s.getSisiB()));
                tfSisiC.setText(String.valueOf(s.getSisiC()));

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

        // Aksi: input manual
        rbManual.addActionListener(e -> {
            tfAlas.setText("");
            tfTinggiSegitiga.setText("");
            tfSisiA.setText("");
            tfSisiB.setText("");
            tfSisiC.setText("");

            tfAlas.setEditable(true);
            tfTinggiSegitiga.setEditable(true);
            tfSisiA.setEditable(true);
            tfSisiB.setEditable(true);
            tfSisiC.setEditable(true);
        });

        // Aksi: tombol hitung
        btnHitung.addActionListener(e -> {
            try {
                double tinggiLimas = Double.parseDouble(tfTinggiLimas.getText());
                LimasSegitiga limas;

                if (rbParent.isSelected()) {
                    Segitiga s = SharedData.getSegitiga();
                    if (s == null) throw new IllegalStateException("Belum ada data dari Segitiga!");

                    limas = new LimasSegitiga(
                        s.getAlas(), s.getTinggi(),
                        s.getSisiA(), s.getSisiB(), s.getSisiC(),
                        tinggiLimas
                    );

                } else if (rbManual.isSelected()) {
                    double alas = Double.parseDouble(tfAlas.getText());
                    double tinggiSegitiga = Double.parseDouble(tfTinggiSegitiga.getText());
                    double sisiA = Double.parseDouble(tfSisiA.getText());
                    double sisiB = Double.parseDouble(tfSisiB.getText());
                    double sisiC = Double.parseDouble(tfSisiC.getText());

                    limas = new LimasSegitiga(alas, tinggiSegitiga, sisiA, sisiB, sisiC, tinggiLimas);
                } else {
                    throw new IllegalStateException("Pilih metode input terlebih dahulu");
                }

                output.setText("== Limas Segitiga ==\n");
                output.append("Volume: " + limas.hitungVolume() + "\n");
                output.append("Luas Permukaan: " + limas.hitungLuasPermukaan() + "\n");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // Aksi: kembali ke main view
        btnKembali.addActionListener(e -> {
            new main().showMainView();
            frame.dispose();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
