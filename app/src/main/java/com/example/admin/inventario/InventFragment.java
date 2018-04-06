package com.example.admin.inventario;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.VISIBLE;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventFragment extends Fragment {


    public InventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invent, container, false);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final RadioGroup radioGroup = view.findViewById(R.id.radioGp);
        final EditText editText = view.findViewById(R.id.marcaEt);

        Button buttonSend = view.findViewById(R.id.saveDesktop);
        final TextView textViewToShow = view.findViewById(R.id.toshowSave);
        final ImageView   imageView = view.findViewById(R.id.imgMod);

        @SuppressLint("CutPasteId") final Button desktopBtn  = view.findViewById(R.id.deskBtn);

        final TextView titleRadio = view.findViewById(R.id.titleRadButton);
        final RadioButton modeloInput = view.findViewById(R.id.radioButton);
        final RadioButton modeloInput2 = view.findViewById(R.id.radioButton2);
        final RadioButton modeloInput3 = view.findViewById(R.id.radioButton3);
        @SuppressLint("CutPasteId") final Button saveInput = view.findViewById(R.id.saveDesktop);
        final Button buttonMonitor = view.findViewById(R.id.monitorBtn);



        desktopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                desktopBtn.setVisibility(View.GONE);
                editText.setVisibility(VISIBLE);
                titleRadio.setVisibility(VISIBLE);
                modeloInput.setVisibility(VISIBLE);
                modeloInput2.setVisibility(VISIBLE);
                modeloInput3.setVisibility(VISIBLE);
                saveInput.setVisibility(VISIBLE);
                textViewToShow.setVisibility(VISIBLE);
                buttonMonitor.setVisibility(View.GONE);

            }
        });
        
        
        
        buttonMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Boton No Disponible por el Momento", Toast.LENGTH_SHORT).show();
            }
        });
        

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String dat = editText.getText().toString();

                if (editText.getText().toString().trim().equalsIgnoreCase("")) {
                    editText.setError("Escribe una Marca ");
                    return;
                }

                int id = radioGroup.getCheckedRadioButtonId();

                if(id != -1){

                    RadioButton radioButton = radioGroup.findViewById(id);
                    String answer =radioButton.getText().toString();
                    imageView.setVisibility(VISIBLE);
                    Toast.makeText(getContext(),"Haz Guardado el siguiente Desktop", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(),"Marca: " + dat, Toast.LENGTH_SHORT).show();

                    textViewToShow.setText("Marca: "+dat+"  "+ "Modelo: " + answer);


                    Toast.makeText(getContext(),"Modelo: " + dat + " "+ answer, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Debes marcar una opcion", Toast.LENGTH_SHORT).show();
                }
            }



        });

    }


}
