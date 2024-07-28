package com.example.uas_mpcoba1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uas_mpcoba1.databinding.ActivityLoginBinding;
import com.example.uas_mpcoba1.model.ResponseLogin;
import com.example.uas_mpcoba1.network.ApiClient;
import com.example.uas_mpcoba1.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private String user = "";
    private String pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
//
//        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                user = binding.txtUsername.getText().toString();
//                pass = binding.txtPassword.getText().toString();
//                Log.d("LoginProcess", "Username: " + user + ", Password: " + pass);
//
//                if (user.isEmpty()) {
//                    binding.txtUsername.setError("Username tidak boleh kosong!");
//                } else if (pass.isEmpty()) {
//                    binding.txtPassword.setError("Password tidak boleh kosong!");
//                } else {
//                    binding.loading.setVisibility(View.VISIBLE);
//                    getData();
//                }
//            }
//        });
//    }
//
//    private void getData() {
//        RetrofitClient api = (RetrofitClient) RetrofitClient.getInstance();
//        ((ApiClient) api).login(user, pass).enqueue(new Callback<ResponseLogin>() {
//            @Override
//            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
//                binding.loading.setVisibility(View.GONE);
//                if (response.isSuccessful() && response.body() != null) {
//                    Log.d("LoginResponse", "Response: " + response.body());
//                    if (response.body().getResponse()) {
//                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                        finish();
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Login gagal. Periksa kembali username dan password", Toast.LENGTH_LONG).show();
//                    }
//                } else {
//                    Toast.makeText(LoginActivity.this, "Login gagal, terjadi kesalahan: " + response.code(), Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseLogin> call, Throwable t) {
//                binding.loading.setVisibility(View.GONE);
//                Toast.makeText(LoginActivity.this, "Login gagal, terjadi kesalahan: " + t.getMessage(), Toast.LENGTH_LONG).show();
//                Log.e("Pesan error", t.getMessage());
//            }
//        });
//    }

