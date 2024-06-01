package com.example.ecommerce;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class PaymentDialog extends AppCompatDialogFragment {

    private EditText editTextCardNumber;
    private EditText editTextExpirationDate;
    private EditText editTextCVV;
    private Button buttonPay;

    @SuppressLint("MissingInflatedId")
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.payment_dialog, null);

        editTextCardNumber = view.findViewById(R.id.edit_text_card_number);
        editTextExpirationDate = view.findViewById(R.id.edit_text_expiration_date);
        editTextCVV = view.findViewById(R.id.edit_text_cvv);
        buttonPay = view.findViewById(R.id.button_pay);

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement payment processing logic here
                Toast.makeText(getContext(), "Payment Succeeded!", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        builder.setView(view)
                .setTitle("Payment Information")
                .setNegativeButton("Cancel", (dialog, which) -> {
                    // Handle cancellation
                });

        return builder.create();
    }
}

