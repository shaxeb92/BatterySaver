package com.example.batterysaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,password,re_pass;
    Button reg_btn, signin_btn;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.user_name);
        password=findViewById(R.id.user_password);
        re_pass=findViewById(R.id.user_retry_password);
        reg_btn=findViewById(R.id.reg_btn);
        signin_btn =findViewById(R.id.signin_btn);
        db=new DBHelper(this);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=name.getText().toString();
                String pass=password.getText().toString();
                String repass=re_pass.getText().toString();

                if(user.equals("") || pass.equals("")||repass.equals(""))
                    Toast.makeText(MainActivity.this, "please Enter all the fields!!", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)){
                        Boolean checkuser=db.checkUserName(user);
                        if(checkuser==false){
                            Boolean insert=db.insertData(user,pass);
                                    if (insert==true){
                                        Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(), DashBoard.class);
                                    startActivity(intent);


                                    }else{
                                        Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                    }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "User already exists! please Sign in", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "password not matching!", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });
    }
}