package gui;

import main.main;
import bendaGeometri.LayangLayang;

import javax.swing.*;
import java.awt.*;

public class GuiLayangLayang {
    public GuiLayangLayang() {
        JFrame frame = new JFrame("Layang-Layang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        JTextField tfDiagonal1 = new JTextField();
        JTextField tfDiagonal2 = new JTextField();
        JTextField tfSisiPendek = new JTextField();
        JTextField tfSisiPanjang = new JTextField();
        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(new JLabel("Diagonal 1:")); panel.add(tfDiagonal1);
        panel.add(new JLabel("Diagonal 2:")); panel.add(tfDiagonal2);
        panel.add(new JLabel("Sisi Pendek:")); panel.add(tfSisiPendek);
        panel.add(new JLabel("Sisi Panjang:")); panel.add(tfSisiPanjang);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        // Aksi tombol hitung
        btnHitung.addActionListener(e -> {
            try {
                double d1 = Double.parseDouble(tfDiagonal1.getText());
                double d2 = Double.parseDouble(tfDiagonal2.getText());
                double sisiPendek = Double.parseDouble(tfSisiPendek.getText());
                double sisiPanjang = Double.parseDouble(tfSisiPanjang.getText());

                if (d1 <= 0 || d2 <= 0 || sisiPendek <= 0 || sisiPanjang <= 0) {
                    throw new IllegalArgumentException("Semua nilai harus lebih dari 0");
                }

                LayangLayang ly = new LayangLayang(d1, d2, sisiPendek, sisiPanjang);
                output.setText("Luas: " + ly.hitungLuas() + "\nKeliling: " + ly.hitungKeliling());
                gui.SharedData.setLayanglayang(ly);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Input harus berupa angka: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // Aksi tombol kembali
        btnKembali.addActionListener(e -> {
            new main().showMainView(); // tampilkan main view
            frame.dispose();           // tutup window ini
        });

        frame.setLocationRelativeTo(null); // pusat layar
        frame.setVisible(true);
    }
}
