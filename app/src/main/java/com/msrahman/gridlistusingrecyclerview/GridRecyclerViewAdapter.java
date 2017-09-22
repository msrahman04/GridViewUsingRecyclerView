package com.msrahman.gridlistusingrecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by syednasharudin on 11/07/2017.
 */

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity context;
    private ArrayList<ItemModel> itemList;

    public GridRecyclerViewAdapter(Activity context,
                                   ArrayList<ItemModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid,
                parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder eHolder = (ItemViewHolder) holder;
        final ItemModel item = itemList.get(position);
        eHolder.tvName.setText(item.getName());

        eHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               context.startActivity(new Intent(context, item.getActivity().getClass()));
            }
        });

    }

    private void callGettingList() {

//        context.dialogUtil.showDialogOk("Conformation !!!", "You get this goods. Please see the status.");
    }

    public void refreshList(ArrayList<ItemModel> goodsList) {

        this.itemList.clear();
        this.itemList.addAll(goodsList);
        notifyDataSetChanged();
    }

    public void addToList(ItemModel itemModel) {
        int oldSize = this.itemList.size();
        this.itemList.add(itemModel);
        notifyItemRangeInserted(oldSize, this.itemList.size());
    }

    public void removeFromList(int index) {
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
