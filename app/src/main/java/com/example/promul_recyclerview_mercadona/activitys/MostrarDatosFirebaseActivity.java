package com.example.promul_recyclerview_mercadona.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.promul_recyclerview_mercadona.R;
import com.example.promul_recyclerview_mercadona.clases.Producto;
import com.example.promul_recyclerview_mercadona.reciclerview1.ListaProductosAdapter1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MostrarDatosFirebaseActivity extends AppCompatActivity {
private RecyclerView rv_productos1;
private ArrayList<Producto> productos;
private FirebaseDatabase database;
private ListaProductosAdapter1 adapter1;
private DatabaseReference myRefProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos_firebase);

        database = FirebaseDatabase.getInstance();
        productos = new ArrayList<Producto>();
        adapter1 = new ListaProductosAdapter1(this, productos);
        rv_productos1.setAdapter(adapter1);
        myRefProductos = database.getReference("productos");
        myRefProductos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // adapter.getProductos().clear();
                ArrayList<Producto> productos = new ArrayList<Producto>();
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    Producto a = (Producto) dataSnapshot.getValue(Producto.class);
                    productos.add(a);
                }
                adapter1.setProductos(productos);
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.i( "firebase1", String.valueOf(error.toException()));
            }
        });
//----------------------------------------------------------------------------------------------------

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            rv_productos1.setLayoutManager(new GridLayoutManager(this,2));
        } else {
            // In portrait
            rv_productos1.setLayoutManager(new LinearLayoutManager(this));
        }

    }
}