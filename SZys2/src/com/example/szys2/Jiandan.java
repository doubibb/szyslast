package com.example.szys2;

import Szys2.Szys;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Jiandan extends Activity {
	private EditText tv1;
	private TextView tv2,tv6;
	private  Button btn1,btn3;
	int i=0,b=0,t=1;
	boolean sh=true;

		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.jiandan);
			tv1=(EditText) findViewById(R.id.editText1);
			tv2=(TextView) findViewById(R.id.textView2);
			tv6=(TextView) findViewById(R.id.textView5);
			btn1=(Button) findViewById(R.id.button1);
			btn3=(Button) findViewById(R.id.button6);
			ActionBar actionBar = getActionBar();//获取ActionBar对象
			actionBar.setDisplayShowHomeEnabled(true);//显示应用程序图标
			actionBar.setDisplayHomeAsUpEnabled(true);
				final Szys []binder=new Szys[10];
				for(int a=0;a<10;a++)
					binder[a]=new Szys((double)((int)(Math.random()*10000))/100,(double)((int)(Math.random()*10000))/100,(int)(Math.random()*3+1));
					tv2.setText(binder[b].str());
			btn1.setOnClickListener(new View.OnClickListener() {				
		        	@SuppressLint("ResourceAsColor")
				public void onClick(View arg0) {
		        	if(sh==true)
					{
		        	tv1.getText().toString();
		       		if(String.valueOf(binder[b].b()).equals(tv1.getText().toString())==true)
		        	{
		        		i++;	
		        		Toast.makeText(Jiandan.this, "恭喜你答对了", Toast.LENGTH_LONG).show();
		        	}
		       		else
					{
		       			Toast.makeText(Jiandan.this, "很遗憾。你答错了", Toast.LENGTH_LONG).show();
					}
					sh=false;
					btn1.setText("下一题");
					}
		        	
					else if(sh==false)
					{	
						
						if(b==9)
						{
							t=0;
							tv6.setText("题目："+t);
							Intent intent=new Intent();
						    intent.setClass(Jiandan.this,kunan.class);
						    startActivity(intent);
						    Jiandan.this.finish();
						}
						else if(b<8)
			   			{		
							t=t+1;
							tv6.setText("题目："+t);
			       			b++;
			       			tv2.setBackgroundColor(getResources().getColor(android.R.color.white));
			       			tv2.setText(binder[b].str());
			       			tv1.setText(null);
			       			btn1.setText("提交");
			   			}
			   			else if(b==8)
			   			{
			   				t=t+1;
							tv6.setText("题目："+t);
			       			b++;
			       			tv2.setText(binder[b].str());
			   			}	
			   			sh=true;
			    	}
				}
			});
		   	btn3.setOnClickListener(new View.OnClickListener() {				
			public void onClick(View arg0) {
					tv1.setText(String.valueOf(binder[b].b()));
				}
			});
				   	
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
				//创建启动MainActivity的Intent
				Intent intent=new Intent(this,MainActivity.class);
				//添加额外的Flag，将Activity栈中处于MainActivity之上的Activity弹出
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
