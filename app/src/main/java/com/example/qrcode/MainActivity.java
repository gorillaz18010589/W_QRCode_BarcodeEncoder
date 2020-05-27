package com.example.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private EditText editValue;
    private ImageView imgQrCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btn = findViewById(R.id.btn);
        editValue = findViewById(R.id.edit_value);
        imgQrCode = findViewById(R.id.img_qrcode);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                getGenCode();
                break;
        }
    }
    //encodeBitmap(//產生Bitmap型態的條碼,(回傳直Bitmap)
    // String contents,//1.輸入要產生條碼的值
    // BarcodeFormat format,//2.條碼的種類
    // int width, int height)://3.條碼寬,條碼高
    private void getGenCode() {
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        try {
            Bitmap bitmap = barcodeEncoder.encodeBitmap(//產生Bitmap型態的條碼
                    editValue.getText().toString().trim(),//1.輸入要產生條碼的值
                    BarcodeFormat.QR_CODE,//2.條碼的種類
                    250,250);//3.條碼寬,條碼高
            imgQrCode.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        Log.v("hank","getGenCode");
    }
}
