package com.example.selva.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void onButtonClick(View v) {
        EditText e1 = (EditText) findViewById(R.id.editText2);
        EditText e2 = (EditText) findViewById(R.id.editText3);
        EditText e3 = (EditText) findViewById(R.id.editText4);

        int date=Integer.parseInt(e1.getText().toString());
        int month=Integer.parseInt(e2.getText().toString());
        int year=Integer.parseInt(e3.getText().toString());

        int ayear=0,E=0,total=0;
        if((date>=1 && date<=31) && (month>=1 && month<=12) && (year>=1000 && year <=9999))
        {
            int a=year%100;
            int b=year-a;
            if(b%400==0)
            {
                ayear=0;
            }
            else if((b+100)%400==0)
            {
                ayear=1;
            }
            else if((b+200)%400==0)
            {
                ayear=2;
            }
            else if((b+300)%400==0)
            {
                ayear=3;
            }
                int c=a/4;
                int d=c+a;
                d=d%7;

                E=d+ayear;

            // System.out.println("Year is :%d",E);

            if((month == 1) && (year % 400 == 0)){
                month = 5;
            }
            if((month == 2) && (year % 400 == 0)){
                month = 1;
            }
            if((month==2 && (year%400 != 0))||month==3||month==11)
            {
                month=2;
            }
            else if((month==1 && (year %400 != 0))||month==10)
            {
                month=6;
            }
            else if(month==4||month==7)
            {
                month=5;
            }
            else if(month==5)
            {
                month=0;
            }
            else if(month==6)
            {
                month=3;
            }
            else if(month==8)
            {
                month=1;
            }
            else if(month==9||month==12)
            {
                month=4;
            }


            //System.out.println("\nMonth is :%d",month);
            if(date>=7)
            {
                date=date%7;
            }
            //System.out.println("\nDate is :%d",date);


            total=(E+month+date)%7;
            //System.out.println("\n%d is belong to ",total);
            TextView textView;
            textView = (TextView) findViewById(R.id.e5);

            switch(total)
            {
                case 0:textView.setText("SUNDAY");;break;
                case 1:textView.setText("MONDAY");break;
                case 2:textView.setText("TUESDAY");break;
                case 3:textView.setText("WEDNESDAY");break;
                case 4:textView.setText("THURSDAY");break;
                case 5:textView.setText("FRIDAY");break;
                case 6:textView.setText("SATURDAY");break;
                default:;
            }
        }
        else
        {
            TextView textView;
            textView = (TextView) findViewById(R.id.e5);
            textView.setText("R U FOOL!!!");
        }

        }
    }
