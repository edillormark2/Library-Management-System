/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
public final class TimeOut extends javax.swing.JFrame { 
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
  

    Color mouseEnterColor = new Color(153, 153, 0);
    Color mouseExitColor = new Color(153, 0, 0);
    Color mouseEnterColor2 = new Color(153, 0, 0);
    Color mouseExitColor2 = new Color(153, 153, 0);
    Color mouseEnterColor3 = new Color(255, 102, 102);
    Color mouseExitColor3 = new Color(153, 153, 153);
    Color mouseEnterColor03 = new Color(153, 153, 153);
    Color mouseExitColor03 = new Color(204, 204, 204);

    public TimeOut() {
        initComponents();
        Image icon = new ImageIcon(this.getClass().getResource("/lmslogo11.png")).getImage();
        this.setIconImage(icon);
        con = DBConnection.ConnectionDB();
        getRootPane().setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 1));
    }

    public void getTimeinDetails() {
        String studentId = txt_studentId.getText().trim();

        if (studentId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a student ID!");
            return;
        }

        try ( Connection con = DBConnection.ConnectionDB()) {
            String sql = "SELECT * FROM time_in_details WHERE student_id = ? AND status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentId);
            pst.setString(2, "Ongoing");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                lbl_studentId.setText(rs.getString("student_id"));
                lbl_studentName.setText(rs.getString("name"));
                lbl_section.setText(rs.getString("section"));
                lbl_contact.setText(rs.getString("contact"));
                lbl_timein.setText(rs.getString("timeIn"));
            } else {
                JOptionPane.showMessageDialog(this, "No record found!");
                lbl_studentId.setText("");
                lbl_studentName.setText("");
                lbl_section.setText("");
                lbl_contact.setText("");
                lbl_timein.setText("");
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean recordTimeOut() {
        boolean isSuccess = false;
        String studentId = txt_studentId.getText();
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy - h:mma");
        String formattedTime = currentTime.format(formatter);
        try {
            Connection con = DBConnection.ConnectionDB();
            String sql = "update time_in_details set status = ?, timeOut = ? where student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "Timed out");
            pst.setString(2, formattedTime);
            pst.setString(3, studentId);
            pst.setString(4, "Ongoing");

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isSuccess = true;
                txt_studentId.setText("");
                lbl_studentId.setText("");
                lbl_studentName.setText("");
                lbl_section.setText("");
                lbl_contact.setText("");
                lbl_timein.setText("");
            } else {
                isSuccess = false;
            }
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return isSuccess;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        date_IssueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel113 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        lbl_studentId = new javax.swing.JTextField();
        lbl_studentName = new javax.swing.JTextField();
        lbl_section = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        txt_studentId14 = new javax.swing.JTextField();
        txt_studentId15 = new javax.swing.JTextField();
        txt_studentId16 = new javax.swing.JTextField();
        txt_studentId17 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        lbl_bookError = new javax.swing.JLabel();
        lbl_contact = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        lbl_timein = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        lbl_title = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jPanel78 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jPanel79 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jPanel82 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        jPanel69 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        jPanel87 = new javax.swing.JPanel();
        jPanel88 = new javax.swing.JPanel();
        jPanel89 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jPanel92 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jPanel91 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel93 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jPanel90 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jPanel94 = new javax.swing.JPanel();
        jPanel95 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel98 = new javax.swing.JPanel();
        jPanel99 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jPanel102 = new javax.swing.JPanel();
        jPanel103 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jPanel100 = new javax.swing.JPanel();
        jPanel101 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jPanel104 = new javax.swing.JPanel();
        jPanel105 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jPanel106 = new javax.swing.JPanel();
        jPanel107 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jPanel108 = new javax.swing.JPanel();
        jPanel109 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jPanel110 = new javax.swing.JPanel();
        jPanel111 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Management System.v2");
        setMinimumSize(new java.awt.Dimension(1350, 760));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1350, 760));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("LIBRARY MANAGEMENT SYSTEM");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/menu (1).png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

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

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 50, 30));

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setForeground(new java.awt.Color(204, 204, 204));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        jLabel24.setText(" -");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.setPreferredSize(new java.awt.Dimension(14, 20));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });
        jPanel13.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 40, 60));

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 50, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1090, 50));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(153, 153, 0));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1550, 1));

        date_IssueDate.setPlaceholder("Select Issue Date");
        jPanel20.add(date_IssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 340, -1));

        jLabel113.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 255, 255));
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RYW icons/ST_TimeIn.png"))); // NOI18N
        jLabel113.setText("  Student Time Out");
        jPanel20.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 310, 50));

        jPanel22.setBackground(new java.awt.Color(153, 153, 0));
        jPanel22.setForeground(new java.awt.Color(102, 102, 255));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/reload.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel22.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 2, 30, 30));

        jPanel20.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 100, 32, 35));

        jPanel15.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1070, 160));

        jPanel24.setBackground(new java.awt.Color(153, 153, 0));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_studentId.setEditable(false);
        lbl_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_studentIdActionPerformed(evt);
            }
        });
        jPanel24.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 410, 40));

        lbl_studentName.setEditable(false);
        lbl_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_studentNameActionPerformed(evt);
            }
        });
        jPanel24.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 410, 40));

        lbl_section.setEditable(false);
        lbl_section.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_sectionActionPerformed(evt);
            }
        });
        jPanel24.add(lbl_section, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 410, 40));

        jLabel126.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setText("Student No.");
        jPanel24.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel127.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setText("Student Name");
        jPanel24.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel128.setText("Section");
        jPanel24.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 60, -1));

        jPanel32.setBackground(new java.awt.Color(102, 153, 255));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setFont(new java.awt.Font("Ebrima", 1, 25)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/reading-book (1).png"))); // NOI18N
        jLabel129.setText("  Students Details");
        jPanel32.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        txt_studentId14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentId14ActionPerformed(evt);
            }
        });
        jPanel32.add(txt_studentId14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 340, 40));

        txt_studentId15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentId15ActionPerformed(evt);
            }
        });
        jPanel32.add(txt_studentId15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 340, 40));

        txt_studentId16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentId16ActionPerformed(evt);
            }
        });
        jPanel32.add(txt_studentId16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 340, 40));

        txt_studentId17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentId17ActionPerformed(evt);
            }
        });
        jPanel32.add(txt_studentId17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 340, 40));

        jLabel130.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(255, 255, 255));
        jLabel130.setText("Course");
        jPanel32.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 60, -1));

        jLabel131.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(255, 255, 255));
        jLabel131.setText("Student No.");
        jPanel32.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel132.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(255, 255, 255));
        jLabel132.setText("Student Name");
        jPanel32.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel133.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setText("Section");
        jPanel32.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 90, -1));

        jPanel24.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 190, 450, 770));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jPanel35.setBackground(new java.awt.Color(204, 255, 255));
        jPanel33.add(jPanel35);

        jPanel24.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 850, 1));

        lbl_bookError.setBackground(new java.awt.Color(255, 102, 102));
        lbl_bookError.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 51, 51));
        jPanel24.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 610, 250, 30));

        lbl_contact.setEditable(false);
        lbl_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_contactActionPerformed(evt);
            }
        });
        jPanel24.add(lbl_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 410, 40));

        jLabel134.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 255, 255));
        jLabel134.setText("Contact");
        jPanel24.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 60, -1));

        lbl_timein.setEditable(false);
        lbl_timein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_timeinActionPerformed(evt);
            }
        });
        jPanel24.add(lbl_timein, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 420, 40));

        jLabel136.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(255, 255, 255));
        jLabel136.setText("Date & Time In");
        jPanel24.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 120, -1));

        lbl_title.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("  Time In Details");
        jPanel24.add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jPanel15.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 590, 490));

        jPanel36.setBackground(new java.awt.Color(204, 204, 204));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel135.setFont(new java.awt.Font("Ebrima", 1, 25)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(51, 51, 51));
        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/clock.png"))); // NOI18N
        jLabel135.setText(" Time Out");
        jPanel36.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 210, -1));

        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        txt_studentId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_studentIdKeyPressed(evt);
            }
        });
        jPanel36.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 340, 40));

        jLabel137.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(51, 51, 51));
        jLabel137.setText("Student No.");
        jPanel36.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 0));
        jButton1.setText("FIND DETAILS");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel36.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 340, 40));

        jButton2.setBackground(new java.awt.Color(153, 153, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 0));
        jButton2.setText("TIME OUT");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel36.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 340, 40));

        jPanel37.setBackground(new java.awt.Color(51, 51, 51));

        jPanel38.setBackground(new java.awt.Color(204, 255, 255));
        jPanel37.add(jPanel38);

        jPanel36.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 700, 1));

        jPanel15.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 470, 490));

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel34.setForeground(new java.awt.Color(204, 204, 204));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\admin\\Documents\\NetBeansProjects\\Library_Management_System_v2\\src\\system icons\\copyright (3).png")); // NOI18N
        jLabel16.setText("Developed by Group 2 Ferrock AiTECH AY2022-2023 |  Library Management System Version 2.1");
        jPanel34.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 550, -1));

        jPanel15.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 675, 1070, 30));

        getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 1260, 800));

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/data-report.png"))); // NOI18N
        jLabel5.setText("   Dashboard");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 190, 40));

        jPanel5.setBackground(new java.awt.Color(102, 153, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel7.setText("   Home Page");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel6.setBackground(new java.awt.Color(102, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel8.setText("   Home Page");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel7.setBackground(new java.awt.Color(102, 153, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel9.setText("   Home Page");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel8.setBackground(new java.awt.Color(102, 153, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel10.setText("   Home Page");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel9.setBackground(new java.awt.Color(102, 153, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel11.setText("   Home Page");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel10.setBackground(new java.awt.Color(102, 153, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel12.setText("   Home Page");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel11.setBackground(new java.awt.Color(102, 153, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel13.setText("   Home Page");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel76.setBackground(new java.awt.Color(102, 153, 255));
        jPanel76.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel79.setText("   Home Page");
        jPanel76.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel77.setBackground(new java.awt.Color(102, 153, 255));
        jPanel77.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel80.setText("   Home Page");
        jPanel77.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel76.add(jPanel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel78.setBackground(new java.awt.Color(102, 153, 255));
        jPanel78.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel81.setText("   Home Page");
        jPanel78.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel79.setBackground(new java.awt.Color(102, 153, 255));
        jPanel79.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel82.setText("   Home Page");
        jPanel79.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel78.add(jPanel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel76.add(jPanel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel80.setBackground(new java.awt.Color(102, 153, 255));
        jPanel80.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel83.setText("   Home Page");
        jPanel80.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel81.setBackground(new java.awt.Color(102, 153, 255));
        jPanel81.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel84.setText("   Home Page");
        jPanel81.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel80.add(jPanel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel82.setBackground(new java.awt.Color(102, 153, 255));
        jPanel82.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel85.setText("   Home Page");
        jPanel82.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel83.setBackground(new java.awt.Color(102, 153, 255));
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel86.setText("   Home Page");
        jPanel83.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel82.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel80.add(jPanel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel76.add(jPanel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel3.add(jPanel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel44.setBackground(new java.awt.Color(0, 102, 255));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel45.setBackground(new java.awt.Color(102, 153, 255));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel47.setText("   Home Page");
        jPanel45.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel46.setBackground(new java.awt.Color(102, 153, 255));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel48.setText("   Home Page");
        jPanel46.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel45.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel44.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel47.setBackground(new java.awt.Color(102, 153, 255));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel49.setText("   Home Page");
        jPanel47.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel44.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 320, 100));

        jPanel48.setBackground(new java.awt.Color(102, 153, 255));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel50.setText("   Home Page");
        jPanel48.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel49.setBackground(new java.awt.Color(102, 153, 255));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel51.setText("   Home Page");
        jPanel49.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel48.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel50.setBackground(new java.awt.Color(102, 153, 255));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel52.setText("   Home Page");
        jPanel50.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel51.setBackground(new java.awt.Color(102, 153, 255));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel53.setText("   Home Page");
        jPanel51.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel50.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel48.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel44.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel52.setBackground(new java.awt.Color(102, 153, 255));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel53.setBackground(new java.awt.Color(102, 153, 255));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel54.setText("   Home Page");
        jPanel53.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel54.setBackground(new java.awt.Color(102, 153, 255));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel55.setText("   Home Page");
        jPanel54.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel53.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel52.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel55.setBackground(new java.awt.Color(102, 153, 255));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel56.setText("   Home Page");
        jPanel55.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel52.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 320, 100));

        jLabel57.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel57.setText("   Home Page");
        jPanel52.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel56.setBackground(new java.awt.Color(102, 153, 255));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel58.setText("   Home Page");
        jPanel56.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel57.setBackground(new java.awt.Color(102, 153, 255));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel59.setText("   Home Page");
        jPanel57.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel56.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel58.setBackground(new java.awt.Color(102, 153, 255));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel60.setText("   Home Page");
        jPanel58.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel59.setBackground(new java.awt.Color(102, 153, 255));
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel61.setText("   Home Page");
        jPanel59.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel58.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel56.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel52.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel44.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 320, 60));

        jPanel60.setBackground(new java.awt.Color(102, 153, 255));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel61.setBackground(new java.awt.Color(102, 153, 255));
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel62.setText("   Home Page");
        jPanel61.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel62.setBackground(new java.awt.Color(102, 153, 255));
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel63.setText("   Home Page");
        jPanel62.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel61.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel60.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel63.setBackground(new java.awt.Color(102, 153, 255));
        jPanel63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel64.setText("   Home Page");
        jPanel63.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel60.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 320, 100));

        jLabel65.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel65.setText("   Home Page");
        jPanel60.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel64.setBackground(new java.awt.Color(102, 153, 255));
        jPanel64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel66.setText("   Home Page");
        jPanel64.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel65.setBackground(new java.awt.Color(102, 153, 255));
        jPanel65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel67.setText("   Home Page");
        jPanel65.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel64.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel66.setBackground(new java.awt.Color(102, 153, 255));
        jPanel66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel68.setText("   Home Page");
        jPanel66.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel67.setBackground(new java.awt.Color(102, 153, 255));
        jPanel67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel69.setText("   Home Page");
        jPanel67.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel66.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel64.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel60.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel68.setBackground(new java.awt.Color(102, 153, 255));
        jPanel68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel69.setBackground(new java.awt.Color(102, 153, 255));
        jPanel69.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel70.setText("   Home Page");
        jPanel69.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel70.setBackground(new java.awt.Color(102, 153, 255));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel71.setText("   Home Page");
        jPanel70.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel69.add(jPanel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel68.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel71.setBackground(new java.awt.Color(102, 153, 255));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel72.setText("   Home Page");
        jPanel71.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel68.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 320, 100));

        jLabel73.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel73.setText("   Home Page");
        jPanel68.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel72.setBackground(new java.awt.Color(102, 153, 255));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel74.setText("   Home Page");
        jPanel72.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel73.setBackground(new java.awt.Color(102, 153, 255));
        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel75.setText("   Home Page");
        jPanel73.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel72.add(jPanel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel74.setBackground(new java.awt.Color(102, 153, 255));
        jPanel74.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel76.setText("   Home Page");
        jPanel74.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel75.setBackground(new java.awt.Color(102, 153, 255));
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel77.setText("   Home Page");
        jPanel75.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel74.add(jPanel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel72.add(jPanel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel68.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 320, 60));

        jPanel60.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 320, 60));

        jPanel44.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 320, 60));

        jLabel78.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel78.setText("   Dashboard");
        jPanel44.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, -1));

        jPanel3.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 400, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 240, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WELCOME ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rsz_1sj_logo-fotor-20230718212431.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 130, -1));

        jPanel86.setBackground(new java.awt.Color(153, 0, 0));
        jPanel86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel86MouseClicked(evt);
            }
        });
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel87.setBackground(new java.awt.Color(0, 102, 255));
        jPanel87.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel86.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 320, 60));

        jPanel88.setBackground(new java.awt.Color(0, 102, 255));
        jPanel88.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel89.setBackground(new java.awt.Color(0, 102, 255));
        jPanel89.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel88.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 320, 60));

        jLabel90.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel90.setText("   Manage Students");
        jPanel88.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 200, -1));

        jPanel86.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 320, 60));

        jLabel91.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/read.png"))); // NOI18N
        jLabel91.setText("   Manage Students");
        jLabel91.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel91MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel91MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel91MouseExited(evt);
            }
        });
        jPanel86.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 210, 40));

        jPanel1.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 240, 40));

        jPanel92.setBackground(new java.awt.Color(153, 0, 0));
        jPanel92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel92MouseClicked(evt);
            }
        });
        jPanel92.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/book.png"))); // NOI18N
        jLabel92.setText("   Check Out");
        jLabel92.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel92MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel92MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel92MouseExited(evt);
            }
        });
        jPanel92.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 180, 40));

        jPanel1.add(jPanel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 240, 40));

        jPanel91.setBackground(new java.awt.Color(153, 0, 0));
        jPanel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel91MouseClicked(evt);
            }
        });
        jPanel91.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/return.png"))); // NOI18N
        jLabel46.setText("   Return Book");
        jLabel46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel46MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel46MouseExited(evt);
            }
        });
        jPanel91.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 180, 40));

        jPanel1.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 240, 40));

        jPanel93.setBackground(new java.awt.Color(153, 0, 0));
        jPanel93.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/criminal-record.png"))); // NOI18N
        jLabel95.setText("   View Records");
        jLabel95.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel95MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel95MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel95MouseExited(evt);
            }
        });
        jPanel93.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 180, 40));

        jPanel1.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 240, 40));

        jPanel90.setBackground(new java.awt.Color(153, 0, 0));
        jPanel90.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel94.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/file.png"))); // NOI18N
        jLabel94.setText("   Pending List");
        jLabel94.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel94MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel94MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel94MouseExited(evt);
            }
        });
        jPanel90.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 180, 40));

        jPanel1.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 240, 40));

        jPanel94.setBackground(new java.awt.Color(153, 0, 0));
        jPanel94.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel95.setBackground(new java.awt.Color(0, 102, 255));
        jPanel95.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel96.setText("   View Records");
        jPanel95.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, -1));

        jPanel94.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 320, 60));

        jLabel97.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/to-do-list.png"))); // NOI18N
        jLabel97.setText("   Overdue List");
        jLabel97.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel97MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel97MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel97MouseExited(evt);
            }
        });
        jPanel94.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 190, 40));

        jPanel1.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 740, 240, 40));

        jPanel29.setBackground(new java.awt.Color(153, 0, 0));
        jPanel29.setForeground(new java.awt.Color(153, 0, 0));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Library");
        jPanel29.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, -1));

        jPanel1.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 70, 20));

        jPanel12.setBackground(new java.awt.Color(102, 153, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 910, 340, 1));

        jPanel28.setBackground(new java.awt.Color(153, 0, 0));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Borrowing Books");
        jPanel28.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, -1));

        jPanel1.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 140, 20));

        jPanel25.setBackground(new java.awt.Color(255, 255, 204));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 548, 340, 1));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 216, 340, 1));

        jPanel30.setBackground(new java.awt.Color(255, 255, 204));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 340, 1));

        jPanel98.setBackground(new java.awt.Color(153, 0, 0));
        jPanel98.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel99.setBackground(new java.awt.Color(0, 102, 255));
        jPanel99.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel124.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel124.setText("   Manage Books");
        jPanel99.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, -1));

        jPanel98.add(jPanel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 320, 60));

        jLabel109.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/criminal-record.png"))); // NOI18N
        jLabel109.setText("  View Records");
        jLabel109.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel109MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel109MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel109MouseExited(evt);
            }
        });
        jPanel98.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 180, 40));

        jPanel102.setBackground(new java.awt.Color(102, 153, 255));
        jPanel102.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel103.setBackground(new java.awt.Color(0, 102, 255));
        jPanel103.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel112.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel112.setText("   Manage Books");
        jPanel103.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, -1));

        jPanel102.add(jPanel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 320, 60));

        jLabel114.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/open-book.png"))); // NOI18N
        jLabel114.setText("   Manage Books");
        jLabel114.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel102.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 260, 40));

        jPanel98.add(jPanel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 320, 40));

        jPanel1.add(jPanel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 240, 40));

        jPanel100.setBackground(new java.awt.Color(153, 0, 0));
        jPanel100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel100MouseEntered(evt);
            }
        });
        jPanel100.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel101.setBackground(new java.awt.Color(0, 102, 255));
        jPanel101.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel110.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel110.setText("   Manage Books");
        jPanel101.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, -1));

        jPanel100.add(jPanel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 320, 60));

        jLabel111.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/open-book.png"))); // NOI18N
        jLabel111.setText("   Manage Books");
        jLabel111.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel111MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel111MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel111MouseExited(evt);
            }
        });
        jPanel100.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 200, 40));

        jPanel1.add(jPanel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 240, 40));

        jPanel104.setBackground(new java.awt.Color(153, 0, 0));
        jPanel104.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel105.setBackground(new java.awt.Color(0, 102, 255));
        jPanel105.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel115.setText("   Manage Books");
        jPanel105.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, -1));

        jPanel104.add(jPanel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 320, 60));

        jLabel117.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/reading.png"))); // NOI18N
        jLabel117.setText("   Student Time In");
        jLabel117.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel117.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel117MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel117MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel117MouseExited(evt);
            }
        });
        jPanel104.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 180, 40));

        jPanel106.setBackground(new java.awt.Color(102, 153, 255));
        jPanel106.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel107.setBackground(new java.awt.Color(0, 102, 255));
        jPanel107.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel122.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel122.setText("   Manage Books");
        jPanel107.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, -1));

        jPanel106.add(jPanel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 320, 60));

        jLabel138.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(255, 255, 255));
        jLabel138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/open-book.png"))); // NOI18N
        jLabel138.setText("   Manage Books");
        jLabel138.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel106.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 260, 40));

        jPanel104.add(jPanel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 320, 40));

        jPanel1.add(jPanel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 240, 40));

        jPanel108.setBackground(new java.awt.Color(153, 153, 0));
        jPanel108.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel109.setBackground(new java.awt.Color(0, 102, 255));
        jPanel109.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel139.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 255, 255));
        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel139.setText("   Manage Books");
        jPanel109.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, -1));

        jPanel108.add(jPanel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 320, 60));

        jLabel140.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(255, 255, 255));
        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/reading.png"))); // NOI18N
        jLabel140.setText("   Student Time Out");
        jLabel140.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel140.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel140MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel140MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel140MouseExited(evt);
            }
        });
        jPanel108.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 190, 40));

        jPanel110.setBackground(new java.awt.Color(102, 153, 255));
        jPanel110.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel111.setBackground(new java.awt.Color(0, 102, 255));
        jPanel111.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel141.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(255, 255, 255));
        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/home.png"))); // NOI18N
        jLabel141.setText("   Manage Books");
        jPanel111.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, -1));

        jPanel110.add(jPanel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 320, 60));

        jLabel142.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(255, 255, 255));
        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/open-book.png"))); // NOI18N
        jLabel142.setText("   Manage Books");
        jLabel142.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel110.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 260, 40));

        jPanel108.add(jPanel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 320, 40));

        jPanel1.add(jPanel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 240, 40));

        jLabel93.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system icons/log-out.png"))); // NOI18N
        jLabel93.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel93MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel93MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel93MouseExited(evt);
            }
        });
        jPanel1.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 30, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 260, 850));

        setSize(new java.awt.Dimension(1350, 760));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        // TODO add your handling code here:
        jPanel22.setBackground(mouseEnterColor2);
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        // TODO add your handling code here:
        jPanel22.setBackground(mouseExitColor2);
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
        TimeOut manage = new TimeOut();
        manage.setLocationRelativeTo(null); // centers JFrame2
        manage.setVisible(true);

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
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        jPanel4.setBackground(mouseEnterColor3);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        jPanel4.setBackground(mouseExitColor3);
    }//GEN-LAST:event_jLabel4MouseExited

    private void lbl_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentIdActionPerformed

    private void lbl_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentNameActionPerformed

    private void lbl_sectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_sectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_sectionActionPerformed

    private void txt_studentId14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentId14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId14ActionPerformed

    private void txt_studentId15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentId15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId15ActionPerformed

    private void txt_studentId16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentId16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId16ActionPerformed

    private void txt_studentId17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentId17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId17ActionPerformed

    private void lbl_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_contactActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getTimeinDetails();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (recordTimeOut() == true) {
            JOptionPane.showMessageDialog(this, "Time out Succesfully!");

        } else {
            JOptionPane.showMessageDialog(this, "Time out  Failed!");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void lbl_timeinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_timeinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_timeinActionPerformed

    private void txt_studentIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_studentIdKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            getTimeinDetails();
        }
    }//GEN-LAST:event_txt_studentIdKeyPressed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        // TODO add your handling code here:
        jPanel13.setBackground(mouseEnterColor03);
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        // TODO add your handling code here:
        jPanel13.setBackground(mouseExitColor03);
    }//GEN-LAST:event_jLabel24MouseExited
    private int panelX = 0;
    private int panelY = 260;
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if (panelX == 0 && panelY == 260) {
            // Move the panel to the left
            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i >= -260; i -= 5) { // Smaller step size
                            Thread.sleep(1);
                            jPanel1.setLocation(i, -40);
                            jPanel2.setSize(jPanel2.getWidth() + 5, jPanel2.getHeight()); // Expand jPanel2 width
                            jPanel2.setLocation(jPanel2.getX() - 5, 0); // Move jPanel2 with jPanel1
                            jPanel4.setLocation(1300 - jPanel2.getX(), 0); // Fix the position of jPanel4 inside jPanel2
                            jPanel13.setLocation(1250 - jPanel2.getX(), 0);
                            jPanel15.setSize(jPanel15.getWidth() + 5, jPanel15.getHeight());
                            jPanel15.setLocation(jPanel15.getX() - 5, 50);

                            // Adjust the table's scroll pane                            
                            jPanel34.setSize(jPanel34.getWidth() + 5, jPanel34.getHeight());
                            jPanel34.setLocation(jPanel34.getX() - 0, jPanel34.getY());

                            // Center jLabel16 inside jPanel34
                            int labelX = (jPanel34.getWidth() - jLabel16.getWidth()) / 2;
                            int labelY = (jPanel34.getHeight() - jLabel16.getHeight()) / 2;
                            jLabel16.setLocation(labelX, labelY);

                            jPanel20.setSize(jPanel20.getWidth() + 5, jPanel20.getHeight());
                            jPanel20.setLocation(jPanel20.getX() - 0, 10);

                            // Adjust the component location based on jPanel20 position                  
                            jPanel22.setSize(jPanel22.getWidth() + 0, jPanel22.getHeight());
                            jPanel22.setLocation(jPanel22.getX() + 5, jPanel22.getY());
                            jPanel36.setSize(jPanel36.getWidth() + 2, jPanel36.getHeight());
                            jPanel36.setLocation(jPanel36.getX() + 0, jPanel36.getY());
                            int labelX1 = (jPanel36.getWidth() - txt_studentId.getWidth()) / 2;
                            txt_studentId.setLocation(labelX1,240);
                            int labelX2 = (jPanel36.getWidth() - jButton1.getWidth()) / 2;
                            jButton1.setLocation(labelX2,320);
                            int labelX3 = (jPanel36.getWidth() - jButton2.getWidth()) / 2;
                            jButton2.setLocation(labelX3,380);
                            jLabel137.setSize(jLabel137.getWidth() + 0 , jLabel137.getHeight());
                            jLabel137.setLocation(jLabel137.getX() + 1, jLabel137.getY());
                            jPanel24.setSize(jPanel24.getWidth() + 3, jPanel24.getHeight());
                            jPanel24.setLocation(jPanel24.getX() + 2, jPanel24.getY());  
                            int labelX9 = (jPanel24.getWidth() - lbl_title.getWidth()) / 2;
                            lbl_title.setLocation(labelX9,20);
                            int labelX10 = (jPanel36.getWidth() - jLabel135.getWidth()) / 2;
                            jLabel135.setLocation(labelX10,20);
                            int labelX4 = (jPanel24.getWidth() - lbl_section.getWidth()) / 2;
                            lbl_section.setLocation(labelX4,250);
                            int labelX5 = (jPanel24.getWidth() - lbl_contact.getWidth()) / 2;
                            lbl_contact.setLocation(labelX5,330);
                            int labelX6 = (jPanel24.getWidth() - lbl_timein.getWidth()) / 2;
                            lbl_timein.setLocation(labelX6,420);
                            int labelX7 = (jPanel24.getWidth() - lbl_studentName.getWidth()) / 2;
                            lbl_studentName.setLocation(labelX7,90);
                            int labelX8 = (jPanel24.getWidth() - lbl_studentId.getWidth()) / 2;
                            lbl_studentId.setLocation(labelX8,170);
                            
                           
                            jLabel127.setLocation(lbl_studentName.getX() + lbl_studentName.getWidth() - 410, jLabel127.getY());
                            jLabel126.setLocation(lbl_studentName.getX() + lbl_studentName.getWidth() - 410, jLabel126.getY());
                            jLabel128.setLocation(lbl_studentName.getX() + lbl_studentName.getWidth() - 410, jLabel128.getY());
                            jLabel134.setLocation(lbl_studentName.getX() + lbl_studentName.getWidth() - 410, jLabel134.getY());
                            jLabel136.setLocation(lbl_studentName.getX() + lbl_studentName.getWidth() - 410, jLabel136.getY());
                       
                            
                        }
                        panelX = -260;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
        } else if (panelX < 0 && panelY == 260) {
            // Move the panel back to the original position
            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = -260; i <= 0; i += 5) { // Smaller step size
                            Thread.sleep(1);
                            jPanel1.setLocation(i, -40);
                            jPanel2.setSize(jPanel2.getWidth() - 5, jPanel2.getHeight()); // Shrink jPanel2 width
                            jPanel2.setLocation(jPanel2.getX() + 5, 0); // Move jPanel2 with jPanel1
                            jPanel4.setLocation(1300 - jPanel2.getX(), 0); // Fix the position of jPanel4 inside jPanel2
                            jPanel13.setLocation(1250 - jPanel2.getX(), 0);
                            jPanel15.setSize(jPanel15.getWidth() - 5, jPanel15.getHeight());
                            jPanel15.setLocation(jPanel15.getX() + 5, 50);

                            // Adjust the table's scroll pane                      
                            jPanel34.setSize(jPanel34.getWidth() - 5, jPanel34.getHeight());
                            jPanel34.setLocation(jPanel34.getX() + 0, jPanel34.getY());

                            // Center jLabel16 inside jPanel34
                            int labelX = (jPanel34.getWidth() - jLabel16.getWidth()) / 2;
                            int labelY = (jPanel34.getHeight() - jLabel16.getHeight()) / 2;
                            jLabel16.setLocation(labelX, labelY);

                            jPanel20.setSize(jPanel20.getWidth() - 5, jPanel20.getHeight());
                            jPanel20.setLocation(jPanel20.getX() + 0, 10);

                            // Adjust the component location based on jPanel20 position
                            jPanel22.setSize(jPanel22.getWidth() - 0, jPanel22.getHeight());
                            jPanel22.setLocation(jPanel22.getX() - 5, jPanel22.getY());                             
                            jPanel36.setSize(jPanel36.getWidth() - 2 , jPanel36.getHeight());
                            jPanel36.setLocation(jPanel36.getX() - 0, jPanel36.getY());
                            int labelX1 = (jPanel36.getWidth() - txt_studentId.getWidth()) / 2;
                            txt_studentId.setLocation(labelX1, 240);
                            int labelX2 = (jPanel36.getWidth() - jButton1.getWidth()) / 2;
                            jButton1.setLocation(labelX2,320);
                            int labelX3 = (jPanel36.getWidth() - jButton2.getWidth()) / 2;
                            jButton2.setLocation(labelX3,380);                        
                            jLabel137.setSize(jLabel137.getWidth() - 0 , jLabel137.getHeight());
                            jLabel137.setLocation(jLabel137.getX() - 1, jLabel137.getY());
                            jPanel24.setSize(jPanel24.getWidth() - 3, jPanel24.getHeight());
                            jPanel24.setLocation(jPanel24.getX() - 2, jPanel24.getY());
                            int labelX9 = (jPanel24.getWidth() - lbl_title.getWidth()) / 2;
                            lbl_title.setLocation(labelX9,20);
                            int labelX10 = (jPanel36.getWidth() - jLabel135.getWidth()) / 2;
                            jLabel135.setLocation(labelX10,20);
                            int labelX4 = (jPanel24.getWidth() - lbl_section.getWidth()) / 2;
                            lbl_section.setLocation(labelX4,250);
                            int labelX5 = (jPanel24.getWidth() - lbl_contact.getWidth()) / 2;
                            lbl_contact.setLocation(labelX5,330);
                            int labelX6 = (jPanel24.getWidth() - lbl_timein.getWidth()) / 2;
                            lbl_timein.setLocation(labelX6,420);
                            int labelX7 = (jPanel24.getWidth() - lbl_studentName.getWidth()) / 2;
                            lbl_studentName.setLocation(labelX7,90);
                            int labelX8 = (jPanel24.getWidth() - lbl_studentId.getWidth()) / 2;
                            lbl_studentId.setLocation(labelX8,170);

                           
                            
                            jLabel127.setLocation(lbl_studentName.getX() + lbl_studentName.getWidth() - 410, jLabel127.getY());
                            jLabel126.setLocation(lbl_studentName.getX() + lbl_studentName.getWidth() - 410, jLabel126.getY());
                            jLabel128.setLocation(lbl_studentName.getX() + lbl_studentName.getWidth() - 410, jLabel128.getY());
                            jLabel134.setLocation(lbl_studentName.getX() + lbl_studentName.getWidth() - 410, jLabel134.getY());
                            jLabel136.setLocation(lbl_studentName.getX() + lbl_studentName.getWidth() - 410, jLabel136.getY());
                        

                        }
                        panelX = 0;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

        HomePage home = new HomePage();
        home.setLocationRelativeTo(null); // centers JFrame2
        home.setVisible(true);

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
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jPanel3.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jPanel3.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setLocationRelativeTo(null); // centers JFrame2
        home.setVisible(true);

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
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseClicked
        ManageStudents students = new ManageStudents();
        students.setLocationRelativeTo(null); // centers JFrame2
        students.setVisible(true);

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
    }//GEN-LAST:event_jLabel91MouseClicked

    private void jLabel91MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseEntered
        jPanel86.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel91MouseEntered

    private void jLabel91MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseExited
        jPanel86.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel91MouseExited

    private void jPanel86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel86MouseClicked
        // TODO add your handling code here:
        ManageStudents students = new ManageStudents();
        students.setLocationRelativeTo(null); // centers JFrame2
        students.setVisible(true);

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
    }//GEN-LAST:event_jPanel86MouseClicked

    private void jLabel92MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel92MouseClicked
        // TODO add your handling code here:
        IssueBook issue = new IssueBook();
        issue.setLocationRelativeTo(null); // centers JFrame2
        issue.setVisible(true);

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
    }//GEN-LAST:event_jLabel92MouseClicked

    private void jLabel92MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel92MouseEntered
        // TODO add your handling code here:
        jPanel92.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel92MouseEntered

    private void jLabel92MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel92MouseExited
        // TODO add your handling code here:
        jPanel92.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel92MouseExited

    private void jPanel92MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel92MouseClicked
        // TODO add your handling code here:
        IssueBook issue = new IssueBook();
        issue.setLocationRelativeTo(null); // centers JFrame2
        issue.setVisible(true);

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
    }//GEN-LAST:event_jPanel92MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
        ReturnBook returnb = new ReturnBook();
        returnb.setLocationRelativeTo(null); // centers JFrame2
        returnb.setVisible(true);

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
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel46MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseEntered
        // TODO add your handling code here:
        jPanel91.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel46MouseEntered

    private void jLabel46MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseExited
        // TODO add your handling code here:
        jPanel91.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel46MouseExited

    private void jPanel91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel91MouseClicked
        // TODO add your handling code here:
        ReturnBook returnb = new ReturnBook();
        returnb.setLocationRelativeTo(null); // centers JFrame2
        returnb.setVisible(true);

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
    }//GEN-LAST:event_jPanel91MouseClicked

    private void jLabel95MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseClicked
        // TODO add your handling code here:
        ViewAllRecord record = new ViewAllRecord();
        record.setLocationRelativeTo(null); // centers JFrame2
        record.setVisible(true);

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
    }//GEN-LAST:event_jLabel95MouseClicked

    private void jLabel95MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseEntered
        // TODO add your handling code here:
        jPanel93.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel95MouseEntered

    private void jLabel95MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseExited
        // TODO add your handling code here:
        jPanel93.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel95MouseExited

    private void jLabel94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseClicked
        // TODO add your handling code here:
        IssuebookDetails Ibook = new IssuebookDetails();
        Ibook.setLocationRelativeTo(null); // centers JFrame2
        Ibook.setVisible(true);

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
    }//GEN-LAST:event_jLabel94MouseClicked

    private void jLabel94MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseEntered
        // TODO add your handling code here:
        jPanel90.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel94MouseEntered

    private void jLabel94MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseExited
        // TODO add your handling code here:
        jPanel90.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel94MouseExited

    private void jLabel97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel97MouseClicked
        // TODO add your handling code here:
        OverdueList over = new OverdueList();
        over.setLocationRelativeTo(null); // centers JFrame2
        over.setVisible(true);

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
    }//GEN-LAST:event_jLabel97MouseClicked

    private void jLabel97MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel97MouseEntered
        // TODO add your handling code here:
        jPanel94.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel97MouseEntered

    private void jLabel97MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel97MouseExited
        // TODO add your handling code here:
        jPanel94.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel97MouseExited

    private void jLabel109MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseClicked
        // TODO add your handling code here:
        In_Out_Record IOR = new In_Out_Record();
        IOR.setLocationRelativeTo(null); // centers JFrame2
        IOR.setVisible(true);

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
    }//GEN-LAST:event_jLabel109MouseClicked

    private void jLabel109MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseEntered
        // TODO add your handling code here:
        jPanel98.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel109MouseEntered

    private void jLabel109MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseExited
        // TODO add your handling code here:
        jPanel98.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel109MouseExited

    private void jLabel111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseClicked
        ManageBooks books = new ManageBooks();
        books.setLocationRelativeTo(null); // centers JFrame2
        books.setVisible(true);

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
    }//GEN-LAST:event_jLabel111MouseClicked

    private void jLabel111MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseEntered
        jPanel100.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel111MouseEntered

    private void jLabel111MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseExited
        jPanel100.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel111MouseExited

    private void jPanel100MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel100MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel100MouseEntered

    private void jLabel117MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel117MouseClicked
        // TODO add your handling code here:
        TimeIn manage = new TimeIn();
        manage.setLocationRelativeTo(null); // centers JFrame2
        manage.setVisible(true);

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
    }//GEN-LAST:event_jLabel117MouseClicked

    private void jLabel117MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel117MouseEntered
        // TODO add your handling code here:
        jPanel104.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel117MouseEntered

    private void jLabel117MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel117MouseExited
        // TODO add your handling code here:
        jPanel104.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel117MouseExited

    private void jLabel140MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel140MouseClicked
      
    }//GEN-LAST:event_jLabel140MouseClicked

    private void jLabel140MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel140MouseEntered

      
    }//GEN-LAST:event_jLabel140MouseEntered

    private void jLabel140MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel140MouseExited
 
        
    }//GEN-LAST:event_jLabel140MouseExited

    private void jLabel93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseClicked
        // TODO add your handling code here:
        int confirm = JOptionPane.showOptionDialog(
            null, "Are you sure you want to log out?", "Confirm Logout",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (confirm == JOptionPane.YES_OPTION) {
            // Close the current JFrame
            this.dispose();

            // Open the login JFrame
            LoginPage login = new LoginPage();
            login.setLocationRelativeTo(null); // centers JFrame2
            login.setVisible(true);

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
        }
    }//GEN-LAST:event_jLabel93MouseClicked

    private void jLabel93MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel93MouseEntered

    private void jLabel93MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel93MouseExited

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
            java.util.logging.Logger.getLogger(TimeOut.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TimeOut.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TimeOut.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TimeOut.class
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
                new TimeOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_IssueDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JTextField lbl_contact;
    private javax.swing.JTextField lbl_section;
    private javax.swing.JTextField lbl_studentId;
    private javax.swing.JTextField lbl_studentName;
    private javax.swing.JTextField lbl_timein;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JTextField txt_studentId;
    private javax.swing.JTextField txt_studentId14;
    private javax.swing.JTextField txt_studentId15;
    private javax.swing.JTextField txt_studentId16;
    private javax.swing.JTextField txt_studentId17;
    // End of variables declaration//GEN-END:variables

}
