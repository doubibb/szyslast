package com.example.szys2;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Bangzhu extends Activity{

	/**
	 * @param args
	 */

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bangzhu);
		ActionBar actionBar = getActionBar();//��ȡActionBar����
		actionBar.setDisplayShowHomeEnabled(true);//��ʾӦ�ó���ͼ��
		actionBar.setDisplayHomeAsUpEnabled(true);
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.help:
		/*	Intent intent1=new Intent(this,Help.class);
			startActivity(intent1);*/
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
