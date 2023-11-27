package com.example.promul_recyclerview_mercadona.reciclerview1;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.promul_recyclerview_mercadona.R;

public class ProductoViewHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView txt_item1_nombre;
    private TextView txt_item1_cantidad;
    private TextView txt_item1_precio;

    public ProductoViewHolder1(@NonNull View itemView) {
        super(itemView);
        txt_item1_nombre = (TextView) itemView.findViewById(R.id.txt_item2_nombre);
        txt_item1_cantidad = (TextView) itemView.findViewById(R.id.txt_item2_cantidad);
        txt_item1_precio = (TextView) itemView.findViewById(R.id.txt_item2_precio);
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }

    public TextView getTxt_item1_nombre() {
        return txt_item1_nombre;
    }

    public void setTxt_item1_nombre(TextView txt_item1_nombre) {
        this.txt_item1_nombre = txt_item1_nombre;
    }

    public TextView getTxt_item1_cantidad() {
        return txt_item1_cantidad;
    }

    public void setTxt_item1_cantidad(TextView txt_item1_cantidad) {
        this.txt_item1_cantidad = txt_item1_cantidad;
    }

    public TextView getTxt_item1_precio() {
        return txt_item1_precio;
    }

    public void setTxt_item1_precio(TextView txt_item1_precio) {
        this.txt_item1_precio = txt_item1_precio;
    }
}
