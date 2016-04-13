package group._2;
import java.awt.*;
import java.util.*;
public class Hornet extends Bee{
	private int id;
	private Image img;//蜜蜂的图片
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
	
	public void search(){
		String strVision = BeeFarming.search(id);
		String[] strs = strVision.split("~");
		for(int i=0;i<strs.length;i++){
		if(strs[i].indexOf('*')==0)
			{			
				Random ra = new Random();
				angle += ra.nextInt(30)+60;
			    ratoteImage(angle);
			}
			//如果碰到了蜜蜂则跟踪
		if(strs[i].indexOf('+')==0){
			//"+("+fs1.id+","+a+","+fs1.angle+")~"
				String strTmp = strs[i];
				int start = strTmp.indexOf('(');
				int end = strTmp.indexOf(',');
				String s = strTmp.substring(start+1,end);
				int tempid = new Integer(s).intValue();
				start = strTmp.indexOf(',');
				strTmp = strTmp.substring(start+1);
				end = strTmp.indexOf(',');
				s = strTmp.substring(0,end);
				double a = new Double(s).doubleValue();
				angle = a;
				ratoteImage(angle);
			}
		}
		setXYs(0);
	}
	public boolean isCatched(){
	    dead = true;
	    return dead;
	}

}