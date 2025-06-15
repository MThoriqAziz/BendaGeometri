package gui;

import bendaGeometri.Kerucut;
import bendaGeometri.KerucutThread;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiKerucut {
    public GuiKerucut() {
        JFrame frame = new JFrame("Kerucut");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel labelJariJari = new JLabel("Jari-jari:");
        JTextField tfJariJari = new JTextField();

        JLabel labelTinggi = new JLabel("Tinggi Kerucut:");
        JTextField tfTinggi = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(labelJariJari);
        panel.add(tfJariJari);
        panel.add(labelTinggi);
        panel.add(tfTinggi);
        panel.add(btnHitung);
        panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        btnHitung.addActionListener(e -> {
            try {
                double jariJari = Double.parseDouble(tfJariJari.getText());
                double tinggi = Double.parseDouble(tfTinggi.getText());

                if (jariJari <= 0 || tinggi <= 0) {
                    throw new IllegalArgumentException("Jari-jari dan tinggi harus bernilai positif");
                }

                Kerucut kerucut = new Kerucut(jariJari, tinggi);
                KerucutThread thread = new KerucutThread(kerucut, output);
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
