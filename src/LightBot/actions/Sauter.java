package LightBot.actions;

import LightBot.Terrain;
import LightBot.cases.Couleur;
import LightBot.personnage.Pcardinaux;
import LightBot.personnage.Personnage;

public class Sauter extends Actions {

	public Sauter(Personnage p) {
		super(p);
	}
	
	public Sauter(Personnage p, Couleur c){
		super(p,c);
	}
	
	public String toString(){
		if(this.couleurCondition==Couleur.Violet || this.couleurCondition==Couleur.Rose)return "Sauter cond.";
		return "Sauter";
	}
	
	@Override
	public Sauter clone() throws CloneNotSupportedException{
		Sauter copie=(Sauter)super.clone();
		return copie;
	}

	@Override
	public void agir() {
		if(matchColor()){
			Pcardinaux o = this.perso.getOrientation();
			Terrain T = this.perso.getTerrain();
			int x = this.perso.getPositionX();
			int y = this.perso.getPositionY();
			int h = T.getEnsembleDeCase()[x][y].getHauteur();
			
			switch(o){
				case EAST :
					if ((x+1)<T.getLargeur()){
						if(h-1 == T.getEnsembleDeCase()[x+1][y].getHauteur()||h+1 == T.getEnsembleDeCase()[x+1][y].getHauteur()){
							this.perso.setPositionX(x+1);
						}
					}else {this.perso.setMort(true);}
					break;
				case SOUTH :
					if ((y+1)<T.getLongueur()){
						if(h-1 == T.getEnsembleDeCase()[x][y+1].getHauteur() || h+1 == T.getEnsembleDeCase()[x][y+1].getHauteur()){
							this.perso.setPositionY(y+1);
						}
					}else{this.perso.setMort(true);}
					break;
				case WEST : 
					if ((x-1)>=0){
						if(h-1 == T.getEnsembleDeCase()[x-1][y].getHauteur() || h+1 == T.getEnsembleDeCase()[x-1][y].getHauteur()){
							this.perso.setPositionX(x-1);
						}
					}else{this.perso.setMort(true);}
					break;
				case NORTH :
					if ((y-1)>=0 ){
						if(h-1 == T.getEnsembleDeCase()[x][y-1].getHauteur() || h+1 == T.getEnsembleDeCase()[x][y-1].getHauteur()){
							this.perso.setPositionY(y-1);
						}
					}else{this.perso.setMort(true);}
					break;
				default:break;
			}

			if(T.getEnsembleDeCase()[this.perso.getPositionX()][this.perso.getPositionY()].getHauteur() == 0){
				this.perso.setMort(true);				
			}
		}
	}

}
