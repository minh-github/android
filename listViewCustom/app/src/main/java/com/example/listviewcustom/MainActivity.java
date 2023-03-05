package com.example.listviewcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtMH;
    Button btnAdd,btnUpdate,btnDel;
    ListView lvMH;

    RadioGroup rdigroup;
    ArrayList<MonHoc> tenMH;
    int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMH = findViewById(R.id.tenSach);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDel = findViewById(R.id.btnDel);


        lvMH = findViewById(R.id.lvMonHoc);

        tenMH = new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenmh = edtMH.getText().toString();
                String theloai = "trống";
                rdigroup	=	(RadioGroup) findViewById(R.id.group_theloai);
                int idChecked	=	rdigroup.getCheckedRadioButtonId();
                switch(idChecked){
                    case R.id.radio_giaokhoa:
                            theloai = "giáo khoa";
                            break;
                    case R.id.radio_khoahoc:
                            theloai = "giáo khoa";
                            break;
                    case R.id.radio_tieuthuyet:
                            theloai = "tiểu thuyết";
                            break;
                    case R.id.radio_tamly:
                            theloai = "tâm lý";
                        break;
                }

                tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,tenmh,theloai));
                edtMH.setText(" ");
                MyAdapter adapter = new MyAdapter(MainActivity.this,tenMH);
                lvMH.setAdapter(adapter);
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