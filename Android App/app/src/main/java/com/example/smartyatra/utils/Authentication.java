package com.example.smartyatra.utils;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.smartyatra.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Authentication {

    private static List<JSONObject> UserList = new ArrayList<>();
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    // Initialize login protocol (fetch users in background)
    public static void initializeLoginProtocol(Runnable onDone) {
        executor.execute(() -> {
            fetchUsers();
            if (onDone != null) onDone.run();
        });
    }

    public static JSONObject getUserByEmail(String email) {
        Callable<JSONObject> task = () -> {
            for (JSONObject a : UserList) {
                try {
                    if (email.equals(a.getString("email"))) {
                        return a; // Return matched user
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null; // Not found
        };

        try {
            Future<JSONObject> future = executor.submit(task);
            return future.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void fetchUsers() {
        try {
            JSONArray jsonArray = getJsonArray();
            UserList.clear();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject user = jsonArray.getJSONObject(i);
                UserList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONArray getJsonArray() throws IOException, JSONException {
        URL url = new URL("https://surajgola.pythonanywhere.com/users");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        return new JSONArray(response.toString());
    }

}
