import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class PanneauBallon extends JPanel {

	private int posX = 0; // position initiale du ballon
	private int posY = 0; // position initiale du ballon
	
	private int largeur = 50; // taille initiale du ballon
	private int hauteur = 50; // taille initiale du ballon
	
	private int incrementation = 0;
	
	public void paintComponent(Graphics g){
		// carré blanc pour effacer les traces du ballon animé
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.black);
		g.fillOval(posX, posY, largeur, hauteur);
		
		
	} // fin méthode paintComponent
	
	/*--------------------------------------------------------------------------
	 * 									MUTATEURS
	 */
	
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	/*--------------------------------------------------------------------------
	 * 									ACCESSEURS
	 */

	public int getHauteur() {
		return hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

} // FIN CLASSE PANNEAUBALLON
