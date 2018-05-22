package id.co.venport.vendorportalandroidapplication.fragmentMenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.co.venport.vendorportalandroidapplication.R;
import id.co.venport.vendorportalandroidapplication.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Event> eventArrayList;
    private ArrayList<Integer> gambar;
    public EventFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        eventArrayList = new ArrayList();
        gambar = new ArrayList();

        gambar.add(R.drawable.poster);

        eventArrayList.add(new Event("Paramabudaya","Acara budaya ada jawa yang di selenggarakan UKM Daerah Jawa","Gedung Serba Guna Telkom University","7PM","Ketua Panitia Paramabudaya",0,gambar.get(0)));
        eventArrayList.add(new Event("Paramabudaya","Acara budaya ada jawa yang di selenggarakan UKM Daerah Jawa","Gedung Serba Guna Telkom University","7PM","Ketua Panitia Paramabudaya",1,gambar.get(0)));
        eventArrayList.add(new Event("Paramabudaya","Acara budaya ada jawa yang di selenggarakan UKM Daerah Jawa","Gedung Serba Guna Telkom University","7PM","Ketua Panitia Paramabudaya",2,gambar.get(0)));

        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new EventRecyclerViewAdapter(eventArrayList, this.getContext()));

        return view;
    }
}
