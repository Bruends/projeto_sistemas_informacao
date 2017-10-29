package classes;




import classesDAO.ContaPagarDAO;
import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lusca
 */
public class GraficoDeBarra {
    //criar o dataset
    public CategoryDataset createDataSetMeses(ArrayList<MesContaPagar> meses){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for ( MesContaPagar mes : meses ) {            
            dataSet.addValue(mes.getContaPagar().getValor(), mes.getNome(), "");  
        }
        return dataSet;
    }
    
    public CategoryDataset createDataSetAnos(ArrayList<AnoContaPagar> anos){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for ( AnoContaPagar ano : anos ) {            
            dataSet.addValue(ano.getSomaValores(), ano.getAno(), "");  
        }
        return dataSet;
    }
    
   
    //criar o grafico de barras
    public JFreeChart createBarChartMeses(CategoryDataset dataSet){
        JFreeChart graficoBarras = ChartFactory.createBarChart("Gastos por mês", "", "Valor R$", dataSet,PlotOrientation.VERTICAL,true,false,false);
        return graficoBarras;
    }        
    
    public JFreeChart createBarChartAno(CategoryDataset dataSet){
        JFreeChart graficoBarras = ChartFactory.createBarChart("Gastos anuais", "", "Valor R$", dataSet,PlotOrientation.VERTICAL,true,false,false);
        return graficoBarras;
    }
    
    public JFreeChart createBarChartAnoIntervalo(CategoryDataset dataSet){
        JFreeChart graficoBarras = ChartFactory.createBarChart3D("Gastos anuais por intervalo de anos", "", "Valor R$", dataSet,PlotOrientation.VERTICAL,true,false,false);
        return graficoBarras;
    }
    
    //criar o grfico completo
    public ChartPanel criarGrafico(ArrayList<MesContaPagar> meses ){
        CategoryDataset dataset = this.createDataSetMeses(meses);
        
        JFreeChart grafico = this.createBarChartMeses(dataset);
        
        ChartPanel painelDoGrafico = new ChartPanel(grafico);
        painelDoGrafico.setPreferredSize( new Dimension(400, 600) );
        
        
        return painelDoGrafico;
    }
    
    
    public ChartPanel criarGraficoAnual(ArrayList<AnoContaPagar> anos ){
        CategoryDataset dataset = this.createDataSetAnos(anos);
        
        JFreeChart grafico = this.createBarChartAno(dataset);
        
        ChartPanel painelDoGrafico = new ChartPanel(grafico);
        painelDoGrafico.setPreferredSize( new Dimension(400, 600) );
        
        
        return painelDoGrafico;
    }
    
    public ChartPanel criarGraficoAnualIntervalo(ArrayList<AnoContaPagar> anos ){
        CategoryDataset dataset = this.createDataSetAnos(anos);
        
        JFreeChart grafico = this.createBarChartAnoIntervalo(dataset);
        
        ChartPanel painelDoGrafico = new ChartPanel(grafico);
        painelDoGrafico.setPreferredSize( new Dimension(400, 600) );
        
        
        return painelDoGrafico;
    }
    
}
