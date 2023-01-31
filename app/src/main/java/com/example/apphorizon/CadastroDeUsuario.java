package com.example.apphorizon;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.apphorizon.databinding.ActivityCadastroDeUsuarioBinding;

public class CadastroDeUsuario extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityCadastroDeUsuarioBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            SQLiteDatabase bancoDados = openOrCreateDatabase("horizon",MODE_PRIVATE,null);
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS prontuario(nome VARCHAR,idade INT(3), temperatura int(2),tosse INT(2),cabeca INT(2),paises VARCHAR )");
            bancoDados.execSQL("INSERT INTO prontuario(nome,idade,temperatura,tosse,cabeca,paises) VALUES('Thiago',25,20)");

           String consulta = "SELECT * FROM prontuario";
            Cursor cursor = bancoDados.rawQuery(consulta,null);
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");
            cursor.moveToFirst();
            while (cursor != null){
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO - nome", nome + " / idade:" +idade);
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);

        binding = ActivityCadastroDeUsuarioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Usuário Cadastrado",Snackbar.LENGTH_LONG)
                        .setAction("Confirmar",null).show();
            }
        }));

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_cadastro_de_usuario);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_cadastro_de_usuario);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}