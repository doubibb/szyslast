package com.example.szys2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class cuoti extends Activity{
	ListView listview;
	SQLiteDatabase db;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cuot);
		db=SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()+"/mydb.db6", null);	
		listview=(ListView)findViewById(R.id.listView1);
		Cursor cursor=db.rawQuery("select * from myTable", null);
		inflateList(cursor);
		ActionBar actionBar = getActionBar();//获取ActionBar对象
		actionBar.setDisplayShowHomeEnabled(true);//显示应用程序图标
		actionBar.setDisplayHomeAsUpEnabled(true);
	}
	private void inflateList(Cursor cursor) {
		SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(cuoti.this,
				R.layout.line, cursor, new String[]{"title","name","content"}, 
				new int[]{R.id.textView2,R.id.textView3,R.id.textView1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		listview.setAdapter(simpleCursorAdapter);
	}
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
