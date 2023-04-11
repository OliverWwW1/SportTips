package com.example.sporttips.ui.notifications;

import static com.example.sporttips.Start.Login.LoginUser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sporttips.Adapter.LeibieAdapter;
import com.example.sporttips.Bean.LeibieBean;
import com.example.sporttips.Database.DBUtils;
import com.example.sporttips.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class UpdateLeibie extends AppCompatActivity implements View.OnClickListener {
    private ListView mlistview;
    private FloatingActionButton floatingActionButton;
    private AlertDialog.Builder builder;
    private LeibieAdapter leibieAdapter;
    private List<LeibieBean> mlist;
    private DBUtils dbUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_leibie);
        initView();
        initListener();
        mlistview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int j, long l) {

                return true;
            }
        });
    }
    public void initView(){
        mlistview = findViewById(R.id.list_leibie);
        floatingActionButton = findViewById(R.id.add_leibie);
        dbUtils = new DBUtils();
        try {
            leibieAdapter = new LeibieAdapter(this,dbUtils.QueryLeibie(LoginUser));
            mlistview.setAdapter(leibieAdapter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void initListener(){
        floatingActionButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_leibie:
                showInput();
                break;
        }
    }
    private void showInput() {
        final EditText editText = new EditText(this);
        builder = new AlertDialog.Builder(this).setTitle("Enter a new category").setView(editText)
                .setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            if (dbUtils.AddLeibie(editText.getText().toString())==0){
                                Toast.makeText(UpdateLeibie.this, "Failed", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(UpdateLeibie.this, "Success", Toast.LENGTH_SHORT).show();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
        builder.create().show();
    }
    private void showTwo(String leibie) {
        builder = new AlertDialog.Builder(this).setIcon(R.drawable.richeng_delete).setTitle("Delete a category")
                .setMessage("Whether to delete the category").setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //DeleteLeibie(leibie);

                    }
                }).setNegativeButton("Canel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });
        builder.create().show();
    }
}