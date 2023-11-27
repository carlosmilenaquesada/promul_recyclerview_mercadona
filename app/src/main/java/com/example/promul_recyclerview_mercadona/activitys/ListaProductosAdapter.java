package com.example.promul_recyclerview_mercadona.activitys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.promul_recyclerview_mercadona.R;
import com.example.promul_recyclerview_mercadona.clases.ProductosViewHolder;

import java.util.ArrayList;
import java.util.List;

import com.example.promul_recyclerview_mercadona.clases.Producto;

public class ListaProductosAdapter extends RecyclerView.Adapter<ProductosViewHolder> {
    private Context contexto;
    private ArrayList<Producto> productos;

    private LayoutInflater inflate;

    public ListaProductosAdapter(Context context, ArrayList<Producto> productos) {
        this.contexto = context;
        this.productos = productos;

        this.inflate = LayoutInflater.from(this.contexto);
    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View miItemView = inflate.inflate(R.layout.item_rv_productos, parent, false);
        ProductosViewHolder pvh = new ProductosViewHolder(miItemView, this);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, int position) {
        //metodo para desplazar por el array de objetos
        Producto p = this.productos.get(position);
        holder.getTxt_nombre_item_rv_producto().setText("Nombre:" + p.getNombre());
        holder.getTxt_cantidad_item_rv_producto().setText("Cantidad:" + p.getCantidad());
        holder.getTxt_descripcion_item_rv_producto().setText("Descripción:" + p.getDescripcion());
        holder.getImg_item_rv_producto().setImageResource(R.drawable.producto);


    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
}
