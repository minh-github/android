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
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtMH;
    Button btnAdd,btnUpdate,btnDel;
    ListView lvMH;
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
                boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch(view.getId()) {
                    case R.id.radio_giaokhoa:
                        if (checked)
                            theloai = "giáo khoa";
                            break;
                    case R.id.radio_khoahoc:
                        if (checked)
                            theloai = "giáo khoa";
                            break;
                    case R.id.radio_tieuthuyet:
                        if (checked)
                            theloai = "tiểu thuyết";
                        break;
                    case R.id.radio_tamly:
                        if (checked)
                            theloai = "tâm lý";
                        break;
                }
//                tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,tenmh,theloai));
                tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,tenmh,theloai));
                edtMH.setText(" ");
                MyAdapter adapter = new MyAdapter(MainActivity.this,tenMH);
                lvMH.setAdapter(adapter);
            }
        });

//        tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,"lập trình android",3));
//        tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,"lập trình android",3));
//        tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,"lập trình android",3));
//        tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,"lập trình android",3));
//        tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,"lập trình android",3));
//        tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,"lập trình android",3));
//        tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,"lập trình android",3));
//        tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,"lập trình android",3));
//        tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,"lập trình android",3));
//        tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,"lập trình android",3));
//        tenMH.add(new MonHoc(R.drawable.baseline_crop_original_24,"lập trình android",3));
////                edtMH.setText(" ");
//        MyAdapter adapter = new MyAdapter(MainActivity.this,tenMH);
//        lvMH.setAdapter(adapter);


//        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,tenMH);
//        lvMH.setAdapter(adapter);

//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

//        lvMH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                edtMH.setText(tenMH.get(i));
//                vitri = i;
//            }
//        });
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tenMH.set(vitri,edtMH.getText().toString());
//                adapter.notifyDataSetChanged();
//                Toast.makeText(MainActivity.this, "da sua thanh cong", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        btnDel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tenMH.set(vitri,edtMH.getText().toString());
//                tenMH.remove(vitri);
//                adapter.notifyDataSetChanged();
//                Toast.makeText(MainActivity.this, "da xoa thanh cong", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        lvMH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("Mon-hoc",tenMH.get(i));
//                intent.putExtras(bundle);
//                startActivity(intent);
//                return false;
//            }
//        });

    }
}