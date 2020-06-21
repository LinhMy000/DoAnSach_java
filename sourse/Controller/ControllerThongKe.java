package Controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import Model.ModelThongKe;
import Table.ThongKeDoanhThu;
import Table.ThongKeSach;

public class ControllerThongKe {

	public void setChart(JComboBox cbb, JPanel jpnItem) {
		setChartSach(jpnItem);
		cbb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (cbb.getSelectedItem().toString()) {
				case "Sach ban chay nhat": {
					setChartSach(jpnItem);
					break;
				}
				case "Tac gia duoc yeu thich nhat": {
					setChartTacGia(jpnItem);
					break;
				}
				case "Doanh thu theo thang": {
					setChartDoanhThuThang(jpnItem);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + cbb.getSelectedItem().toString());
				}
			}
		});
    }
	
	public void setChartSach(JPanel jpnItem) {
        List<ThongKeSach> listItem = ModelThongKe.getThongKeSach();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThongKeSach item : listItem) {
                dataset.addValue(item.getSl(), "Sach", item.getTen());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Bieu do thong ke sach ban chay nhat".toUpperCase(),
                "Ten sach", "So luong",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
	
	public void setChartTacGia(JPanel jpnItem) {
        List<ThongKeSach> listItem = ModelThongKe.getThongKeTacGia();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThongKeSach item : listItem) {
                dataset.addValue(item.getSl(), "Tac gia", item.getTen());
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Bieu do thong ke tac gia duoc yeu thich nhat".toUpperCase(),
                "Tac gia", "So luong",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 500));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
	
	public void setChartDoanhThuThang(JPanel jpnItem) {
        List<ThongKeDoanhThu> listItem = ModelThongKe.getThongKeDoanhThuThang();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (listItem != null) {
            for (ThongKeDoanhThu item : listItem) {
                dataset.addValue(item.getTien(), "Doanh thu", "Thang " + String.valueOf(item.getTime()));
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Bieu do thong ke doanh thu theo thang".toUpperCase(),
                "Nam 2020", "Doanh thu",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 500));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();
    }
}
