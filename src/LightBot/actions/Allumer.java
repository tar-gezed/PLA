package LightBot.actions;

import LightBot.cases.Allumable;
import LightBot.cases.Case;
import LightBot.cases.Condition;
import LightBot.cases.Couleur;
import LightBot.cases.Lampe;
import LightBot.cases.Pointeur;
import LightBot.personnage.Personnage;


public class Allumer extends Actions {

	public Allumer(Personnage p) {
		super(p);
	}
	
	public Allumer(Personnage p, Couleur c){
		super(p,c);
	}
	
	public String toString(){
		if(this.couleurCondition==Couleur.Violet || this.couleurCondition==Couleur.Rose){
			return "Allumer cond.";
		}else if(this.couleurCondition == Couleur.Vert){
			return "Allumer Pointeur";
		}else{
			return "Allumer";
		}
	}

	@Override
	public void agir() {
		if(super.matchColor()){
			Case C = this.perso.getTerrain().getEnsembleDeCase()[this.perso.getPositionX()][this.perso.getPositionY()];
			int nbLampeAllumee=this.perso.getTerrain().getNbLampeAllumee();
			if (C instanceof Lampe){
				switch(C.getColor()){
				case Bleu:
					C.setColor(Couleur.Jaune);
					this.perso.getTerrain().setNbLampeAllumee(nbLampeAllumee+1);
					break;
				case Jaune:
					C.setColor(Couleur.Bleu);
					this.perso.getTerrain().setNbLampeAllumee(nbLampeAllumee-1);
					break;
				default:break;
				}
			}
			else if (C instanceof Pointeur){
				Case temp;
				temp = ((Pointeur) C).getSuivante();
				if (temp != null)
					this.perso.setPosition(this.perso.getTerrain().getPosCaseX(temp), this.perso.getTerrain().getPosCaseY(temp));
			}
			else if(C instanceof Condition){
				if(this.perso.getCouleur()!=Couleur.Blanc)this.perso.setCouleur(Couleur.Blanc);
				else this.perso.setCouleur(C.getColor());
			}
		}
	}
}
