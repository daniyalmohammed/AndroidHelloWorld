package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.example.myapplication.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    int firstNumber, secondNumber;
    public static int sum;
    EditText firstNumberInput;
    EditText secondNumberInput;
    Button buttonFirst;
    FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firstNumberInput = (EditText) getView().findViewById(R.id.firstNumberInput);
        secondNumberInput = (EditText) getView().findViewById(R.id.secondNumberInput);

        buttonFirst = (Button) getView().findViewById(R.id.buttonFirst);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (firstNumberInput != null) {
                    firstNumber = Integer.valueOf(firstNumberInput.getText().toString());
                    System.out.println("1: " + firstNumber);
                }
                if (secondNumberInput != null) {
                    secondNumber = Integer.valueOf(secondNumberInput.getText().toString());
                    System.out.println("2: " + secondNumber);
                }

                sum = firstNumber + secondNumber;
                System.out.println("fs: " + sum);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}