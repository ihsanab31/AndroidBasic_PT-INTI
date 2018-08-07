package com.ycreation.ihsan.pelatihan;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CapcinActivity extends AppCompatActivity {
    TextView txt_hasil, txt_jumlah;
    Button btn_plus, btn_min, btn_order, btn_claer;
    EditText et_name;
    CheckBox cb_jeruk, cb_manggo, cb_melon;
    String rasa = "";
    int jumlah = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffe);
        btn_min = findViewById(R.id.btn_min);
        btn_plus = findViewById(R.id.btn_plus);
        btn_claer = findViewById(R.id.btn_clear);
        btn_order = findViewById(R.id.btn_order);
        et_name = findViewById(R.id.et_nama);
        cb_jeruk = findViewById(R.id.cb_jeruk);
        cb_manggo = findViewById(R.id.cb_manggo);
        cb_melon = findViewById(R.id.cb_melon);
        txt_jumlah = findViewById(R.id.txt_jumlah);
        txt_hasil = findViewById(R.id.txt_hasil);
        btn_min.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if (jumlah == 1) {
                    Toast.makeText(getApplicationContext(),
                            "Jumlah Tidak Boleh Nol ",
                            Toast.LENGTH_SHORT).show();
                } else
                    jumlah = jumlah - 1;
                    txt_jumlah.setText("" + jumlah);
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                jumlah = jumlah + 1;
                txt_jumlah.setText("" + jumlah);
            }
        });
        btn_order.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                getCheck();
                txt_hasil.setText("Name : " +
                        et_name.getText().toString() +
                        "\nOrder Amount : " + jumlah + "\nTaste : "
                         + rasa + "\nThank You");
                txt_hasil.setVisibility(View.VISIBLE);
                btn_claer.setVisibility(View.VISIBLE);
            }
        });
        btn_claer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_hasil.setText("");
                rasa = "";
                txt_hasil.setVisibility(View.GONE);
                btn_claer.setVisibility(View.GONE);
            }
        });
    }

    public void getCheck() {
        if (cb_jeruk.isChecked()) {
            rasa += " Orange Flavor";
        }
        if (cb_melon.isChecked()) {
            rasa += " Melon Flavor";
        }
        if (cb_manggo.isChecked()) {
            rasa += " Manggo Flavor";
        }
    }
}
