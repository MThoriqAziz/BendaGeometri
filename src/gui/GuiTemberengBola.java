package gui;

import bendaGeometri.TemberengBola;
import bendaGeometri.TemberengBolaThread;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiTemberengBola {
    public GuiTemberengBola() {
        JFrame frame = new JFrame("Tembereng Bola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel labelJariJari = new JLabel("Jari-jari:");
        JTextField tfJariJari = new JTextField();

        JLabel labelTheta = new JLabel("Sudut (θ) dalam derajat:");
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

        btnHitung.addActionListener(e -> {
            try {
                double jariJari = Double.parseDouble(tfJariJari.getText());
                double theta = Double.parseDouble(tfTheta.getText());

                if (jariJari <= 0 || theta <= 0 || theta > 360) {
                    throw new IllegalArgumentException("Jari-jari dan sudut harus > 0, dan sudut maksimal 360°");
                }

                TemberengBola tb = new TemberengBola(jariJari, theta);
                TemberengBolaThread thread = new TemberengBolaThread(tb, output);
                thread.start();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Input tidak valid: " + ex.getMessage());
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
