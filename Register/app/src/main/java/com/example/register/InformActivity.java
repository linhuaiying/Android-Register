package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class InformActivity extends AppCompatActivity {
    private TextView usname;
    Map<String,String > account;
    private EditText niname;
    private  EditText sex;
    private  EditText signal;
    MyHelper myHelper;
    SQLiteDatabase db;
    ContentValues values;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informlayout);
        myHelper=new MyHelper(this);
        init();
    }
    private void init()
    {
        usname=findViewById(R.id._user_name);
        niname=findViewById(R.id._name);
        sex=findViewById(R.id.sex);
        signal=findViewById(R.id.signal);
        account=SaveAccount.getUserInfo(this);
        usname.setText(account.get("account"));
      if(!isExitAccount())
       {
          Insert();
      }
        Select();
    }
    public void onSaveClick(View view)
    {
        //数据库存储
        Update();
    }
    public void Insert()
    {
        db=myHelper.getWritableDatabase();
        values=new ContentValues();
        values.put("account",usname.getText().toString());
        values.put("niname",niname.getText().toString());
        values.put("sex",sex.getText().toString());
        values.put("signal",signal.getText().toString());
        db.insert("information",null,values);
        //db.execSQL("insert into information (account,niname,sex,signal) values (?,?,?,?)",new Object[]{usname.getText().toString(),niname.getText().toString(),sex.getText().toString(),signal.getText().toString()});
       // Toast.makeText(this,"插入数据成功",Toast.LENGTH_SHORT).show();
        db.close();
    }
    public void Select()
    {
        db=myHelper.getReadableDatabase();
        Cursor cursor=db.query("information",null,"account=?",new String[]{usname.getText().toString()},null,null,null);
        if(cursor.getCount()==0)
        {
            //Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
        }
        else
        { //有问题
            cursor.moveToFirst();
            String name=cursor.getString(1);
            String _sex=cursor.getString(2);
            String _signal=cursor.getString(3);
            niname.setText(name);
            sex.setText(_sex);
            signal.setText(_signal);

        }
        cursor.close();
        db.close();
    }
     public void Update()
     {
         db=myHelper.getWritableDatabase();
         values=new ContentValues();
        values.put("niname",niname.getText().toString());
        values.put("sex",sex.getText().toString());
        values.put("signal",signal.getText().toString());
         db.update("information",values,"account=?",new String[]{usname.getText().toString()});//
         Toast.makeText(this,"信息已修改",Toast.LENGTH_SHORT).show();
         db.close();
     }
    public boolean isExitAccount()
    {
        db=myHelper.getReadableDatabase();
        Cursor cursor=db.query("information",null,"account=?",new String[]{usname.getText().toString()},null,null,null);
        if(cursor.getCount()==0)
        {
            //Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public void onBackClick(View view)
    {
        finish();
    }
}

