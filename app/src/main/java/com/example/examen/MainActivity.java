package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.ImageDecoder;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.examen.objeto.Curso;
import com.example.examen.objeto.Cursos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView ListaCursos;
    Cursos cursos;
    Curso curso;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListaCursos = (ListView) findViewById(R.id.listView1); //Referencia a la lista de la vista
        ListaCursos.setOnCreateContextMenuListener(this);

        fillList();//Método que llena la lsita
    }

    void fillList(){//Método que llena la lista

        cursos= new Cursos();

        // estableciendo valores a los atributos según el modelo usado

        curso=new Curso("Planificaciòn de TIC", "Curso de clase", "$ 200 dolares", "80 horas", "Haber aprobada la clase de introducción a la programación");
        curso.setImage(R.drawable.app);
        cursos.add(curso);
        curso=new Curso(  "Facultatita II", "Curso de clase", "$ 300 dolares", "100 horas", "Haber aprobada la clase de programación orientada a objetos");
        curso.setImage(R.drawable.pc);
        cursos.add(curso);
        curso=new Curso(  "Gestión y formulación de proyecto", "Curso de clase", "$ 100 dolares", "70 horas", "Haber aprobada la clase de diseño de sistemas");
        curso.setImage(R.drawable.files);
        cursos.add(curso);
        adapter=new Adapter(this, R.layout.item_list, cursos);
        ListaCursos.setAdapter(adapter);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.btndelete:// Acciones para item btndelete del diálogo
                this.cursos.remove(info.position);//Quita un elemneto de la lista
                this.adapter.notifyDataSetChanged();// Actualiza el adaptador
                return true;
            case R.id.btncancel://Acciones para item btncancel del diálogo
                System.exit(0);//Cierre de Aplicación
            case R.id.btnadd://Acciones para item btnadd del diálogo


                //El diálogo debe declararse de tipo final para ser
                //reconocido desde los eventos onClick de la actividad
                final Dialog dlg= new Dialog(this);//Definir objeto diálogo
                dlg.setContentView(R.layout.add_new);//Se llama el xml del diálogo
                dlg.setTitle("Agregar Nuevo Curso");
                dlg.setCancelable(false);//No puede cerrarse

                //referenciando botones que posee el diálogo
                Button btAddNew=(Button)dlg.findViewById(R.id.btnRegistrar);
                Button btCancel=(Button)dlg.findViewById(R.id.btncancelar);

                //Evento click del boton agregar nuevo
                btAddNew.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Variables que almacenaran la info del curso
                        EditText editText_Nombrec=(EditText) dlg.findViewById(R.id.editText_nombrec);
                        EditText editText_Descripc=(EditText) dlg.findViewById(R.id.editText_descripcion);
                        EditText editText_Costoc=(EditText) dlg.findViewById(R.id.editText_costo);
                        EditText editText_CantHorac=(EditText) dlg.findViewById(R.id.editText_canthoras);
                        EditText editText_ReqMinc=(EditText) dlg.findViewById(R.id.editText_requisitos);

                        //Condición para que no se pueda guardar hasta que todos los campos esten llenos
                        if ((editText_Nombrec.getText().toString().contentEquals("")) ||
                                (editText_Descripc.getText().toString().contentEquals(""))||
                                (editText_Costoc.getText().toString().contentEquals(""))||
                                (editText_CantHorac.getText().toString().contentEquals(""))||
                                (editText_ReqMinc.getText().toString().contentEquals(""))){
                            //Muestra el texto entre las comillas si hay algún EditText esta vacio
                            Toast.makeText(MainActivity.this, "Ningún campo puede quedar vacio", Toast.LENGTH_SHORT).show();
                        }
                        else{

                            //Se crea un objeto para poder guardar la info
                            Curso NewCurso= new Curso();

                            //Se asigna los datos a cada uno de los atributos establecidos en el modelo usado
                            NewCurso.setImage(R.drawable.book);
                            NewCurso.setNombrec(editText_Nombrec.getText().toString());
                            NewCurso.setDescripcionc(editText_Descripc.getText().toString());
                            NewCurso.setCostoc(editText_Costoc.getText().toString());
                            NewCurso.setHorasc(editText_CantHorac.getText().toString());
                            NewCurso.setRequisitosc(editText_ReqMinc.getText().toString());

                            cursos.add(NewCurso);//Se gurdan en la lista
                            adapter.notifyDataSetChanged();// Actualiza el adaptador
                            //Se limpia los campos del diálogo
                            editText_Nombrec.setText("");
                            editText_Descripc.setText("");
                            editText_Costoc.setText("");
                            editText_CantHorac.setText("");
                            editText_ReqMinc.setText("");
                            dlg.cancel();// Cierre del diálogo
                        }
                    }
                });
                btCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlg.cancel();
                    }
                });
                dlg.show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Opciones");
        getMenuInflater().inflate(R.menu.menu_item,menu);
    }

}


