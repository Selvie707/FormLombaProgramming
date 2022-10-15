package com.example.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity {

    DatePickerDialog dpd;
    private TextView tv_Nama, tv_jk, tvNoWa, tvAlamat, tv_tanggal;
    private Button btn_tanggal, btn_konfirmasi;
    private String nama, jk, noWa, alamat, choosenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        tv_Nama = findViewById(R.id.tv_nama);
        tv_jk = findViewById(R.id.tv_jk);
        tvNoWa = findViewById(R.id.tv_no_whatsapp);
        tvAlamat = findViewById(R.id.tv_alamat);
        tv_tanggal = findViewById(R.id.tv_tanggal);

        btn_tanggal = findViewById(R.id.btn_tanggal);
        btn_konfirmasi = findViewById(R.id.btn_konfirmasi);

        //ambil intent yang dikirim activity
        Intent terimaIntent = getIntent();
        nama = terimaIntent.getStringExtra("varNama");
        jk = terimaIntent.getStringExtra("varJk");
        noWa = terimaIntent.getStringExtra("varNoWhatsapp");
        alamat = terimaIntent.getStringExtra("varAlamat");

        //set variabel
        tv_Nama.setText(nama);
        tv_jk.setText(jk);
        tvNoWa.setText(noWa);
        tvAlamat.setText(alamat);

        //Button Tanggal
        btn_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar newCalender = Calendar.getInstance();

                dpd = new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String tahun = Integer.toString(year);
                        String bulan = Integer.toString(month+1);
                        String tanggal = Integer.toString(dayOfMonth);
                        choosenDate = tanggal + "/" + bulan + "/" + tahun;
                        tv_tanggal.setText(choosenDate);
                    }
                }, newCalender.get(Calendar.YEAR), newCalender.get(Calendar.MONTH), newCalender.get(Calendar.DAY_OF_MONTH));

                //Tampilkan Date Picker
                dpd.show();
            }
        });

        btn_konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah data Anda sudah benar?");

                //Button Positif
                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(ConfirmActivity.this,
                                "Terima kasih, pendaftaran Anda berhasil",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                //Button Negatif
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                    }
                });

                //Tampilkan Dialog
                dialog.show();
            }
        });
    }
}