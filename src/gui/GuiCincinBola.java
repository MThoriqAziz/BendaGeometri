package gui;

import bendaGeometri.CincinBola;
import bendaGeometri.CincinBolaThread;
import main.main;

import javax.swing.*;
import java.awt.*;

public class GuiCincinBola {
    public GuiCincinBola() {
        JFrame frame = new JFrame("Cincin Bola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel labelJariJari = new JLabel("Jari-jari luar bola:");
        JTextField tfJariJari = new JTextField();

        JLabel labelJarak = new JLabel("Jarak dua bidang sejajar:");
        JTextField tfJarak = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");

        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(labelJariJari);
        panel.add(tfJariJari);
        panel.add(labelJarak);
        panel.add(tfJarak);
        panel.add(btnHitung);
        panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        btnHitung.addActionListener(e -> {
            try {
                double jariJari = Double.parseDouble(tfJariJari.getText());
                double jarak = Double.parseDouble(tfJarak.getText());

                if (jariJari <= 0 || jarak <= 0) {
                    throw new IllegalArgumentException("Nilai harus positif");
                }

                // Karena konstruktor CincinBola hanya menerima 1 parameter, tapi memerlukan 2 variabel tambahan,
                // sebaiknya modifikasi kelas CincinBola agar mendukung parameter lengkap (di bawah ada catatan).
                CincinBola cb = new CincinBola(jariJari);
                
                // Set nilai manual (workaround karena konstruktor tidak lengkap)
                java.lang.reflect.Field fieldDalam = CincinBola.class.getDeclaredField("jariJariDalam");
                java.lang.reflect.Field fieldJarak = CincinBola.class.getDeclaredField("jarakDuaBidang");
                fieldDalam.setAccessible(true);
                fieldJarak.setAccessible(true);
                fieldDalam.set(cb, jariJari); // asumsi jari-jari dalam = jari-jari luar
                fieldJarak.set(cb, jarak);

                new CincinBolaThread(cb, output).start();
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
