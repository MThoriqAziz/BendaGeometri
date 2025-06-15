package gui;

import main.main;
import bendaGeometri.BelahKetupat;
import bendaGeometri.BelahKetupatThread;

import javax.swing.*;
import java.awt.*;

public class GuiBelahKetupat {
    public GuiBelahKetupat() {
        JFrame frame = new JFrame("Belah Ketupat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JTextField tfDiagonal1 = new JTextField();
        JTextField tfDiagonal2 = new JTextField();
        JTextField tfSisi = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(new JLabel("Diagonal 1:")); panel.add(tfDiagonal1);
        panel.add(new JLabel("Diagonal 2:")); panel.add(tfDiagonal2);
        panel.add(new JLabel("Sisi:")); panel.add(tfSisi);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        btnHitung.addActionListener(e -> {
            try {
                double d1 = Double.parseDouble(tfDiagonal1.getText());
                double d2 = Double.parseDouble(tfDiagonal2.getText());
                double sisi = Double.parseDouble(tfSisi.getText());

                if (d1 <= 0 || d2 <= 0 || sisi <= 0) {
                    throw new IllegalArgumentException("Semua nilai harus lebih dari 0");
                }

                BelahKetupat bk = new BelahKetupat(d1, d2, sisi);
                BelahKetupatThread thread = new BelahKetupatThread(bk, output);
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
