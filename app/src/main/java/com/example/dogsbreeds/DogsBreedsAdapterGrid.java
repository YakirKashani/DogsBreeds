package com.example.dogsbreeds;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogbreedslib.BreedAndUrlModel;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class DogsBreedsAdapterGrid extends RecyclerView.Adapter<DogsBreedsAdapterGrid.ViewHolder> {
    private final List<BreedAndUrlModel> breedAndUrlModels;
    private final CallbackBreedSelectedGrid callbackBreedSelectedGrid;

    public DogsBreedsAdapterGrid(List<BreedAndUrlModel> breedAndUrlModels, CallbackBreedSelectedGrid callbackBreedSelectedGrid) {
        this.breedAndUrlModels = breedAndUrlModels;
        this.callbackBreedSelectedGrid = callbackBreedSelectedGrid;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_grid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BreedAndUrlModel breedAndUrlModel = breedAndUrlModels.get(position);
        holder.ICG_MTV_name.setText(breedAndUrlModel.getBreed_name());

        holder.itemView.setOnClickListener(v -> {
            if(callbackBreedSelectedGrid != null){
                callbackBreedSelectedGrid.onBreedSelected(breedAndUrlModel.getBreed_name());
            }
        });
    }

    @Override
    public int getItemCount() {
        return breedAndUrlModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ICG_IV_image;
        MaterialTextView ICG_MTV_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ICG_IV_image = itemView.findViewById(R.id.ICG_IV_image);
            ICG_MTV_name = itemView.findViewById(R.id.ICG_MTV_name);
        }
    }
}
