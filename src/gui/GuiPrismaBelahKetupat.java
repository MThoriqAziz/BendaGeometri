package gui;

import main.main;
import bendaGeometri.PrismaBelahKetupat;
import bendaGeometri.PrismaBelahKetupatThread;
import bendaGeometri.BelahKetupat;
import javax.swing.*;
import java.awt.*;

public class GuiPrismaBelahKetupat {
    public GuiPrismaBelahKetupat() {
        JFrame frame = new JFrame("Prisma Belah Ketupat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        JRadioButton rbParent = new JRadioButton("Gunakan data dari Belah Ketupat");
        JRadioButton rbManual = new JRadioButton("Input data dari awal");
        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbManual);

        JTextField tfDiagonal1 = new JTextField();
        JTextField tfDiagonal2 = new JTextField();
        JTextField tfSisi = new JTextField();
        JTextField tfTinggiPrisma = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(rbParent); panel.add(rbManual);
        panel.add(new JLabel("Diagonal 1:")); panel.add(tfDiagonal1);
        panel.add(new JLabel("Diagonal 2:")); panel.add(tfDiagonal2);
        panel.add(new JLabel("Sisi:")); panel.add(tfSisi);
        panel.add(new JLabel("Tinggi Prisma:")); panel.add(tfTinggiPrisma);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        rbParent.addActionListener(e -> {
            BelahKetupat bk = SharedData.getBelahKetupat(); // pastikan metode ini disediakan
            if (bk != null) {
                tfDiagonal1.setText(String.valueOf(bk.hitungLuas() * 2 / bk.hitungKeliling())); // pendekatan
                tfDiagonal2.setText(""); // atau tambahkan getter jika diperlukan
                tfSisi.setText("");       // atau tambahkan getter jika diperlukan

                tfDiagonal1.setEditable(false);
                tfDiagonal2.setEditable(false);
                tfSisi.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Belum ada data dari Belah Ketupat!");
                group.clearSelection();
            }
        });

        rbManual.addActionListener(e -> {
            tfDiagonal1.setText("");
            tfDiagonal2.setText("");
            tfSisi.setText("");

            tfDiagonal1.setEditable(true);
            tfDiagonal2.setEditable(true);
            tfSisi.setEditable(true);
        });

        btnHitung.addActionListener(e -> {
            try {
                double tinggiPrisma = Double.parseDouble(tfTinggiPrisma.getText());
                PrismaBelahKetupat prisma;

                if (rbParent.isSelected()) {
                    BelahKetupat bk = SharedData.getBelahKetupat();
                    if (bk == null) throw new IllegalStateException("Belum ada data dari Belah Ketupat");

                    // Anggap diagonal dan sisi bisa diambil dari objek lama (perlu getter jika mau valid)
                    double d1 = Double.parseDouble(tfDiagonal1.getText());
                    double d2 = Double.parseDouble(tfDiagonal2.getText());
                    double sisi = Double.parseDouble(tfSisi.getText());

                    prisma = new PrismaBelahKetupat(d1, d2, sisi, tinggiPrisma);

                } else if (rbManual.isSelected()) {
                    double d1 = Double.parseDouble(tfDiagonal1.getText());
                    double d2 = Double.parseDouble(tfDiagonal2.getText());
                    double sisi = Double.parseDouble(tfSisi.getText());

                    prisma = new PrismaBelahKetupat(d1, d2, sisi, tinggiPrisma);
                } else {
                    throw new IllegalStateException("Pilih metode input terlebih dahulu");
                }

                PrismaBelahKetupatThread thread = new PrismaBelahKetupatThread(prisma, output);
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
