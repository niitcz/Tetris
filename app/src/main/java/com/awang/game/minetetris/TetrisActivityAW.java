package com.awang.game.minetetris;

import java.util.List;

import com.awang.game.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TetrisActivityAW extends Activity {

	String [] multi_list = {"俄罗斯方块"};

	private NextBlockView nextBlockView;
	private TetrisViewAW tetrisViewAW;
	private TextView gameStatusTip;
	public TextView score;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tetris_activity_aw);
		nextBlockView = (NextBlockView) findViewById(R.id.nextBlockView1);
		tetrisViewAW = (TetrisViewAW) findViewById(R.id.tetrisViewAW1);
		tetrisViewAW.setFather(this);
		gameStatusTip = (TextView) findViewById(R.id.game_staus_tip);
		score = (TextView) findViewById(R.id.score);
		initEvent();
	}

	private void initEvent() {
		findViewById(R.id.toast_btn1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				showToast1();

			}
		});

		findViewById(R.id.dialog_btn3).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				showDialog3();
			}
		});
	}

	private void showDialog3() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("你喜欢第5组的俄罗斯方块小游戏吗？");//设置标题
		builder.setIcon(R.drawable.ic_launcher);//设置图标
		builder.setMultiChoiceItems(multi_list, null, new DialogInterface.OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					Toast.makeText(TetrisActivityAW.this, "我喜欢上了"+multi_list[which]+"！",
							Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(TetrisActivityAW.this, "我不喜欢"+multi_list[which]+"了！",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		AlertDialog dialog = builder.create();//获取dialog
		dialog.show();//显示对话框
	}



	private void showToast1() {
		Toast toast = Toast.makeText(this,"上面会随机给你一些稀奇古怪的砖块，你可以旋转和调整下落的位置，目的是修出一座没有空隙的墙。",Toast.LENGTH_LONG);
		toast.show();
	}

	public void playFromRes(View view){
		MediaPlayer mp = MediaPlayer.create(this,R.raw.tetris);
		mp.start();
		mp.setLooping(true);
	}

	public void setNextBlockView(List<BlockUnit> blockUnits, int div_x) {
		nextBlockView.setBlockUnits(blockUnits, div_x);
	}

	/**
	 * 开始游戏
	 * 
	 * @param view
	 */
	public void startGame(View view) {
		tetrisViewAW.startGame();
		gameStatusTip.setText("游戏运行中");
	}

	/**
	 * 暂停游戏
	 */
	public void pauseGame(View view) {
		tetrisViewAW.pauseGame();
		gameStatusTip.setText("游戏已暂停");
	}

	/**
	 * 继续游戏
	 */
	public void continueGame(View view) {
		tetrisViewAW.continueGame();
		gameStatusTip.setText("游戏运行中");
	}

	/**
	 * 停止游戏
	 */
	public void stopGame(View view) {
		tetrisViewAW.stopGame();
		score.setText("" + 0);
		gameStatusTip.setText("游戏已停止");
	}

	/**
	 * 向左滑动
	 */
	public void toLeft(View view) {
		tetrisViewAW.toLeft();
	}

	/**
	 * 向右滑动
	 */
	public void toRight(View view) {
		tetrisViewAW.toRight();
	}

	/**
	 * 旋转
	 */
	public void toRoute(View view) {
		tetrisViewAW.route();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (tetrisViewAW != null) {
			tetrisViewAW.stopGame();
		}
	}
}