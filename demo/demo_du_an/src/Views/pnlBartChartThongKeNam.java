/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import ViewModels.ThongKeNamViewModels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author tuyenPham
 */
public class pnlBartChartThongKeNam extends javax.swing.JPanel {

    /**
     * Creates new form panelBartChart
     */
    public pnlBartChartThongKeNam(ArrayList<ThongKeNamViewModels> ds) {
        initComponents();
        showbartDoanhThu(ds);
       
    }
    void showbartDoanhThu(ArrayList<ThongKeNamViewModels> ds) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        ThongKeNamViewModels x = new ThongKeNamViewModels();
        if (ds.size() == 1) {
            x.setNam(ds.get(0).getNam() + 1);
        }
        
        ds.add(x);
        for (ThongKeNamViewModels d : ds) {
            dataSet.setValue(d.getDoanhThu(), "năm", d.getNam() + "");
        }

        JFreeChart chart = ChartFactory.createBarChart("Biểu đồ doanh thu", "Năm",
                "", dataSet, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot cate = chart.getCategoryPlot();
        cate.setBackgroundPaint(Color.WHITE);
//        BarRenderer renderer = (BarRenderer) cate.getRenderer();
//        Color clr3 = new Color(204, 0, 51);
//        renderer.setSeriesPaint(0, clr3);

        ChartPanel chartPanel = new ChartPanel(chart);
        paneldoanhthu.removeAll();
        paneldoanhthu.add(chartPanel, BorderLayout.CENTER);
        paneldoanhthu.validate();
//        pnlNam.setVisible(true);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneldoanhthu = new javax.swing.JPanel();

        paneldoanhthu.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneldoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneldoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel paneldoanhthu;
    // End of variables declaration//GEN-END:variables
}
