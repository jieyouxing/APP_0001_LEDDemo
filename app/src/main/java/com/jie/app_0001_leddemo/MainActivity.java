package com.jie.app_0001_leddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.jie.hardlibrary.HardControl;

public class MainActivity extends AppCompatActivity {
    private Boolean ledflag = true;
    private Button button = null;
    private CheckBox checkboxled1 = null;
    private CheckBox checkboxled2 = null;

    class MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            ledflag = !ledflag;

            if(ledflag) {
                button.setText("ALL ON");
                checkboxled1.setChecked(false);
                checkboxled2.setChecked(false);
                HardControl.ledCtrl(1, 0);
                HardControl.ledCtrl(2, 0);
            }
            else {
                button.setText("ALL OFF");
                checkboxled1.setChecked(true);
                checkboxled2.setChecked(true);
                HardControl.ledCtrl(1, 1);
                HardControl.ledCtrl(2, 1);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.BUTTON);

        checkboxled1 = (CheckBox)findViewById(R.id.LED1);
        checkboxled2 = (CheckBox)findViewById(R.id.LED2);

        HardControl.ledOpen();

        button.setOnClickListener(new MyButtonListener());
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.LED1:
                if (checked) {
                    Toast.makeText(MainActivity.this, "LED1 ON", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 1);
                }
                else {
                    Toast.makeText(MainActivity.this, "LED1 OFF", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 0);
                }
                break;
            case R.id.LED2:
                if (checked) {
                    Toast.makeText(MainActivity.this, "LED2 ON", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 1);
                }
                else {
                    Toast.makeText(MainActivity.this, "LED2 OFF", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 0);
                }
                break;
        }
    }
}
