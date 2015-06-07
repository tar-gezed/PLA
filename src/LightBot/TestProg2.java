package LightBot;

import LightBot.actions.Allumer;
import LightBot.actions.Avancer;
import LightBot.actions.TournerGauche;
import LightBot.cases.Case;
import LightBot.cases.Lampe;
import LightBot.cases.Normal;
import LightBot.personnage.Pcardinaux;
import LightBot.personnage.Personnage;


public class TestProg2 extends Niveau{

	public static void main(String[] pArgs){
		new TestProg2();
	}
	
	public TestProg2(){
		super();
		this.setTerrain(new Terrain(5,5));
		Case[][] cases=this.getTerrain().getEnsembleDeCase();
		
		cases[1][0]=new Normal(2);
		cases[1][1]=new Normal(2);
		cases[1][2]=new Normal(2);
		cases[2][2]=new Lampe(2,false);			
		
		this.getTerrain().setEnsembleDeCase(cases);
		
		Personnage robot=new Personnage(1, 0, Pcardinaux.SOUTH);
		robot.setTerrain(this.getTerrain());
		this.getPersonnages().add(robot);
		
		Programme progMain=new Programme("main",10);
		progMain.inserer(new Avancer(robot), 0);
		progMain.inserer(new Avancer(robot), 1);
		progMain.inserer(new TournerGauche(robot), 2);
		progMain.inserer(new Avancer(robot), 3);
		progMain.inserer(new Allumer(robot), 4);
		this.getProgrammes().add(progMain);

		robot.setProgramme(progMain);
		
		System.out.println("Terrain de base avant exécution");
		System.out.println("Position du robot: (x="+robot.getPositionX()+",y="+robot.getPositionY()+")");
		this.getTerrain().affiche();
		robot.run();		
		System.out.println("Terrain après exécution");
		System.out.println("Position du robot: (x="+robot.getPositionX()+",y="+robot.getPositionY()+")");
		this.getTerrain().affiche();	
		
	}
	
}
