package com.example.smartyatra;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DishaAIFragment extends Fragment {

    private EditText etMessage;
    private ImageButton btnSend;
    private LinearLayout chatArea;
    private ScrollView chatScroll;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_disha_ai, container, false);

        etMessage = root.findViewById(R.id.etMessage);
        btnSend = root.findViewById(R.id.btnSend);
        chatArea = root.findViewById(R.id.chatArea);  // LinearLayout inside ScrollView to hold chat bubbles
        chatScroll = root.findViewById(R.id.chatScroll); // ScrollView for scrolling chat bubbles

        btnSend.setOnClickListener(v -> {
            String msg = etMessage.getText().toString().trim();
            if (!TextUtils.isEmpty(msg)) {
                addMessageBubble(msg, true);   // user message
                etMessage.setText("");
                etMessage.postDelayed(() -> addMessageBubble(getBotResponse(msg), false), 600);  // bot reply delayed
            }
        });

        return root;
    }

    // Dynamically add chat message bubble to chat area
    private void addMessageBubble(String message, boolean isUser) {
        TextView bubble = new TextView(getContext());
        bubble.setText(message);
        bubble.setTextSize(16f);
        bubble.setTextColor(0xFF222c34); // Dark text color
        bubble.setBackgroundResource(R.drawable.bg_chat_bubble);
        bubble.setPadding(28, 20, 28, 20);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.topMargin = 18;
        params.gravity = isUser ? Gravity.END : Gravity.START;
        bubble.setLayoutParams(params);

        chatArea.addView(bubble);

        // Scroll to bottom after adding bubble
        chatScroll.post(() -> chatScroll.fullScroll(View.FOCUS_DOWN));
    }

    // Hardcoded bot response - replace with real AI logic as needed
    private String getBotResponse(String userMessage) {
        return "I received: \"" + userMessage + "\". How can I assist further?";
    }
}
