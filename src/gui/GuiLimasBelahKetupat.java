package gui;

import main.main;
import bendaGeometri.LimasBelahKetupat;
import bendaGeometri.LimasBelahKetupatThread;
import bendaGeometri.BelahKetupat;

import javax.swing.*;
import java.awt.*;

public class GuiLimasBelahKetupat {
    public GuiLimasBelahKetupat() {
        JFrame frame = new JFrame("Limas Belah Ketupat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        JRadioButton rbParent = new JRadioButton("Gunakan data dari Belah Ketupat");
        JRadioButton rbManual = new JRadioButton("Input data dari awal");
        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbManual);

        JTextField tfDiagonal1 = new JTextField();
        JTextField tfDiagonal2 = new JTextField();
        JTextField tfSisi = new JTextField();
        JTextField tfTinggiLimas = new JTextField();
        JTextField tfTinggiSisiTegak = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(rbParent); panel.add(rbManual);
        panel.add(new JLabel("Diagonal 1:")); panel.add(tfDiagonal1);
        panel.add(new JLabel("Diagonal 2:")); panel.add(tfDiagonal2);
        panel.add(new JLabel("Sisi:")); panel.add(tfSisi);
        panel.add(new JLabel("Tinggi Limas:")); panel.add(tfTinggiLimas);
        panel.add(new JLabel("Tinggi Sisi Tegak:")); panel.add(tfTinggiSisiTegak);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        rbParent.addActionListener(e -> {
            BelahKetupat bk = SharedData.getBelahKetupat(); // kamu perlu membuat method ini
            if (bk != null) {
                tfDiagonal1.setText(""); // Tambahkan getter di BelahKetupat jika ingin isi otomatis
                tfDiagonal2.setText("");
                tfSisi.setText("");

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
                double tinggiLimas = Double.parseDouble(tfTinggiLimas.getText());
                double tinggiSisiTegak = Double.parseDouble(tfTinggiSisiTegak.getText());

                LimasBelahKetupat limas;

                if (rbParent.isSelected()) {
                    BelahKetupat bk = SharedData.getBelahKetupat();
                    if (bk == null) throw new IllegalStateException("Belum ada data dari Belah Ketupat");

                    double d1 = Double.parseDouble(tfDiagonal1.getText());
                    double d2 = Double.parseDouble(tfDiagonal2.getText());
                    double sisi = Double.parseDouble(tfSisi.getText());

                    limas = new LimasBelahKetupat(d1, d2, sisi, tinggiLimas, tinggiSisiTegak);
                } else if (rbManual.isSelected()) {
                    double d1 = Double.parseDouble(tfDiagonal1.getText());
                    double d2 = Double.parseDouble(tfDiagonal2.getText());
                    double sisi = Double.parseDouble(tfSisi.getText());

                    limas = new LimasBelahKetupat(d1, d2, sisi, tinggiLimas, tinggiSisiTegak);
                } else {
                    throw new IllegalStateException("Pilih metode input terlebih dahulu");
                }

                LimasBelahKetupatThread thread = new LimasBelahKetupatThread(limas, output);
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
