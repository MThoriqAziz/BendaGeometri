package gui;

import main.main;
import bendaGeometri.Segitiga;
import bendaGeometri.SegitigaThread;

import javax.swing.*;
import java.awt.*;

public class GuiSegitiga {
    public GuiSegitiga() {
        JFrame frame = new JFrame("Segitiga");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        JTextField tfAlas = new JTextField();
        JTextField tfTinggi = new JTextField();
        JTextField tfSisiA = new JTextField();
        JTextField tfSisiB = new JTextField();
        JTextField tfSisiC = new JTextField();
        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(new JLabel("Alas:")); panel.add(tfAlas);
        panel.add(new JLabel("Tinggi:")); panel.add(tfTinggi);
        panel.add(new JLabel("Sisi A:")); panel.add(tfSisiA);
        panel.add(new JLabel("Sisi B:")); panel.add(tfSisiB);
        panel.add(new JLabel("Sisi C:")); panel.add(tfSisiC);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        btnHitung.addActionListener(e -> {
            try {
                double alas = Double.parseDouble(tfAlas.getText());
                double tinggi = Double.parseDouble(tfTinggi.getText());
                double sisiA = Double.parseDouble(tfSisiA.getText());
                double sisiB = Double.parseDouble(tfSisiB.getText());
                double sisiC = Double.parseDouble(tfSisiC.getText());

                if (alas <= 0 || tinggi <= 0 || sisiA <= 0 || sisiB <= 0 || sisiC <= 0) {
                    throw new IllegalArgumentException("Semua nilai harus lebih dari 0");
                }

                Segitiga segitiga = new Segitiga(alas, tinggi, sisiA, sisiB, sisiC);

                output.setText(""); // Kosongkan area output sebelum dijalankan
                Thread t = new SegitigaThread(segitiga, output);
                t.start();

                gui.SharedData.setSegitiga(segitiga); // jika ada kebutuhan menyimpan datanya

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Input tidak valid: " + ex.getMessage());
            }
        });

        btnKembali.addActionListener(e -> {
            new main().showMainView();
            frame.setVisible(true);
            frame.dispose();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
