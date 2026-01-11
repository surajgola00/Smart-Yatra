package com.example.smartyatra;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartyatra.utils.Authentication;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.atomic.AtomicReference;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AtomicReference<SharedPreferences> sharedPref = new AtomicReference<>(getSharedPreferences("MyAppPrefs", MODE_PRIVATE));
        if(sharedPref.get().contains("name")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
                return;
            }

            Authentication.initializeLoginProtocol(() -> {
                runOnUiThread(() -> {
                    new Thread(() -> {
                        JSONObject matchedUser = null;
                        matchedUser = Authentication.getUserByEmail(email);

                        JSONObject finalUser = matchedUser;
                        runOnUiThread(() -> {
                            if (finalUser != null) {
                                try {
                                    String id = finalUser.getString("user_id");
                                    String name = finalUser.getString("name");
                                    String emailFetched = finalUser.getString("email");

                                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();

                                    sharedPref.set(getSharedPreferences("MyAppPrefs", MODE_PRIVATE));
                                    SharedPreferences.Editor editor = sharedPref.get().edit();
                                    editor.putString("user_id", id);
                                    editor.putString("name", name);
                                    editor.putString("email", emailFetched);
                                    editor.apply();

                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                Toast.makeText(this, "User Doesn't exist!", Toast.LENGTH_SHORT).show();
                                Toast.makeText(this, "Please Check details or Register!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }).start();
                });
            });


        });

        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });
    }
}
