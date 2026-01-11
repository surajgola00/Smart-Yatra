package com.example.smartyatra.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartyatra.R;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    private final List<Place> placeList;

    public PlaceAdapter(List<Place> placeList) {
        this.placeList = placeList;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_explore_place, parent, false);
        return new PlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        Place currentPlace = placeList.get(position);
        holder.imgPlace.setImageResource(currentPlace.imageResId);
        holder.tvPlaceName.setText(currentPlace.name);
        holder.tvPlaceDesc.setText(currentPlace.description);

        if(currentPlace.description == null || currentPlace.description.isEmpty()) {
            holder.tvPlaceDesc.setVisibility(View.GONE);
        } else {
            holder.tvPlaceDesc.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    static class PlaceViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPlace;
        TextView tvPlaceName, tvPlaceDesc;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPlace = itemView.findViewById(R.id.imgPlace);
            tvPlaceName = itemView.findViewById(R.id.tvPlaceName);
            tvPlaceDesc = itemView.findViewById(R.id.tvPlaceDesc);
        }
    }
}
