package com.example.apphorizon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphorizon.R;
import com.example.apphorizon.model.Tarefa;

import java.nio.channels.MulticastChannel;
import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder> {
 private List<Tarefa>listaTarefas;
    public TarefaAdapter(List<Tarefa> lista) {
        this.listaTarefas =lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_tarefa,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            Tarefa tarefa = listaTarefas.get(position);
            holder.tarefa.setText(tarefa.getNomePaciente());
    }

    @Override
    public int getItemCount() {
        return this.listaTarefas.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView tarefa;
        public MyViewHolder(View itemView){
            super(itemView);

            tarefa = itemView.findViewById(R.id.textTarefa);
        }
    }
}

