package gui;

import bendaGeometri.LimasPersegi;
import bendaGeometri.LimasPersegiThread;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiLimasPersegi {
    public GuiLimasPersegi() {
        JFrame frame = new JFrame("Limas Persegi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel labelSisi = new JLabel("Sisi Persegi:");
        JTextField tfSisi = new JTextField();

        JLabel labelTinggiLimas = new JLabel("Tinggi Limas:");
        JTextField tfTinggiLimas = new JTextField();

        JLabel labelTinggiSisiTegak = new JLabel("Tinggi Sisi Tegak:");
        JTextField tfTinggiSisiTegak = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(labelSisi);
        panel.add(tfSisi);
        panel.add(labelTinggiLimas);
        panel.add(tfTinggiLimas);
        panel.add(labelTinggiSisiTegak);
        panel.add(tfTinggiSisiTegak);
        panel.add(btnHitung);
        panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        btnHitung.addActionListener(e -> {
            try {
                double sisi = Double.parseDouble(tfSisi.getText());
                double tinggiLimas = Double.parseDouble(tfTinggiLimas.getText());
                double tinggiSisiTegak = Double.parseDouble(tfTinggiSisiTegak.getText());

                if (sisi <= 0 || tinggiLimas <= 0 || tinggiSisiTegak <= 0) {
                    throw new IllegalArgumentException("Semua nilai harus lebih dari 0");
                }

                LimasPersegi limas = new LimasPersegi(sisi, tinggiLimas, tinggiSisiTegak);
                LimasPersegiThread thread = new LimasPersegiThread(limas, output);
                thread.start();

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
