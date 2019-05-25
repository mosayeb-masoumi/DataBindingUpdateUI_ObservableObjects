package com.example.databindingupdateui_observableobjects;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.databindingupdateui_observableobjects.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private User user;
    private ClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);


        user= new User();
        user.setFirstName("hassan");
        user.setLastName("masoumi");
        binding.setUser(user);

                                          // content  the id for layout included
        clickHandler =new ClickHandler(binding.content.edtFirstName , binding.content.edtLastName);
        binding.content.setClickHandler(clickHandler);

    }


    public class ClickHandler {

        private EditText fName,lName;

        public ClickHandler(EditText fName, EditText lName) {
            this.fName = fName;
            this.lName = lName;
        }

        public void updateUser(View view){
            user.setFirstName(fName.getText().toString());
            user.setLastName(lName.getText().toString());

            fName.setText("");
            lName.setText("");
        }
    }

}
