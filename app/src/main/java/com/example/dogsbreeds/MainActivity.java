package com.example.dogsbreeds;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogbreedslib.BreedAndUrlModel;
import com.example.dogbreedslib.DogData;
import com.example.dogbreedslib.DogModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;

    private MaterialButton ActivityMain_MB_List;
    private MaterialButton ActivityMain_MB_Grid;
    private MaterialButtonToggleGroup ActivityMain_MBTG_toggleGroup;

    private int selectionColor;
    private int unselectedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        recyclerView = findViewById(R.id.ActivityMain_RV);
        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this,2);

        List<DogModel> dogModels = new ArrayList<>();
        List<BreedAndUrlModel> breedAndUrlModels = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
 //       DogsBreedsAdapterGrid dogsBreedsAdapterGrid = new DogsBreedsAdapterGrid(breedAndUrlModels);
        ActivityMain_MBTG_toggleGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if(isChecked) {
                if (checkedId == R.id.ActivityMain_MB_List) {
                    /*Style*/
                    ActivityMain_MB_List.setBackgroundColor(selectionColor);
                    ActivityMain_MB_Grid.setBackgroundColor(unselectedColor);
                    /*Logic*/
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(new DogsBreedsAdapterList(this,dogModels));
                    DogData.getAllDogsData(this, new DogData.Callback_Data<List<DogModel>>() {
                        @Override
                        public void data(List<DogModel> value) {
                            dogModels.clear();
                            dogModels.addAll(value);
                            recyclerView.getAdapter().notifyDataSetChanged();
                        }
                    });
                }
                else if(checkedId == R.id.ActivityMain_MB_Grid){
                    /*Style*/
                    ActivityMain_MB_List.setBackgroundColor(unselectedColor); //white
                    ActivityMain_MB_Grid.setBackgroundColor(selectionColor);// blue
                    /*Logic*/
                    recyclerView.setLayoutManager(gridLayoutManager);
                    recyclerView.setAdapter(new DogsBreedsAdapterGrid(breedAndUrlModels, new CallbackBreedSelectedGrid() {
                        @Override
                        public void onBreedSelected(String breed) {
                            BottomSheetDialogFragment bottomSheetDialogFragment = new BottomSheetDialogFragment(breed);
                            bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                        }
                    }));
                    DogData.getAllDogsAndUrls(this, new DogData.Callback_Data<List<BreedAndUrlModel>>() {
                        @Override
                        public void data(List<BreedAndUrlModel> value) {
                            breedAndUrlModels.clear();
                            breedAndUrlModels.addAll(value);
                            recyclerView.getAdapter().notifyDataSetChanged();
                        }
                    });
                }
            }
        });
        ActivityMain_MBTG_toggleGroup.check(R.id.ActivityMain_MB_List);
    }

    private void findViews(){
        ActivityMain_MB_List = findViewById(R.id.ActivityMain_MB_List);
        ActivityMain_MB_Grid = findViewById(R.id.ActivityMain_MB_Grid);
        ActivityMain_MBTG_toggleGroup = findViewById(R.id.ActivityMain_MBTG_toggleGroup);
        selectionColor  = ContextCompat.getColor(this,R.color.blue);
        unselectedColor = ContextCompat.getColor(this,R.color.white);
    }
}