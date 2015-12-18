package com.example.szys2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private  Button btn1;
	private  Button btn2;
	private  Button btn3;
	private  Button btn4;
	//SQLiteDatabase db;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main);	
		 btn1=(Button)findViewById(R.id.button1);
	     btn2=(Button)findViewById(R.id.button2); 
	     btn3=(Button)findViewById(R.id.button3);
	     btn4=(Button)findViewById(R.id.button4);
	     ActionBar actionBar = getActionBar();//获取ActionBar对象
		actionBar.setDisplayShowHomeEnabled(true);//显示应用程序图标 
		actionBar.setDisplayHomeAsUpEnabled(true);
		// TODO Auto-generated method stub
	/*	db=SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/mydb.db6", null);
		String title,content,name;
		// TODO Auto-generated method stub
		title="题目";
		content="你的答案";
		name="正确答案";
		try {
			insertData(db, title, name,content);
			
		} catch (SQLiteException e) {
		
			db.execSQL("create table myTable(_id integer"
					+"primary key autonicrement,"
					+"title varchar(50),"
					+"name varchar(50),"
					+ "content varchar(255))");
			insertData(db, title, name,content);
		}
	*/
		 btn1.setOnClickListener(new View.OnClickListener() {
				
	        	public void onClick(View arg0) {
	        		Intent intent=new Intent();
				    intent.setClass(MainActivity.this,Jiandan.class);
				    startActivity(intent);
				    MainActivity.this.finish();
	        	}
	        	
	        });  
		 btn2.setOnClickListener(new View.OnClickListener() {
				
	        	public void onClick(View arg0) {
	        		Intent intent2=new Intent();
				    intent2.setClass(MainActivity.this,zhongdeng.class);
				    startActivity(intent2);
				    MainActivity.this.finish();
	        
	        	}
	        	
	        }); 
		 btn3.setOnClickListener(new View.OnClickListener() {
				
	        	public void onClick(View arg0) {
	        		Intent intent1=new Intent();
				    intent1.setClass(MainActivity.this,kunan.class);
				    startActivity(intent1);
				    MainActivity.this.finish();
	        	}
	        	
	        });  
		 btn4.setOnClickListener(new View.OnClickListener() {
				
	        	public void onClick(View arg0) {
	        		System.exit(0);
	        	}
	        	
	        });
	}
/*private void insertData(SQLiteDatabase db,String title,String content,String name) {
	db.execSQL("insert into myTable values(null,?,?,?)",new String[]{title,name,content});
}

@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (db!=null &&db.isOpen()) {
			db.close();
		}
	}*/
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

