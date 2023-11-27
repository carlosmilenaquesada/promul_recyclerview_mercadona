package com.example.promul_recyclerview_mercadona.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.promul_recyclerview_mercadona.R;
import com.example.promul_recyclerview_mercadona.clases.Producto;
import com.example.promul_recyclerview_mercadona.clases.ProductosViewHolder;

public class DetallesProductosActivity extends AppCompatActivity {
    private Producto p;
    private TextView txt_detalles_cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_productos);
        txt_detalles_cantidad = (TextView) findViewById(R.id.edt_detalles_cantidad);
        Intent intent = getIntent();
        if (intent != null) {
            p = (Producto) intent.getSerializableExtra(ProductosViewHolder.EXTRA_PRODUCTO_ITEM);
            txt_detalles_cantidad.setText(String.valueOf("Cantidad: " + p.getCantidad()));
        }
    }
}