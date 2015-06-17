package LightBot;

import LightBot.actions.Allumer;
import LightBot.actions.Avancer;
import LightBot.actions.PoserBloc;
import LightBot.actions.RetirerBloc;
import LightBot.actions.TournerGauche;
import LightBot.cases.Case;
import LightBot.cases.Lampe;
import LightBot.cases.Normal;
import LightBot.personnage.Pcardinaux;
import LightBot.personnage.Personnage;


public class TestProg4 extends Niveau{

	public static void main(String[] pArgs){
		new TestProg4();
	}
	
	public TestProg4(){
		super();
		this.setTerrain(new Terrain(5,5));
		Case[][] cases=this.getTerrain().getEnsembleDeCase();
		
		cases[0][0]=new Normal(2);
		cases[1][0]=new Normal(2);
		cases[1][1]=new Normal(2);
		cases[1][2]=new Normal(2);
		cases[2][1]=new Normal(2);
		cases[4][4]=new Normal(2);
		cases[2][2]=new Lampe(2);			
		
		this.getTerrain().setEnsembleDeCase(cases);
		
		Personnage robot=new Personnage("Robot",4, 4, Pcardinaux.NORTH);
		robot.setTerrain(this.getTerrain());
		this.getPersonnages().add(robot);
		
		Programme progMain=new Programme("main",10);
		/*progMain.insererQueue(new Avancer(robot));
		progMain.insererQueue(new Avancer(robot));
		progMain.insererQueue(new PoserBloc(robot));
		progMain.insererQueue(new TournerGauche(robot));
		progMain.insererQueue(new Avancer(robot));
		progMain.insererQueue(new Allumer(robot));*/
		progMain.insererQueue(new PoserBloc(robot));
		progMain.insererQueue(new PoserBloc(robot));
		progMain.insererQueue(new RetirerBloc(robot));
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
