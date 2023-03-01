package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button calculateBtn;
    private EditText costOfService;
    private RadioGroup tipOptions;
    private Switch roundSwitch;
    private TextView tipAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateBtn = findViewById(R.id.calculate_button);
        costOfService = findViewById(R.id.cost_of_service);

        tipOptions = findViewById(R.id.tip_options);
        roundSwitch = findViewById(R.id.round_up_switch);
        tipAmount = findViewById(R.id.tip_result);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = costOfService.getText().toString();
                float tipPercent = 0f;
                float totalTip = 0f;
                switch(tipOptions.getCheckedRadioButtonId()){
                    case R.id.option_twenty_percent:
                        tipPercent = 0.2f;
                        break;
                    case R.id.option_eighteen_percent:
                        tipPercent = 0.18f;
                        break;
                    case R.id.option_fifteen_percent:
                        tipPercent = 0.15f;
                        break;
                    default:
                        tipPercent = 0.2f;
                        break;
                }
                totalTip = Integer.parseInt(text) * tipPercent;
                if(roundSwitch.isChecked()){
                    totalTip = Math.round(totalTip);
                }

                tipAmount.setText("Tip amount: " + Float.toString(totalTip));
            }
        });
    }
}