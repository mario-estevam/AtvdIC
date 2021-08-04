package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class TipperTest {

	public static void main(String[] args) {
		
		FIS fis = FIS.load("src/resource/tipperCovid.fcl", true); // MANDANI
	
			
		//APRESENTA AS VARIVEIS MODELADAS
        JFuzzyChart.get().chart(fis.getFunctionBlock("teste"));
		
        //SETA AS ENTRADAS
	    fis.setVariable("Setor",30);
	    fis.setVariable("QtdPessoas", 12);
	    
	    //AVALIA
	    fis.evaluate();

	    //MOSTRA O CONJUNTO DE SAIDA PARA A VARIAVEL A PARTIR DE UMA MEDIA PONDERADA POIS ESTÁ SENDO UTILZIADA O COG
        Variable percentual = fis.getFunctionBlock("teste").getVariable("Aglomeracao");
        JFuzzyChart.get().chart(percentual, percentual.getDefuzzifier(), true);

        //PRINTA VARIÃVEL DE SAÃ�DA    
        System.out.println(percentual.getValue());
        
        //MOSTRA CADA REGRA COM O VALOR DE
        for( Rule r : fis.getFunctionBlock("teste").getFuzzyRuleBlock("No1").getRules() )
          System.out.println(r);
	}

}
