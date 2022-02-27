package com.example.lockpick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.lockpick.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    TextView userEnteredPasscode;

    private void updateUserEnteredPasscode(View view, String numString) {
        String passcode = userEnteredPasscode.getText().toString();
        if (passcode.length() < 4) {
            passcode += numString;
            userEnteredPasscode.setText(passcode);
        }
    }

    private void clearUserEnteredPasscode(View view) {
        userEnteredPasscode.setText("");
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        View fragmentSecondLayout = binding.getRoot();

        // cache userEnteredPasscode TextView
        userEnteredPasscode = fragmentSecondLayout.findViewById(R.id.user_entered_passcode);
        System.out.println("\n------------------------------[2nd Fragment] user passcode: " + userEnteredPasscode.getText().toString() + " ------------------------------\n");

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // default from android studio: NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);

                // Create an action with currentCount as the argument to actionSecondFragmentToFirstFragment()
                SecondFragmentDirections.ActionSecondFragmentToFirstFragment action = SecondFragmentDirections.actionSecondFragmentToFirstFragment();
                action.setPasscode(userEnteredPasscode.getText().toString());
                // Add a line to find the nav controller and navigate with the action you created.
                System.out.println("\n------------------------------[2nd Fragment][onClick] user passcode: " + userEnteredPasscode.getText().toString() + " ------------------------------\n");
                NavHostFragment.findNavController(SecondFragment.this).navigate(action);
            }
            
        });

        binding.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearUserEnteredPasscode(view);
            }
        });

        binding.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserEnteredPasscode(view, "1");
            }
        });

        binding.buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserEnteredPasscode(view, "2");
            }
        });

        binding.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserEnteredPasscode(view, "3");
            }
        });

        binding.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserEnteredPasscode(view, "4");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}