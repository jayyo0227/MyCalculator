package jayyo.mycalculator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    private TextView mainNumber;
    private TextView tmpNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        setView();
    }

    private void setView() {
        mainNumber = findViewById(R.id.mainNumber);
        tmpNumber = findViewById(R.id.tmpNumber);

        TextView userName = findViewById(R.id.userName);
        userName.setText(UserData.userName);

        Button btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(v -> mainNumber.setText("0"));
        Button btn_delete = findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(v -> {
            String str = mainNumber.getText().toString();
            try {
                str = str.substring(0, str.length() - 1);
                if (str.equals("")) {
                    str = "0";
                }
            } catch (Exception ignore) {
                str = "0";
            }
            mainNumber.setText(str);
        });

        Button btn_equal = findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(v -> calculate());

        Button btn_point = findViewById(R.id.btn_point);
        btn_point.setOnClickListener(v -> {
            if (!mainNumber.getText().toString().contains(".")) {
                mainNumber.append(".");
            }
        });

        Button btn_factorial = findViewById(R.id.btn_factorial);
        btn_factorial.setOnClickListener(v -> {
            arithmetic("!");
            calculate();
        });

        Button btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(v -> arithmetic("+"));
        Button btn_subtract = findViewById(R.id.btn_subtract);
        btn_subtract.setOnClickListener(v -> arithmetic("-"));
        Button btn_multiply = findViewById(R.id.btn_multiply);
        btn_multiply.setOnClickListener(v -> arithmetic("*"));
        Button btn_divide = findViewById(R.id.btn_divide);
        btn_divide.setOnClickListener(v -> arithmetic("/"));

        Button btn_zero = findViewById(R.id.btn_zero);
        btn_zero.setOnClickListener(v -> numbers("0"));
        Button btn_one = findViewById(R.id.btn_one);
        btn_one.setOnClickListener(v -> numbers("1"));
        Button btn_two = findViewById(R.id.btn_two);
        btn_two.setOnClickListener(v -> numbers("2"));
        Button btn_three = findViewById(R.id.btn_three);
        btn_three.setOnClickListener(v -> numbers("3"));
        Button btn_four = findViewById(R.id.btn_four);
        btn_four.setOnClickListener(v -> numbers("4"));
        Button btn_five = findViewById(R.id.btn_five);
        btn_five.setOnClickListener(v -> numbers("5"));
        Button btn_six = findViewById(R.id.btn_six);
        btn_six.setOnClickListener(v -> numbers("6"));
        Button btn_seven = findViewById(R.id.btn_seven);
        btn_seven.setOnClickListener(v -> numbers("7"));
        Button btn_eight = findViewById(R.id.btn_eight);
        btn_eight.setOnClickListener(v -> numbers("8"));
        Button btn_nine = findViewById(R.id.btn_nine);
        btn_nine.setOnClickListener(v -> numbers("9"));
    }

    private void numbers(String strParam) {
        String strNumer = mainNumber.getText().toString();
        strNumer += strParam;
        try {
            if (strNumer.contains(".")) {
                double currentNumer = Double.parseDouble(strNumer);
                mainNumber.setText(String.valueOf(currentNumer));
            } else {
                long currentNumer = Long.parseLong(strNumer);
                mainNumber.setText(String.valueOf(currentNumer));
            }
        } catch (Exception ignored) {
        }
    }

    private void arithmetic(String strParam) {
        String strNumer;
        strNumer = mainNumber.getText().toString();
        tmpNumber.setText(strNumer);
        mainNumber.setText("0");
        tmpNumber.append(strParam);
    }

    private void calculate() {
        double firstNumer = 0;
        double secondNumer = 0;
        double answer = 0;
        String strFirstNumer = tmpNumber.getText().toString();
        if (strFirstNumer.equals("")) {
            return;
        }
        String strArithmetic = strFirstNumer.substring(strFirstNumer.length() - 1);

        strFirstNumer = strFirstNumer.substring(0, strFirstNumer.length() - 1);
        try {
            if (strFirstNumer.contains(".")) {
                firstNumer = Double.parseDouble(strFirstNumer);
            } else {
                firstNumer = Long.parseLong(strFirstNumer);
            }
        } catch (Exception ignored) {
        }
        Log.d("dev", "firstNumer: " + firstNumer);

        String strSecondNumer = mainNumber.getText().toString();
        try {
            if (strSecondNumer.contains(".")) {
                secondNumer = Double.parseDouble(strSecondNumer);
            } else {
                secondNumer = Long.parseLong(strSecondNumer);
            }
        } catch (Exception ignored) {
        }
        Log.d("dev", "secondNumer: " + secondNumer);

        try {
            switch (strArithmetic) {
                case "+":
                    answer = firstNumer + secondNumer;
                    break;
                case "-":
                    answer = firstNumer - secondNumer;
                    break;
                case "*":
                    answer = firstNumer * secondNumer;
                    break;
                case "/":
                    answer = firstNumer / secondNumer;
                    break;
                case "!":
                    answer = firstNumer;
                    while (firstNumer - 1 > 0) {
                        answer = answer * (firstNumer - 1);
                        firstNumer -= 1;
                    }
                    break;
            }
        } catch (Exception ignored) {
        }
        Log.d("dev", "answer: " + answer);

        mainNumber.setText(String.valueOf(answer));

        String strAnswer = String.valueOf(answer);
        Log.d("dev", "strAnswer: " + strAnswer);
        if (strAnswer.endsWith(".0")) {
            strAnswer = strAnswer.substring(0, strAnswer.length() - 2);

            Log.d("dev", "strAnswer: " + strAnswer);

            mainNumber.setText(strAnswer);
        }
    }
}
