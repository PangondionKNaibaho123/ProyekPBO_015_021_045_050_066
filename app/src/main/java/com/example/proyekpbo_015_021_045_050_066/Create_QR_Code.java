package com.example.proyekpbo_015_021_045_050_066;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Create_QR_Code extends AppCompatActivity {

    private EditText etInput;
    private EditText etInput1;
    private EditText etInput2;
    private EditText etInput3;
    private EditText etInput4;
    private EditText etInput5;
    private Button btnCreateQr;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__qr__code);
        getSupportActionBar().setTitle("Create QR Code");

        etInput1 = findViewById(R.id.etInput1);
        etInput2 = findViewById(R.id.etInput2);
        etInput3 = findViewById(R.id.etInput3);
        etInput4 = findViewById(R.id.etInput4);
        etInput5 = findViewById(R.id.etInput5);

        btnCreateQr = findViewById(R.id.btnCreate);
        imageView = findViewById(R.id.imageView);

        btnCreateQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = etInput1.getText().toString().trim();
                String text2 = etInput2.getText().toString().trim();
                String text3 = etInput3.getText().toString().trim();
                String text4 = etInput4.getText().toString().trim();
                String text5 = etInput5.getText().toString().trim();

                String text6 = toString_(text1,text2,text3,text4,text5);

                if((text6 != null)){
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

                    try {
                        BitMatrix bitMatrix = multiFormatWriter.encode(text6, BarcodeFormat.QR_CODE, 500,500);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                        imageView.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                }
            }

            public String toString_(String e1,String e2,String e3,String e4,String e5){
                return "Absensi Berhasil\n\n"+ "Kode Dosen : " + e1+"\n"+ "ID Matakuliah : "+ e2+"\n"+ "Nomor Sesi : " + e3 +"\n"+ "Tanggal : " + e4+"\n"+"Ruangan : "+e5;
            }
        });
    }
}
