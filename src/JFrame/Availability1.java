/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author admin
 */
public final class Availability1 extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColor = new Color(102, 153, 255);
    Color mouseExitColor = new Color(0, 102, 255);
    Color mouseExitColor2 = new Color(0, 102, 255);
    Color mouseEnterColor3 = new Color(255, 102, 102);
    Color mouseExitColor3 = new Color(153, 153, 153);
    Color mouseEnterColor03 = new Color(153, 153, 153);
    Color mouseExitColor03 = new Color(204, 204, 204);
    Color mouseEnterColor4 = new Color(0, 153, 255);
    Color mouseExitColor4 = new Color(0, 102, 255);
    String bookName, author, categories, subject;
    int bookId, quantity;
    DefaultTableModel model;

    public Availability1() {
        initComponents();
        Image icon = new ImageIcon(this.getClass().getResource("/lmslogo11.png")).getImage();
        this.setIconImage(icon);
        setBookDetailsToTable();
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 1));
    }

    public void setBookDetailsToTable() {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:library_ms.db");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM book_details WHERE available_quantity = 0");

            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String categories = rs.getString("categories");
                String subject = rs.getString("subject");
                String author = rs.getString("author");
                int avquantity = rs.getInt("available_quantity");

                Object[] obj = {bookId, bookName, categories, subject, author, avquantity};
                model = (DefaultTableModel) tbl_bookDetails.getModel();
                model.addRow(obj);
            }
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Search data from table
    public void searchBook() {
        String searchText = searchTextField2.getText().trim(); // Trim whitespace from the search text

        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter what you want to search!");
            return;
        }

        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:library_ms.db");
            String sql = "SELECT * FROM book_details WHERE (book_id=? OR book_name=? OR categories=? OR subject=? OR author=?) AND available_quantity = 0";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, searchText);
            pst.setString(2, searchText);
            pst.setString(3, searchText);
            pst.setString(4, searchText);
            pst.setString(5, searchText);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) tbl_bookDetails.getModel();
            model.setRowCount(0); // Clear the table before adding new rows

            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String categories = rs.getString("categories");
                String subject = rs.getString("subject");
                String author = rs.getString("author");
                String quantity1 = rs.getString("available_quantity");

                Object[] obj = {bookId, bookName, categories, subject, author, quantity1};
                model.addRow(obj);
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No records found.");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void refresh() {
        // Perform the refresh operation here
        // You can update the JFrame components or perform any other actions
        // For example, you can clear text fields, update labels, etc.

        // Here, we'll simply repaint the JFrame to refresh its contents
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchTextField = new app.bolivia.swing.JCTextField();
        searchTextField1 = new app.bolivia.swing.JCTextField();
        searchTextField2 = new app.bolivia.swing.JCTextField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Library Management System.v2");
        setMinimumSize(new java.awt.Dimension(1217, 747));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(102, 153, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel18.setText("   Home Page");
        jPanel16.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel17.setBackground(new java.awt.Color(102, 153, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel19.setText("   Home Page");
        jPanel17.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel18.setBackground(new java.awt.Color(102, 153, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel20.setText("   Home Page");
        jPanel18.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel19.setBackground(new java.awt.Color(102, 153, 255));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel21.setText("   Home Page");
        jPanel19.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel16.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel2.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 350, 60));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 22)); // NOI18N
        jLabel4.setText("  x");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setPreferredSize(new java.awt.Dimension(14, 20));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 2, 30, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 0, 50, 30));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setForeground(new java.awt.Color(204, 204, 204));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        jLabel25.setText(" -");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel25.setPreferredSize(new java.awt.Dimension(14, 20));
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel25MouseExited(evt);
            }
        });
        jPanel13.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 40, 60));

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 0, 50, 30));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 22)); // NOI18N
        jLabel5.setText("  x");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.setPreferredSize(new java.awt.Dimension(14, 20));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 2, 30, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1165, 0, 50, 30));

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));
        jPanel14.setForeground(new java.awt.Color(204, 204, 204));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        jLabel15.setText(" -");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.setPreferredSize(new java.awt.Dimension(14, 20));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 40, 60));

        jPanel2.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 0, 50, 30));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Available Books");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 60));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Not Available Books");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 170, 60));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 190, -1));

        searchTextField.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        searchTextField.setPlaceholder("  Search...");
        searchTextField.setSelectionColor(new java.awt.Color(255, 255, 255));
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyTyped(evt);
            }
        });
        jPanel2.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 210, 40));

        searchTextField1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        searchTextField1.setPlaceholder("  Search...");
        searchTextField1.setSelectionColor(new java.awt.Color(255, 255, 255));
        searchTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextField1ActionPerformed(evt);
            }
        });
        searchTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextField1KeyTyped(evt);
            }
        });
        jPanel2.add(searchTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, 210, 40));

        searchTextField2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        searchTextField2.setPlaceholder("  Search...");
        searchTextField2.setSelectionColor(new java.awt.Color(255, 255, 255));
        searchTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextField2ActionPerformed(evt);
            }
        });
        searchTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextField2KeyTyped(evt);
            }
        });
        jPanel2.add(searchTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 210, 40));

        jButton4.setBackground(new java.awt.Color(153, 153, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Search");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 80, 40));

        jButton1.setBackground(new java.awt.Color(153, 153, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/reload.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 40, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 60));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_bookDetails.setForeground(new java.awt.Color(51, 51, 51));
        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial Number", "Book Title", "Categories", "Subject", "Author", "Available Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_bookDetails.setAltoHead(40);
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(204, 204, 0));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(204, 204, 204));
        tbl_bookDetails.setColorBordeHead(new java.awt.Color(204, 204, 204));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_bookDetails.setColorFilasForeground2(new java.awt.Color(51, 51, 51));
        tbl_bookDetails.setColorForegroundHead(new java.awt.Color(51, 51, 0));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 255, 102));
        tbl_bookDetails.setColorSelForeground(new java.awt.Color(51, 51, 51));
        tbl_bookDetails.setFocusable(false);
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbl_bookDetails.setMultipleSeleccion(false);
        tbl_bookDetails.setOpaque(false);
        tbl_bookDetails.setRequestFocusEnabled(false);
        tbl_bookDetails.setRowHeight(30);
        tbl_bookDetails.setSelectionForeground(new java.awt.Color(153, 204, 255));
        tbl_bookDetails.setUpdateSelectionOnSort(false);
        tbl_bookDetails.setVerifyInputWhenFocusTarget(false);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

        jPanel15.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1190, 650));

        getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 60, 1220, 690));

        setSize(new java.awt.Dimension(1217, 747));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked

    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void jLabel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseExited
        // TODO add your handling code here:
        jPanel13.setBackground(mouseExitColor03);
    }//GEN-LAST:event_jLabel25MouseExited

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
        // TODO add your handling code here:
        jPanel13.setBackground(mouseEnterColor03);
    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // TODO add your handling code here:
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        jPanel4.setBackground(mouseExitColor3);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        jPanel4.setBackground(mouseEnterColor3);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        jPanel4.setBackground(mouseEnterColor3);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
        jPanel4.setBackground(mouseExitColor3);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        // TODO add your handling code here:
        jPanel13.setBackground(mouseEnterColor03);
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        // TODO add your handling code here:
        jPanel13.setBackground(mouseExitColor03);
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        Availability available = new Availability();
        available.setLocationRelativeTo(null);
        available.setVisible(true);
        Timer timer = new Timer(50, new ActionListener() {
            float opacity = 1.0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.1f;
                if (opacity <= 0.0f) {
                    ((Timer) e.getSource()).stop();
                    dispose();
                }
                setOpacity(opacity);
            }
        });
        timer.start();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        dispose();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyPressed
        // TODO add your handling code here:

        searchBook();


    }//GEN-LAST:event_searchTextFieldKeyPressed

    private void searchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldKeyTyped

    private void searchTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextField1ActionPerformed

    private void searchTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextField1KeyPressed
        // TODO add your handling code here:

        searchBook();


    }//GEN-LAST:event_searchTextField1KeyPressed

    private void searchTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextField1KeyTyped

    private void searchTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextField2ActionPerformed

    private void searchTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextField2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {

            searchBook();

        }

    }//GEN-LAST:event_searchTextField2KeyPressed

    private void searchTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextField2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextField2KeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        searchBook();


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Availability1 av1 = new Availability1();
        av1.setLocationRelativeTo(null); // centers JFrame2
        av1.setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            float opacity = 1.0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.1f;
                if (opacity <= 0.0f) {
                    ((Timer) e.getSource()).stop();
                    dispose();
                }
                setOpacity(opacity);
            }
        });
        timer.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Availability1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Availability1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Availability1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Availability1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Availability1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private app.bolivia.swing.JCTextField searchTextField;
    private app.bolivia.swing.JCTextField searchTextField1;
    private app.bolivia.swing.JCTextField searchTextField2;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    // End of variables declaration//GEN-END:variables

}
