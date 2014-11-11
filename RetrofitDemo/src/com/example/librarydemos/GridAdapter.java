package com.example.librarydemos;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.librarydemos.ListviewActivity.Movies;
import com.squareup.picasso.Picasso;

public class GridAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private List<Movies> movieItems;

	public GridAdapter(LayoutInflater inflater, List<Movies> movieItems) {
		this.inflater = inflater;
		this.movieItems = movieItems;
	}

	@Override
	public int getCount() {
		return movieItems.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = (View) inflater.inflate(R.layout.gridcell, null);
			holder.text = (TextView) convertView.findViewById(R.id.gridtext);
			holder.image = (ImageView) convertView.findViewById(R.id.gridimage);
			holder.context = inflater.getContext();
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.text.setText(getItem(position).title);
		Picasso.with(holder.context).load(getItem(position).image).into(holder.image);
		return convertView;
	}

	@Override
	public Movies getItem(int location) {
		return movieItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public static class ViewHolder {
		TextView text;
		ImageView image;
		Context context;
	}

}