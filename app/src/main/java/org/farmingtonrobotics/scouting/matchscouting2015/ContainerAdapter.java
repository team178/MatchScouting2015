package org.farmingtonrobotics.scouting.matchscouting2015;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nandan on 2/28/2015.
 */

    public class ContainerAdapter extends ArrayAdapter<Container> {

    public ArrayList<Container> containers = new ArrayList<Container>();
    private Activity context;
    /**
     * Constructor
     *
     * @param context  The current context.
     * //@param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public ContainerAdapter(Activity context, ArrayList<Container> objects) {
        super(context, R.layout.container_info, TeleFrag.getContainers());
        this.containers = objects;
        this.context = context;
    }

    /**
     * {@inheritDoc}
     *
     * @param position
     */
    @Override
    public Container getItem(int position) {
        return super.getItem(position);
    }

    /**
     * {@inheritDoc}
     *
     * @param position
     * @param convertView
     * @param parent
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        LayoutInflater inflator = context.getLayoutInflater();
        itemView=inflator.inflate(R.layout.container_info,null);
        TextView title = (TextView) itemView.findViewById(R.id.title);
        title.setText(containers.get(position).getName());
        EditText height = (EditText) itemView.findViewById(R.id.height);
        height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                    containers.get(position).setHeight(Integer.parseInt(s.toString()));
            }
        });
        CheckBox wasUsed = (CheckBox) itemView.findViewById(R.id.wasUsed);
        wasUsed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                containers.get(position).setUsed(isChecked);
            }
        });
        return itemView;
    }
}
