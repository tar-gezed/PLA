package LightBot.actions;

import LightBot.Terrain;
import LightBot.cases.Case;
import LightBot.cases.Couleur;
import LightBot.cases.Transparente;
import LightBot.personnage.Personnage;

public class Swap extends Actions {

	public Swap(Personnage p) {
		super(p);
	}
	
	public Swap(Personnage p, Couleur c){
		super(p,c);
	}

	public void agir(){
		if(matchColor()){
		// Mettre une gestion de la couleur pour ne pouvoir faire un swap que si on est colorisé		
			Terrain t = this.perso.getTerrain();
			Case actuelle;
			int x = this.perso.getPositionX();
			int y = this.perso.getPositionY();
			
			actuelle = t.getEnsembleDeCase()[x][y];
			if(actuelle instanceof Transparente){
				switch(this.perso.getOrientation()){
					case EAST :
						if ((x+1) < t.getLargeur()){
							Case devant = t.getEnsembleDeCase()[x+1][y];
							if(devant instanceof Transparente){
								t.getEnsembleDeCase()[x][y] = devant;
								t.getEnsembleDeCase()[x+1][y] = actuelle;
							}
						}
						break;
					case SOUTH :
						if ((y+1) < t.getLongueur()){
							Case devant = t.getEnsembleDeCase()[x][y+1];
							if(devant instanceof Transparente){
								t.getEnsembleDeCase()[x][y] = devant;
								t.getEnsembleDeCase()[x][y+1] = actuelle;
							}
						}
						break;
					case WEST : 
						if ((x-1) >= 0){
							Case devant = t.getEnsembleDeCase()[x-1][y];
							if(devant instanceof Transparente){
								t.getEnsembleDeCase()[x][y] = devant;
								t.getEnsembleDeCase()[x-1][y] = actuelle;
							}
						}
						break;
					case NORTH :
						if ((y-1) >= 0){
							Case devant = t.getEnsembleDeCase()[x][y-1];
							if(devant instanceof Transparente){
								t.getEnsembleDeCase()[x][y] = devant;
								t.getEnsembleDeCase()[x][y-1] = actuelle;
							}
						}
						break;
					default:break;
				}
			}
		}
	}
}
