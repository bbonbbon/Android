package com.example.a230612;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    EditText edit_name, edit_tel;
    TextView edit_result;
    Button insert, search, all_select, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DBHelper(this);
        try {
            db = helper.getWritableDatabase();
        } catch (SQLException ex) {
            db = helper.getReadableDatabase();
        }
        edit_name = findViewById(R.id.editText);
        edit_tel = findViewById(R.id.editText2);
        edit_result = findViewById(R.id.textView3);

        insert = findViewById(R.id.button);
        search = findViewById(R.id.button2);
        all_select = findViewById(R.id.button3);
        delete = findViewById(R.id.button4);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                String tel = edit_tel.getText().toString();
                db.execSQL("INSERT INTO contacts VALUES(null,'" + name + "','" + tel + "');");

                Toast.makeText(getApplicationContext(), "성공적으로 추가되었음", Toast.LENGTH_SHORT).show();
                edit_name.setText("");
                edit_tel.setText("");
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                Cursor cursor;
                cursor = db.rawQuery("SELECT name, tel FROM contacts WHERE name='" + name + "';", null);

                while (cursor.moveToNext()) {
                    String tel = cursor.getString(1);
                    edit_tel.setText(tel);
                }
            }
        });
        all_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor;
                cursor = db.rawQuery("SELECT * FROM contacts", null);

                String s = "Id Name Tel \r\n";
                while (cursor.moveToNext()) {
                    s += cursor.getString(0) + " ";
                    s += cursor.getString(1) + " ";
                    s += cursor.getString(2) + " \r\n";
                }
                edit_result.setText(s);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_name.getText().toString();
                String tel = edit_tel.getText().toString();
                db.execSQL("Delete FROM contacts WHERE name= '" + name + "';");

                Toast.makeText(getApplicationContext(), "성공적으로 삭제되었음", Toast.LENGTH_SHORT).show();
                edit_name.setText("");
                edit_tel.setText("");
            }
        });
    }
}


    class  DBHelper extends SQLiteOpenHelper{
        private static final String DATABASE_NAME = "mycontacts.db";
        private static final int DATABASE_VERSION =2;

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE contacts(_id INTEGER PRIMARY KEY AUTOINCREMENT, name text, tel text);");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }