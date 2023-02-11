package com.example.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtMH;
    Button btnAdd,btnUpdate,btnDel;
    ListView lvMH;
    ArrayList<String> tenMH;

    int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtMH = findViewById(R.id.tenMonHoc);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDel = findViewById(R.id.btnDel);
        lvMH = findViewById(R.id.lvMonHoc);

        tenMH = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,tenMH);
        lvMH.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenmh = edtMH.getText().toString();
                tenMH.add(tenmh);
                edtMH.setText(" ");
                adapter.notifyDataSetChanged();
            }
        });

        lvMH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMH.setText(tenMH.get(i));
                vitri = i;
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenMH.set(vitri,edtMH.getText().toString());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "da sua thanh cong", Toast.LENGTH_SHORT).show();

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tenMH.set(vitri,edtMH.getText().toString());
                tenMH.remove(vitri);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "da xoa thanh cong", Toast.LENGTH_SHORT).show();
            }
        });

        lvMH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("Mon-hoc",tenMH.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
                return false;
            }
        });

    }
}