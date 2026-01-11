package com.example.smartyatra;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SecurityFragment extends Fragment implements OnMapReadyCallback {

    private static final String TAG = "SecurityFragment";
    private static final int PERM_REQUEST = 1001;
    private static final String BASE_URL = "API_Base_URL"; //update the base url here
    private static final String UPDATE_ENDPOINT = "location/update";

    private FusedLocationProviderClient fusedClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;

    private GoogleMap googleMap;
    private Marker marker;

    private String etUsername;
    private Button btnStart, btnStop;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_security, container, false);

        btnStart = rootView.findViewById(R.id.btnStart);
        btnStop = rootView.findViewById(R.id.btnStop);

        SharedPreferences pref = requireActivity().getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
        etUsername = pref.getString("name", "Guest");

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) mapFragment.getMapAsync(this);

        fusedClient = LocationServices.getFusedLocationProviderClient(requireContext());

        locationRequest = LocationRequest.create()
                .setInterval(1000L)
                .setFastestInterval(500L)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult result) {
                Location loc = result.getLastLocation();
                if (loc != null) {
                    onLocationUpdate(loc);
                }
            }
        };

        btnStart.setOnClickListener(v -> {
            if (checkLocationPermission()) {
                startLocationUpdates();
            } else {
                requestLocationPermission();
            }
        });

        btnStop.setOnClickListener(v -> stopLocationUpdates());

        return rootView;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        this.googleMap = map;
    }

    private void onLocationUpdate(Location location) {
        double lat = location.getLatitude();
        double lon = location.getLongitude();

        if (!isAdded()) return;

        requireActivity().runOnUiThread(() -> {

            LatLng pos = new LatLng(lat, lon);
            if (googleMap != null) {
                if (marker == null) {
                    marker = googleMap.addMarker(new MarkerOptions()
                            .position(pos)
                            .title(etUsername));
                } else {
                    marker.setPosition(pos);
                }
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 16f));
            }
        });

        sendLocationToServer(etUsername.trim(), lat, lon);
    }

    private void startLocationUpdates() {
        try {
            fusedClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);
        } catch (SecurityException e) {
            Log.w(TAG, "startLocationUpdates: permission missing");
        }
    }

    private void stopLocationUpdates() {
        fusedClient.removeLocationUpdates(locationCallback);
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
    }

    private boolean checkLocationPermission() {
        return ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED;
    }

    private void requestLocationPermission() {
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERM_REQUEST);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == PERM_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationUpdates();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void sendLocationToServer(String username, double lat, double lon) {
        new Thread(() -> {
            try {
                JSONObject json = new JSONObject();
                json.put("user_id", username);
                json.put("latitude", lat);
                json.put("longitude", lon);
                json.put("timestamp", System.currentTimeMillis());

                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(mediaType, json.toString());

                Request request = new Request.Builder()
                        .url(BASE_URL + UPDATE_ENDPOINT)
                        .post(body)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    String resp = response.body() != null ? response.body().string() : "null";

                    if (!isAdded()) return;

                    requireActivity().runOnUiThread(() -> {
                        if (!response.isSuccessful()) {
                            Toast.makeText(requireContext(),
                                    "Server error: " + response.code(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(requireContext(),
                                    "Sent OK: " + resp,
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } catch (Exception e) {
                Log.e(TAG, "Network error", e);
                if (!isAdded()) return;
                requireActivity().runOnUiThread(() ->
                        Toast.makeText(requireContext(),
                                "Network error: " + e.getMessage(),
                                Toast.LENGTH_SHORT).show());
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopLocationUpdates();
    }
}
