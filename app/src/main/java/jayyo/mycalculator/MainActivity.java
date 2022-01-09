package jayyo.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
    }

    private void setView() {
        EditText editTextUserName = findViewById(R.id.editTextUserName);

        Button comfirmUserName = findViewById(R.id.comfirmUserName);
        comfirmUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comfirmUserName.setClickable(false);

                String userName = editTextUserName.getText().toString();

                Intent intent = new Intent(MainActivity.this, Calculator.class);
                startActivity(intent);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        comfirmUserName.setClickable(true);
                    }
                }).start();
            }
        });
    }
}