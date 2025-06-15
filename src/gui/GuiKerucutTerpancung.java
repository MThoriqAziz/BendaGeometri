package gui;

import bendaGeometri.KerucutTerpancung;
import bendaGeometri.KerucutTerpacungThread;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiKerucutTerpancung {
    public GuiKerucutTerpancung() {
        JFrame frame = new JFrame("Kerucut Terpancung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel labelJariJariBawah = new JLabel("Jari-jari bawah (R):");
        JTextField tfJariJariBawah = new JTextField();

        JLabel labelJariJariAtas = new JLabel("Jari-jari atas (r):");
        JTextField tfJariJariAtas = new JTextField();

        JLabel labelTinggi = new JLabel("Tinggi:");
        JTextField tfTinggi = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(labelJariJariBawah);
        panel.add(tfJariJariBawah);
        panel.add(labelJariJariAtas);
        panel.add(tfJariJariAtas);
        panel.add(labelTinggi);
        panel.add(tfTinggi);
        panel.add(btnHitung);
        panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        btnHitung.addActionListener(e -> {
            try {
                double rBawah = Double.parseDouble(tfJariJariBawah.getText());
                double rAtas = Double.parseDouble(tfJariJariAtas.getText());
                double tinggi = Double.parseDouble(tfTinggi.getText());

                if (rBawah <= 0 || rAtas <= 0 || tinggi <= 0) {
                    throw new IllegalArgumentException("Semua nilai harus positif");
                }

                KerucutTerpancung kt = new KerucutTerpancung(rBawah, rAtas, tinggi);
                KerucutTerpacungThread thread = new KerucutTerpacungThread(kt, output);
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
