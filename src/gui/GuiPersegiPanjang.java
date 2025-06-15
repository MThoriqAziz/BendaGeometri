package gui;

import main.main;
import bendaGeometri.PersegiPanjang;

import javax.swing.*;
import java.awt.*;

public class GuiPersegiPanjang {
    public GuiPersegiPanjang() {
        JFrame frame = new JFrame("Persegi Panjang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JTextField tfPanjang = new JTextField();
        JTextField tfLebar = new JTextField();
        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(new JLabel("Panjang:")); panel.add(tfPanjang);
        panel.add(new JLabel("Lebar:")); panel.add(tfLebar);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        // Tombol Hitung
        btnHitung.addActionListener(e -> {
            try {
                double panjang = Double.parseDouble(tfPanjang.getText());
                double lebar = Double.parseDouble(tfLebar.getText());

                if (panjang <= 0 || lebar <= 0) {
                    throw new IllegalArgumentException("Nilai harus lebih dari 0");
                }

                PersegiPanjang pp = new PersegiPanjang(panjang, lebar);
                output.setText("Luas: " + pp.hitungLuas() + "\nKeliling: " + pp.hitungKeliling());

                SharedData.setPersegiPanjang(pp); // Simpan ke SharedData jika dibutuhkan komponen lain

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Input harus berupa angka: " + ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // Tombol Kembali
        btnKembali.addActionListener(e -> {
            new main().showMainView();
            frame.dispose();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
