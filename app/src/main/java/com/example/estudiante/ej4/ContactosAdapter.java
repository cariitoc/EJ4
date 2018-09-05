package com.example.estudiante.ej4;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactosAdapter extends BaseAdapter {


    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactosAdapter(Activity activity) {
        this.activity = activity;
        contactos = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return contactos.size();
    }

    @Override
    public Object getItem(int i) {
        return contactos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    // generar un renglon por objeto
    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();


        // Pasa de XML a View

        View renglon = inflater.inflate(R.layout.renglon, null, false);
        ImageView iv_genero = renglon.findViewById(R.id.iv_genero);

        if (contactos.get(position).getGenero().equals("femenino")) {

            iv_genero.setImageResource(R.drawable.mujer);
        } else {
            iv_genero.setImageResource(R.drawable.hombre);
        }


        TextView tv_nombre = renglon.findViewById(R.id.tv_nombre);
        TextView tv_telefono = renglon.findViewById(R.id.tv_telefono);
        ImageButton ib_call = renglon.findViewById(R.id.ib_call);
        ImageButton ib_delete = renglon.findViewById(R.id.ib_delete);

        tv_nombre.setText(contactos.get(position).getNombre());
        tv_telefono.setText(contactos.get(position).getTelefono());


        ib_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactos.remove(position);
                notifyDataSetChanged();
            }
        });

        ib_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call=new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel:"+contactos.get(position).getTelefono()));

                if(ContextCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, 222);
                }else{
                    activity.startActivity(call);
                }
            }
        });

        return renglon;
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        notifyDataSetChanged();
    }
}
