import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MainFrame extends JFrame implements ActionListener{
	boolean started = false;

	private StickFigure figureA;
	private StickFigure figureB;
	private ArrayList<Ball> ballList;

	private int numBallsA, numBallsB;

	private char dirA, dirB;


	public MainFrame() {
		setTitle("Dodgeball");
		//getContentPane().setBackground(Color.black);

		setBounds(100,100,800,600);
		setLayout(null);

		figureA = new StickFigure(10,10, 'B');
		figureB = new StickFigure(300,300, 'W');

		numBallsA = 0;
		numBallsB = 0;

		add(figureA);
		add(figureB);

		ballList = new ArrayList<Ball>();

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_A && figureA.getX()-3>getContentPane().getX()) {
					figureA.setDx(-1); 
					dirA = 'L';
				}
				else if(e.getKeyCode() == e.VK_D && figureA.getX()+3+figureA.getWidth()<getContentPane().getX()+getContentPane().getWidth()) {
					figureA.setDx(1);
					dirA = 'R';
				}
				else if(e.getKeyCode() == e.VK_S && figureA.getY()+3+figureA.getHeight()<getContentPane().getY()+getContentPane().getHeight()) {
					figureA.setDy(1);
					dirA = 'D';
				}
				else if(e.getKeyCode() == e.VK_W && figureA.getY()-3>getContentPane().getY()) {
					figureA.setDy(-1);
					dirA = 'U';
				}
			

				if(e.getKeyCode() == e.VK_LEFT && figureB.getX()-3>getContentPane().getX()) {
					figureB.setDx(-1);
					dirB = 'L';
				}
				else if(e.getKeyCode() == e.VK_RIGHT && figureB.getX()+3+figureB.getWidth()<getContentPane().getX()+getContentPane().getWidth()) {
					figureB.setDx(1);
					dirB = 'R';
				}
				else if(e.getKeyCode() == e.VK_DOWN && figureB.getY()+3+figureB.getHeight()<getContentPane().getY()+getContentPane().getHeight()) {
					figureB.setDy(1);
					dirB = 'D';
				}
				else if(e.getKeyCode() == e.VK_UP && figureB.getY()-3>getContentPane().getY()) {
					figureB.setDy(-1);
					dirB = 'U';
				}
				

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == e.VK_A && figureA.getX()>getContentPane().getX())
					figureA.setDx(0);
				else if(e.getKeyCode() == e.VK_D && figureA.getX()+figureA.getWidth()<getContentPane().getX()+getContentPane().getWidth())
					figureA.setDx(0);
				else if(e.getKeyCode() == e.VK_S && figureA.getY()+figureA.getHeight()<getContentPane().getY()+getContentPane().getHeight())
					figureA.setDy(0);
				else if(e.getKeyCode() == e.VK_W && figureA.getY()>getContentPane().getY())
					figureA.setDy(0);
				else if(e.getKeyCode() == e.VK_E)
					fire('A');
			
				if(e.getKeyCode() == e.VK_LEFT)
					figureB.setDx(0);
				else if(e.getKeyCode() == e.VK_RIGHT)
					figureB.setDx(0);
				else if(e.getKeyCode() == e.VK_DOWN)
					figureB.setDy(0);
				else if(e.getKeyCode() == e.VK_UP)
					figureB.setDy(0);
				else if(e.getKeyCode() == e.VK_SPACE) 
					fire('B');
			
			}
			

		});

		Timer time = new Timer(2,this);
		time.start();

		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (figureA.getX()-3<getContentPane().getX() ||
				figureA.getX()+3+figureA.getWidth()>getContentPane().getX()+getContentPane().getWidth() ||
				figureA.getY()+3+figureA.getHeight()>getContentPane().getY()+getContentPane().getHeight() ||
				figureA.getY()-3<getContentPane().getY()) {
			figureA.setLocation(figureA.getLocation().x-figureA.getDx(), figureA.getLocation().y-figureA.getDy());
			figureA.setDx(0);
			figureA.setDy(0);
		}
		
		if (figureB.getX()-3<getContentPane().getX() ||
				figureB.getX()+3+figureB.getWidth()>getContentPane().getX()+getContentPane().getWidth() ||
				figureB.getY()+3+figureB.getHeight()>getContentPane().getY()+getContentPane().getHeight() ||
				figureB.getY()-3<getContentPane().getY()) {
			figureB.setLocation(figureB.getLocation().x-figureB.getDx(), figureB.getLocation().y-figureB.getDy());
			figureB.setDx(0);
			figureB.setDy(0);
		}
		if (figureA.getX()+1<getContentPane().getX()||
				figureA.getX()-1+figureA.getWidth()>getContentPane().getX()+getContentPane().getWidth() ||
				figureA.getY()-1+figureA.getHeight()>getContentPane().getY()+getContentPane().getHeight() ||
				figureA.getY()+1<getContentPane().getY()) {
			figureA.setLocation(10,10);
		}
		if (figureB.getX()+1<getContentPane().getX()||
				figureB.getX()-1+figureB.getWidth()>getContentPane().getX()+getContentPane().getWidth() ||
				figureB.getY()-1+figureB.getHeight()>getContentPane().getY()+getContentPane().getHeight() ||
				figureB.getY()+1<getContentPane().getY()) {
			figureB.setLocation(300,300);
		}
		figureA.update();
		figureB.update();
		for (int i = 0; i < ballList.size(); i++) {
			Ball ball = ballList.get(i);
			if (ball.getX()<getContentPane().getX() || 
					ball.getY()<getContentPane().getY() || 
					ball.getX()+ball.getWidth()>getContentPane().getX()+getContentPane().getWidth() ||
					ball.getY()+ball.getHeight()>getContentPane().getY()+getContentPane().getHeight()) {
				if (ball.getType() == 'A')
					numBallsA--;
				else
					numBallsB--;

				ballList.remove(ballList.indexOf(ball));
				remove(ball);
			}
			else {
				char result = isTouching(ball);
				if (result != 'N') {
					String end = "";
					if (result == 'A') end = "Arrow Key";
					else end = "W.A.S.D";
					JOptionPane pane = new JOptionPane();
					pane.showMessageDialog(null,"Game Over! The Winner is Player " + end);
					System.exit(0);


				}

			}

			ball.update();

		}

		repaint();

	}

	public void fire(char figLetter) {
		if (figLetter == 'A' && numBallsA < 3) {
			Ball ball = new Ball(figureA.getX(), figureA.getY(), 'A');
			ballList.add(ball);
			add(ball);
			ball.setVisible(true);

			if (dirA == 'R') ball.setDx(1);
			else if (dirA == 'L') ball.setDx(-1);
			else if (dirA == 'U') ball.setDy(-1);
			else if (dirA == 'D') ball.setDy(1);
			
			numBallsA++;
		}
		else if (figLetter == 'B' && numBallsB < 3){
			Ball ball = new Ball(figureB.getX(), figureB.getY(), 'B');
			ballList.add(ball);
			add(ball);
			ball.setVisible(true);
			
			if (dirB == 'R') ball.setDx(1);
			else if (dirB == 'L') ball.setDx(-1);
			else if (dirB == 'U') ball.setDy(-1);
			else if (dirB == 'D') ball.setDy(1);
			
			numBallsB++;
		}
	}

	public char isTouching (Ball ball) {
		char returnChar = 'N';		
		if (ball.getType() == 'A') {
			
			if ((figureB.getY()<(ball.getY()+ball.getHeight())) 
					&& (figureB.getX()<ball.getX()+ball.getWidth() && !(figureB.getX()+figureB.getWidth()<ball.getX()))
					&& (figureB.getY()+figureB.getHeight()>ball.getY())) {
				returnChar = 'B';
			}
			else if ((figureB.getY()+figureB.getHeight()>(ball.getY()))
					&& (figureB.getX()<ball.getX()+ball.getWidth() && !(figureB.getX()+figureB.getWidth()<ball.getX()))
					&& (figureB.getY()<ball.getY()+ball.getHeight())) {
				returnChar = 'B';
			}
			else if((figureB.getX()<(ball.getX()+ball.getWidth()))
					&& (figureB.getY()<ball.getY()+ball.getHeight() && !(figureB.getY()+figureB.getHeight()<ball.getY()))
					&& (figureB.getX()+figureB.getWidth()>ball.getX())){
				returnChar = 'B';
			}
			else if((figureB.getX()+figureB.getWidth()>(ball.getX()))
					&&(figureB.getY()<ball.getY()+ball.getHeight() && (figureB.getY()+figureB.getHeight()>ball.getY()))
					&& (figureB.getX()<ball.getX()+ball.getWidth())){
				returnChar = 'B';
			}
		}
		else {
			if ((figureA.getY()<(ball.getY()+ball.getHeight())) 
					&& (figureA.getX()<ball.getX()+ball.getWidth() && !(figureA.getX()+figureA.getWidth()<ball.getX()))
					&& (figureA.getY()+figureA.getHeight()>ball.getY())) {
				returnChar = 'A';
			}
			else if ((figureA.getY()+figureA.getHeight()>(ball.getY()))
					&& (figureA.getX()<ball.getX()+ball.getWidth() && !(figureA.getX()+figureA.getWidth()<ball.getX()))
					&& (figureA.getY()<ball.getY()+ball.getHeight())) {
				returnChar = 'A';
			}
			else if((figureA.getX()<(ball.getX()+ball.getWidth()))
					&& (figureA.getY()<ball.getY()+ball.getHeight() && !(figureA.getY()+figureA.getHeight()<ball.getY()))
					&& (figureA.getX()+figureA.getWidth()>ball.getX())){
				returnChar = 'A';
			}
			else if((figureA.getX()+figureA.getWidth()>(ball.getX()))
					&&(figureA.getY()<ball.getY()+ball.getHeight() && !(figureA.getY()+figureA.getHeight()<ball.getY()))
					&& (figureA.getX()<ball.getX()+ball.getWidth())){
				returnChar = 'A';
			}
		}
		return returnChar;
	}

	public static void main(String[] args) 
	{
		new MainFrame();
	}

}
