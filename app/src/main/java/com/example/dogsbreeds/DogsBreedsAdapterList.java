package com.example.dogsbreeds;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dogbreedslib.DogModel;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class DogsBreedsAdapterList extends RecyclerView.Adapter<DogsBreedsAdapterList.ItemViewHolder> {

    private Context context;
    private List<DogModel> dogsBreeds;

    public DogsBreedsAdapterList(Context context, List<DogModel> dogsBreeds) {
        this.context = context;
        this.dogsBreeds = dogsBreeds;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_list,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        DogModel dogModel = dogsBreeds.get(position);
        holder.ICL_MTV_name.setText(dogModel.getBreed_name());
        holder.ICL_MTV_age_range.setText(dogModel.getFrom_age() + " - " + dogModel.getTo_age() + " years old");
        holder.ICL_MTV_gender.setText(dogModel.getGender());
        Glide.with(holder.itemView.getContext()).load(dogModel.getPic_url()).into(holder.ICL_IV_image);

        holder.itemView.setOnClickListener(view->{
            showDogDetailDialog(dogModel);
        });
    }

    @Override
    public int getItemCount() {
        return dogsBreeds.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        MaterialTextView ICL_MTV_name;
        ImageView ICL_IV_image;
        MaterialTextView ICL_MTV_age_range;
        MaterialTextView ICL_MTV_gender;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ICL_MTV_name = itemView.findViewById(R.id.ICL_MTV_name);
            ICL_IV_image = itemView.findViewById(R.id.ICL_IV_image);
            ICL_MTV_age_range = itemView.findViewById(R.id.ICL_MTV_age_range);
            ICL_MTV_gender = itemView.findViewById(R.id.ICL_MTV_gender);
        }
    }

    private void showDogDetailDialog(DogModel dogModel){
        Dialog dogDetailDialog = new Dialog(context);
        dogDetailDialog.setContentView(R.layout.dialog_dog_detail);
        TextView DDD_TV_BreedName = dogDetailDialog.findViewById(R.id.DDD_TV_BreedName);
        TextView DDD_TV_Gender = dogDetailDialog.findViewById(R.id.DDD_TV_Gender);
        TextView DDD_TV_AgeRange = dogDetailDialog.findViewById(R.id.DDD_TV_AgeRange);
        TextView DDD_TV_Height_min = dogDetailDialog.findViewById(R.id.DDD_TV_Height_min);
        TextView DDD_TV_Height_max = dogDetailDialog.findViewById(R.id.DDD_TV_Height_max);
        TextView DDD_TV_Weight_min = dogDetailDialog.findViewById(R.id.DDD_TV_Weight_min);
        TextView DDD_TV_Weight_max = dogDetailDialog.findViewById(R.id.DDD_TV_Weight_max);
        TextView DDD_TV_Food = dogDetailDialog.findViewById(R.id.DDD_TV_Food);
        TextView DDD_TV_Water = dogDetailDialog.findViewById(R.id.DDD_TV_Water);
        ImageView DDD_IV_dogImage = dogDetailDialog.findViewById(R.id.DDD_IV_dogImage);

        DDD_TV_BreedName.setText(dogModel.getBreed_name());
        DDD_TV_Gender.setText(dogModel.getGender());
        DDD_TV_AgeRange.setText(dogModel.getFrom_age() + " - " + dogModel.getTo_age() + " years old");
        DDD_TV_Height_min.setText(dogModel.getAvg_height_min());
        DDD_TV_Height_max.setText(dogModel.getAvg_height_max());
        DDD_TV_Weight_min.setText(dogModel.getAvg_weight_min());
        DDD_TV_Weight_max.setText(dogModel.getAvg_weight_max());
        DDD_TV_Food.setText(dogModel.getAvg_food());
        DDD_TV_Water.setText(dogModel.getAvg_drink());
        Glide.with(context).load(dogModel.getPic_url()).into(DDD_IV_dogImage);

        dogDetailDialog.show();
    }
}

