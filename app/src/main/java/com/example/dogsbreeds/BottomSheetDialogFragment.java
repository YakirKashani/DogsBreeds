package com.example.dogsbreeds;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.dogbreedslib.DogData;
import com.example.dogbreedslib.DogModel;

public class BottomSheetDialogFragment extends DialogFragment {
    private Spinner BSGA_spinner_gender;
    private EditText BSGA_ET_age;
    private Button BSGA_button_submit;
    private String breed;

    public BottomSheetDialogFragment(String breed){
        this.breed = breed;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_gender_age, container, false);
        BSGA_spinner_gender = view.findViewById(R.id.BSGA_spinner_gender);
        BSGA_ET_age = view.findViewById(R.id.BSGA_ET_age);
        BSGA_button_submit = view.findViewById(R.id.BSGA_button_submit);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.gender_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BSGA_spinner_gender.setAdapter(adapter);

        BSGA_button_submit.setOnClickListener(v -> {
            String selectionGender = BSGA_spinner_gender.getSelectedItem().toString();
            String ageString = BSGA_ET_age.getText().toString();

            if(selectionGender.isEmpty() || ageString.isEmpty()){
                Toast.makeText(getContext(),"Please fill all the fields",Toast.LENGTH_LONG).show();
            }
            else{
                try{
                    float age_f = Float.parseFloat(ageString);
                }catch(NumberFormatException e){
                    Toast.makeText(getContext(),"please enter a valid age (numeric value)",Toast.LENGTH_LONG).show();
                }
                DogData.getDogByBreedGenderAge(getContext(),breed, selectionGender, ageString, new DogData.Callback_Data<DogModel>() {
                    @Override
                    public void data(DogModel value) {
                        if(value!=null){
                            showDogDetailDialog(getContext(),value);
                        }else{
                            Toast.makeText(getContext(),"No dog data found",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        return view;
    }

    private void showDogDetailDialog(Context context, DogModel dogModel){
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

        DDD_TV_BreedName.setText(dogModel.getBreed_name());
        DDD_TV_Gender.setText(dogModel.getGender());
        DDD_TV_AgeRange.setText(dogModel.getFrom_age() + " - " + dogModel.getTo_age() + " years old");
        DDD_TV_Height_min.setText(dogModel.getAvg_height_min());
        DDD_TV_Height_max.setText(dogModel.getAvg_height_max());
        DDD_TV_Weight_min.setText(dogModel.getAvg_weight_min());
        DDD_TV_Weight_max.setText(dogModel.getAvg_weight_max());
        DDD_TV_Food.setText(dogModel.getAvg_food());
        DDD_TV_Water.setText(dogModel.getAvg_drink());

        dogDetailDialog.show();
    }
}
