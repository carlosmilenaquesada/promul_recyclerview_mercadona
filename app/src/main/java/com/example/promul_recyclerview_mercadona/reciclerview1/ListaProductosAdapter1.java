package com.example.promul_recyclerview_mercadona.reciclerview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.promul_recyclerview_mercadona.R;
import com.example.promul_recyclerview_mercadona.clases.Producto;

import java.util.ArrayList;


public class ListaProductosAdapter1 extends RecyclerView.Adapter<ProductoViewHolder1> {
    private Context contexto;
    private ArrayList<Producto> productos;

    private LayoutInflater inflate;
    private ProductoViewHolder1 holder;
    private int position;

    public ListaProductosAdapter1(Context contexto, ArrayList<Producto> productos) {
        this.contexto = contexto;
        this.productos = productos;
        this.inflate = LayoutInflater.from(this.contexto);
    }

    @NonNull
    @Override
    public ProductoViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View miIteMView = inflate.inflate(R.layout.item_rv_productos1, parent, false);
        ProductoViewHolder1 pvh = new ProductoViewHolder1(miIteMView, this);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder1 holder, int position) {

        this.holder = holder;
        this.position = position;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder1 holder, int position) {
        Producto p = this.getProductos().get(position);
        holder.getTxt_item1_nombre().setText("Nombre:" + p.getNombre());
        holder.setTxt_item1_nombre.setText("Cantidad:" + p.getCantidad());
        holder.getTxt_item1_cantidad.setText("Descripción:" + p.getDescripcion());

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
        notifyDataSetChanged();
    }
}
