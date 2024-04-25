package com.example.n2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LaunchActivity extends AppCompatActivity {
    private TextView tvInfo;
    private EditText etInput;
    private Button bControl;
    private int guess;
    private boolean gameFinished;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.textView);
        etInput = (EditText) findViewById(R.id.editTextNumber);
        bControl = (Button) findViewById(R.id.button);
        guess = (int) (Math.random() * 100);
        gameFinished = false;
    }

    public void onClick(View v) {
        // Проверяем, было ли что-то введено в EditText
        if (etInput.getText().toString().equals("")) {
            tvInfo.setText(getResources().getString(R.string.no_input));  // сообщение об отсутствии ввода
            return;
        }

        int inp;
        try {
            inp = Integer.parseInt(etInput.getText().toString());
        } catch (NumberFormatException e) {
            tvInfo.setText(getResources().getString(R.string.invalid_input));  // сообщение о некорректном вводе (не число)
            etInput.setText("");
            return;
        }

        // Проверяем, находится ли число в допустимом диапазоне
        if (inp < 0 || inp > 100) {
            tvInfo.setText(getResources().getString(R.string.out_of_bounds));  // сообщение о выходе за пределы диапазона
            etInput.setText("");
            return;
        }

        if (!gameFinished) {
            if (inp > guess) {
                tvInfo.setText(getResources().getString(R.string.ahead));
            } else if (inp < guess) {
                tvInfo.setText(getResources().getString(R.string.behind));
            } else {
                tvInfo.setText(getResources().getString(R.string.hit));
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
            }
        } else {
            guess = (int) (Math.random() * 101);  // новое случайное число от 0 до 100
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
        etInput.setText("");
    }

}