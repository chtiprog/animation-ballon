import javax.swing.JFrame;


public class FenetreBallonFoot extends JFrame {
	PanneauBallon pan = new PanneauBallon();
	private int x, y; // coordonnées de départ
	private boolean backY = false;
	final double g = 9.81;  // champ d'apesanteur terrestre
	private int hauteur;

	public FenetreBallonFoot(){
		this.setTitle("Ballon de Foot");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.setContentPane(pan);
		hauteur = pan.getHeight();

		this.setVisible(true);
		
		go();

	} // fin constructeur

	/**
	 * Méthode qui lance l'animation
	 * Appelle les méthodes tombe() et rebond()
	 */
	private void go() {
		x = pan.getPosX(); y = pan.getPosY();
		// initialisation des variables servant de paramètres à la méthode go()
		double v0 = 30;
		double degres = 20;
		double angle = degres * Math.PI/180; // Conversion car la méthode cos et sin de Math est en radian
		double vX = v0 * Math.cos(angle);  // vecteur vitesse horizontal
		double vY = v0 * Math.sin(angle);  // vecteur vitesse vertical

		while(x < ( pan.getWidth() - pan.getLargeur() ) ){ // tant qu'on ne touche pas le bord droit

			if (y > pan.getHeight() - pan.getHauteur()) backY = true ; // On rebondit quand on touche le bord bas
			if( !backY ){
				tombe(angle, vX);
			} // fin du if(ballon n'a pas atteint le bord bas)
			else{
				rebond(angle, vX);
			} // fin du else

			pan.repaint();

			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}

		} // fin du while infini


	} // fin méthode go

	/**
	 * méthode qui fait tomber le ballon
	 * @param angle : angle du lancé
	 * @param vX : vecteur vitesse horizontal
	 */
	private void tombe(double angle, double vX) {
		int t = 0;
		while( y < pan.getHeight() - pan.getHauteur()){
			++t;
			x = (int) (vX * t);
			int y2 = (int) ((vX * t) - (g *(t*t) / 2));
			y = -y2;                        // le repère d'un écran fonctionne à l'opposé d'un repère orthonormé mathématique
			pan.setPosX(x); pan.setPosY(y);
			pan.repaint();
			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
		}
	} // fin méthode tombe

/**
 * méthode qui fait remonter le ballon
 * @param angle : angle du lancé
 * @param vX : vecteur vitesse horizontal
 */
	private void rebond(double angle, double vX) {
		int t = 0;
		while( y > hauteur * 10/100){
			++t;
			x = x + (int) (vX * t); 
			y = y - (int) ((vX * t) - (g *(t*t) / 2));
			pan.setPosX(x); pan.setPosY(y);
			pan.repaint();
			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
		}
		hauteur = hauteur * 90/100;
		backY = false;

	} // fin méthode rebond

	// TODO méthode collision




} // FIN DE LA CLASSE FENETREBALLONFOOT
