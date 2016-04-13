package group._2;
import java.awt.*;
import java.util.*;
public class HoneyBee extends Bee{
	private int id;
	boolean state=false;
 	
	public HoneyBee(int id,int x, int y, double angle,boolean isAlive,Image img){
		super(id,x,y,angle,isAlive,img);
		this.id = id;
	}
	
	public void search(){
		String strVision = BeeFarming.search(id);
		String[] strs = strVision.split("~");
		String strVision9 = BeeFarming.search(9);
		String[] strs9 = strVision9.split("~");
		state=false;
		//������Ʒ䶢�����������ֱ������
		for(int j=0;j<strs9.length;j++){
			if(strs9[j].indexOf('+')==0){
				String strTmp = strs9[j];
				int start = strTmp.indexOf('(');
				int end = strTmp.indexOf(',');
				String s = strTmp.substring(start+1,end);
				int tempid = new Integer(s).intValue();
				if(tempid==id)
					state=true;
			}
		}
		
		for(int i=0;i<strs.length;i++){
			//�������*Ϊ�׵��ַ��������������˱ߣ����������˳ʱ����ת90�����ڵĽǶ�
			if(strs[i].indexOf('*')==0)
			{			
				Random ra = new Random();
				angle += ra.nextInt(45)+60;
			    ratoteImage(angle);
				// angle += 90;
				// ratoteImage(angle);
				//state=true;
			}
			//�������-Ϊ�׵��ַ��������������˻�
			
			if(strs[i].indexOf('-')==0)
			{
				//"-("+f.getVolumn()+",ON)~"
				//"-("+f.getVolumn()+","+a+")~"
				String strTmp = strs[i];
				int start = strTmp.indexOf('(');
				int end = strTmp.indexOf(',');
				String s = strTmp.substring(start+1,end);
				int honey = new Integer(s).intValue();
				strTmp = strTmp.substring(end+1);
				end = strTmp.indexOf(')');
				s = strTmp.substring(0,end);
				if(!s.equals("ON")){
					double a = new Double(s).doubleValue();
					if(state)
						angle = a+60;
					else
					    angle = a;
					ratoteImage(angle);
				}
			}
			else if(strs[i].indexOf('+')==0){
				//"+("+fs1.id+","+a+","+fs1.angle+")~"
				//��������˻Ʒ������˶�������������۷������ת���Ƕ�
				String strTmp = strs[i];
				int start = strTmp.indexOf('(');
				int end = strTmp.indexOf(',');
				String s = strTmp.substring(start+1,end);
				int tempid = new Integer(s).intValue();
				strTmp = strTmp.substring(end+1);
				start=strTmp.indexOf(',');
				end = strTmp.indexOf(')');
				s = strTmp.substring(start+1,end);
				if(tempid==9)
				angle = angle+180;
			    else {
					Random ra = new Random();
				    angle += ra.nextInt(90);
				}
				ratoteImage(angle);
			}
		}
		setXYs(0);
	}

	
}