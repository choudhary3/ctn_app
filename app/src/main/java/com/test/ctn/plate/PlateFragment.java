package com.test.ctn.plate;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.test.ctn.R;
import com.test.ctn.fooditems.fooddata.FoodDetails;
import com.test.ctn.fooditems.fooddata.StorageClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class PlateFragment extends Fragment {
    ListView listview;
    private static final String SEND_URL = "http://pcpradeep22.16mb.com/sent.php";

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_plate, container, false);

        listview = (ListView) view.findViewById(R.id.custom_ListView);
        listview.setAdapter(new PlateAdapter(getContext(),new StorageClass().getFoodCart()));

        FloatingActionButton addItems = (FloatingActionButton) view.findViewById(R.id.addItems);
        listview.setEmptyView(view.findViewById(R.id.empty_view));
        addItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Add Some Items",Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
            }
        });

        final Button checkout = (Button) view.findViewById(R.id.checkout);
        checkout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (true) {
                            ArrayList<FoodDetails> dbArray = new StorageClass().getFoodCart();
                            int size = dbArray.size();
                            for (int i = 0; i < size; i++) {
                                int price = dbArray.get(i).getPrice();
                                String name = dbArray.get(i).getFoodName();
                                int quantity = dbArray.get(i).getFoodQuantity();
                                for(int j = 0; j < name.length(); j++){
                                    if(name.charAt(j) == ' '){
                                        name = name.substring(0,j) + '_' + name.substring(j+1);
                                    }
                                }
                                SendToDb data = new SendToDb(price, name, quantity);
                                SendOrder sendOrder = new SendOrder();
                                sendOrder.execute(data.getUrl());
                            }
                            for(int i = 0; i < size; i++){
                                dbArray.remove(0);
                            }
                            listview.setEmptyView(view.findViewById(R.id.empty_view));
                        }else{
                            Toast.makeText(getContext(), "No internet!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        return view;
    }

    public class SendToDb{
        private int sendPrice;
        private int sendQuantity;
        private String sendName;
        private String sendUrl;
        SendToDb(int price, String name, int quantity){
            sendPrice = price;
            sendQuantity = quantity;
            sendName = name;
            sendUrl = "?sendprice=" + sendPrice + "&sendname=" + sendName + "&sendquantity=" + sendQuantity;
        }
        public String getUrl(){
            return sendUrl;
        }
    }

    class SendOrder extends AsyncTask<String, Void, String> {

        ProgressDialog loading;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading = ProgressDialog.show(getContext(), "Please Wait", null, true, true);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            loading.dismiss();
        }

        @Override
        protected String doInBackground(String... params) {
            String s = params[0];
            BufferedReader bufferedReader = null;
            try {
                URL url = new URL(SEND_URL + s);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String result;
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return null;
            }
        }
    }

}
