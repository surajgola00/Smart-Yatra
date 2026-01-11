package com.example.smartyatra;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
// Remove this import if DishaAIFragment is just a simple fragment layout for now
// import com.example.smartyatra.DishaAIFragment;

public class MainActivity extends AppCompatActivity { // Ensure this is a class

    private BottomNavigationView bottomNavigationView;
    Fragment homeFragment, securityFragment, dishaAiFragment, profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure you have activity_main.xml

        // Initialize your fragments.
        // If DishaAIFragment is meant to be a simple layout for now:
        homeFragment = new SimpleFragment(R.layout.fragment_home);
        securityFragment = new SecurityFragment();
        dishaAiFragment = new DishaAIFragment(); // Assuming you have fragment_disha_ai.xml
        // If DishaAIFragment is a custom class with its own logic, ensure it's correctly defined:
        // dishaAiFragment = new DishaAIFragment();
        profileFragment = new ProfileFragment();

        bottomNavigationView = findViewById(R.id.bottomNavigationView); // Make sure this ID exists in activity_main.xml

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, homeFragment) // Make sure R.id.fragmentContainer exists in activity_main.xml
                    .commit();
        }

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment;
            int id = item.getItemId();

            if (id == R.id.nav_home) { // Make sure these IDs exist in your menu resource
                selectedFragment = homeFragment;
            } else if (id == R.id.nav_security) {
                selectedFragment = securityFragment;
            } else if (id == R.id.nav_disha_ai) {
                selectedFragment = dishaAiFragment;
            } else if (id == R.id.nav_profile) {
                selectedFragment = profileFragment;
            } else {
                selectedFragment = homeFragment;
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, selectedFragment)
                    .commit();
            return true;
        });
    }

    // This SimpleFragment class can be an inner class or a separate public class
    public static class SimpleFragment extends Fragment {
        public SimpleFragment(int layoutRes) {
            super(layoutRes);
        }
    }
}
