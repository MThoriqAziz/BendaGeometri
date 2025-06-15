package gui;

import bendaGeometri.TemberengLingkaran;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiTemberengLingkaran {
    public GuiTemberengLingkaran() {
        JFrame frame = new JFrame("Tembereng Lingkaran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel labelJariJari = new JLabel("Jari-jari:");
        JTextField tfJariJari = new JTextField();

        JLabel labelSudut = new JLabel("Sudut (°):");
        JTextField tfSudut = new JTextField();

        JLabel labelTaliBusur = new JLabel("Tali busur:");
        JTextField tfTaliBusur = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(labelJariJari);
        panel.add(tfJariJari);
        panel.add(labelSudut);
        panel.add(tfSudut);
        panel.add(labelTaliBusur);
        panel.add(tfTaliBusur);
        panel.add(btnHitung);
        panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        // Tombol Hitung
        btnHitung.addActionListener(e -> {
            try {
                double jariJari = Double.parseDouble(tfJariJari.getText());
                double sudut = Double.parseDouble(tfSudut.getText());
                double taliBusur = Double.parseDouble(tfTaliBusur.getText());

                if (jariJari <= 0 || sudut <= 0 || sudut > 360 || taliBusur <= 0) {
                    throw new IllegalArgumentException("Input harus positif dan sudut maksimal 360°");
                }

                TemberengLingkaran tbg = new TemberengLingkaran(taliBusur, 0, jariJari, sudut); // busur dihitung otomatis

                output.setText("== Tembereng Lingkaran ==\n");
                output.append("Luas: " + tbg.hitungLuas() + "\n");
                output.append("Keliling: " + tbg.hitungKeliling() + "\n");

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
