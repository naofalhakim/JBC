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

import java.util.ArrayList;

import id.co.venport.vendorportalandroidapplication.R;
import id.co.venport.vendorportalandroidapplication.model.Barang;
import id.co.venport.vendorportalandroidapplication.model.Vendor;

public class LogistikFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Vendor> vendors;
    private ArrayList<Barang> barangs;


    public LogistikFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logistik_list, container, false);
        vendors = new ArrayList();
        barangs = new ArrayList();

        vendors.add(new Vendor("lol@gmail.com","lol","Malang","lol","lol","089977665543","LOL"));
        vendors.add(new Vendor("lol@gmail.com","lol","Malang","lol","lol","089977665543","LOL"));
        vendors.add(new Vendor("lol@gmail.com","lol","Malang","lol","lol","089977665543","LOL"));

        barangs.add(new Barang("Baju Koko Black Panther","lol",100000,"https://ecs7.tokopedia.net/img/cache/700/product-1/2018/3/12/22405193/22405193_bc42d801-ea27-4f16-a18f-7bdb88fca89c_1080_1080",10,0,"-10%"));
        barangs.add(new Barang("Baju Koko Black Panther","lol",120000,"https://ecs7.tokopedia.net/img/cache/300/product-1/2018/5/1/3001835/3001835_b9bc8118-a35d-47ed-b277-9ec0b5716b85_533_800.jpg",10,1,""));
        barangs.add(new Barang("Baju Koko Black Panther","lol",110000,"https://ecs7.tokopedia.net/img/cache/300/product-1/2018/3/31/10488937/10488937_c43e4c3a-6225-45b7-ad8c-b32801f04c57_500_500.jpg",10,2,"-90%"));


        vendors.get(0).isiBarang(barangs);
        vendors.get(1).isiBarang(barangs);
        vendors.get(2).isiBarang(barangs);

        recyclerView = (RecyclerView) view.findViewById(R.id.listVendor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new MyLogistikRecyclerViewAdapter(vendors,barangs,this.getContext()));

        return view;
    }

}
