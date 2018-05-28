package id.co.venport.vendorportalandroidapplication.fragmentMenu;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
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
        gambar.add(R.drawable.p1gsoc);
        gambar.add(R.drawable.p2kecak);
        gambar.add(R.drawable.p3madani);
        gambar.add(R.drawable.p4pejuang);
        gambar.add(R.drawable.p5saman);

        eventArrayList.add(new Event("Paramabudaya","Jawa tak lengkap tanpa ceritanya, dari zaman pewayangan hingga zaman kerajaan. Pelajari sejarah, budaya dan selalu ingat ceritanya. Karena djawa tak pernah padam","G. Keong TelU","07:00 PM","UKM Jawa - Telkom",0,gambar.get(0), 12000,"2 Agustus 2018","Untuk info selebihnya bisa menghubungi OA dari UKM Jawa pada (@ukmDjawa/085258286221). Kami terbuka untuk semua kalangan dan juga media patnetr :)"));
        eventArrayList.add(new Event("Summer of Code","Berkumpulnya para programmer google summer of code untuk berbagi ilmu. Disini kalian akan mendapatkan mentor dalam mendalami koding yang kalian inginkan dan tentunya berhubungan dengan google.","Gedung K TelU","01:30 PM","Google Summer",0,gambar.get(1), 0,"5 Agustus 2018","Lakukan pendaftaran terlebih dahulu pada link yang sudah disediakan sebagai tiket masuk ke acara"));
        eventArrayList.add(new Event("Kecak Dance","Kecak merupakan tarian tradisional asal Bali. Tanpa kecak Bali tak akan terkenang, oleh karena itu lestarikan Bali dengan melihat aksi kami.","GSG TelU","07:30 PM","UKM Bali - Telkom",0,gambar.get(2), 15000,"8 Agustus 2018","Jika masih bingung acaranya seperti apa, silahkan langusng tanya melalui OA (@ukmBaliTelU). Khusus kalian mahasiswa Bali, wajib datang ya :)"));
        eventArrayList.add(new Event("Generasi Madani","Generasi sekarang generasi micin? Tidak, tergantung dari bagaimana kita mendidik mereka. Perkuat islam dan ajarkan jaran madani pada pribadi kita","Masjid Telkom","06:00 PM","Syamsul Ulum",0,gambar.get(3), 0,"8 Agustus 2018","Bawa sedekah terbaik kalian karena sedekah tersebut nantinya akan digunakan untuk santunan anak yatim piatu. Beramallah meski sebiji jarah"));
        eventArrayList.add(new Event("Saman Festifal","Kenali budaya aceh, kesenian dan juga makanan khasnya. Kita hadirkan festifal yang akan mengenalkan kalian dengan lingkungan Aceh yang bersahabat. ","Sabuga ITB","08:00 AM","UKM Aceh - ITB",0,gambar.get(5), 20000,"10 Agustus 2018","Acara ini diperuntukkan untuk siapa saja, bukan anak ITB saja. Jadi tunggu apa lagi langsung diorder tiketnya. Info lebih lanjut hubungi (@ukmAcehITB) ya"));
        eventArrayList.add(new Event("Pejuang Islam","Sambut ramadhan mu dengan menambah ilmu. Kajian bersama ustadz somad hadir lagi, ramaikan yuk. Islam tidak butuh kata tapi butuh hal nyata","Masjid Telkom","07:00 PM","Syamsul Ulum",0,gambar.get(4), 0,"12 Agustus 2018","Mantapkan jiwa dan teguhkan hati, sebagai islam yang kuat maka kalian juga harus berjuang. Tegakkan khalifah di bumu nusantara, insyaAllah berkah."));

        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new EventRecyclerViewAdapter(eventArrayList, this.getContext()));

        return view;
    }
}
