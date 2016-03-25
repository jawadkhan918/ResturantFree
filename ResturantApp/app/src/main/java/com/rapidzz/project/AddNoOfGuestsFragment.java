package com.rapidzz.project;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Talhazk on 15-Mar-16.
 */
public class AddNoOfGuestsFragment  extends DialogFragment {

    private Button cancelBtn,confirmBtn;
    private EditText customerName;
    private Dialog dialog;

    // private static String EXTRA_ORDER_LIST = "com.pk.rapidzz.aap.yourder.fragment.NotificationDialogFragment.EXTRA_ORDER_LIST";
    //  private static String EXTRA_RESTAURANT = "com.pk.rapidzz.aap.yourder.fragment.NotificationDialogFragment.EXTRA_RESTAURANT";


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.add_guests_fragment, null);

        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        cancelBtn = (Button) view.findViewById(R.id.cancelButton);
        cancelBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dismiss();
            }
        });
        confirmBtn = (Button) view.findViewById(R.id.confirmButton);
        confirmBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dismiss();
            }
        });






        return dialog;
    }


}

