package com.example.satya.viewpagerwithdatabaseq;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {
    ListView lv1;
    Cursor c;
    SimpleCursorAdapter simpleCursorAdapter ;
    MyDataBase myDataBase ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDataBase = new MyDataBase(getActivity());
    }

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_two, container, false);
        lv1= (ListView) v.findViewById(R.id.lv1);
        MainActivity mainActivity = (MainActivity) getActivity();
        c= mainActivity.myDataBase.queryStudent();
        simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),R.layout.row,c,new String[]{"_id","sname","ssubject","semail"},new int[]{R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,}) ;
        lv1.setAdapter(simpleCursorAdapter);
        /*if(c!=null)
        {
            while (c.moveToNext())
            {
                simpleCursorAdapter() = new simpleCursorAdapter();
            }
        }*/
        return v;
    }

}
