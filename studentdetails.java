package com.example.studentdetails1;

        import android.os.Bundle;
        import android.util.Patterns;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etStudentId, etName, etEmail, etPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etStudentId = findViewById(R.id.etStudentId);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> validateForm());
    }

    private void validateForm() {

        String studentId = etStudentId.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        boolean isValid = true;

        // Student ID validation
        if (studentId.isEmpty()) {
            etStudentId.setError("Student ID is required");
            isValid = false;
        }

        // Name validation
        if (name.isEmpty()) {
            etName.setError("Name is required");
            isValid = false;
        }

        // Email validation
        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email address");
            isValid = false;
        }

        // Password validation
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            isValid = false;
        } else if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            isValid = false;
        }

        // Success
        if (isValid) {
            Toast.makeText(
                    MainActivity.this,
                    "Student registration successful!",
                    Toast.LENGTH_LONG
            ).show();
        } else {
            Toast.makeText(
                    MainActivity.this,
                    "Please correct the errors",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
