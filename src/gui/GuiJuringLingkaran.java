package gui;

import bendaGeometri.JuringLingkaran;
import bendaGeometri.JuringLingkaranThread;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiJuringLingkaran {
    public GuiJuringLingkaran() {
        JFrame frame = new JFrame("Juring Lingkaran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel labelJariJari = new JLabel("Jari-jari:");
        JTextField tfJariJari = new JTextField();

        JLabel labelSudut = new JLabel("Sudut (°):");
        JTextField tfSudut = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(labelJariJari);
        panel.add(tfJariJari);
        panel.add(labelSudut);
        panel.add(tfSudut);
        panel.add(btnHitung);
        panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        btnHitung.addActionListener(e -> {
            try {
                double jariJari = Double.parseDouble(tfJariJari.getText());
                double sudut = Double.parseDouble(tfSudut.getText());

                if (jariJari <= 0 || sudut <= 0 || sudut > 360) {
                    throw new IllegalArgumentException("Jari-jari dan sudut harus positif, sudut maksimal 360°");
                }

                JuringLingkaran juring = new JuringLingkaran(jariJari, sudut);
                JuringLingkaranThread thread = new JuringLingkaranThread(juring, output);
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
