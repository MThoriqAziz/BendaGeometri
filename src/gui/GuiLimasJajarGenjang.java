package gui;

import main.main;
import bendaGeometri.JajarGenjang;
import bendaGeometri.LimasJajarGenjang;

import javax.swing.*;
import java.awt.*;
import main.main;

public class GuiLimasJajarGenjang {
    public GuiLimasJajarGenjang() {
        JFrame frame = new JFrame("Limas Jajar Genjang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 420);

        JPanel panel = new JPanel(new GridLayout(7, 2));

        JRadioButton rbParent = new JRadioButton("Gunakan data dari Jajar Genjang");
        JRadioButton rbManual = new JRadioButton("Input data manual");
        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbManual);

        JTextField tfAlas = new JTextField();
        JTextField tfTinggiAlas = new JTextField();
        JTextField tfSisiMiring = new JTextField();
        JTextField tfTinggiLimas = new JTextField();
        JTextField tfTinggiSisiTegak = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(rbParent); panel.add(rbManual);
        panel.add(new JLabel("Alas:")); panel.add(tfAlas);
        panel.add(new JLabel("Tinggi Alas:")); panel.add(tfTinggiAlas);
        panel.add(new JLabel("Sisi Miring:")); panel.add(tfSisiMiring);
        panel.add(new JLabel("Tinggi Limas:")); panel.add(tfTinggiLimas);
        panel.add(new JLabel("Tinggi Sisi Tegak:")); panel.add(tfTinggiSisiTegak);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        // Aksi jika pilih data dari parent (JajarGenjang)
        rbParent.addActionListener(e -> {
            JajarGenjang jg = SharedData.getJajarGenjang();
            if (jg != null) {
                tfAlas.setText(String.valueOf(jg.getAlas()));
                tfTinggiAlas.setText(String.valueOf(jg.getTinggi()));
                tfSisiMiring.setText(String.valueOf(jg.getSisiMiring()));
                tfAlas.setEditable(false);
                tfTinggiAlas.setEditable(false);
                tfSisiMiring.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Belum ada data dari Jajar Genjang!");
                group.clearSelection();
            }
        });

        // Aksi jika pilih input manual
        rbManual.addActionListener(e -> {
            tfAlas.setText("");
            tfTinggiAlas.setText("");
            tfSisiMiring.setText("");
            tfAlas.setEditable(true);
            tfTinggiAlas.setEditable(true);
            tfSisiMiring.setEditable(true);
        });

        btnHitung.addActionListener(e -> {
            try {
                double tinggiLimas = Double.parseDouble(tfTinggiLimas.getText());
                double tinggiSisiTegak = Double.parseDouble(tfTinggiSisiTegak.getText());

                LimasJajarGenjang limas;
                if (rbParent.isSelected()) {
                    JajarGenjang jg = SharedData.getJajarGenjang();
                    if (jg == null) throw new IllegalStateException("Belum ada data dari Jajar Genjang!");

                    limas = new LimasJajarGenjang(
                        jg.getAlas(), jg.getTinggi(), jg.getSisiMiring(),
                        tinggiLimas, tinggiSisiTegak
                    );

                } else if (rbManual.isSelected()) {
                    double alas = Double.parseDouble(tfAlas.getText());
                    double tinggiAlas = Double.parseDouble(tfTinggiAlas.getText());
                    double sisiMiring = Double.parseDouble(tfSisiMiring.getText());

                    limas = new LimasJajarGenjang(alas, tinggiAlas, sisiMiring, tinggiLimas, tinggiSisiTegak);
                } else {
                    throw new IllegalStateException("Pilih metode input terlebih dahulu");
                }

                output.setText("== Limas Jajar Genjang ==\n");
                output.append("Volume: " + limas.hitungVolume() + "\n");
                output.append("Luas Permukaan: " + limas.hitungLuasPermukaan() + "\n");
                output.append("Luas Sisi Tegak: " + limas.hitungLuasSisiTegak());

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
