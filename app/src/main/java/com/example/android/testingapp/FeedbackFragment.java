package com.example.android.testingapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {

    public FeedbackFragment() {
        // Required empty public constructor
    }

    // Creating global variables
    Button sendEmail;
    EditText name;
    EditText message;
    String subject;
    String emailText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_feedback, container, false);

        // Find the editTexts and submit button
        sendEmail = rootView.findViewById(R.id.send_email);
        name = rootView.findViewById(R.id.edit_text_name);
        message = rootView.findViewById(R.id.edit_text_message);

        // Set click listener on submit button to send email
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
        return rootView;
    }

    // Method to send email
    public void sendMessage() {

        // Create subject and email text
        subject = name.getText().toString() + getString(R.string.user_feedback);
        emailText =message.getText().toString();

        // Create intent to send email
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:bogdan.e.corcoveanu@gmail.com")); // only email apps should handle this
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT, emailText);

        // Send email
        if(i.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(i);
        }
    }

}
