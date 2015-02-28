package org.farmingtonrobotics.scouting.matchscouting2015;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.NumberPicker;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TeleFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeleFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeleFrag extends Fragment {

    private OnFragmentInteractionListener mListener;
    public static TeleFrag newInstance() {
        TeleFrag fragment = new TeleFrag();
        return fragment;
    }

    public TeleFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tele, container, false);
        CheckBox isDisabledTele = (CheckBox) rootView.findViewById(R.id.isDisabledTele);
        ObjStor.getInstance().teleisDisabled = isDisabledTele;
        NumberPicker teleNumStacks = (NumberPicker) rootView.findViewById(R.id.teleNumStacks);
        teleNumStacks.setMaxValue(75);
        teleNumStacks.setMinValue(0);
        ObjStor.getInstance().teleNumStacks = teleNumStacks;
        NumberPicker teleNumTotes = (NumberPicker) rootView.findViewById(R.id.teleNumTotes);
        teleNumTotes.setMinValue(0);
        teleNumTotes.setMaxValue(150);
        ObjStor.getInstance().teleNumTotes = teleNumTotes;
        NumberPicker teleNumContainers = (NumberPicker) rootView.findViewById(R.id.teleNumContainers);
        teleNumContainers.setMinValue(0);
        teleNumContainers.setMaxValue(7);
        ObjStor.getInstance().teleNumContainers = teleNumContainers;
        NumberPicker teleContainerMax = (NumberPicker) rootView.findViewById(R.id.teleContainerMax);
        teleContainerMax.setMaxValue(7);
        teleContainerMax.setMinValue(0);
        ObjStor.getInstance().teleMaxStackHeight = teleContainerMax;

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
