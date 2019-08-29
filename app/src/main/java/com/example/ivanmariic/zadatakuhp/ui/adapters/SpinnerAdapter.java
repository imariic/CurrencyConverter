package com.example.ivanmariic.zadatakuhp.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ivanmariic.zadatakuhp.model.Currency;

public class SpinnerAdapter extends ArrayAdapter<Currency>{

    private Context context;

    private Currency [] currencies;

    public SpinnerAdapter(Context context, int textViewResourceId, Currency [] currencies){
        super(context,textViewResourceId,currencies);

        this.context = context;
        this.currencies = currencies;

    }

    @Override
    public int getCount() {
        return currencies.length;
    }

    @Nullable
    @Override
    public Currency getItem(int position) {
        return currencies[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = (TextView) super.getView(position,convertView,parent);
        textView.setTextColor(Color.BLACK);
        textView.setText(currencies[position].getCurrencyCode());
        return textView;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView textView = (TextView) super.getDropDownView(position,convertView,parent);
        textView.setTextColor(Color.BLACK);
        textView.setText(currencies[position].getCurrencyCode());
        return textView;

    }


}
