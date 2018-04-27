package c.google.deathmath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class PopUpBackActivity extends GameActivity {

    Button btnBackHome, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_back);

        btnCancel = findViewById(R.id.btn_cancel);
        btnBackHome =findViewById(R.id.btn_back_home);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopUpBackActivity.super.resumeTimer(true);
                finish();
            }
        });

        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PopUpBackActivity.this, DifficultyActivity.class);
                startActivity(intent);
                finishAffinity();
                System.exit(0);
            }
        });
    }
}
