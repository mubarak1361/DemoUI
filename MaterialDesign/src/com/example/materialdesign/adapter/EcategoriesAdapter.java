package com.example.materialdesign.adapter;

import java.util.ArrayList;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.materialdesign.R;
import com.example.materialdesign.model.Categories;

public class EcategoriesAdapter extends BaseAdapter {
private LayoutInflater inflater;
private ArrayList<Categories> categoriesArrayList;
private TextView category ;
private View color;
	public EcategoriesAdapter(LayoutInflater inflater,ArrayList<Categories> categoriesArrayList) {
		this.inflater =inflater;
		this.categoriesArrayList =categoriesArrayList;
	}
	
	@Override
	public int getCount() {

		return categoriesArrayList.size();
	}

	@Override
	public Categories getItem(int position) {

		return categoriesArrayList.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	
		if(convertView == null){
			convertView = inflater.inflate(R.layout.item, parent, false);
		}
		category = (TextView) convertView.findViewById(R.id.category);
		color = (View) convertView.findViewById(R.id.color);
		category.setText(getItem(position).getName());
		color.setBackgroundColor(Color.parseColor(getItem(position).getColor()));
		
		return convertView;
	}

}
