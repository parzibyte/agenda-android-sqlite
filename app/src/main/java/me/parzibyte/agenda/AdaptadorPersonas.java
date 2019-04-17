package me.parzibyte.agenda;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.parzibyte.agenda.modelos.Persona;

public class AdaptadorPersonas extends RecyclerView.Adapter<AdaptadorPersonas.MyViewHolder> {
    private List<Persona> listaDePersonas;

    public List<Persona> getListaDePersonas() {
        return listaDePersonas;
    }

    public void setListaDePersonas(List<Persona> listaDePersonas) {
        this.listaDePersonas = listaDePersonas;
    }

    public AdaptadorPersonas(List<Persona> listaDePersonas) {
        this.listaDePersonas = listaDePersonas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View filaPersona = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fila_persona, viewGroup, false);
        return new MyViewHolder(filaPersona);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
// Obtener la persona de nuestra lista gracias al índice i
        Persona persona = listaDePersonas.get(i);

        // Obtener los datos de la lista
        String nombre = persona.getNombre();
        String telefono = persona.getTelefono();
        String identificador = String.valueOf(persona.getId());
        // Y poner a los TextView los datos con setText
        myViewHolder.tvNombre.setText(nombre);
        myViewHolder.tvEdad.setText(telefono);
        myViewHolder.tvIdentificador.setText(identificador);
    }

    @Override
    public int getItemCount() {
        return listaDePersonas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvEdad, tvIdentificador;

        MyViewHolder(View itemView) {
            super(itemView);
            this.tvNombre = itemView.findViewById(R.id.tvFilaNombre);
            this.tvEdad = itemView.findViewById(R.id.tvFilaEdad);
            this.tvIdentificador = itemView.findViewById(R.id.tvFilaIdentificador);
        }
    }
}
