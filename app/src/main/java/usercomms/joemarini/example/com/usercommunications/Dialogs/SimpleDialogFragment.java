package usercomms.joemarini.example.com.usercommunications.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

public class SimpleDialogFragment extends DialogFragment {
    private final String TAG = "AUC_SIMPLE";

    // TODO: Implement an interface for hosts to get callbacks


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //TODO: Create an AlertDialog.Builder instance
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //TODO: Set builder properties
        builder.setTitle("Peas Preferences");
        builder.setMessage("Do you like sugar snap peas?");

        builder.setPositiveButton("Sure!", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Log.i(TAG, "Positive button clicked!");
            }
        });

        builder.setNegativeButton("No Way!", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Log.i(TAG, "Negative button clicked!");
            }
        });

        builder.setNeutralButton("Not sure", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Log.i(TAG, "Neautral button clicked!");
            }
        });


        // TODO: return the created dialog

        return builder.create();
    }

    // TODO: Listen for cancel message by overriding onCancel
    @Override
    public void onCancel(DialogInterface dlg){
        super.onCancel(dlg);
        Log.i(TAG, "Dialog Cancelled!");
    }


    // TODO: Override onAttach to get Activity instance

}
