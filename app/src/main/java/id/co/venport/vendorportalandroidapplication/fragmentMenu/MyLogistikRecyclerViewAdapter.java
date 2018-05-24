package id.co.venport.vendorportalandroidapplication.fragmentMenu;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.venport.vendorportalandroidapplication.R;
import id.co.venport.vendorportalandroidapplication.model.Barang;
import id.co.venport.vendorportalandroidapplication.model.Vendor;

import java.util.List;

public class MyLogistikRecyclerViewAdapter extends RecyclerView.Adapter<MyLogistikRecyclerViewAdapter.ViewHolder> {

    private final List<Vendor> mValues;
    private final List<Barang> mBarang;
    private Context context;

    public MyLogistikRecyclerViewAdapter(List<Vendor> items, List<Barang> barangs,Context context) {
        mValues = items;
        mBarang = barangs;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_logistik, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.txtNamaVendor.setText(mValues.get(position).getNamaVendor());
        holder.txtAlamatVendor.setText(mValues.get(position).getAlamat());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtNamaVendor;
        public final TextView txtAlamatVendor;
        public final RecyclerView recyclerView;

        public Vendor mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtNamaVendor = (TextView) view.findViewById(R.id.txtNamaVendor);
            txtAlamatVendor = (TextView) view.findViewById(R.id.txtAlamatVendor);
            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerLogistikInner);

            recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            recyclerView.setAdapter(new BarangLogistikRecyclerAdapter(mBarang,context));
        }
    }
}
