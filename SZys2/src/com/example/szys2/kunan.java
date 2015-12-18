package com.example.szys2;

import java.math.BigDecimal;

import Szys2.Szys1;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class kunan extends Activity {
	private EditText tv1;
	private TextView tv2,tv3,tv4,tv5,tv6;
	private  Button btn1,btn2,btn3;
	int i=0,b=0,t=1;
	public double str;
	boolean sh=true;
	SQLiteDatabase db;

		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.kunan);
			db=SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/mydb.db6", null);
			tv1=(EditText) findViewById(R.id.editText1);
			tv2=(TextView) findViewById(R.id.textView2);
			tv3=(TextView) findViewById(R.id.textView1);
			tv4=(TextView) findViewById(R.id.textView3);
			tv5=(TextView) findViewById(R.id.textView4);
			tv6=(TextView) findViewById(R.id.textView5);
			btn1=(Button) findViewById(R.id.button1);
			btn2=(Button) findViewById(R.id.button2);
			btn3=(Button) findViewById(R.id.button6);
			ActionBar actionBar = getActionBar();//获取ActionBar对象
			actionBar.setDisplayShowHomeEnabled(true);//显示应用程序图标
			actionBar.setDisplayHomeAsUpEnabled(true);
			tv6.setText("题目："+t);
		    final Szys1 []binder=new Szys1[10];
			for(int a=0;a<10;a++)
			binder[a]=new Szys1((double)((int)(Math.random()*10000))/100,(double)((int)(Math.random()*10000))/100,(double)((int)(Math.random()*10000))/100,(double)((int)(Math.random()*10000))/100,(int)(Math.random()*3+1),(int)(Math.random()*3+1),(int)(Math.random()*3+1),(int)(Math.random()*5+1));
			//binder[a]=new Szys1((double)((int)(Math.random()*100)),(double)((int)(Math.random()*100)),(double)((int)(Math.random()*100)),(double)((int)(Math.random()*100)),1,1,1,1);
			tv2.setText(binder[b].str());		
		   	btn1.setOnClickListener(new View.OnClickListener() {
						
			        	
				public void onClick(View arg0) {
					if(sh==true)
					{
						try{
							tv1.getText().toString();
						BigDecimal bd = new BigDecimal(Double.parseDouble(tv1.getText().toString()));
						str=bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
							
							if(String.valueOf(binder[b].fen5()).equals(tv1.getText().toString())==true)
			 				{
								i++;	
			        		Toast.makeText(kunan.this, "恭喜你答对了", Toast.LENGTH_LONG).show();
							}
							else
							{
			        		//tv2.setBackgroundColor(R.color.red); 
								try {
								insertData(db, binder[b].str(), tv1.getText().toString(),String.valueOf(binder[b].fen5()));
							} catch (SQLiteException e) {
								// TODO: handle exception
								db.execSQL("create table myTable(_id integer"
										+"primary key autonicrement,"
										+"title varchar(50),"
										+"name varchar(50),"
										+ "content varchar(255))");
								insertData(db,binder[b].str(), tv1.getText().toString(),String.valueOf(binder[b].fen5()));
							}
						
							Toast.makeText(kunan.this, "很遗憾。你答错了", Toast.LENGTH_LONG).show();
							}
							sh=false;
							btn1.setText("下一题");
						}
						catch(Exception e){
							Toast.makeText(kunan.this, "请输入答案或者数字", Toast.LENGTH_LONG).show();
						}
						
		        	}
					else if(sh==false)
					{	
						
						if(b==9)
						{
							t=0;
							tv6.setText("题目："+t);
							Intent intent=new Intent();
						    intent.setClass(kunan.this,kunan.class);
						    startActivity(intent);
						    kunan.this.finish();
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
		   	btn2.setOnClickListener(new View.OnClickListener() {				
				public void onClick(View arg0) {
					tv3.setText(binder[b].fe1());
					tv4.setText(binder[b].fe2()+binder[b].fen2());
					tv5.setText(binder[b].fe3()+binder[b].fen5());
					}
			 });
		   	btn3.setOnClickListener(new View.OnClickListener() {				
				public void onClick(View arg0) {
					tv1.setText(String.valueOf(binder[b].fen5()));
					}
			 });
		}
		private void insertData(SQLiteDatabase db,String title,String content,String name) {
			db.execSQL("insert into myTable values(null,?,?,?)",new String[]{title,name,content});
		}

		@Override
			protected void onDestroy() {
				// TODO Auto-generated method stub
				super.onDestroy();
				if (db!=null &&db.isOpen()) {
					db.close();
				}
			}
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
			switch (item.getItemId()) {
			case R.id.help:
				Intent intent1=new Intent(this,cuoti.class);
				startActivity(intent1);
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
