package com.rapidzz.project;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Talhazk on 11-Mar-16.
 */public class NumberGuestsFragment  extends DialogFragment {

    private Dialog dialog;

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.guests_fragment, null);
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        btn1 = (Button) view.findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });

        btn2 = (Button) view.findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });

        btn3 = (Button) view.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });

        btn4 = (Button) view.findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });

        btn5 = (Button) view.findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });

        btn5 = (Button) view.findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });

        btn6 = (Button) view.findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });

        btn7 = (Button) view.findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });

        btn8 = (Button) view.findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });

        btn9 = (Button) view.findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });

        btn10 = (Button) view.findViewById(R.id.button10);
        btn10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });

        btn11 = (Button) view.findViewById(R.id.button11);
        btn11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });


        btn12 = (Button) view.findViewById(R.id.button12);
        btn12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getActivity(), TableGuestActivity.class);
                startActivity(i);
                dismiss();
            }
        });



/* Bundle args = new Bundle();
        args.putInt("num", num);
        dialog.setArguments(args);
*/

        return dialog;
    }



}