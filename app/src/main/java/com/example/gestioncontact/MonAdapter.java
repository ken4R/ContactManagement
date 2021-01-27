package com.example.gestioncontact;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAdapter extends BaseAdapter implements Filterable  {
    Context con;
    ArrayList<Contact> d;

    ArrayList<Contact> filtredData;
    MonAdapter(Context con , ArrayList<Contact> d)

    {
        this.con=con;
        this.d=d;
        this.filtredData = d;


    }
    @Override
    public int getCount() {
        //nbr de views a creer
        return filtredData.size();
    }

    @Override
    public Contact getItem(int position) {

        return filtredData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // parsing code xml  de xml vers java
        LayoutInflater inf=LayoutInflater.from(con);

        LinearLayout l= (LinearLayout) inf.inflate(R.layout.view_contact,null);
        TextView tvnom=l.findViewById(R.id.tvnom_view);
        TextView tvprenom=l.findViewById(R.id.tvprenom_view);
        TextView tvnum=l.findViewById(R.id.tvnum_view);

        Contact c=getItem(position);
        tvnom.setText(c.nom);
        tvprenom.setText(c.prenom);
        tvnum.setText(c.numero);
        return l;
    }

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                if (results != null && results.values != null) {

                    filtredData = (ArrayList<Contact>) results.values; }
                else {
                    filtredData = d;
                }
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();
                ArrayList<Contact> filteredList = new ArrayList<Contact>();

                //Do your filtering operation with the constraint String
                for(int i = 0; i < d.size(); i++) {

                    Contact currentContact = d.get(i);
                    if (currentContact.getNom()
                            .contains(constraint.toString())) {

                       // Log.d("myTag", "This is my message");

                        filteredList.add(currentContact);
                    }
                }
                //Return result for publishResults to use it

                results.count = filteredList.size();
                results.values = filteredList;

                return results;
            }
        };
        return filter;
    }

}
