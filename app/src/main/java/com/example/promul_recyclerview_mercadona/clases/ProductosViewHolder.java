package com.example.promul_recyclerview_mercadona.clases;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.promul_recyclerview_mercadona.R;
import com.example.promul_recyclerview_mercadona.activitys.DetallesProductosActivity;
import com.example.promul_recyclerview_mercadona.activitys.ListaProductosAdapter;

public class ProductosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public static final String EXTRA_PRODUCTO_ITEM = "com.example.promul_recyclervierw_mercadona.producto";
    //punteros a los objetos del item, es una clase que nos ayuda a colocar dentro del view todos los
    //atributos, para usarlos en el adapter.
    private TextView txt_nombre_item_rv_producto;
    private TextView txt_cantidad_item_rv_producto;
    private TextView txt_descripcion_item_rv_producto;
    private ImageView img_item_rv_producto;
    private ListaProductosAdapter lpa;

    public ProductosViewHolder(@NonNull View itemView, ListaProductosAdapter listaProductosAdapter) {
        super(itemView);
        txt_nombre_item_rv_producto = (TextView) itemView.findViewById(R.id.txt_nombre_item_rv_producto);
        txt_cantidad_item_rv_producto = (TextView) itemView.findViewById(R.id.txt_cantidad_item_rv_producto);
        txt_descripcion_item_rv_producto = (TextView) itemView.findViewById(R.id.txt_descripcion_item_rv_producto);
        img_item_rv_producto = (ImageView) itemView.findViewById(R.id.img_item_rv_producto);
        this.lpa= listaProductosAdapter;
        itemView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        //este método dice lo que hay que hacer cuando hagas click en el item
        int posicion = getLayoutPosition();
        Producto p = lpa.getProductos().get(posicion);
        Intent intent = new Intent(lpa.getContexto(), DetallesProductosActivity.class);
        intent.putExtra(EXTRA_PRODUCTO_ITEM, p);
        lpa.getContexto().startActivity(intent);
    }

    public TextView getTxt_nombre_item_rv_producto() {
        return txt_nombre_item_rv_producto;
    }

    public void setTxt_nombre_item_rv_producto(TextView txt_nombre_item_rv_producto) {
        this.txt_nombre_item_rv_producto = txt_nombre_item_rv_producto;
    }

    public TextView getTxt_cantidad_item_rv_producto() {
        return txt_cantidad_item_rv_producto;
    }

    public void setTxt_cantidad_item_rv_producto(TextView txt_cantidad_item_rv_producto) {
        this.txt_cantidad_item_rv_producto = txt_cantidad_item_rv_producto;
    }

    public TextView getTxt_descripcion_item_rv_producto() {
        return txt_descripcion_item_rv_producto;
    }

    public void setTxt_descripcion_item_rv_producto(TextView txt_descripcion_item_rv_producto) {
        this.txt_descripcion_item_rv_producto = txt_descripcion_item_rv_producto;
    }

    public ImageView getImg_item_rv_producto() {
        return img_item_rv_producto;
    }

    public void setImg_item_rv_producto(ImageView img_item_rv_producto) {
        this.img_item_rv_producto = img_item_rv_producto;
    }
}
