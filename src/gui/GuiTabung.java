package gui;

import main.main;
import bendaGeometri.Tabung;
import bendaGeometri.Lingkaran;

import javax.swing.*;
import java.awt.*;

public class GuiTabung {
    public GuiTabung() {
        JFrame frame = new JFrame("Tabung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        JRadioButton rbParent = new JRadioButton("Gunakan data dari Lingkaran");
        JRadioButton rbManual = new JRadioButton("Input data dari awal");
        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbManual);

        JTextField tfJariJari = new JTextField();
        JTextField tfTinggiTabung = new JTextField();
        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(rbParent); panel.add(rbManual);
        panel.add(new JLabel("Jari-jari:")); panel.add(tfJariJari);
        panel.add(new JLabel("Tinggi Tabung:")); panel.add(tfTinggiTabung);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        rbParent.addActionListener(e -> {
            Lingkaran lingkaran = SharedData.getLingkaran();
            if (lingkaran != null) {
                tfJariJari.setText(String.valueOf(lingkaran.getJariJari()));
                tfJariJari.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Belum ada data dari Lingkaran!");
                group.clearSelection();
            }
        });

        rbManual.addActionListener(e -> {
            tfJariJari.setText("");
            tfJariJari.setEditable(true);
        });

        btnHitung.addActionListener(e -> {
            try {
                double jariJari;
                double tinggiTabung = Double.parseDouble(tfTinggiTabung.getText());

                if (rbParent.isSelected()) {
                    Lingkaran lingkaran = SharedData.getLingkaran();
                    if (lingkaran == null) throw new IllegalStateException("Belum ada data dari Lingkaran");
                    jariJari = lingkaran.getJariJari();
                } else if (rbManual.isSelected()) {
                    jariJari = Double.parseDouble(tfJariJari.getText());
                } else {
                    throw new IllegalStateException("Pilih metode input terlebih dahulu");
                }

                Tabung tabung = new Tabung(jariJari, tinggiTabung);
                output.setText("Volume: " + tabung.hitungVolume() + "\nLuas Permukaan: " + tabung.hitungLuasPermukaan());

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
