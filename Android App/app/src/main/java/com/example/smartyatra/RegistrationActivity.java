package com.example.smartyatra;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etName, etAge, etGender, etBloodType, etEmail, etPhone,
            etPrefLanguage, etEmergencyContact, etEmergencyContactRelation,
            etCurrentLocation, etNationality;
    private Button btnRegisterConfirm;
    private static final String BASE_URL = "Base_URL";  //update the base url

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etName = findViewById(R.id.etRegName);
        etAge = findViewById(R.id.etRegAge);
        etGender = findViewById(R.id.etRegGender);
        etBloodType = findViewById(R.id.etRegBloodType);
        etEmail = findViewById(R.id.etRegEmail);
        etPhone = findViewById(R.id.etRegPhone);
        etPrefLanguage = findViewById(R.id.etRegPrefLanguage);
        etEmergencyContact = findViewById(R.id.etRegEmergencyContact);
        etEmergencyContactRelation = findViewById(R.id.etRegEmergencyContactRelation);
        etCurrentLocation = findViewById(R.id.etRegCurrentLocation);
        etNationality = findViewById(R.id.etRegNationality);

        btnRegisterConfirm = findViewById(R.id.btnRegisterConfirm);

        btnRegisterConfirm.setOnClickListener(v -> {
            if (checkInputs()) {
                //Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();

                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody.put("full_name", etName.getText().toString());
                    jsonBody.put("age", Integer.parseInt(etAge.getText().toString()));
                    jsonBody.put("gender", etGender.getText().toString());
                    jsonBody.put("b_group", etBloodType.getText().toString());
                    jsonBody.put("email", etEmail.getText().toString());
                    jsonBody.put("phone", etPhone.getText().toString());
                    jsonBody.put("language", etPrefLanguage.getText().toString());
                    jsonBody.put("e_contact", etEmergencyContact.getText().toString());
                    jsonBody.put("e_relation", etEmergencyContactRelation.getText().toString());
                    jsonBody.put("location", etCurrentLocation.getText().toString());
                    jsonBody.put("nationality", etNationality.getText().toString());
                    jsonBody.put("user_id",  UUID.randomUUID());
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                    RequestQueue requestQueue = Volley.newRequestQueue(this);

                    // POST request
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                            Request.Method.POST,
                            BASE_URL,
                            jsonBody,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        Log.d("L", response.get("status").toString());
                                        if(response.get("status").toString().equals("ok")){

                                            Toast.makeText(RegistrationActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(RegistrationActivity.this, "Unable to Register!", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(RegistrationActivity.this,
                                            "Error: " + error.toString(),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                    );

                    // Add request to queue
                    requestQueue.add(jsonObjectRequest);
            }
        });
    }

    private boolean checkInputs() {
        if (TextUtils.isEmpty(etName.getText().toString().trim())) {
            etName.setError("Enter Name");
            return false;
        }
        if (TextUtils.isEmpty(etAge.getText().toString().trim())) {
            etAge.setError("Enter Age");
            return false;
        }
        if (TextUtils.isEmpty(etGender.getText().toString().trim())) {
            etGender.setError("Enter Gender");
            return false;
        }
        if (TextUtils.isEmpty(etBloodType.getText().toString().trim())) {
            etBloodType.setError("Enter Blood Type");
            return false;
        }
        if (TextUtils.isEmpty(etEmail.getText().toString().trim())) {
            etEmail.setError("Enter Email");
            return false;
        }
        if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
            etPhone.setError("Enter Phone");
            return false;
        }
        if (TextUtils.isEmpty(etPrefLanguage.getText().toString().trim())) {
            etPrefLanguage.setError("Enter Preferred Language");
            return false;
        }
        if (TextUtils.isEmpty(etEmergencyContact.getText().toString().trim())) {
            etEmergencyContact.setError("Enter Emergency Contact");
            return false;
        }
        if (TextUtils.isEmpty(etEmergencyContactRelation.getText().toString().trim())) {
            etEmergencyContactRelation.setError("Enter Emergency Contact Relation");
            return false;
        }
        if (TextUtils.isEmpty(etCurrentLocation.getText().toString().trim())) {
            etCurrentLocation.setError("Enter Current Location");
            return false;
        }
        if (TextUtils.isEmpty(etNationality.getText().toString().trim())) {
            etNationality.setError("Enter Nationality");
            return false;
        }
        return true;
    }
}
