package gui;

import bendaGeometri.PrismaPersegi;
import bendaGeometri.PrismaPersegiThread;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiPrismaPersegi {
    public GuiPrismaPersegi() {
        JFrame frame = new JFrame("Prisma Persegi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel labelSisi = new JLabel("Sisi Persegi:");
        JTextField tfSisi = new JTextField();

        JLabel labelTinggi = new JLabel("Tinggi Prisma:");
        JTextField tfTinggi = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(labelSisi);
        panel.add(tfSisi);
        panel.add(labelTinggi);
        panel.add(tfTinggi);
        panel.add(btnHitung);
        panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        btnHitung.addActionListener(e -> {
            try {
                double sisi = Double.parseDouble(tfSisi.getText());
                double tinggi = Double.parseDouble(tfTinggi.getText());

                if (sisi <= 0 || tinggi <= 0) {
                    throw new IllegalArgumentException("Nilai harus lebih dari 0");
                }

                PrismaPersegi prisma = new PrismaPersegi(sisi, tinggi);
                PrismaPersegiThread thread = new PrismaPersegiThread(prisma, output);
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
