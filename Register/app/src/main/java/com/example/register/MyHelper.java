package com.example.register;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;
        import android.widget.Toast;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context)
    {
        super(context,"itcast.db",null,10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE information (account VARCHAR(20) PRIMARY KEY,niname VARCHAR(20),sex VARCHAR(20),signal VARCHAR(20))");
        // db.execSQL("CREATE TABLE inf (account VARCHAR(20) PRIMARY KEY AUTOINCREMENT,niname VARCHAR(20),sex VARCHAR(20),signal VARCHAR(20))");
        Log.d("MainActivity","h");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE information ");
        Log.d("MainActivity","i");
    }
}
