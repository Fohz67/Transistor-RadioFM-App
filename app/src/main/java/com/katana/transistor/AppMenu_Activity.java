package com.katana.transistor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class AppMenu_Activity extends AppCompatActivity {

    TextView title, subtitle, subtitle2, subtitle3;
    CardView top;
    CardView random, random_top;
    NestedScrollView nestedScrollView;

    CardView pop1, pop2, pop3, pop4, pop5, pop6;
    CardView cAll1, cAll3, cAll4, cAll5, cAll6, cAll7, cAll8, cAll9, cAll10, cAll11, cAll12, cAll13, cAll14, cAll15, cAll16, cAll17, cAll18, cAll19, cAll20, cAll21, cAll22, cAll23, cAll24, cAll25, cAll26, cAll27, cAll29, cAll30, cAll31;
    CardView fav1, fav2, fav3, fav4, fav5;
   
    ImageView plus1, plus2, plus3, plus4, plus5;
    ImageView cover1, cover2, cover3, cover4, cover5;
    ImageView delete1, delete2, delete3, delete4, delete5;

    String f1, f2, f3, f4, f5;

    SharedPreferences spFavoris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_menu);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        spFavoris = getApplication().getSharedPreferences("sp_favoris", Context.MODE_PRIVATE);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        title = findViewById(R.id.title);
        top = findViewById(R.id.top);
        subtitle = findViewById(R.id.subtitle);
        subtitle2 = findViewById(R.id.subtitle2);
        subtitle3 = findViewById(R.id.subtitle3);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        pop1 = findViewById(R.id.c_pop_1);
        pop2 = findViewById(R.id.c_pop_2);
        pop3 = findViewById(R.id.c_pop_3);
        pop4 = findViewById(R.id.c_pop_4);
        pop5 = findViewById(R.id.c_pop_5);
        pop6 = findViewById(R.id.c_pop_6);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        cAll1 = findViewById(R.id.cAll1);
        cAll3 = findViewById(R.id.cAll3);
        cAll4 = findViewById(R.id.cAll4);
        cAll5 = findViewById(R.id.cAll5);
        cAll6 = findViewById(R.id.cAll6);
        cAll7 = findViewById(R.id.cAll7);
        cAll8 = findViewById(R.id.cAll8);
        cAll9 = findViewById(R.id.cAll9);
        cAll10 = findViewById(R.id.cAll10);
        cAll11 = findViewById(R.id.cAll11);
        cAll12 = findViewById(R.id.cAll12);
        cAll13 = findViewById(R.id.cAll13);
        cAll14 = findViewById(R.id.cAll14);
        cAll15 = findViewById(R.id.cAll15);
        cAll16 = findViewById(R.id.cAll16);
        cAll17 = findViewById(R.id.cAll17);
        cAll18 = findViewById(R.id.cAll18);
        cAll19 = findViewById(R.id.cAll19);
        cAll20 = findViewById(R.id.cAll20);
        cAll21 = findViewById(R.id.cAll21);
        cAll22 = findViewById(R.id.cAll22);
        cAll23 = findViewById(R.id.cAll23);
        cAll24 = findViewById(R.id.cAll24);
        cAll25 = findViewById(R.id.cAll25);
        cAll26 = findViewById(R.id.cAll26);
        cAll27 = findViewById(R.id.cAll27);
        cAll29 = findViewById(R.id.cAll29);
        cAll30 = findViewById(R.id.cAll30);
        cAll31 = findViewById(R.id.cAll31);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        fav1 = findViewById(R.id.c_fav_1);
        fav2 = findViewById(R.id.c_fav_2);
        fav3 = findViewById(R.id.c_fav_3);
        fav4 = findViewById(R.id.c_fav_4);
        fav5 = findViewById(R.id.c_fav_5);

        plus1 = findViewById(R.id.plus1);
        plus2 = findViewById(R.id.plus2);
        plus3 = findViewById(R.id.plus3);
        plus4 = findViewById(R.id.plus4);
        plus5 = findViewById(R.id.plus5);

        delete1 = findViewById(R.id.supp1);
        delete2 = findViewById(R.id.supp2);
        delete3 = findViewById(R.id.supp3);
        delete4 = findViewById(R.id.supp4);
        delete5 = findViewById(R.id.supp5);

        cover1 = findViewById(R.id.cover1);
        cover2 = findViewById(R.id.cover2);
        cover3 = findViewById(R.id.cover3);
        cover4 = findViewById(R.id.cover4);
        cover5 = findViewById(R.id.cover5);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        random = findViewById(R.id.c_probleme);
        random_top = findViewById(R.id.c_random_top);
        nestedScrollView = findViewById(R.id.nestedScrollView);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getRandom();
            }
        });

        random_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRandom();
            }
        });

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFav(1);
            }
        });

        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFav(2);
            }
        });

        delete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFav(3);
            }
        });

        delete4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFav(4);
            }
        });

        delete5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFav(5);
            }
        });

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        fav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f1.equals("null")){
                    dialogFav(1);
                } else {
                    Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                    switch (f1) {
                        case "alouette":
                            intent.putExtra("string", getResources().getString(R.string.alouette));
                            break;
                        case "beur":
                            intent.putExtra("string", getResources().getString(R.string.beur));
                            break;
                        case "bfm":
                            intent.putExtra("string", getResources().getString(R.string.bfm));
                            break;
                        case "cheriefm":
                            intent.putExtra("string", getResources().getString(R.string.cheriefm));
                            break;
                        case "classique":
                            intent.putExtra("string", getResources().getString(R.string.classique));
                            break;
                        case "europe1":
                            intent.putExtra("string", getResources().getString(R.string.europe1));
                            break;
                        case "fg":
                            intent.putExtra("string", getResources().getString(R.string.fg));
                            break;
                        case "fip":
                            intent.putExtra("string", getResources().getString(R.string.fip));
                            break;
                        case "francebleu":
                            intent.putExtra("string", getResources().getString(R.string.francebleu));
                            break;
                        case "franceculture":
                            intent.putExtra("string", getResources().getString(R.string.franceculture));
                            break;
                        case "franceinter":
                            intent.putExtra("string", getResources().getString(R.string.franceinter));
                            break;
                        case "franceinfo":
                            intent.putExtra("string", getResources().getString(R.string.franceinfo));
                            break;
                        case "fun":
                            intent.putExtra("string", getResources().getString(R.string.fun));
                            break;
                        case "hit":
                            intent.putExtra("string", getResources().getString(R.string.hit));
                            break;
                        case "jazz":
                            intent.putExtra("string", getResources().getString(R.string.jazz));
                            break;
                        case "mouv":
                            intent.putExtra("string", getResources().getString(R.string.mouv));
                            break;
                        case "mradio":
                            intent.putExtra("string", getResources().getString(R.string.mradio));
                            break;
                        case "nova":
                            intent.putExtra("string", getResources().getString(R.string.nova));
                            break;
                        case "nrj":
                            intent.putExtra("string", getResources().getString(R.string.nrj));
                            break;
                        case "ouifm":
                            intent.putExtra("string", getResources().getString(R.string.ouifm));
                            break;
                        case "premiere":
                            intent.putExtra("string", getResources().getString(R.string.premiere));
                            break;
                        case "rfm":
                            intent.putExtra("string", getResources().getString(R.string.rfm));
                            break;
                        case "rire":
                            intent.putExtra("string", getResources().getString(R.string.rire));
                            break;
                        case "rmc":
                            intent.putExtra("string", getResources().getString(R.string.rmc));
                            break;
                        case "rtl":
                            intent.putExtra("string", getResources().getString(R.string.rtl));
                            break;
                        case "skyrock":
                            intent.putExtra("string", getResources().getString(R.string.skyrock));
                            break;
                        case "sud":
                            intent.putExtra("string", getResources().getString(R.string.sud));
                            break;
                        case "virgin":
                            intent.putExtra("string", getResources().getString(R.string.virgin));
                            break;
                        case "nostalgie":
                            intent.putExtra("string", getResources().getString(R.string.nostalgie));
                            break;
                    }
                    startActivity(intent);
                }
            }
        });

        fav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f2.equals("null")){
                    dialogFav(2);
                } else {
                    Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                    switch (f2) {
                        case "alouette":
                            intent.putExtra("string", getResources().getString(R.string.alouette));
                            break;
                        case "beur":
                            intent.putExtra("string", getResources().getString(R.string.beur));
                            break;
                        case "bfm":
                            intent.putExtra("string", getResources().getString(R.string.bfm));
                            break;
                        case "cheriefm":
                            intent.putExtra("string", getResources().getString(R.string.cheriefm));
                            break;
                        case "classique":
                            intent.putExtra("string", getResources().getString(R.string.classique));
                            break;
                        case "europe1":
                            intent.putExtra("string", getResources().getString(R.string.europe1));
                            break;
                        case "fg":
                            intent.putExtra("string", getResources().getString(R.string.fg));
                            break;
                        case "fip":
                            intent.putExtra("string", getResources().getString(R.string.fip));
                            break;
                        case "francebleu":
                            intent.putExtra("string", getResources().getString(R.string.francebleu));
                            break;
                        case "franceculture":
                            intent.putExtra("string", getResources().getString(R.string.franceculture));
                            break;
                        case "franceinter":
                            intent.putExtra("string", getResources().getString(R.string.franceinter));
                            break;
                        case "franceinfo":
                            intent.putExtra("string", getResources().getString(R.string.franceinfo));
                            break;
                        case "fun":
                            intent.putExtra("string", getResources().getString(R.string.fun));
                            break;
                        case "hit":
                            intent.putExtra("string", getResources().getString(R.string.hit));
                            break;
                        case "jazz":
                            intent.putExtra("string", getResources().getString(R.string.jazz));
                            break;
                        case "mouv":
                            intent.putExtra("string", getResources().getString(R.string.mouv));
                            break;
                        case "mradio":
                            intent.putExtra("string", getResources().getString(R.string.mradio));
                            break;
                        case "nova":
                            intent.putExtra("string", getResources().getString(R.string.nova));
                            break;
                        case "nrj":
                            intent.putExtra("string", getResources().getString(R.string.nrj));
                            break;
                        case "ouifm":
                            intent.putExtra("string", getResources().getString(R.string.ouifm));
                            break;
                        case "premiere":
                            intent.putExtra("string", getResources().getString(R.string.premiere));
                            break;
                        case "rfm":
                            intent.putExtra("string", getResources().getString(R.string.rfm));
                            break;
                        case "rire":
                            intent.putExtra("string", getResources().getString(R.string.rire));
                            break;
                        case "rmc":
                            intent.putExtra("string", getResources().getString(R.string.rmc));
                            break;
                        case "rtl":
                            intent.putExtra("string", getResources().getString(R.string.rtl));
                            break;
                        case "skyrock":
                            intent.putExtra("string", getResources().getString(R.string.skyrock));
                            break;
                        case "sud":
                            intent.putExtra("string", getResources().getString(R.string.sud));
                            break;
                        case "virgin":
                            intent.putExtra("string", getResources().getString(R.string.virgin));
                            break;
                        case "nostalgie":
                            intent.putExtra("string", getResources().getString(R.string.nostalgie));
                            break;
                    }
                    startActivity(intent);
                }
            }
        });

        fav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f3.equals("null")){
                    dialogFav(3);
                } else {
                    Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                    switch (f3) {
                        case "alouette":
                            intent.putExtra("string", getResources().getString(R.string.alouette));
                            break;
                        case "beur":
                            intent.putExtra("string", getResources().getString(R.string.beur));
                            break;
                        case "bfm":
                            intent.putExtra("string", getResources().getString(R.string.bfm));
                            break;
                        case "cheriefm":
                            intent.putExtra("string", getResources().getString(R.string.cheriefm));
                            break;
                        case "classique":
                            intent.putExtra("string", getResources().getString(R.string.classique));
                            break;
                        case "europe1":
                            intent.putExtra("string", getResources().getString(R.string.europe1));
                            break;
                        case "fg":
                            intent.putExtra("string", getResources().getString(R.string.fg));
                            break;
                        case "fip":
                            intent.putExtra("string", getResources().getString(R.string.fip));
                            break;
                        case "francebleu":
                            intent.putExtra("string", getResources().getString(R.string.francebleu));
                            break;
                        case "franceculture":
                            intent.putExtra("string", getResources().getString(R.string.franceculture));
                            break;
                        case "franceinter":
                            intent.putExtra("string", getResources().getString(R.string.franceinter));
                            break;
                        case "franceinfo":
                            intent.putExtra("string", getResources().getString(R.string.franceinfo));
                            break;
                        case "fun":
                            intent.putExtra("string", getResources().getString(R.string.fun));
                            break;
                        case "hit":
                            intent.putExtra("string", getResources().getString(R.string.hit));
                            break;
                        case "jazz":
                            intent.putExtra("string", getResources().getString(R.string.jazz));
                            break;
                        case "mouv":
                            intent.putExtra("string", getResources().getString(R.string.mouv));
                            break;
                        case "mradio":
                            intent.putExtra("string", getResources().getString(R.string.mradio));
                            break;
                        case "nova":
                            intent.putExtra("string", getResources().getString(R.string.nova));
                            break;
                        case "nrj":
                            intent.putExtra("string", getResources().getString(R.string.nrj));
                            break;
                        case "ouifm":
                            intent.putExtra("string", getResources().getString(R.string.ouifm));
                            break;
                        case "premiere":
                            intent.putExtra("string", getResources().getString(R.string.premiere));
                            break;
                        case "rfm":
                            intent.putExtra("string", getResources().getString(R.string.rfm));
                            break;
                        case "rire":
                            intent.putExtra("string", getResources().getString(R.string.rire));
                            break;
                        case "rmc":
                            intent.putExtra("string", getResources().getString(R.string.rmc));
                            break;
                        case "rtl":
                            intent.putExtra("string", getResources().getString(R.string.rtl));
                            break;
                        case "skyrock":
                            intent.putExtra("string", getResources().getString(R.string.skyrock));
                            break;
                        case "sud":
                            intent.putExtra("string", getResources().getString(R.string.sud));
                            break;
                        case "virgin":
                            intent.putExtra("string", getResources().getString(R.string.virgin));
                            break;
                        case "nostalgie":
                            intent.putExtra("string", getResources().getString(R.string.nostalgie));
                            break;
                    }
                    startActivity(intent);
                }
            }
        });

        fav4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f4.equals("null")){
                    dialogFav(4);
                } else {
                    Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                    switch (f4) {
                        case "alouette":
                            intent.putExtra("string", getResources().getString(R.string.alouette));
                            break;
                        case "beur":
                            intent.putExtra("string", getResources().getString(R.string.beur));
                            break;
                        case "bfm":
                            intent.putExtra("string", getResources().getString(R.string.bfm));
                            break;
                        case "cheriefm":
                            intent.putExtra("string", getResources().getString(R.string.cheriefm));
                            break;
                        case "classique":
                            intent.putExtra("string", getResources().getString(R.string.classique));
                            break;
                        case "europe1":
                            intent.putExtra("string", getResources().getString(R.string.europe1));
                            break;
                        case "fg":
                            intent.putExtra("string", getResources().getString(R.string.fg));
                            break;
                        case "fip":
                            intent.putExtra("string", getResources().getString(R.string.fip));
                            break;
                        case "francebleu":
                            intent.putExtra("string", getResources().getString(R.string.francebleu));
                            break;
                        case "franceculture":
                            intent.putExtra("string", getResources().getString(R.string.franceculture));
                            break;
                        case "franceinter":
                            intent.putExtra("string", getResources().getString(R.string.franceinter));
                            break;
                        case "franceinfo":
                            intent.putExtra("string", getResources().getString(R.string.franceinfo));
                            break;
                        case "fun":
                            intent.putExtra("string", getResources().getString(R.string.fun));
                            break;
                        case "hit":
                            intent.putExtra("string", getResources().getString(R.string.hit));
                            break;
                        case "jazz":
                            intent.putExtra("string", getResources().getString(R.string.jazz));
                            break;
                        case "mouv":
                            intent.putExtra("string", getResources().getString(R.string.mouv));
                            break;
                        case "mradio":
                            intent.putExtra("string", getResources().getString(R.string.mradio));
                            break;
                        case "nova":
                            intent.putExtra("string", getResources().getString(R.string.nova));
                            break;
                        case "nrj":
                            intent.putExtra("string", getResources().getString(R.string.nrj));
                            break;
                        case "ouifm":
                            intent.putExtra("string", getResources().getString(R.string.ouifm));
                            break;
                        case "premiere":
                            intent.putExtra("string", getResources().getString(R.string.premiere));
                            break;
                        case "rfm":
                            intent.putExtra("string", getResources().getString(R.string.rfm));
                            break;
                        case "rire":
                            intent.putExtra("string", getResources().getString(R.string.rire));
                            break;
                        case "rmc":
                            intent.putExtra("string", getResources().getString(R.string.rmc));
                            break;
                        case "rtl":
                            intent.putExtra("string", getResources().getString(R.string.rtl));
                            break;
                        case "skyrock":
                            intent.putExtra("string", getResources().getString(R.string.skyrock));
                            break;
                        case "sud":
                            intent.putExtra("string", getResources().getString(R.string.sud));
                            break;
                        case "virgin":
                            intent.putExtra("string", getResources().getString(R.string.virgin));
                            break;
                        case "nostalgie":
                            intent.putExtra("string", getResources().getString(R.string.nostalgie));
                            break;
                    }
                    startActivity(intent);
                }
            }
        });

        fav5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f5.equals("null")){
                    dialogFav(5);
                } else {
                    Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                    switch (f5) {
                        case "alouette":
                            intent.putExtra("string", getResources().getString(R.string.alouette));
                            break;
                        case "beur":
                            intent.putExtra("string", getResources().getString(R.string.beur));
                            break;
                        case "bfm":
                            intent.putExtra("string", getResources().getString(R.string.bfm));
                            break;
                        case "cheriefm":
                            intent.putExtra("string", getResources().getString(R.string.cheriefm));
                            break;
                        case "classique":
                            intent.putExtra("string", getResources().getString(R.string.classique));
                            break;
                        case "europe1":
                            intent.putExtra("string", getResources().getString(R.string.europe1));
                            break;
                        case "fg":
                            intent.putExtra("string", getResources().getString(R.string.fg));
                            break;
                        case "fip":
                            intent.putExtra("string", getResources().getString(R.string.fip));
                            break;
                        case "francebleu":
                            intent.putExtra("string", getResources().getString(R.string.francebleu));
                            break;
                        case "franceculture":
                            intent.putExtra("string", getResources().getString(R.string.franceculture));
                            break;
                        case "franceinter":
                            intent.putExtra("string", getResources().getString(R.string.franceinter));
                            break;
                        case "franceinfo":
                            intent.putExtra("string", getResources().getString(R.string.franceinfo));
                            break;
                        case "fun":
                            intent.putExtra("string", getResources().getString(R.string.fun));
                            break;
                        case "hit":
                            intent.putExtra("string", getResources().getString(R.string.hit));
                            break;
                        case "jazz":
                            intent.putExtra("string", getResources().getString(R.string.jazz));
                            break;
                        case "mouv":
                            intent.putExtra("string", getResources().getString(R.string.mouv));
                            break;
                        case "mradio":
                            intent.putExtra("string", getResources().getString(R.string.mradio));
                            break;
                        case "nova":
                            intent.putExtra("string", getResources().getString(R.string.nova));
                            break;
                        case "nrj":
                            intent.putExtra("string", getResources().getString(R.string.nrj));
                            break;
                        case "ouifm":
                            intent.putExtra("string", getResources().getString(R.string.ouifm));
                            break;
                        case "premiere":
                            intent.putExtra("string", getResources().getString(R.string.premiere));
                            break;
                        case "rfm":
                            intent.putExtra("string", getResources().getString(R.string.rfm));
                            break;
                        case "rire":
                            intent.putExtra("string", getResources().getString(R.string.rire));
                            break;
                        case "rmc":
                            intent.putExtra("string", getResources().getString(R.string.rmc));
                            break;
                        case "rtl":
                            intent.putExtra("string", getResources().getString(R.string.rtl));
                            break;
                        case "skyrock":
                            intent.putExtra("string", getResources().getString(R.string.skyrock));
                            break;
                        case "sud":
                            intent.putExtra("string", getResources().getString(R.string.sud));
                            break;
                        case "virgin":
                            intent.putExtra("string", getResources().getString(R.string.virgin));
                            break;
                        case "nostalgie":
                            intent.putExtra("string", getResources().getString(R.string.nostalgie));
                            break;
                    }
                    startActivity(intent);
                }
            }
        });

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int size = 40-(scrollY/20);
                top.setAlpha((float) scrollY/200);
                title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Math.max(size, 28));
            }
        });

        pop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.nrj));
                startActivity(intent);
            }
        });

        pop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.europe1));
                startActivity(intent);
            }
        });

        pop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.skyrock));
                startActivity(intent);
            }
        });

        pop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.fun));
                startActivity(intent);
            }
        });

        pop5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.franceinter));
                startActivity(intent);
            }
        });

        pop6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.rtl));
                startActivity(intent);
            }
        });

        cAll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.alouette));
                startActivity(intent);
            }
        });

        cAll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.beur));
                startActivity(intent);
            }
        });

        cAll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.bfm));
                startActivity(intent);
            }
        });

        cAll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.cheriefm));
                startActivity(intent);
            }
        });

        cAll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.classique));
                startActivity(intent);
            }
        });

        cAll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.europe1));
                startActivity(intent);
            }
        });

        cAll8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.fg));
                startActivity(intent);
            }
        });

        cAll9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.fip));
                startActivity(intent);
            }
        });

        cAll10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.francebleu));
                startActivity(intent);
            }
        });

        cAll11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.franceculture));
                startActivity(intent);
            }
        });

        cAll12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.franceinfo));
                startActivity(intent);
            }
        });

        cAll13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.franceinter));
                startActivity(intent);
            }
        });

        cAll14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.fun));
                startActivity(intent);
            }
        });

        cAll15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.hit));
                startActivity(intent);
            }
        });

        cAll16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.jazz));
                startActivity(intent);
            }
        });

        cAll17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.premiere));
                startActivity(intent);
            }
        });

        cAll18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.mradio));
                startActivity(intent);
            }
        });

        cAll19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.mouv));
                startActivity(intent);
            }
        });

        cAll20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.nostalgie));
                startActivity(intent);
            }
        });

        cAll21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.nova));
                startActivity(intent);
            }
        });

        cAll22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.nrj));
                startActivity(intent);
            }
        });

        cAll23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.ouifm));
                startActivity(intent);
            }
        });

        cAll24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.rfm));
                startActivity(intent);
            }
        });

        cAll25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.rire));
                startActivity(intent);
            }
        });

        cAll26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.rmc));
                startActivity(intent);
            }
        });

        cAll27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.rtl));
                startActivity(intent);
            }
        });

        cAll29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.skyrock));
                startActivity(intent);
            }
        });

        cAll30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.sud));
                startActivity(intent);
            }
        });

        cAll31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
                intent.putExtra("string", getResources().getString(R.string.virgin));
                startActivity(intent);
            }
        });

        getFav();

    }

    private void deleteFav(int i) {
        SharedPreferences.Editor editor = spFavoris.edit();
        editor.putString("fav"+ i, "null");
        editor.apply();

        getFav();
    }
    private void dialogFav(int i) {
        Dialog dialog = new Dialog(AppMenu_Activity.this);
        dialog.setContentView(R.layout.dialog_flux);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);

        CardView _1,_2,_3,_4,_5,_6,_7,_8,_9,_10,_11,_12,_13,_14,_15,_16,_17,_18,_19,_20,_21,_22,_23,_24,_25,_26,_27,_28,_29;
        NestedScrollView scrollView;
        CardView topCard;
        TextView titleCard;

        scrollView = dialog.findViewById(R.id.scrollViewDialog);
        topCard = dialog.findViewById(R.id.cardView);
        titleCard = dialog.findViewById(R.id.textView);

        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int size = 30-(scrollY/20);
                topCard.setAlpha((float) scrollY/200);
                titleCard.setTextSize(TypedValue.COMPLEX_UNIT_DIP, Math.max(size, 23));
            }
        });

        _1 = dialog.findViewById(R.id.flux1);
        _2 = dialog.findViewById(R.id.flux2);
        _3 = dialog.findViewById(R.id.flux3);
        _4 = dialog.findViewById(R.id.flux4);
        _5 = dialog.findViewById(R.id.flux5);
        _6 = dialog.findViewById(R.id.flux6);
        _7 = dialog.findViewById(R.id.flux7);
        _8 = dialog.findViewById(R.id.flux8);
        _9 = dialog.findViewById(R.id.flux9);
        _10 = dialog.findViewById(R.id.flux10);
        _11 = dialog.findViewById(R.id.flux11);
        _12 = dialog.findViewById(R.id.flux12);
        _13 = dialog.findViewById(R.id.flux13);
        _14 = dialog.findViewById(R.id.flux14);
        _15 = dialog.findViewById(R.id.flux15);
        _16 = dialog.findViewById(R.id.flux16);
        _17 = dialog.findViewById(R.id.flux17);
        _18 = dialog.findViewById(R.id.flux19);
        _19 = dialog.findViewById(R.id.flux20);
        _20 = dialog.findViewById(R.id.flux21);
        _21 = dialog.findViewById(R.id.flux22);
        _22 = dialog.findViewById(R.id.flux23);
        _23 = dialog.findViewById(R.id.flux24);
        _24 = dialog.findViewById(R.id.flux25);
        _25 = dialog.findViewById(R.id.flux26);
        _26 = dialog.findViewById(R.id.flux27);
        _27 = dialog.findViewById(R.id.flux28);
        _28 = dialog.findViewById(R.id.flux18);
        _29 = dialog.findViewById(R.id.flux29);

        _1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "beur");
                dialog.dismiss();
            }
        });

        _2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "bfm");
                dialog.dismiss();
            }
        });

        _3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "cheriefm");
                dialog.dismiss();
            }
        });

        _4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "classique");
                dialog.dismiss();
            }
        });

        _5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "europe1");
                dialog.dismiss();
            }
        });

        _6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "fg");
                dialog.dismiss();
            }
        });

        _7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "fip");
                dialog.dismiss();
            }
        });

        _8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "francebleu");
                dialog.dismiss();
            }
        });

        _9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "franceculture");
                dialog.dismiss();
            }
        });

        _10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "franceinter");
                dialog.dismiss();
            }
        });

        _11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "franceinfo");
                dialog.dismiss();
            }
        });

        _12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "fun");
                dialog.dismiss();
            }
        });

        _13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "hit");
                dialog.dismiss();
            }
        });

        _14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "jazz");
                dialog.dismiss();
            }
        });

        _15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "mouv");
                dialog.dismiss();
            }
        });

        _16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "mradio");
                dialog.dismiss();
            }
        });

        _17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "nova");
                dialog.dismiss();
            }
        });

        _18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "nrj");
                dialog.dismiss();
            }
        });

        _19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "ouifm");
                dialog.dismiss();
            }
        });

        _20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "premiere");
                dialog.dismiss();
            }
        });

        _21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "rfm");
                dialog.dismiss();
            }
        });

        _22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "rire");
                dialog.dismiss();
            }
        });

        _23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "rmc");
                dialog.dismiss();
            }
        });

        _24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "rtl");
                dialog.dismiss();
            }
        });

        _25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "skyrock");
                dialog.dismiss();
            }
        });

        _26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "sud");
                dialog.dismiss();
            }
        });

        _27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "virgin");
                dialog.dismiss();
            }
        });

        _28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "nostalgie");
                dialog.dismiss();
            }
        });

        _29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFav(i, "alouette");
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
    private void setFav(int i, String name) {
        SharedPreferences.Editor editor = spFavoris.edit();
        editor.putString("fav"+ i, name);
        editor.apply();

        getFav();
    }
    private void getFav() {
        f1 = spFavoris.getString("fav1", "null");
        f2 = spFavoris.getString("fav2", "null");
        f3 = spFavoris.getString("fav3", "null");
        f4 = spFavoris.getString("fav4", "null");
        f5 = spFavoris.getString("fav5", "null");

        if (!f1.equals("null")){

            cover1.setVisibility(View.VISIBLE);
            delete1.setVisibility(View.VISIBLE);
            plus1.setVisibility(View.GONE);
            
            switch (f1) {
                case "alouette":
                    cover1.setImageResource(R.drawable.alouette);
                    break;
                case "beur":
                    cover1.setImageResource(R.drawable.beurfm);
                    break;
                case "bfm":
                    cover1.setImageResource(R.drawable.bfm);
                    break;
                case "cheriefm":
                    cover1.setImageResource(R.drawable.cheriefm);
                    break;
                case "classique":
                    cover1.setImageResource(R.drawable.radioclassique);
                    break;
                case "europe1":
                    cover1.setImageResource(R.drawable.europe);
                    break;
                case "fg":
                    cover1.setImageResource(R.drawable.fgradio);
                    break;
                case "fip":
                    cover1.setImageResource(R.drawable.fip);
                    break;
                case "francebleu":
                    cover1.setImageResource(R.drawable.francebleu);
                    break;
                case "franceculture":
                    cover1.setImageResource(R.drawable.franceculture);
                    break;
                case "franceinter":
                    cover1.setImageResource(R.drawable.franceinter);
                    break;
                case "franceinfo":
                    cover1.setImageResource(R.drawable.franceinfo);
                    break;
                case "fun":
                    cover1.setImageResource(R.drawable.fun);
                    break;
                case "hit":
                    cover1.setImageResource(R.drawable.hitradio);
                    break;
                case "jazz":
                    cover1.setImageResource(R.drawable.jazzradio);
                    break;
                case "mouv":
                    cover1.setImageResource(R.drawable.mouv);
                    break;
                case "mradio":
                    cover1.setImageResource(R.drawable.mradio);
                    break;
                case "nova":
                    cover1.setImageResource(R.drawable.nova);
                    break;
                case "nrj":
                    cover1.setImageResource(R.drawable.nrj);
                    break;
                case "ouifm":
                    cover1.setImageResource(R.drawable.ouifm);
                    break;
                case "premiere":
                    cover1.setImageResource(R.drawable.lapremiere);
                    break;
                case "rfm":
                    cover1.setImageResource(R.drawable.rfm);
                    break;
                case "rire":
                    cover1.setImageResource(R.drawable.rireetchanson);
                    break;
                case "rmc":
                    cover1.setImageResource(R.drawable.rmc);
                    break;
                case "rtl":
                    cover1.setImageResource(R.drawable.rtl);
                    break;
                case "skyrock":
                    cover1.setImageResource(R.drawable.skyrock);
                    break;
                case "sud":
                    cover1.setImageResource(R.drawable.sudradio);
                    break;
                case "virgin":
                    cover1.setImageResource(R.drawable.virgin);
                    break;
                case "nostalgie":
                    cover1.setImageResource(R.drawable.nostalgie);
                    break;
            }
        } else {
            cover1.setVisibility(View.GONE);
            delete1.setVisibility(View.GONE);
            plus1.setVisibility(View.VISIBLE);
        }

        if (!f2.equals("null")){

            cover2.setVisibility(View.VISIBLE);
            delete2.setVisibility(View.VISIBLE);
            plus2.setVisibility(View.GONE);

            switch (f2) {
                case "alouette":
                    cover2.setImageResource(R.drawable.alouette);
                    break;
                case "beur":
                    cover2.setImageResource(R.drawable.beurfm);
                    break;
                case "bfm":
                    cover2.setImageResource(R.drawable.bfm);
                    break;
                case "cheriefm":
                    cover2.setImageResource(R.drawable.cheriefm);
                    break;
                case "classique":
                    cover2.setImageResource(R.drawable.radioclassique);
                    break;
                case "europe1":
                    cover2.setImageResource(R.drawable.europe);
                    break;
                case "fg":
                    cover2.setImageResource(R.drawable.fgradio);
                    break;
                case "fip":
                    cover2.setImageResource(R.drawable.fip);
                    break;
                case "francebleu":
                    cover2.setImageResource(R.drawable.francebleu);
                    break;
                case "franceculture":
                    cover2.setImageResource(R.drawable.franceculture);
                    break;
                case "franceinter":
                    cover2.setImageResource(R.drawable.franceinter);
                    break;
                case "franceinfo":
                    cover2.setImageResource(R.drawable.franceinfo);
                    break;
                case "fun":
                    cover2.setImageResource(R.drawable.fun);
                    break;
                case "hit":
                    cover2.setImageResource(R.drawable.hitradio);
                    break;
                case "jazz":
                    cover2.setImageResource(R.drawable.jazzradio);
                    break;
                case "mouv":
                    cover2.setImageResource(R.drawable.mouv);
                    break;
                case "mradio":
                    cover2.setImageResource(R.drawable.mradio);
                    break;
                case "nova":
                    cover2.setImageResource(R.drawable.nova);
                    break;
                case "nrj":
                    cover2.setImageResource(R.drawable.nrj);
                    break;
                case "ouifm":
                    cover2.setImageResource(R.drawable.ouifm);
                    break;
                case "premiere":
                    cover2.setImageResource(R.drawable.lapremiere);
                    break;
                case "rfm":
                    cover2.setImageResource(R.drawable.rfm);
                    break;
                case "rire":
                    cover2.setImageResource(R.drawable.rireetchanson);
                    break;
                case "rmc":
                    cover2.setImageResource(R.drawable.rmc);
                    break;
                case "rtl":
                    cover2.setImageResource(R.drawable.rtl);
                    break;
                case "skyrock":
                    cover2.setImageResource(R.drawable.skyrock);
                    break;
                case "sud":
                    cover2.setImageResource(R.drawable.sudradio);
                    break;
                case "virgin":
                    cover2.setImageResource(R.drawable.virgin);
                    break;
                case "nostalgie":
                    cover2.setImageResource(R.drawable.nostalgie);
                    break;
            }
        } else {
            cover2.setVisibility(View.GONE);
            delete2.setVisibility(View.GONE);
            plus2.setVisibility(View.VISIBLE);
        }

        if (!f3.equals("null")){

            cover3.setVisibility(View.VISIBLE);
            delete3.setVisibility(View.VISIBLE);
            plus3.setVisibility(View.GONE);

            switch (f3) {
                case "alouette":
                    cover3.setImageResource(R.drawable.alouette);
                    break;
                case "beur":
                    cover3.setImageResource(R.drawable.beurfm);
                    break;
                case "bfm":
                    cover3.setImageResource(R.drawable.bfm);
                    break;
                case "cheriefm":
                    cover3.setImageResource(R.drawable.cheriefm);
                    break;
                case "classique":
                    cover3.setImageResource(R.drawable.radioclassique);
                    break;
                case "europe1":
                    cover3.setImageResource(R.drawable.europe);
                    break;
                case "fg":
                    cover3.setImageResource(R.drawable.fgradio);
                    break;
                case "fip":
                    cover3.setImageResource(R.drawable.fip);
                    break;
                case "francebleu":
                    cover3.setImageResource(R.drawable.francebleu);
                    break;
                case "franceculture":
                    cover3.setImageResource(R.drawable.franceculture);
                    break;
                case "franceinter":
                    cover3.setImageResource(R.drawable.franceinter);
                    break;
                case "franceinfo":
                    cover3.setImageResource(R.drawable.franceinfo);
                    break;
                case "fun":
                    cover3.setImageResource(R.drawable.fun);
                    break;
                case "hit":
                    cover3.setImageResource(R.drawable.hitradio);
                    break;
                case "jazz":
                    cover3.setImageResource(R.drawable.jazzradio);
                    break;
                case "mouv":
                    cover3.setImageResource(R.drawable.mouv);
                    break;
                case "mradio":
                    cover3.setImageResource(R.drawable.mradio);
                    break;
                case "nova":
                    cover3.setImageResource(R.drawable.nova);
                    break;
                case "nrj":
                    cover3.setImageResource(R.drawable.nrj);
                    break;
                case "ouifm":
                    cover3.setImageResource(R.drawable.ouifm);
                    break;
                case "premiere":
                    cover3.setImageResource(R.drawable.lapremiere);
                    break;
                case "rfm":
                    cover3.setImageResource(R.drawable.rfm);
                    break;
                case "rire":
                    cover3.setImageResource(R.drawable.rireetchanson);
                    break;
                case "rmc":
                    cover3.setImageResource(R.drawable.rmc);
                    break;
                case "rtl":
                    cover3.setImageResource(R.drawable.rtl);
                    break;
                case "skyrock":
                    cover3.setImageResource(R.drawable.skyrock);
                    break;
                case "sud":
                    cover3.setImageResource(R.drawable.sudradio);
                    break;
                case "virgin":
                    cover3.setImageResource(R.drawable.virgin);
                    break;
                case "nostalgie":
                    cover3.setImageResource(R.drawable.nostalgie);
                    break;
            }
        } else {
            cover3.setVisibility(View.GONE);
            delete3.setVisibility(View.GONE);
            plus3.setVisibility(View.VISIBLE);
        }

        if (!f4.equals("null")){

            cover4.setVisibility(View.VISIBLE);
            delete4.setVisibility(View.VISIBLE);
            plus4.setVisibility(View.GONE);

            switch (f4) {
                case "alouette":
                    cover4.setImageResource(R.drawable.alouette);
                    break;
                case "beur":
                    cover4.setImageResource(R.drawable.beurfm);
                    break;
                case "bfm":
                    cover4.setImageResource(R.drawable.bfm);
                    break;
                case "cheriefm":
                    cover4.setImageResource(R.drawable.cheriefm);
                    break;
                case "classique":
                    cover4.setImageResource(R.drawable.radioclassique);
                    break;
                case "europe1":
                    cover4.setImageResource(R.drawable.europe);
                    break;
                case "fg":
                    cover4.setImageResource(R.drawable.fgradio);
                    break;
                case "fip":
                    cover4.setImageResource(R.drawable.fip);
                    break;
                case "francebleu":
                    cover4.setImageResource(R.drawable.francebleu);
                    break;
                case "franceculture":
                    cover4.setImageResource(R.drawable.franceculture);
                    break;
                case "franceinter":
                    cover4.setImageResource(R.drawable.franceinter);
                    break;
                case "franceinfo":
                    cover4.setImageResource(R.drawable.franceinfo);
                    break;
                case "fun":
                    cover4.setImageResource(R.drawable.fun);
                    break;
                case "hit":
                    cover4.setImageResource(R.drawable.hitradio);
                    break;
                case "jazz":
                    cover4.setImageResource(R.drawable.jazzradio);
                    break;
                case "mouv":
                    cover4.setImageResource(R.drawable.mouv);
                    break;
                case "mradio":
                    cover4.setImageResource(R.drawable.mradio);
                    break;
                case "nova":
                    cover4.setImageResource(R.drawable.nova);
                    break;
                case "nrj":
                    cover4.setImageResource(R.drawable.nrj);
                    break;
                case "ouifm":
                    cover4.setImageResource(R.drawable.ouifm);
                    break;
                case "premiere":
                    cover4.setImageResource(R.drawable.lapremiere);
                    break;
                case "rfm":
                    cover4.setImageResource(R.drawable.rfm);
                    break;
                case "rire":
                    cover4.setImageResource(R.drawable.rireetchanson);
                    break;
                case "rmc":
                    cover4.setImageResource(R.drawable.rmc);
                    break;
                case "rtl":
                    cover4.setImageResource(R.drawable.rtl);
                    break;
                case "skyrock":
                    cover4.setImageResource(R.drawable.skyrock);
                    break;
                case "sud":
                    cover4.setImageResource(R.drawable.sudradio);
                    break;
                case "virgin":
                    cover4.setImageResource(R.drawable.virgin);
                    break;
                case "nostalgie":
                    cover4.setImageResource(R.drawable.nostalgie);
                    break;
            }
        } else {
            cover4.setVisibility(View.GONE);
            delete4.setVisibility(View.GONE);
            plus4.setVisibility(View.VISIBLE);
        }

        if (!f5.equals("null")){

            cover5.setVisibility(View.VISIBLE);
            delete5.setVisibility(View.VISIBLE);
            plus5.setVisibility(View.GONE);

            switch (f5) {
                case "alouette":
                    cover5.setImageResource(R.drawable.alouette);
                    break;
                case "beur":
                    cover5.setImageResource(R.drawable.beurfm);
                    break;
                case "bfm":
                    cover5.setImageResource(R.drawable.bfm);
                    break;
                case "cheriefm":
                    cover5.setImageResource(R.drawable.cheriefm);
                    break;
                case "classique":
                    cover5.setImageResource(R.drawable.radioclassique);
                    break;
                case "europe1":
                    cover5.setImageResource(R.drawable.europe);
                    break;
                case "fg":
                    cover5.setImageResource(R.drawable.fgradio);
                    break;
                case "fip":
                    cover5.setImageResource(R.drawable.fip);
                    break;
                case "francebleu":
                    cover5.setImageResource(R.drawable.francebleu);
                    break;
                case "franceculture":
                    cover5.setImageResource(R.drawable.franceculture);
                    break;
                case "franceinter":
                    cover5.setImageResource(R.drawable.franceinter);
                    break;
                case "franceinfo":
                    cover5.setImageResource(R.drawable.franceinfo);
                    break;
                case "fun":
                    cover5.setImageResource(R.drawable.fun);
                    break;
                case "hit":
                    cover5.setImageResource(R.drawable.hitradio);
                    break;
                case "jazz":
                    cover5.setImageResource(R.drawable.jazzradio);
                    break;
                case "mouv":
                    cover5.setImageResource(R.drawable.mouv);
                    break;
                case "mradio":
                    cover5.setImageResource(R.drawable.mradio);
                    break;
                case "nova":
                    cover5.setImageResource(R.drawable.nova);
                    break;
                case "nrj":
                    cover5.setImageResource(R.drawable.nrj);
                    break;
                case "ouifm":
                    cover5.setImageResource(R.drawable.ouifm);
                    break;
                case "premiere":
                    cover5.setImageResource(R.drawable.lapremiere);
                    break;
                case "rfm":
                    cover5.setImageResource(R.drawable.rfm);
                    break;
                case "rire":
                    cover5.setImageResource(R.drawable.rireetchanson);
                    break;
                case "rmc":
                    cover5.setImageResource(R.drawable.rmc);
                    break;
                case "rtl":
                    cover5.setImageResource(R.drawable.rtl);
                    break;
                case "skyrock":
                    cover5.setImageResource(R.drawable.skyrock);
                    break;
                case "sud":
                    cover5.setImageResource(R.drawable.sudradio);
                    break;
                case "virgin":
                    cover5.setImageResource(R.drawable.virgin);
                    break;
                case "nostalgie":
                    cover5.setImageResource(R.drawable.nostalgie);
                    break;
            }
        } else {
            cover5.setVisibility(View.GONE);
            delete5.setVisibility(View.GONE);
            plus5.setVisibility(View.VISIBLE);
        }
        
        

    }

    private void getRandom() {
        final int min = 1;
        final int max = 29;
        final int random = new Random().nextInt((max - min) + 1) + min;

        Intent intent = new Intent(AppMenu_Activity.this, Player_Activity.class);
        switch (random) {
            case 1:
                intent.putExtra("string", getResources().getString(R.string.nostalgie));
                startActivity(intent);
                break;
            case 2:
                intent.putExtra("string", getResources().getString(R.string.alouette));
                startActivity(intent);
                break;
            case 3:
                intent.putExtra("string", getResources().getString(R.string.beur));
                startActivity(intent);
                break;
            case 4:
                intent.putExtra("string", getResources().getString(R.string.bfm));
                startActivity(intent);
                break;
            case 5:
                intent.putExtra("string", getResources().getString(R.string.cheriefm));
                startActivity(intent);
                break;
            case 6:
                intent.putExtra("string", getResources().getString(R.string.classique));
                startActivity(intent);
                break;
            case 7:
                intent.putExtra("string", getResources().getString(R.string.europe1));
                startActivity(intent);
                break;
            case 8:
                intent.putExtra("string", getResources().getString(R.string.fg));
                startActivity(intent);
                break;
            case 9:
                intent.putExtra("string", getResources().getString(R.string.fip));
                startActivity(intent);
                break;
            case 10:
                intent.putExtra("string", getResources().getString(R.string.francebleu));
                startActivity(intent);
                break;
            case 11:
                intent.putExtra("string", getResources().getString(R.string.franceculture));
                startActivity(intent);
                break;
            case 12:
                intent.putExtra("string", getResources().getString(R.string.franceinter));
                startActivity(intent);
                break;
            case 13:
                intent.putExtra("string", getResources().getString(R.string.franceinfo));
                startActivity(intent);
                break;
            case 14:
                intent.putExtra("string", getResources().getString(R.string.rtl));
                startActivity(intent);
                break;
            case 15:
                intent.putExtra("string", getResources().getString(R.string.hit));
                startActivity(intent);
                break;
            case 16:
                intent.putExtra("string", getResources().getString(R.string.jazz));
                startActivity(intent);
                break;
            case 17:
                intent.putExtra("string", getResources().getString(R.string.mouv));
                startActivity(intent);
                break;
            case 18:
                intent.putExtra("string", getResources().getString(R.string.mradio));
                startActivity(intent);
                break;
            case 19:
                intent.putExtra("string", getResources().getString(R.string.nova));
                startActivity(intent);
                break;
            case 20:
                intent.putExtra("string", getResources().getString(R.string.nrj));
                startActivity(intent);
                break;
            case 21:
                intent.putExtra("string", getResources().getString(R.string.ouifm));
                startActivity(intent);
                break;
            case 22:
                intent.putExtra("string", getResources().getString(R.string.premiere));
                startActivity(intent);
                break;
            case 23:
                intent.putExtra("string", getResources().getString(R.string.rfm));
                startActivity(intent);
                break;
            case 24:
                intent.putExtra("string", getResources().getString(R.string.rire));
                startActivity(intent);
                break;
            case 25:
                intent.putExtra("string", getResources().getString(R.string.rmc));
                startActivity(intent);
                break;
            case 26:
                intent.putExtra("string", getResources().getString(R.string.rtl));
                startActivity(intent);
                break;
            case 27:
                intent.putExtra("string", getResources().getString(R.string.skyrock));
                startActivity(intent);
                break;
            case 28:
                intent.putExtra("string", getResources().getString(R.string.sud));
                startActivity(intent);
                break;
            case 29:
                intent.putExtra("string", getResources().getString(R.string.virgin));
                startActivity(intent);
                break;
        }
    }
}