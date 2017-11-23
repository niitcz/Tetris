package com.awang.game.minetetris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.awang.game.R;

/**
 * Created by Mr.chen on 2017/6/9.
 */

public class WelcomeActivity extends Activity {
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(WelcomeActivity.this,TetrisActivityAW.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler.postDelayed(runnable,3000);

    }


}
