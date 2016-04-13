package group._3;
import java.awt.*;
import java.util.*;
public class Hornet extends Bee{
	private int id;
	private Image img;//ÃÛ·äµÄÍ¼Æ¬
	private int posX;
	private int posY;
	private boolean isAlive;
	private FlyingStatus fs;
	private int[] nextX;
	private int[] nextY;  
	boolean dead;
	
	public Hornet(int id,int x, int y, double angle,boolean isAlive,Image img){
		super(id,x,y,angle,isAlive,img);
		this.id = id;
	}
	
	public boolean isCatched(){
	    dead = true;
	    return dead;
	}

}