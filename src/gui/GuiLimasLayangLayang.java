package gui;

import main.main;
import bendaGeometri.LayangLayang;
import bendaGeometri.LimasLayangLayang;

import javax.swing.*;
import java.awt.*;

public class GuiLimasLayangLayang {
    public GuiLimasLayangLayang() {
        JFrame frame = new JFrame("Limas Layang-Layang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 420);

        JPanel panel = new JPanel(new GridLayout(8, 2));

        JRadioButton rbParent = new JRadioButton("Gunakan data dari Layang-Layang");
        JRadioButton rbManual = new JRadioButton("Input data manual");
        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbManual);

        JTextField tfD1 = new JTextField();
        JTextField tfD2 = new JTextField();
        JTextField tfSisiPendek = new JTextField();
        JTextField tfSisiPanjang = new JTextField();
        JTextField tfTinggiLimas = new JTextField();

        JButton btnHitung = new JButton("Hitung");
        JButton btnKembali = new JButton("Kembali ke Main View");
        JTextArea output = new JTextArea();
        output.setEditable(false);

        panel.add(rbParent); panel.add(rbManual);
        panel.add(new JLabel("Diagonal 1:")); panel.add(tfD1);
        panel.add(new JLabel("Diagonal 2:")); panel.add(tfD2);
        panel.add(new JLabel("Sisi Pendek:")); panel.add(tfSisiPendek);
        panel.add(new JLabel("Sisi Panjang:")); panel.add(tfSisiPanjang);
        panel.add(new JLabel("Tinggi Limas:")); panel.add(tfTinggiLimas);
        panel.add(btnHitung); panel.add(btnKembali);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(output), BorderLayout.CENTER);

        rbParent.addActionListener(e -> {
            LayangLayang ll = SharedData.getLayanglayang();
            if (ll != null) {
                tfD1.setText(String.valueOf(ll.getDiagonal1()));
                tfD2.setText(String.valueOf(ll.getDiagonal2()));
                tfSisiPendek.setText(String.valueOf(ll.getSisiPendek()));
                tfSisiPanjang.setText(String.valueOf(ll.getSisiPanjang()));

                tfD1.setEditable(false);
                tfD2.setEditable(false);
                tfSisiPendek.setEditable(false);
                tfSisiPanjang.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Belum ada data dari Layang-Layang!");
                group.clearSelection();
            }
        });

        rbManual.addActionListener(e -> {
            tfD1.setText("");
            tfD2.setText("");
            tfSisiPendek.setText("");
            tfSisiPanjang.setText("");

            tfD1.setEditable(true);
            tfD2.setEditable(true);
            tfSisiPendek.setEditable(true);
            tfSisiPanjang.setEditable(true);
        });

        btnHitung.addActionListener(e -> {
            try {
                double tinggiLimas = Double.parseDouble(tfTinggiLimas.getText());

                LimasLayangLayang limas;
                if (rbParent.isSelected()) {
                    LayangLayang ll = SharedData.getLayanglayang();
                    if (ll == null) throw new IllegalStateException("Belum ada data dari Layang-Layang");

                    limas = new LimasLayangLayang(
                        ll.getDiagonal1(), ll.getDiagonal2(),
                        ll.getSisiPendek(), ll.getSisiPanjang(),
                        tinggiLimas
                    );

                } else if (rbManual.isSelected()) {
                    double d1 = Double.parseDouble(tfD1.getText());
                    double d2 = Double.parseDouble(tfD2.getText());
                    double sisiPendek = Double.parseDouble(tfSisiPendek.getText());
                    double sisiPanjang = Double.parseDouble(tfSisiPanjang.getText());

                    limas = new LimasLayangLayang(d1, d2, sisiPendek, sisiPanjang, tinggiLimas);
                } else {
                    throw new IllegalStateException("Pilih metode input terlebih dahulu");
                }

                output.setText("Volume: " + limas.hitungVolume() +
                        "\nLuas Permukaan: " + limas.hitungLuasPermukaan());

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
