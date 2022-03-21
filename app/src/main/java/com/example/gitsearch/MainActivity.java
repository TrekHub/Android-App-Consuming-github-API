package com.example.gitsearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.gitsearch.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    String gitEmail;
    String emailPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    String name;
    String gitId;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();
        gitEmail = mSharedPreferences.getString(Constants.PREFERENCES_EMAIL_KEY, null);
        binding.gitBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        firebaseAuth = FirebaseAuth.getInstance();
        if (view == binding.gitBtn) {

            gitEmail = binding.gitSignForm.getText().toString();
            if (!(gitEmail).equals("")) {
                addToSharedPreferences(gitEmail);

            }
            if (!gitEmail.matches(emailPattern)) {
                Toast.makeText(this, "Enter a Valid Email", Toast.LENGTH_SHORT).show();
            } else {
                OAuthProvider.Builder provider = OAuthProvider.newBuilder("github.com");
                // Target specific email with login hint.
                provider.addCustomParameter("login", gitEmail);

                List<String> scopes =
                        new ArrayList<String>() {
                            {
                                add(gitEmail);
                            }
                        };
                provider.setScopes(scopes);
                Task<AuthResult> pendingResultTask = firebaseAuth.getPendingAuthResult();
                if (pendingResultTask != null) {
                    // There's something already here! Finish the sign-in for your user.
                    pendingResultTask
                            .addOnSuccessListener(
                                    new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
                                        }
                                    })
                            .addOnFailureListener(
                                    new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            // Handle failure.
                                            Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();

                                        }
                                    });
                } else {
                    firebaseAuth
                            .startActivityForSignInWithProvider(this, provider.build())
                            .addOnSuccessListener(
                                    new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
                                            firebaseUser = firebaseAuth.getCurrentUser();
                                            if (firebaseUser != null) {
                                                name = firebaseUser.getDisplayName();
                                                gitEmail = firebaseUser.getEmail();
                                                gitId = firebaseUser.getProviderData().get(1).getUid();


                                            }

                                            openActivity();
                                        }
                                    })
                            .addOnFailureListener(
                                    new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            // Handle failure.
                                            Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                }

            }

        }

    }

    private void addToSharedPreferences(String gitEmail) {
        mEditor.putString(Constants.PREFERENCES_EMAIL_KEY, gitEmail).apply();
    }

    private void openActivity() {
        Intent intent = new Intent(MainActivity.this, DashBoard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("gitEmail", gitEmail);
        intent.putExtra("name", name);
        intent.putExtra("gitId", gitId);
        startActivity(intent);
        finish();


    }
}