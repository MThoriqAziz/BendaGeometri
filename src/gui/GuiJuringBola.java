package gui;

import bendaGeometri.JuringBola;
import bendaGeometri.JuringBolaThread;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiJuringBola {
    public GuiJuringBola() {
        JFrame frame = new JFrame("Juring Bola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel labelJariJari = new JLabel("Jari-jari:");
        JTextField tfJariJari = new JTextField();

        JLabel labelTheta = new JLabel("Sudut θ (radian):");
        JTextField tfTheta = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(labelJariJari);
        panel.add(tfJariJari);
        panel.add(labelTheta);
        panel.add(tfTheta);
        panel.add(btnHitung);
        panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        // Tombol Hitung
        btnHitung.addActionListener(e -> {
            try {
                double jariJari = Double.parseDouble(tfJariJari.getText());
                double theta = Double.parseDouble(tfTheta.getText());

                if (jariJari <= 0 || theta <= 0) {
                    throw new IllegalArgumentException("Jari-jari dan theta harus positif");
                }

                JuringBola jb = new JuringBola(jariJari, theta);
                JuringBolaThread thread = new JuringBolaThread(jb, output);
                thread.start();

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
