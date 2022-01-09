package jayyo.mycalculator;

import android.os.Bundle;
import android.view.View;
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

        Button btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(v -> mainNumber.setText("0"));
        Button btn_delete = findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(v -> {
            String str = mainNumber.getText().toString();
            str = str.substring(0, str.length() - 1);
            mainNumber.setText(str);
        });

        Button btn_factorial = findViewById(R.id.btn_factorial);
        btn_factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button btn_equal = findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button btn_point = findViewById(R.id.btn_point);
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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

        Button btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(v -> arithmetic("+"));
        Button btn_subtract = findViewById(R.id.btn_subtract);
        btn_subtract.setOnClickListener(v -> arithmetic("-"));
        Button btn_multiply = findViewById(R.id.btn_multiply);
        btn_multiply.setOnClickListener(v -> arithmetic("*"));
        Button btn_divide = findViewById(R.id.btn_divide);
        btn_divide.setOnClickListener(v -> arithmetic("/"));
    }

    private void numbers(String strParam) {
        String strNumer;
        long currentNumer;

        strNumer = mainNumber.getText().toString();
        currentNumer = Long.parseLong(strNumer);

        strNumer += strParam;

        try {
            currentNumer = Long.parseLong(strNumer);
        } catch (Exception ignored) {

        }

        mainNumber.setText(String.valueOf(currentNumer));
    }

    private void arithmetic(String strParam) {
        String strNumer;
        double firstNumer;
        String  currentCalculationMode;

        strNumer = mainNumber.getText().toString();

        tmpNumber.setText(strNumer);

        try {
             firstNumer = Double.parseDouble(strNumer);
        } catch (Exception ignored) {

        }

        currentCalculationMode = strParam;

        mainNumber.setText("0");
        tmpNumber.append(strParam);
    }
}
