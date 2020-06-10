package com.example.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examen.objeto.Curso;
import com.example.examen.objeto.Cursos;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private Cursos Cursos;//ArrayList de Cursos (lista)


    //se genera el construtor de los atributos definidos
    public Adapter(Context context, int layout, com.example.examen.objeto.Cursos cursos) {
        this.context = context;
        this.layout = layout;
        this.Cursos = cursos;
    }

    @Override
    public int getCount() { return Cursos.size(); } //# de items que se mostraran en el listview

    @Override
    public Object getItem(int position) { return Cursos.get(position); }//obtiene un item de la colección

    @Override
    public long getItemId(int position) { return position; }// obtiene el id de del item en la colección

    static class ViewHolder{

        //Se definen los elementos del item_list
        //que van a llevar la lista con diferentes datos
        private ImageView imageView;
        private TextView textViewNombrec;
        private TextView textViewDescripc;
        private TextView textViewCostoc;
        private TextView textViewCantHorasc;
        private TextView textViewReqMinc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//Muestra cada elemento de la lista

        ViewHolder holder;
        if(convertView==null || convertView.getTag()==null){
            LayoutInflater layoutInflater=LayoutInflater.from(this.context);//Infla la vista personalizada
            convertView=layoutInflater.inflate(R.layout.item_list, null);
            holder=new ViewHolder();
            //Referencia a los elementos a mostrar
            holder.imageView=(ImageView) convertView.findViewById(R.id.imagecurso);
            holder.textViewNombrec=(TextView) convertView.findViewById(R.id.nombrec);
            holder.textViewDescripc=(TextView) convertView.findViewById(R.id.descripcion);
            holder.textViewCostoc=(TextView) convertView.findViewById(R.id.costo);
            holder.textViewCantHorasc=(TextView) convertView.findViewById(R.id.canthoras);
            holder.textViewReqMinc=(TextView) convertView.findViewById(R.id.requisitos);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }

        Curso current_Item=Cursos.get(position);//Elemento actual de la lista
        holder.textViewNombrec.setText(current_Item.getNombrec());
        holder.textViewDescripc.setText(current_Item.getDescripcionc());
        holder.textViewCostoc.setText(current_Item.getCostoc());
        holder.textViewCantHorasc.setText(current_Item.getHorasc());
        holder.textViewReqMinc.setText(current_Item.getRequisitosc());
        holder.imageView.setImageResource(Cursos.get(position).getImage());

        return convertView;//Devuelve la vista
    }
}
