package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.example.myapplication.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    MainActivity mainActivity = new MainActivity();
    int firstNumber = mainActivity.firstNumber;
    int secondNumber = mainActivity.secondNumber;

    public int sum;
    EditText firstNumberInput = mainActivity.firstNumberInput;
    EditText secondNumberInput = mainActivity.secondNumberInput;
    private FragmentFirstBinding binding;

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

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainActivity.firstNumberInput != null) {
                    EditText firstNumberInput = mainActivity.firstNumberInput;
                    firstNumber = Integer.valueOf(firstNumberInput.getText().toString());
                }
                if (mainActivity.firstNumberInput != null) {
                    EditText firstNumberInput = mainActivity.firstNumberInput;
                    firstNumber = Integer.valueOf(firstNumberInput.getText().toString());
                }
                sum = firstNumber + secondNumber;
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