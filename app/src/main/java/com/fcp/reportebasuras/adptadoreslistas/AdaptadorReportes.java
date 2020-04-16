package com.fcp.reportebasuras.adptadoreslistas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fcp.reportebasuras.R;
import com.fcp.reportebasuras.modelo.vo.Reporte;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabian on 29/01/18.
 */

public class AdaptadorReportes extends BaseAdapter implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener  {

    private List<Reporte> listaOpciones;
    private Activity activity;

    public AdaptadorReportes(Activity activity){
        this.activity = activity;
        listaOpciones = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return listaOpciones.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inf = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.item_lista_reportes,null);
        }

        Reporte reporte= getListaOpciones().get(i);

        TextView txtDescrip = (TextView) view.findViewById(R.id.descrip);
        TextView txtTitulo = (TextView) view.findViewById(R.id.titulo_reporte);
        ImageView imgContacto= (ImageView) view.findViewById(R.id.icono_reporte);
        txtDescrip.setText(reporte.getMensaje());
        txtTitulo.setText(reporte.getTipomensaje());
        //imgContacto.setImageDrawable(ResourcesCompat.getDrawable(view.getResources(),reporte.getRecursoimagen(), null));

        return view;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Intent opcion = new Intent(view.getContext(), listaOpciones.get(position).getPagina());
        //view.getContext().startActivity(opcion);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    public List<Reporte> getListaOpciones() {
        return listaOpciones;
    }
}
