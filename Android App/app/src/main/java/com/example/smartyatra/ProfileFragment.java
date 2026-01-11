package com.example.smartyatra;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private TextView profileName;
    private TextView emailView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);


        profileName = root.findViewById(R.id.profile_name);
        emailView = root.findViewById(R.id.profile_email);
        ImageView avatarView = root.findViewById(R.id.profile_image);
        avatarView.setImageResource(R.drawable.ic_profile_avatar);

        // Option Views
        View optionTrips = root.findViewById(R.id.option_trips);
        View optionLanguage = root.findViewById(R.id.option_language);
        View optionEditProfile = root.findViewById(R.id.option_editprofile);
        View optionNotifications = root.findViewById(R.id.option_notifications);
        View optionFeedback = root.findViewById(R.id.option_feedback);
        View optionLogout = root.findViewById(R.id.option_logout);

        optionTrips.setOnClickListener(v -> {
            // TODO: Implement See Trips Done action
        });

        optionLanguage.setOnClickListener(v -> {
            // TODO: Implement Change Language action
        });

        optionEditProfile.setOnClickListener(v -> {
            // TODO: Implement Edit Profile action
        });

        optionNotifications.setOnClickListener(v -> {
            // TODO: Implement Notification Settings action
        });

        optionFeedback.setOnClickListener(v -> {
            // TODO: Implement Rating and Feedback action
        });

        optionLogout.setOnClickListener(v -> {
            SharedPreferences Pref = requireActivity().getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = Pref.edit();
            editor.clear();
            editor.apply();
            Intent intent = new Intent(requireActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPref = requireActivity().getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
        String name = sharedPref.getString("name", "Guest"); // "Guest" = default if not logged in
        String email = sharedPref.getString("email","NA");
        profileName.setText(name);
        emailView.setText(email);
    }

}
