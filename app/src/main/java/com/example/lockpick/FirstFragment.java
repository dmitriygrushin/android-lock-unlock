package com.example.lockpick;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.lockpick.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @SuppressLint("SetTextI18n")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // get passcode arg sent from second fragment
        String passcode = FirstFragmentArgs.fromBundle(getArguments()).getPasscode();
        if (passcode != null) {
            System.out.println("\n------------------------------[1st Fragment] we got the passcode: " + passcode + " ------------------------------\n");
            System.out.println(binding.textviewFirst.getText().toString());
            if (passcode.equals("1234")) {
                binding.textviewFirst.setText("APP IS UNLOCKED");
                binding.buttonFirst.setVisibility(View.GONE);
            } else {
                binding.textviewFirst.setText("WRONG CODE \n APP STILL LOCKED");
            }
        }

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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