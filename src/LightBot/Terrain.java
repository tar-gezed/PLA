package LightBot;

import LightBot.cases.Case;
import LightBot.cases.Lampe;
import LightBot.personnage.Pcardinaux;


public class Terrain {
	
/********************************************* ATTRIBUTS *********************************************/

	private int largeur;
	private int longueur;
	private int nbActionsPossible;
	private int nbLampeAllumee=0;
	private int maxAllumee;
	private Case[][] ensembleDeCase;			//Tableau à 2 dimensions de cases représentant le terrain
	
/********************************************* ACCESSEURS *********************************************/
	
	public int getLargeur() {
		return largeur;
	}
	
	public int getLongueur() {
		return longueur;
	}

	public int getNbActionsPossible() {
		return nbActionsPossible;
	}
	
	public Case[][] getEnsembleDeCase() {
		return ensembleDeCase;
	}
	
	public int getNbLampeAllumee(){
		return this.nbLampeAllumee;
	}
	
	public int getMaxLampe(){
		return this.maxAllumee;
	}
	
	public int getHauteurMax(){
		int max = 0;
		for(int i = 0 ; i < this.largeur ; i++){
			for(int j = 0; j < this.longueur ; j++){
				int h = this.ensembleDeCase[i][j].getHauteur();
				if(h > max){
					max = h;
				}
			}
		}
		return max;
	}
	
	
/********************************************* MUTATEURS *********************************************/

	public void setLargeur(int pLargeur) {
		this.largeur = pLargeur;
	}

	public void setLongueur(int pLongueur) {
		this.longueur = pLongueur;
	}

	public void setNbActionsPossible(int pNbActionsPossible) {
		this.nbActionsPossible = pNbActionsPossible;
	}

	public void setEnsembleDeCase(Case[][] pEnsembleDeCase) {
		this.ensembleDeCase = pEnsembleDeCase;
		this.setMaxLampe();
	}
	
	public void setMaxAllumee(int i){
		if(this.maxAllumee!=i)this.maxAllumee=i;
	}
	
	private void setMaxLampe(){
		this.maxAllumee=0;
		for(int i=0;i<largeur;i++)
			for(int j=0;j<longueur;j++)
				if(this.ensembleDeCase[i][j] instanceof Lampe)this.maxAllumee++;
	}
	
	public void setNbLampeAllumee(int i){
		this.nbLampeAllumee=i;
	}
	
	public void affiche(){
		for(int y=0;y<largeur;y++){
			for(int x=0;x<longueur;x++)
				if(this.ensembleDeCase[x][y]==null)System.out.print("null ");
				else System.out.print(this.ensembleDeCase[x][y].getColor()+" ");
				//if(this.ensembleDeCase[x][y]!=null) System.out.print("("+x+","+y+")"+this.ensembleDeCase[x][y].getColor()+" ");
			System.out.println("");
		}
	}
	
	public void printTerm(){
		System.out.print("\n");
		String ligne = "";
		for(int i=0; i<(this.largeur*2)+1 ; i++){
			ligne = ligne+"–";
		}
		System.out.println(ligne);
		for(int i=0 ; i<largeur ; i++){
			for(int j=0 ; j<longueur ; j++){
				System.out.print("|");
				ensembleDeCase[j][i].printTerm();
			}
			System.out.print("|\n");
		}
		System.out.println(ligne);
	}
	
/********************************************* METHODES D'INSTANCE *********************************************/
	
	//Constructeur de l'objet Terrain
	public Terrain(int pLargeur, int pLongueur, int pNbActionsPossible, Case[][] pEnsembleDeCase){
		largeur = pLargeur;
		longueur = pLongueur;
		nbActionsPossible = pNbActionsPossible;
		ensembleDeCase = pEnsembleDeCase;
	}
	
	public Terrain(int largeur, int longueur){
		this.longueur=longueur;
		this.largeur=largeur;
		this.ensembleDeCase=new Case[largeur][longueur];
		initCase();
	}
	
	private void initCase(){
		for(int i=0 ; i<largeur ; i++){
			for(int j=0; j<longueur ; j++){
				this.ensembleDeCase[i][j].setHauteur(0);
			}
		}
	}

}
