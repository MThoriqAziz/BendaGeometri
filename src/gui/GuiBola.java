package gui;

import bendaGeometri.Bola;
import bendaGeometri.BolaThread;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiBola {
    public GuiBola() {
        JFrame frame = new JFrame("Bola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(2, 2));

        JLabel labelJariJari = new JLabel("Jari-jari:");
        JTextField tfJariJari = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(labelJariJari);
        panel.add(tfJariJari);
        panel.add(btnHitung);
        panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        btnHitung.addActionListener(e -> {
            try {
                double jariJari = Double.parseDouble(tfJariJari.getText());

                if (jariJari <= 0) {
                    throw new IllegalArgumentException("Jari-jari harus positif");
                }

                Bola bola = new Bola(jariJari);
                BolaThread thread = new BolaThread(bola, output);
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
