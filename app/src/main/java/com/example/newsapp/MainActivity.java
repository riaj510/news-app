package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    HashMap<String,String> hashMap = new HashMap<>();
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listView);

        createTable();

        MyAdapter myAdapter = new MyAdapter();
       listView.setAdapter(myAdapter);


    }
    //=============================================
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.item,viewGroup,false);
            ImageView item_thumb = myView.findViewById(R.id.ivThumb);
            TextView item_title = myView.findViewById(R.id.tvTitle);
            TextView item_description = myView.findViewById(R.id.tvdes);
            TextView item_cat  = myView.findViewById(R.id.tvIcon);
            LinearLayout layListView = myView.findViewById(R.id.layListView);

            HashMap <String,String> hashMap = arrayList.get(i);
            String cat = hashMap.get("cat");
            String title = hashMap.get("title");
            String des = hashMap.get("des");
            String image = hashMap.get("image");

            Picasso.get()
                    .load(image)
                    .placeholder(R.drawable.image_placeholder)
                    .into(item_thumb);
            item_cat.setText(cat);
            item_description.setText(des);
            item_title.setText(title);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            item_cat.setBackgroundColor(color);

            layListView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, NewsDetails.class));
                    NewsDetails.TITLE = title;
                    NewsDetails.DESCRIPTION = des;
                    Bitmap bitmap = ((BitmapDrawable)item_thumb.getDrawable()).getBitmap();
                    NewsDetails.MY_BITMAP = bitmap;
                }
            });

            return myView;
        }
    }
    // ============================================
    // ============================================
    private void createTable(){
        hashMap = new HashMap<>();
        hashMap.put("cat","world");
        hashMap.put("title","তাইওয়ানের কাছে শতকোটি ডলারের অস্ত্র বিক্রি, যা বলছে ক্ষুব্ধ চীন");
        hashMap.put("des","তাইওয়ানের কাছে ১১০ কোটি মার্কিন ডলারের অস্ত্র বিক্রির অনুমোদন দিয়েছে যুক্তরাষ্ট্র। শুক্রবার ওয়াশিংটন এই ঘোষণা দেয়। এ ঘটনায় ক্ষুব্ধ চীন বলেছে, অস্ত্র বিক্রি বাতিল না হলে ওয়াশিংটনের বিরুদ্ধে পাল্টাব্যবস্থা নেওয়া হবে।\n" +
                "\n" +
                "সম্প্রতি মার্কিন কংগ্রেসের স্পিকার ন্যান্সি পেলোসির তাইওয়ান সফর নিয়ে প্রণালির দুই পাশে উত্তেজনা শুরু হয়। তাইওয়ানের চারপাশে নজিরবিহীন সামরিক মহড়া চালায় বেইজিং।\n" +
                "\n" +
                "তাইওয়ানের কাছে যুক্তরাষ্ট্রের সম্ভাব্য বিক্রি ঘোষণা দেওয়া অস্ত্রের মধ্যে রয়েছে, ৬৬ কোটি ৫০ লাখ ডলারের অরেথিওন ‘রাডার ওয়ার্নিং সিস্টেম’। এ রাডার ব্যবস্থার মাধ্যমে ধেয়ে আসা ক্ষেপণাস্ত্র শনাক্ত করা যাবে। এ ছাড়া আছে ৩৫ কোটি ৫০ লাখ ডলারের ৬০টি হারপুন ক্ষেপণাস্ত্র, যা যেকোনো জাহাজ ডুবিয়ে দিতে সক্ষম। আরও আছে ৮ কোটি ৫৬ লাখ ডলারের সাইডউইন্ডার ক্ষেপণাস্ত্র যা বিমানবাহিনী ব্যবহার করতে পারবে।\n" +
                "ওয়াশিংটনে চীনা দূতাবাসের মুখপাত্র লিউ পেংয়ু বলেন, পরিস্থিতির আলোকে চীন দৃঢ়তার সঙ্গে বৈধ এবং প্রয়োজনীয় পাল্টাব্যবস্থা নেবে।\n" +
                "\n" +
                "তাইওয়ানে অস্ত্র বিক্রির অনুমোদন দেওয়া যুক্তরাষ্ট্রের পররাষ্ট্র মন্ত্রণালয়ের একজন মুখপাত্র বলেন, তাইওয়ানের নিরাপত্তার জন্য এসব অস্ত্র খুব জরুরি। সূ");
        hashMap.put("image","https://www.bd-pratidin.com/assets/news_images/2022/09/04/060703_bangladesh_pratidin_Taiwan.jpg");


        arrayList.add(hashMap);
    }

    // ============================================



}