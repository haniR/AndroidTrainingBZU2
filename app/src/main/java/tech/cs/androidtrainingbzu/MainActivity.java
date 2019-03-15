package tech.cs.androidtrainingbzu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, buttondot, buttonC, buttonEqual,buttonsin,buttoncos;
    EditText calculation;
    TextView answer;

    float ValueOne, ValueTwo;

    boolean summation, subtactor, multiplication, division,sin,cos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.btn_zero);
        button1 = (Button) findViewById(R.id.btn_one);
        button2 = (Button) findViewById(R.id.btn_two);
        button3 = (Button) findViewById(R.id.btn_three);
        button4 = (Button) findViewById(R.id.btn_four);
        button5 = (Button) findViewById(R.id.btn_five);
        button6 = (Button) findViewById(R.id.btn_six);
        button7 = (Button) findViewById(R.id.btn_seven);
        button8 = (Button) findViewById(R.id.btn_eight);
        button9 = (Button) findViewById(R.id.btn_nine);
        buttondot = (Button) findViewById(R.id.btn_dot);
        buttonAdd = (Button) findViewById(R.id.btn_plus);
        buttonSub = (Button) findViewById(R.id.btn_minus);
        buttonMul = (Button) findViewById(R.id.btn_multiplication);
        buttonDivision = (Button) findViewById(R.id.btn_division);
        buttonC = (Button) findViewById(R.id.btn_clear);
        buttonEqual = (Button) findViewById(R.id.btn_equal);
        buttonsin = (Button) findViewById(R.id.btn_sin);
        buttoncos = (Button) findViewById(R.id.btn_cos);
        calculation = (EditText) findViewById(R.id.calculation);
        answer = (TextView) findViewById(R.id.answer);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (calculation == null) {
                    calculation.setText("");
                } else {
                    ValueOne = Float.parseFloat(calculation.getText() + "");
                    summation = true;
                    calculation.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueOne = Float.parseFloat(calculation.getText() + "");
                subtactor = true;
                calculation.setText(null);
                answer.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueOne = Float.parseFloat(calculation.getText() + "");
                multiplication = true;
                calculation.setText(null);
                answer.setText(null);

            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueOne = Float.parseFloat(calculation.getText() + "");
                division = true;
                calculation.setText(null);
            }
        });
        buttonsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sin = true;
                calculation.setText(null);

            }
        });
        buttoncos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cos = true;
                calculation.setText(null);

            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueTwo = Float.parseFloat(calculation.getText() + "");

                if (summation == true) {
                    answer.setText(ValueOne + ValueTwo + "");
                    summation = false;
                }
                if (sin == true) {
                    answer.setText("sin " +ValueTwo+" = "+Math.sin(ValueTwo) + "");
                    sin = false;
                }
                if (cos == true) {
                    answer.setText(Math.cos(ValueTwo) + "");
                    cos = false;
                }

                if (subtactor == true) {
                    answer.setText(ValueOne - ValueTwo + "");
                    subtactor = false;
                }

                if (multiplication == true) {
                    answer.setText(ValueOne * ValueTwo + "");
                    multiplication = false;
                }

                if (division == true) {
                    answer.setText(ValueOne / ValueTwo + "");
                    division = false;
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText("");
                answer.setText("");

            }
        });

        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + ".");
            }
        });
    }
}

