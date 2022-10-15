package com.example.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText etnama, etNoWa, etAlamat, etPassword, etPin;
    private RadioGroup rgJk;
    private RadioButton rbjk;
    private Button btnDaftar, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = findViewById(R.id.et_nama);
        etNoWa = findViewById(R.id.et_noWhatsapp);
        etAlamat = findViewById(R.id.et_alamat);
        etPassword = findViewById(R.id.et_password);
        etPin = findViewById(R.id.et_pin);
        rgJk = findViewById(R.id.rg_jk);
        btnDaftar = findViewById(R.id.btn_daftar);
        btnDelete = findViewById(R.id.btn_delete);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etnama.getText().toString();
                String noWa = etNoWa.getText().toString();
                String alamat = etAlamat.getText().toString();
                String password = etPassword.getText().toString();
                String pin = etPin.getText().toString();

                int jk_id = rgJk.getCheckedRadioButtonId();
                rbjk = findViewById(jk_id);

                String jk = rbjk.getText().toString();

                if (nama.trim().equals(""))
                {
                    etnama.setError("Nama tidak boleh kosong");
                }
                else if (noWa.trim().equals(""))
                {
                    etNoWa.setError("Nomor Whatsapp tidak boleh kosong");
                }
                else if (alamat.trim().equals(""))
                {
                    etAlamat.setError("Alamat tidak boleh kosong");
                }
                else if (password.trim().equals(""))
                {
                    etPassword.setError("Password tidak boleh kosong");
                }
                else if (noWa.trim().startsWith("08"))
                {
                    if (noWa.trim().length() == 12)
                    {
                        if (pin.trim().equals(""))
                        {
                            etPin.setError("Nomor Whatsapp tidak boleh kosong");
                        }
                        else
                        {
                            Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);

                            intent.putExtra("varNama", nama);
                            intent.putExtra("varNoWhatsapp", noWa);
                            intent.putExtra("varAlamat", alamat);
                            intent.putExtra("varJk", jk);

                            startActivity(intent);
                        }
                    }
                    else
                    {
                        etNoWa.setError("Nomor Whatsapp harus 12 angka");
                    }

                }
                else
                {
                    etNoWa.setError("Nomor harus dimulai dengan angka 08");
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etnama.setText("");
                etNoWa.setText("");
                etAlamat.setText("");
                etPassword.setText("");
                etPin.setText("");
                rgJk.check(R.id.rb_lk);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        etnama.setText("");
        etNoWa.setText("");
        etAlamat.setText("");
        etPassword.setText("");
        etPin.setText("");
        rgJk.check(R.id.rb_lk);
    }
}