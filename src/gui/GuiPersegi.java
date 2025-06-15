package gui;

import bendaGeometri.Persegi;
import bendaGeometri.PersegiThread;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiPersegi {

    public GuiPersegi() {
        JFrame frame = new JFrame("Persegi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JLabel lblSisi = new JLabel("Panjang sisi (cm):");
        JTextField tfSisi = new JTextField();
        inputPanel.add(lblSisi);
        inputPanel.add(tfSisi);

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");

        inputPanel.add(btnHitung);
        inputPanel.add(btnKembali);

        JTextArea output = new JTextArea();
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);

        // Tombol Hitung
        btnHitung.addActionListener(e -> {
            try {
                double sisi = Double.parseDouble(tfSisi.getText());
                if (sisi <= 0) throw new NumberFormatException("Sisi harus positif.");
                Persegi p = new Persegi(sisi);
                new PersegiThread(p, output).start();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Input tidak valid: " + ex.getMessage());
            }
        });

        // Tombol Kembali
        btnKembali.addActionListener(e -> {
            new main().showMainView();
            frame.dispose();
        });

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
