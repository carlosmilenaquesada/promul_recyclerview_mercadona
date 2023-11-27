package com.example.promul_recyclerview_mercadona.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.example.promul_recyclerview_mercadona.R;
import com.example.promul_recyclerview_mercadona.clases.Producto;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_productos;
    private ListaProductosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_productos = (RecyclerView) findViewById(R.id.rv_productos1);
        //------------------------------------------------------------------------------------------
        // recuperar los datos

        ArrayList<Producto> productosConsulta = new ArrayList<Producto>();
        productosConsulta.add(new Producto("p1", "tomates", 30.0, "tomates de ensalada"));
        productosConsulta.add(new Producto("p2", "peras", 10.0, "peras de agua"));
        productosConsulta.add(new Producto("p3", "carne", 20.0, "ternera"));
        productosConsulta.add(new Producto("p4", "pescado", 5.0, "sardinas"));
        productosConsulta.add(new Producto("p5", "atun", 2.0, "blanco"));
        productosConsulta.add(new Producto("p6", "papel", 10.0, "higiénico"));
        productosConsulta.add(new Producto("p7", "latas", 20.0, "refrescos"));
        productosConsulta.add(new Producto("p8", "leche", 100.0, "pascual"));
        productosConsulta.add(new Producto("p9", "zumo", 20.0, "manzana"));
        productosConsulta.add(new Producto("p10", "pan", 20.0, "hogaza"));
        productosConsulta.add(new Producto("p11", "huevos", 30.0, "clase l"));
        productosConsulta.add(new Producto("p12", "platanos", 40.0, "canario"));

        //crear un adaptador para mostrar la lista de productos
        adapter = new ListaProductosAdapter(this, productosConsulta);
        rv_productos.setAdapter(adapter);

        //para saber la posición del teléfono
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rv_productos.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            rv_productos.setLayoutManager(new LinearLayoutManager(this));
        }

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(productosConsulta, from, to);
                adapter.notifyItemMoved(from, to);
                return true;
            }


            //para poder hacer drag sobre item, para desplazarlos, quitarlas etc
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if (direction == ItemTouchHelper.LEFT) {
                    // Ciudad c = ciudades.get(viewHolder.getAdapterPosition());
                    // CiudadController.borrarCiudad(c);
                    productosConsulta.remove(viewHolder.getAdapterPosition());
                    adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if (direction == ItemTouchHelper.RIGHT) {
                    productosConsulta.remove(viewHolder.getAdapterPosition());
                    adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if (direction == ItemTouchHelper.UP) {
                    //estudiantes.remove(viewHolder.getAdapterPosition());
                    //adaptadorEstudiantes.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if (direction == ItemTouchHelper.DOWN) {
                    //estudiantes.remove(viewHolder.getAdapterPosition());
                    //adaptadorEstudiantes.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        helper.attachToRecyclerView(rv_productos);


    }

    public void mostarDatos(View view) {
        Intent intent = new Intent(this, MostrarDatosFirebaseActivity.class);
        startActivity(intent);

    }
}