package org.farmingtonrobotics.scouting.matchscouting2015;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SetupFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SetupFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetupFrag extends Fragment {

    private OnFragmentInteractionListener mListener;

    public static SetupFrag newInstance() {
        SetupFrag fragment = new SetupFrag();
        return fragment;
    }

    public SetupFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){}

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_setup, container, false);
        EditText teamNumber = (EditText) rootView.findViewById(R.id.teamNumber);
        ObjStor.getInstance().teamNumber = teamNumber;
        EditText matchNumber = (EditText) rootView.findViewById(R.id.matchNum);
        ObjStor.getInstance().matchNumber = matchNumber;

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
