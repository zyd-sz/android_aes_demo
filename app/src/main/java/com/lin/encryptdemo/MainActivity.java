package com.lin.encryptdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lin.encryptdemo.utlis.EncryptUtlis;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.et_data)
    EditText etData;
    @Bind(R.id.et_key)
    EditText etKey;
    @Bind(R.id.btn_en)
    Button btnEn;
    @Bind(R.id.btn_de)
    Button btnDe;
    @Bind(R.id.btn_c)
    Button btnC;
    @Bind(R.id.tv_en)
    TextView tvEn;
    @Bind(R.id.tv_de)
    TextView tvDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("加解密Demo");
        ButterKnife.bind(this);

        // 加密
        btnEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etData.getText().toString();
                String key = etKey.getText().toString();
                if (TextUtils.isEmpty(data)) {
                    Toast.makeText(MainActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(key)) {
                    Toast.makeText(MainActivity.this, "请输入key", Toast.LENGTH_SHORT).show();
                } else {
                    String newData = EncryptUtlis.encrypt(data, key);
                    tvEn.setText(newData == null ? "加密错误" : newData);
                }
            }
        });

        // 解密
        btnDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String en = tvEn.getText().toString();
                String key = etKey.getText().toString();
                if (TextUtils.isEmpty(en)) {
                    Toast.makeText(MainActivity.this, "请先加密", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(key)) {
                    Toast.makeText(MainActivity.this, "请输入key", Toast.LENGTH_SHORT).show();
                } else {
                    String newData = EncryptUtlis.decrypt(en, key);
                    tvDe.setText(newData == null ? "key错误" : newData);
                }
            }
        });

        // 清空
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etData.setText("");
                etKey.setText("");
                tvEn.setText("");
                tvDe.setText("");
            }
        });
    }

}
