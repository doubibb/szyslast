package com.example.szys2;

import Szys2.Core;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class zhongdeng extends Activity implements OnClickListener{

	private int num1=0,num2=0,num3,result,resultTure;
	int trueNum,falseNum;
	private Button btn_star,btn_next,btn_QD,btn_end;
	private EditText text;    //�����
	private TextView textView;    //��Ŀ
	private TextView textViewtip;    //��ʾ
	Core core=new Core();
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.zhongdeng);
		 btn_star=(Button) findViewById(R.id.button1);
		 btn_star.setOnClickListener(this);
		 btn_next=(Button) findViewById(R.id.button2);
		 btn_next.setOnClickListener(this);
		 btn_QD=(Button) findViewById(R.id.button3);
		 btn_QD.setOnClickListener(this);
		 btn_end=(Button) findViewById(R.id.button4);
		 btn_end.setOnClickListener(this);
		 text=(EditText) findViewById(R.id.editText1);
		 textView=(TextView) findViewById(R.id.textView5);
		 textViewtip=(TextView) findViewById(R.id.textView3);
		 ActionBar actionBar = getActionBar();//��ȡActionBar����
		actionBar.setDisplayShowHomeEnabled(true);//��ʾӦ�ó���ͼ��
		actionBar.setDisplayHomeAsUpEnabled(true);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			btn_star.setText("���¿�ʼ"); 
			text.setText(null);
			trueNum=0;
			falseNum=0;
			Count();
			break;
		case R.id.button2:
			text.setText(null);
			textViewtip.setText(null);
			Count();
			break;
		case R.id.button3:
			checkout(resultTure);
		    break;
		case R.id.button4:
			ending( );
		    break;
		}
	}

	public void Count()
	{
		num1=(int)(Math.random()*10);
		num2=(int)(Math.random()*10+1);
		num3=(int)(Math.random()*10+2);
		int i=0;
		char[]h={'+','-','*','/'};
		i=(int)(Math.random()*4);
		textView.setText("      "+num1+""+h[i]+""+num2+h[i]+""+num3+"=");
		switch (i) {
		case 0:
			resultTure=core.Add(num1, num2,num3);
			 
			break;
		case 1:
			resultTure=core.Subtraction(num1, num2,num3);
			break;
		case 2:
			resultTure=core.multiplication(num1, num2,num3);
			break;
		case 3:
			resultTure=core.Division(num1, num2,num3);
			break;
		}
	}
	public void  checkout(int resultTure)
	{
		String str=this.text.getText().toString();
		boolean isAllDigit = true;//����һ��booleanֵ��������ʾ�Ƿ���������ַ�
		for(int i=0 ;i<str.length(); i++)//ѭ�������ַ���   
			if(!Character.isDigit(str.charAt(i))){isAllDigit=false;}//��char��װ���е��ж����ֵķ����ж�ÿһ���ַ�
		if(isAllDigit)
		{
			result=Integer.parseInt(this.text.getText().toString());
			if(result==resultTure)
			{
			this.textViewtip.setText("����ȷ");trueNum++;
			}
			else
			{
			this.textViewtip.setText("������ȷ����:"+this.resultTure);falseNum++;
			}
        }
        else
        	 this.textViewtip.setText("�������󣡣�");
	}
	public void  ending()
	{
		if(trueNum==0&&falseNum==0)this.textViewtip.setText("�㻹û��ʼ�����أ�"); 
		else
			{
			double a,b;a=trueNum;b=falseNum;
		this.textViewtip.setText("�����"+trueNum+"�⣬���"+falseNum+"��\n��ȷ��Ϊ��"+a/(a+b)*100+"%"); 
			}
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.help:
	//		Intent intent1=new Intent(this,Help.class);
		//	startActivity(intent1);
			break;
		case R.id.newgame:
		//	Intent intent2=new Intent(this,New_Game.class);
		//	startActivity(intent2);
			break;
		case R.id.bangzhu:
			Intent intent3=new Intent(this,Bangzhu.class);
			startActivity(intent3);
			break;
		case android.R.id.home:
			//��������MainActivity��Intent
			Intent intent=new Intent(this,MainActivity.class);
			//��Ӷ����Flag����Activityջ�д���MainActivity֮�ϵ�Activity����
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;


		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

}

