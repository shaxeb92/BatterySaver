package com.example.batterysaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button login_btn;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        username=findViewById(R.id.user_name_login);
        password=findViewById(R.id.user_pass_login);
        login_btn=findViewById(R.id.sign_in_btn);
        db=new DBHelper(this);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkpass=db.checkUserPassword(user,pass);
                        if (checkpass==true){
                            Toast.makeText(LoginActivity.this, "Sign in Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(), DashBoard.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(LoginActivity.this, "Invalid Data", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });


    }
}