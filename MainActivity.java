package com.example.exp1loginform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String VALID_USR_NAME = "user";
    private static final String VALID_PWD = "pass";
    private EditText username;
    private EditText password;
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.uname);
        password = findViewById(R.id.pwd);

        loginbtn = findViewById(R.id.btn);
        loginbtn.setOnClickListener(view -> {
            String enteredUname = username.getText().toString().trim();
            String enteredpwd = password.getText().toString().trim();

            if (enteredUname.isEmpty() || enteredpwd.isEmpty()) {
                showToast("Please enter both username and password");
            } else if (isValid(enteredUname, enteredpwd)) {
                showToast("Login Success!");
            } else {
                showToast("Invalid Credentials");
            }
        });
    }

    public boolean isValid(String euname, String epwd) {
        return VALID_USR_NAME.equals(euname) && VALID_PWD.equals(epwd);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}






