package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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
    Spinner op;

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
        operation = (Spinner) getView().findViewById(R.id.operations);

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

                switch (operation) {
                    case 1:
                        sum = firstNumber + secondNumber;
                        break;
                    case 2:
                        sum = firstNumber - secondNumber;
                        break;
                    case 3:
                        sum = firstNumber * secondNumber;
                        break;
                    case 4:
                        sum = (int) Math.floor(firstNumber / secondNumber);
                        break;
                    case 5:
                        sum = firstNumber % secondNumber;
                        break;
                    case 6:
                        sum = (int) Math.pow(firstNumber, secondNumber);
                        break;

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