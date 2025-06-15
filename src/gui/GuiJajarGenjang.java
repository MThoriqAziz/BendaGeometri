package gui;

import main.main;
import bendaGeometri.JajarGenjang;

import javax.swing.*;
import java.awt.*;


public class GuiJajarGenjang {
    public GuiJajarGenjang() {
        JFrame frame = new JFrame("Jajar Genjang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        JTextField tfAlas = new JTextField();
        JTextField tfTinggi = new JTextField();
        JTextField tfSisiMiring = new JTextField();
        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(new JLabel("Alas:")); panel.add(tfAlas);
        panel.add(new JLabel("Tinggi:")); panel.add(tfTinggi);
        panel.add(new JLabel("Sisi Miring:")); panel.add(tfSisiMiring);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        btnHitung.addActionListener(e -> {
            try {
                double alas = Double.parseDouble(tfAlas.getText());
                double tinggi = Double.parseDouble(tfTinggi.getText());
                double sisi = Double.parseDouble(tfSisiMiring.getText());

                if (alas <= 0 || tinggi <= 0 || sisi <= 0) {
                    throw new IllegalArgumentException("Nilai harus lebih dari 0");
                }

                JajarGenjang jg = new JajarGenjang(alas, tinggi, sisi);
                output.setText("Luas: " + jg.hitungLuas() + "\nKeliling: " + jg.hitungKeliling());
                gui.SharedData.setJajarGenjang(jg);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Input tidak valid: " + ex.getMessage());
            }
        });

        btnKembali.addActionListener(e -> {
            new main().showMainView();
            frame.setVisible(true);
            frame.dispose();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
