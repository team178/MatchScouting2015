package org.farmingtonrobotics.scouting.matchscouting2015;

import android.text.InputType;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.ArrayList;

/**
 * Created by Nandan on 2/13/2015.
 */
public class ObjStor {
    private static ObjStor ourInstance = new ObjStor();

    public static ObjStor getInstance() {
        return ourInstance;
    }

    public static ObjStor newInstance(){
        ourInstance = new ObjStor();
        System.gc();
        return getInstance();
    }

    public static NumberPicker teleNumStacks,teleNumTotes,teleNumContainers,teleMaxStackHeight;
    public static CheckBox teleisDisabled, autoisDisabled,autoZone,autoToteSet,autoToteStack,autoContainerSet;
    public static EditText teamNumber,matchNumber,notes;
    static ArrayList<Container> arrayContainers= new ArrayList<Container>(7);

    public static String getCSV(){
        return (readEditText(teamNumber)+","+readEditText(matchNumber)+","+readCheckBox(autoisDisabled)+","+readCheckBox(autoZone)+","+readCheckBox(autoToteSet)+","+readCheckBox(autoToteStack)+","+
                readCheckBox(autoContainerSet)+","+readCheckBox(teleisDisabled)+","+readNumPick(teleNumStacks)+","+readNumPick(teleNumTotes)+
                getContainerData()+","+readEditText(notes)+"\n");
    }

    private static String getContainerData() {
        String data="";
        for(Container c:arrayContainers){
            data.concat(","+c.toString());
        }
        return data;
    }

    private static int readNumPick(NumberPicker numberPicker){
        return numberPicker.getValue();
    }
    private static String readCheckBox(CheckBox checkBox){
        if(checkBox.isChecked()){
            return "true";
        }
        if (!checkBox.isChecked()) {
            return "false";
        }
        else {
            return "";
        }
    }
    private static String readEditText(EditText editText) {

        switch (editText.getInputType()) {
            case(InputType.TYPE_CLASS_NUMBER):
                return //Integer.parseInt(editText.getText().toString());
                        editText.getText().toString();
            case(InputType.TYPE_CLASS_TEXT):
                return  editText.getText().toString();
            default:
                return editText.getText().toString();

        }
    }


    private ObjStor() {
    }
}
