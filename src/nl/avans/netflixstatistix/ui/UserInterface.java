/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.netflixstatistix.ui;

import nl.avans.netflixstatistix.NetflixStatistix;
import nl.avans.netflixstatistix.programs.Episode;
import nl.avans.netflixstatistix.programs.Movie;
import nl.avans.netflixstatistix.programs.Series;
import nl.avans.netflixstatistix.subscribers.Profile;
import nl.avans.netflixstatistix.subscribers.Subscriber;
import nl.avans.netflixstatistix.subscribers.View;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author rowan & teun
 */
public class UserInterface extends javax.swing.JFrame {

    /**
     * Creates new form UserInterface
     */
    public UserInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JInternalFrame();
        buttonPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        textPanel = new javax.swing.JPanel();
        scrollPanel = new javax.swing.JScrollPane();
        mainText = new javax.swing.JTextPane();
        showPanel = new javax.swing.JPanel();
        boxPanel = new javax.swing.JScrollPane();
        textDisplay = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        serieBox = new javax.swing.JComboBox<>();
        accountBox = new javax.swing.JComboBox<>();
        filmBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Netflix Statistix");
        setBackground(new java.awt.Color(185, 9, 11));

        panelMain.setBackground(new java.awt.Color(185, 9, 11));
        panelMain.setTitle("Netflix Statistix");
        panelMain.setFocusable(false);
        panelMain.setVisible(true);

        buttonPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Serie overzicht");
        jButton1.setToolTipText("Het gemiddelde bekeken % van de tijdsduur.");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Account overzicht");
        jButton2.setToolTipText("Selecteer een serie om het bekeken % van de tijdsduur te zien.");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Film overzicht");
        jButton3.setToolTipText("Films die bekeken door het account");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Film met de langste tijdsduur< 16 jaar");
        jButton4.setToolTipText("De film met de langste tijdsduur voor kijkers onder 16 jaar.");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Accounts met 1 profiel");
        jButton5.setToolTipText("De accounts met 1 profiel.");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Bekijk de hoeveelheid kijkers van een film");
        jButton6.setToolTipText("Hoeveelheid kijkers van de geselecteerde film.");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(buttonPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                                        .addContainerGap(18, Short.MAX_VALUE)))
        );
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(351, Short.MAX_VALUE))
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(buttonPanelLayout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        textPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textPanel.setPreferredSize(new java.awt.Dimension(474, 130));

        mainText.setEditable(false);
        mainText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mainText.setText("Welkom op de Netflix Statistix applicatie.\n\nOp deze applicatie kunt u verschillende informatie vinden over netflix. De knoppen hieronder wijzen naar de gevraagde informatie.");
        scrollPanel.setViewportView(mainText);

        javax.swing.GroupLayout textPanelLayout = new javax.swing.GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
                textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(textPanelLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        textPanelLayout.setVerticalGroup(
                textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                .addContainerGap())
        );

        showPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        textDisplay.setEditable(false);
        textDisplay.setColumns(20);
        textDisplay.setRows(5);
        textDisplay.setText("Klik op een van de knoppen om de informatie weer te geven");
        boxPanel.setViewportView(textDisplay);

        javax.swing.GroupLayout showPanelLayout = new javax.swing.GroupLayout(showPanel);
        showPanel.setLayout(showPanelLayout);
        showPanelLayout.setHorizontalGroup(
                showPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(showPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(boxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                                .addContainerGap())
        );
        showPanelLayout.setVerticalGroup(
                showPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(showPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(boxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextPane1.setText("Netflix Statistix                                \t\t\t\t\t\tInformatica 2018, 23IVT1B1, Rowan, Teun, Rick en Lars");
        jScrollPane1.setViewportView(jTextPane1);

        serieBox.setModel(new javax.swing.DefaultComboBoxModel<>(NetflixStatistix.getPrograms().getNames(Series.class)));
        serieBox.setEnabled(false);
        serieBox.addActionListener(evt -> serieBoxActionPerformed(evt, (String) serieBox.getSelectedItem()));

        accountBox.setModel(new javax.swing.DefaultComboBoxModel<>(NetflixStatistix.getSubscribers().getSubscriberNames()));
        accountBox.setEnabled(false);
        accountBox.addActionListener(evt -> accountBoxActionPerformed(evt, (String) accountBox.getSelectedItem()));

        filmBox.setModel(new javax.swing.DefaultComboBoxModel<>(NetflixStatistix.getPrograms().getNames(Movie.class)));
        filmBox.setEnabled(false);
        filmBox.addActionListener(evt -> filmBoxActionPerformed(evt, (String) filmBox.getSelectedItem()));

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain.getContentPane());
        panelMain.getContentPane().setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                                .addComponent(showPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(25, 25, 25))))
                        .addGroup(panelMainLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(textPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(serieBox, 0, 233, Short.MAX_VALUE)
                                        .addComponent(accountBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(filmBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
                panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(textPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelMainLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(serieBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(accountBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(filmBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(showPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelMain)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        this.currentScreen = 1;
        this.updateScreen();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        textDisplay.setText("Hello world");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.currentScreen = 2;
        this.updateScreen();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        this.currentScreen = 3;
        this.updateScreen();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        this.currentScreen = 4;
        this.updateScreen();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        this.currentScreen = 5;
        this.updateScreen();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        this.currentScreen = 6;
        this.updateScreen();
        serieBox.setEnabled(false);
        filmBox.setEnabled(true);
        accountBox.setEnabled(false);
    }//GEN-LAST:event_jButton6MouseClicked

    private void serieBoxActionPerformed(java.awt.event.ActionEvent evt, String clicked)
    {
        this.updateScreen();
    }

    private void accountBoxActionPerformed(java.awt.event.ActionEvent evt, String clicked)
    {
        this.updateScreen();
    }

    private void filmBoxActionPerformed(java.awt.event.ActionEvent evt, String clicked)
    {
        this.updateScreen();
    }

    private int currentScreen;

    public void updateScreen()
    {
        switch(this.currentScreen)
        {
            case 1:
                this.loadSeriesOverview();
                return;
            case 2:
                this.loadAccountOverview();
                return;
            case 3:
                this.loadMoviesOverview();
                return;
            case 4:
                this.loadMovieUnder16();
                return;
            case 5:
                this.loadAccountsWithOneProfile();
                return;
            case 6:
                this.loadMovieViewCount();
                return;
        }
    }

    public void loadMovieViewCount()
    {
        serieBox.setEnabled(false);
        filmBox.setEnabled(false);
        accountBox.setEnabled(false);

        String moviestr = (String) filmBox.getSelectedItem();
        int id;
        try
        {
            id = Integer.parseInt(moviestr.split(". ")[0]);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            textDisplay.setText("Kon film niet laden");
            return;
        }
        Movie m = NetflixStatistix.getPrograms().getMovie(id);
        if(m == null)
        {
            textDisplay.setText("Kon film niet laden");
            return;
        }
        int i = 0;
        for(Subscriber s : NetflixStatistix.getSubscribers().getSubscribers())
        {
            for(Profile p : s.getProfiles().values())
            {
                for(View v : p.getViews())
                {
                    if(v.getProgram().getId() == m.getId())
                        i++;
                }
            }
        }

        textDisplay.setText("Aantal keer dat " + m.getTitle() + " bekeken is: " + i);
    }

    public void loadAccountsWithOneProfile()
    {
        serieBox.setEnabled(false);
        filmBox.setEnabled(false);
        accountBox.setEnabled(false);

        StringBuilder sb = new StringBuilder("Accounts met slechts één profiel:\n\n");

        for(Subscriber s : NetflixStatistix.getSubscribers().getAccountsWithOneProfile())
        {
            sb.append(s.getName() + "\n");
        }
        textDisplay.setText(sb.toString());
    }

    public void loadMovieUnder16()
    {
        serieBox.setEnabled(false);
        filmBox.setEnabled(false);
        accountBox.setEnabled(false);

        Movie m = NetflixStatistix.getPrograms().getMovieUnder16();
        textDisplay.setText("De langste film voor leeftijden onder 16 is... " + m.getTitle() + ", met een lengte van " + m.getTotalLength() + "min");
    }

    public void loadMoviesOverview()
    {
        serieBox.setEnabled(false);
        filmBox.setEnabled(false);
        accountBox.setEnabled(true);

        String substr = (String) accountBox.getSelectedItem();
        int subid;
        try
        {
             subid = Integer.parseInt(substr.split(". ")[0]);
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
            textDisplay.setText("Error on loading subscriber " + substr);
            return;
        }
        Subscriber sub = NetflixStatistix.getSubscribers().getSubscriber(subid);
        if(sub == null)
        {
            textDisplay.setText("Error on loading account " + substr);
            return;
        }
        ArrayList<Integer> ids = new ArrayList<>();
        StringBuilder sb = new StringBuilder("Alle bekeken films van profielen van account " + sub.getName() + "\n\n");
        for(Profile p : sub.getProfiles().values())
        {
            for(View v : p.getViews())
            {
                if(v.getEpisode() == null)
                {
                    if(!ids.contains(v.getProgram().getId()))
                        ids.add(v.getProgram().getId());
                    else
                        continue;
                    sb.append(v.getProgram().getTitle() + " (" + v.getProgram().getGenre() + "), lengte: " + v.getProgram().getTotalLength() + "min\n");
                }
            }
        }

        textDisplay.setText(sb.toString());
    }

    public void loadAccountOverview()
    {
        serieBox.setEnabled(true);
        filmBox.setEnabled(false);
        accountBox.setEnabled(false);
        String substr = (String) accountBox.getSelectedItem();
        int subid;
        try
        {
            subid = Integer.parseInt(substr.split(". ")[0]);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            textDisplay.setText("Error on loading account " + substr);
            return;
        }
        Subscriber sub = NetflixStatistix.getSubscribers().getSubscriber(subid);
        if(sub == null)
        {
            textDisplay.setText("Error on loading account " + substr);
            return;
        }

        String series = (String) serieBox.getSelectedItem();
        int sid;
        try {
            sid = Integer.parseInt(series.split(". ")[0]);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            textDisplay.setText("Error on loading series" + series);
            return;
        }
        Series s = NetflixStatistix.getPrograms().getSeries(sid);
        if(s == null)
        {
            textDisplay.setText("Series not found " + sid);
            return;
        }

        StringBuilder text = new StringBuilder("Afleveringen van de serie " + s.getTitle() + " die alle profielen van " + sub.getName() + " samen hebben gezien\n\n");

        Connection con = NetflixStatistix.getDatabase().getConnection();

        for(Episode e : s.getEpisodes().values())
        {
            int perc = sub.getAverageSeen(e);
            text.append(e.getId() + " " + e.getTitle() + " -> " + perc + "% samen gemiddeld bekeken tijdsduur\n");
        }

        textDisplay.setText(text.toString());
    }

    public void loadSeriesOverview()
    {
        serieBox.setEnabled(true);
        filmBox.setEnabled(false);
        accountBox.setEnabled(false);
        String series = (String) serieBox.getSelectedItem();
        int sid;
        try {
            sid = Integer.parseInt(series.split(". ")[0]);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            textDisplay.setText("Error on loading series");
            return;
        }
        Series s = NetflixStatistix.getPrograms().getSeries(sid);
        if(s == null)
        {
            textDisplay.setText("Series not found " + sid);
            return;
        }

        StringBuilder text = new StringBuilder("Afleveringen van de serie " + s.getTitle() + "\n\n");

        Connection con = NetflixStatistix.getDatabase().getConnection();

        for(Episode e : s.getEpisodes().values())
        {
            text.append(e.getId() + " " + e.getTitle() + " -> " + e.getAvgPercentage() + "% gemiddeld bekeken tijdsduur\n");
        }

        textDisplay.setText(text.toString());
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accountBox;
    private javax.swing.JScrollPane boxPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JComboBox<String> filmBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane mainText;
    private javax.swing.JInternalFrame panelMain;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JComboBox<String> serieBox;
    private javax.swing.JPanel showPanel;
    private javax.swing.JTextArea textDisplay;
    private javax.swing.JPanel textPanel;
    // End of variables declaration//GEN-END:variables
}
