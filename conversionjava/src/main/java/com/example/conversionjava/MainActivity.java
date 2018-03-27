package com.example.conversionjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText num;
    EditText result;
    Button con;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num=(EditText)findViewById(R.id.etNum);
        result=(EditText)findViewById(R.id.etResult);
        res=(TextView)findViewById(R.id.txtRes);
        con=(Button)findViewById(R.id.btnConvert);
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no=Integer.parseInt(num.getText().toString());
                String rs=convert(no);
                result.setText(rs);
                res.setText(rs);
            }
        });

    }
    public static final String units[]={"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static final String tens[]={"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


    public static final  String convert(int i){

        if (i < 20) {
            return units[i];
        }
        else{

        }

        if (i < 100) {
            return tens[i / 10] + ((i % 10 != 0) ? " " : "") + units[i % 10];

        }
        if (i < 1000) {
            return units[i / 100] + " Hundred" + ((i % 100 != 0) ? " " : "") + convert(i % 100);

        }
        if(i<100000){
            return convert(i / 1000) + " Thousand" + ((i % 10000 != 0) ? " " : "") + convert(i % 1000);
        }
        if (i < 10000000){
            return convert(i / 100000) + " Lakh" + ((i % 100000 != 0) ? " " : "") + convert(i % 100000);
        }
        return convert(i / 10000000) + " crore " + ((i % 10000000 > 0)? " ":"  ") + convert(i % 10000000);
    }
}

