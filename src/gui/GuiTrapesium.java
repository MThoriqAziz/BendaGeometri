package gui;

import main.main;
import bendaGeometri.Trapesium;
import bendaGeometri.TrapesiumThread;

import javax.swing.*;
import java.awt.*;

public class GuiTrapesium {
    public GuiTrapesium() {
        JFrame frame = new JFrame("Trapesium");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JLabel lblSisi1 = new JLabel("Sisi Sejajar 1:");
        JTextField tfSisi1 = new JTextField();

        JLabel lblSisi2 = new JLabel("Sisi Sejajar 2:");
        JTextField tfSisi2 = new JTextField();

        JLabel lblTinggi = new JLabel("Tinggi:");
        JTextField tfTinggi = new JTextField();

        JLabel lblSisiMiring = new JLabel("Sisi Miring:");
        JTextField tfSisiMiring = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(lblSisi1); panel.add(tfSisi1);
        panel.add(lblSisi2); panel.add(tfSisi2);
        panel.add(lblTinggi); panel.add(tfTinggi);
        panel.add(lblSisiMiring); panel.add(tfSisiMiring);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        btnHitung.addActionListener(e -> {
            try {
                double sisi1 = Double.parseDouble(tfSisi1.getText());
                double sisi2 = Double.parseDouble(tfSisi2.getText());
                int tinggi = Integer.parseInt(tfTinggi.getText());
                double sisiMiring = Double.parseDouble(tfSisiMiring.getText());

                if (sisi1 <= 0 || sisi2 <= 0 || tinggi <= 0 || sisiMiring <= 0) {
                    throw new IllegalArgumentException("Semua nilai harus lebih dari 0");
                }

                Trapesium trapesium = new Trapesium(sisi1, sisi2, tinggi, sisiMiring);
                TrapesiumThread thread = new TrapesiumThread(trapesium, output);
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
