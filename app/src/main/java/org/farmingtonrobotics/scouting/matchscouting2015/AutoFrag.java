package org.farmingtonrobotics.scouting.matchscouting2015;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AutoFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AutoFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AutoFrag extends Fragment {

    private OnFragmentInteractionListener mListener;


    public static AutoFrag newInstance() {
        AutoFrag fragment = new AutoFrag();

        return fragment;
    }

    public AutoFrag() {
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
        View rootView = inflater.inflate(R.layout.fragment_auto, container, false);
        CheckBox autoZone = (CheckBox) rootView.findViewById(R.id.autoZone);
        ObjStor.getInstance().autoZone = autoZone;
        CheckBox autoToteSet = (CheckBox) rootView.findViewById(R.id.autoToteSet);
        ObjStor.getInstance().autoToteSet = autoToteSet;
        CheckBox autoToteStack = (CheckBox) rootView.findViewById(R.id.autoToteStack);
        ObjStor.getInstance().autoToteStack = autoToteStack;
        CheckBox autoContainerSet = (CheckBox) rootView.findViewById(R.id.autoContainerSet);
        ObjStor.getInstance().autoContainerSet = autoContainerSet;
        CheckBox isDisabledAuto = (CheckBox) rootView.findViewById(R.id.isDisabledAuto);
        ObjStor.getInstance().autoisDisabled = isDisabledAuto;

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
