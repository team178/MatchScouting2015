package org.farmingtonrobotics.scouting.matchscouting2015;

import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SaveFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SaveFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaveFrag extends Fragment {


    int Saveclicks = 0;
    int Resetclicks = 0;
    private OnFragmentInteractionListener mListener;

    public static SaveFrag newInstance() {
        SaveFrag fragment = new SaveFrag();
        return fragment;
    }

    public SaveFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) { }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_save, container, false);
        final Button reset = (Button) rootView.findViewById(R.id.resetButton);
        final Button save = (Button) rootView.findViewById(R.id.saveButton);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Saveclicks==0){
                    AlertDialog.Builder saveAlert = new AlertDialog.Builder(getActivity());
                    saveAlert.setTitle("Saving");
                    saveAlert.setMessage("You may save once only. Ensure that this data is correct.\n If it is, PRESS THIS BUTTON AGAIN");
                    saveAlert.setPositiveButton("Got It!", null);
                    saveAlert.show();
                    Saveclicks++;
                }
                else {
                    Toast.makeText(rootView.getContext(), "Data Saving." + ObjStor.getCSV() + "\n Kill ", Toast.LENGTH_SHORT).show();
                    FileOutputStream outputStream;
                    OutputStreamWriter outputStreamWriter;
                    try {
                        String externaldirectorypath = Environment.getExternalStorageDirectory().toString() + "/EnforcersScouting";
                        String internaldirectorypath = Environment.getExternalStorageDirectory().toString() + "/EnforcersScouting/MatchData";
                        File internaldirectoryfile = new File(externaldirectorypath, "MatchData");
                        if (!internaldirectoryfile.exists()) {
                            internaldirectoryfile.mkdirs();
                        }
                        File realfilepass = new File(internaldirectorypath, "frc_score_2015_" + Settings.Secure.getString(rootView.getContext().getContentResolver(), Settings.Secure.ANDROID_ID) + ".csv");
                        if (!realfilepass.exists()) {
                            outputStream = new FileOutputStream(realfilepass, false);
                            outputStreamWriter = new OutputStreamWriter(outputStream);
                        } else {
                            outputStream = new FileOutputStream(realfilepass, true);
                            outputStreamWriter = new OutputStreamWriter(outputStream);
                        }
                        outputStreamWriter.write(ObjStor.getCSV());
                        outputStream.write(String.valueOf(ObjStor.getCSV()).getBytes());
                    } catch (Exception e) {
                        //I should record the exception, but I won't
                    }
                    reset.setEnabled(true);
                    save.setEnabled(false);
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Resetclicks == 0){
                    Toast.makeText(getActivity(),"Double click. I dare you.",Toast.LENGTH_SHORT).show();
                    Resetclicks++;
                }
                else{
                    Toast.makeText(getActivity(),"Oh, ok. I see how it is. -NT",Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AlertDialog.Builder resetDiag = new AlertDialog.Builder(getActivity());
                            resetDiag .setTitle("Instructions")
                                    .setMessage("You must restart the app to scout another match")
                                    .setPositiveButton("Understood.",null);
                            resetDiag.show();
                            System.gc();
                        }
                    },50);
                    /* Doesn't really work
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            PackageManager pm = getActivity().getPackageManager();
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.setComponent(new ComponentName("org.farmingtonrobotics.scouting.matchscouting2015","org.farmingtonrobotics.scouting.matchscouting2015.HomeActivity"));
                            startActivity(intent);
                        }
                    },1500);
                    */
                    getActivity().finish();
                }
            }
        });
        final EditText endMatchNotes = (EditText) rootView.findViewById(R.id.endMatchNotes);
        ObjStor.getInstance().notes = endMatchNotes;

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
