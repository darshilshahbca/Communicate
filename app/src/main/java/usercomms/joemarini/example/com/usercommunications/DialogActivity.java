package usercomms.joemarini.example.com.usercommunications;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import java.util.Calendar;

import usercomms.joemarini.example.com.usercommunications.Dialogs.CustomDialogFragment;
import usercomms.joemarini.example.com.usercommunications.Dialogs.SingleChoiceDialogFragment;
import usercomms.joemarini.example.com.usercommunications.Dialogs.SimpleDialogFragment;

public class DialogActivity extends AppCompatActivity
    implements View.OnClickListener, SimpleDialogFragment.SimpleDialogListener {

    private final String TAG = "AUC_DLG_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        // set up button click handlers
        findViewById(R.id.btnSimpleDialog).setOnClickListener(this);
        findViewById(R.id.btnShowDatePicker).setOnClickListener(this);
        findViewById(R.id.btnShowChoiceDialog).setOnClickListener(this);
        findViewById(R.id.btnShowCustomDialog).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSimpleDialog:
                showSimpleDialog();
                break;
            case R.id.btnShowDatePicker:
                // TODO: Get a calendar instance
                Calendar cal = Calendar.getInstance();

                // TODO: Create a DatePickerDialog
                DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
                   @Override
                    public void onDateSet(DatePicker datePicker, int year, int mOfYear, int dOfMo){
                       Log.i(TAG, String.format("Date Chosen -- day: %d, month: %d, year: %d", dOfMo, mOfYear, year));
                   }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));

                // TODO: Set the title and show the dialog
                datePicker.setTitle("Choose a Date");
                datePicker.show();


                break;
            case R.id.btnShowChoiceDialog:
                showChoiceDialog();
                break;
            case R.id.btnShowCustomDialog:
                showCustomDialog();
                break;
        }
    }

    private void showSimpleDialog() {
        SimpleDialogFragment simpleDialog = new SimpleDialogFragment();
        // TODO: Use setCancelable() to make the dialog non-cancelable
        simpleDialog.setCancelable(false);
        simpleDialog.show(getSupportFragmentManager(), "SimpleDialogFragment");
    }

    private void showCustomDialog() {
        CustomDialogFragment customDialog = new CustomDialogFragment();
        customDialog.show(getSupportFragmentManager(), "CustomDialogFragment");
    }

    private void showChoiceDialog() {
        SingleChoiceDialogFragment complexDialog = new SingleChoiceDialogFragment();
        complexDialog.show(getSupportFragmentManager(),"SingleChoiceDialogFragment");
    }

    @Override
    public void onPositiveResult(DialogFragment dlg) {
        Log.i(TAG, "Dialog Positive Result");
    }

    @Override
    public void onNegativeResult(DialogFragment dlg) {
        Log.i(TAG, "Dialog Negative Result");
    }

    @Override
    public void onNeutralResult(DialogFragment dlg) {
        Log.i(TAG, "Dialog Neutral Result");
    }

    //TODO: implement dialog listener interface functions

}
