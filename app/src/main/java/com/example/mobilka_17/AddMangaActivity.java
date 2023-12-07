package com.example.mobilka_17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMangaActivity extends AppCompatActivity {

    EditText mangaName, mangaAuthor;
    Button addManga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_manga);

        mangaName = findViewById(R.id.manga_name);
        mangaAuthor = findViewById(R.id.manga_author);
        addManga = findViewById(R.id.add_manga);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        addManga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Manga manga = new Manga(0, mangaName.getText().toString(),
                        mangaAuthor.getText().toString());
                dataBaseHelper.addManga(manga);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}