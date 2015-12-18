package Szys2;

import java.math.BigDecimal;

public class Szys {
		public double e,d;
		double b;
		public double result;
		public int a1; 
		public char f;
		public String str;
		public Szys(double e,double d,int a1)
		{
			this.e=e;
			this.d=d;
			this.a1=a1;
			
		}
		public void setnumber(int e,int d,int a1)
		{
			this.e=e;
			this.d=d;
			this.a1=a1;	
		}
		public void seta1(int a1){this.a1=a1;}
		public double gete(){return e;}
		public double getd(){return d;}
		public char getf(){	
			switch(a1)
	        {
            case 1: f='+';break;
            case 2: f='-';break;
            case 3: f='*';break;
            case 4: f='/';break; 
            default: 
            	break;
	        }
			return f;
		}	
		public double b() {
			switch(a1)
	        {
	            case 1: b=e+d;break;
	            case 2: b=e-d;break;
	            case 3: b=e*d;break;
	            case 4: b=e/d;break;
	        }
			// TODO Auto-generated method stub
			BigDecimal bd = new BigDecimal(Double.parseDouble(String.valueOf(b)));
			b=bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			return b;
		}
		public CharSequence str() {
			switch(a1)
	        {
	            case 1:str=String.valueOf(e)+getf()+String.valueOf(d)+'=';break;
	            case 2:str=String.valueOf(e)+getf()+String.valueOf(d)+'=';break;
	            case 3:str=String.valueOf(e)+getf()+String.valueOf(d)+'=';break;
	            case 4:str=String.valueOf(e)+getf()+String.valueOf(d)+'=';break;
	        }
			return str;
		}
}