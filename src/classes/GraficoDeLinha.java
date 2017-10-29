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
import org.jfree.data.xy.XYSeries;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lusca
 */
public class GraficoDeLinha {
    //criar o dataset
    public CategoryDataset createDataSetCrescimentoMeses(ArrayList<PercentualCrescimentoMes> percentuais){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for ( PercentualCrescimentoMes percentual : percentuais ) {            
            dataSet.addValue(percentual.getCrescimentoPorcentagem(), percentual.getIntervaloMeses(), "");              
        }
        
        return dataSet;
    }
    
    public CategoryDataset createDataSetCrescimentoAnos(ArrayList<PercentualCrescimentoAno> percentuais ){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();        
                        
        for ( PercentualCrescimentoAno percentual : percentuais ) {            
            dataSet.addValue(percentual.getPorcentagemDeCrescimento(), percentual.getIntervaloDeAnos()+" ", "");              
        }
        
        return dataSet;
    }
    
   
    //criar o grafico de barras
    
    
    public JFreeChart createLineChartCrescimentoAnoIntervalo(CategoryDataset dataSet){
        JFreeChart graficoBarras = ChartFactory.createBarChart3D("Crescimento de gastos anuais", "", "Porcentual %", dataSet,PlotOrientation.VERTICAL,true,true,false);                
        return graficoBarras;
    }
    
    public JFreeChart createLineChartCrescimentoMesIntervalo(CategoryDataset dataSet){
        JFreeChart graficoBarras = ChartFactory.createBarChart3D("Crescimento de gastos por mês", "", "Porcentual %", dataSet,PlotOrientation.VERTICAL,true,true,false);                
        return graficoBarras;
    }
    
    //criar o grfico completo
    
    
    
    
    
    public ChartPanel criarGraficoCrescimentoAnual(ArrayList<PercentualCrescimentoAno> percentuais ){
        CategoryDataset dataset = this.createDataSetCrescimentoAnos(percentuais);
        
        JFreeChart grafico = this.createLineChartCrescimentoAnoIntervalo(dataset);
        
        ChartPanel painelDoGrafico = new ChartPanel(grafico);
        painelDoGrafico.setPreferredSize( new Dimension(400, 600) );
        
        
        return painelDoGrafico;
    }
    
    public ChartPanel criarGraficoCrescimentoPorMes(ArrayList<PercentualCrescimentoMes> percentuais ){
        CategoryDataset dataset = this.createDataSetCrescimentoMeses(percentuais);
        
        JFreeChart grafico = this.createLineChartCrescimentoAnoIntervalo(dataset);
        
        ChartPanel painelDoGrafico = new ChartPanel(grafico);
        painelDoGrafico.setPreferredSize( new Dimension(400, 600) );
        
        
        return painelDoGrafico;
    }
    
}
