package com.awang.game.minetetris;

import com.awang.game.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
	}

	public void intoMineTetrisActivity(View view) {
		startActivity(new Intent(context, TetrisActivityAW.class));
	}
}
