package com.unlucky.assignment3.ui;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.unlucky.assignment3.R;
import com.unlucky.assignment3.user.buyer.BuyerDetail;
import com.unlucky.assignment3.user.buyer.BuyerMain;
import com.unlucky.assignment3.user.seller.SellerMain;
import com.google.firebase.firestore.Query.Direction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class WelcomePage extends AppCompatActivity {

    Button signInButton;
    TextView signUpButton;
    boolean isBuyer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome_page);


        signUpButton = findViewById(R.id.signUpWelcomeButton);
        signInButton = findViewById(R.id.signInButton);



        signInButton.setOnClickListener(v -> {
            if (logIn()) {
                Intent i;
                if (isBuyer) {
                    i = new Intent(this, BuyerMain.class);
                } else {

                    i = new Intent(this, SellerMain.class);
                }
                startActivity(i);
                finish();
            }
        });
    }

    public boolean logIn() {
        boolean isValid = true;

        return  isValid;
    }

    public void signUp_action(View view) {
        signUpButton.setOnClickListener(v -> {
            Intent i = new Intent(this, SignUpPage.class);
            startActivity(i);
            finish();
        });
    }
}