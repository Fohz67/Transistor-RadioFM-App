package com.katana.transistor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.IOException;

@SuppressLint({"SetTextI18n", "StaticFieldLeak"})
public class Player_Activity extends AppCompatActivity {

    String name, flux, string;
    ImageView cover, play, base, up, down, close;
    TextView title;
    SeekBar volume;

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    Player playerTask = null;

    boolean prepared = false;
    boolean started = false;
    int maxVolume, curVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        cover = findViewById(R.id.i_cover);
        play = findViewById(R.id.play);
        base = findViewById(R.id.i_cover_null);
        title = findViewById(R.id.titleRadio);
        volume = findViewById(R.id.seekBar);
        up = findViewById(R.id.up);
        down = findViewById(R.id.down);
        close = findViewById(R.id.i_close);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        Intent intent = getIntent();
        string = intent.getStringExtra("string");
        name = string.substring(0, string.indexOf("*"));
        flux = string.substring(string.indexOf("*")+1);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        }
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        mediaPlayer = new MediaPlayer();
        playerTask = new Player();

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        playerTask.execute(flux);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        base.setVisibility(View.GONE);
        up.setVisibility(View.GONE);
        down.setVisibility(View.GONE);

        play.setImageResource(R.drawable.refresh);
        play.setEnabled(false);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        volume.setMax(maxVolume);
        volume.setProgress(curVolume);
        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, arg1, 0);
            }
        });

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (started){
                    play.setImageResource(R.drawable.play_outlined);
                    started = false;
                    mediaPlayer.pause();
                } else {
                    play.setImageResource(R.drawable.stop_outlined);
                    started = true;
                    mediaPlayer.start();
                }
            }
        });

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerTask.cancel(true);
                finish();
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upRadio();
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downRadio();
            }
        });

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        new CountDownTimer(100000000, 10) {
            public void onTick(long millisUntilFinished) {
                maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                volume.setMax(maxVolume);
                volume.setProgress(curVolume);
            }

            public void onFinish() {
            }
        }.start();

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        getRadio();

        //----------------------------------------------------------------------------------------------------------------------------------------------------
    }

    private void upRadio() {
        switch (name) {
            case "nostalgie":
                cover.setImageResource(R.drawable.alouette);
                title.setText("Alouette");
                string = getResources().getString(R.string.alouette);
                break;
            case "alouette":
                cover.setImageResource(R.drawable.beurfm);
                title.setText("Beur");
                string = getResources().getString(R.string.beur);
                break;
            case "beur":
                cover.setImageResource(R.drawable.bfm);
                title.setText("BFM");
                string = getResources().getString(R.string.bfm);
                break;
            case "bfm":
                cover.setImageResource(R.drawable.cheriefm);
                title.setText("Chérie FM");
                string = getResources().getString(R.string.cheriefm);
                break;
            case "cheriefm":
                cover.setImageResource(R.drawable.radioclassique);
                title.setText("Radio Classique");
                string = getResources().getString(R.string.classique);
                break;
            case "classique":
                cover.setImageResource(R.drawable.europe);
                title.setText("Europe 1");
                string = getResources().getString(R.string.europe1);
                break;
            case "europe1":
                cover.setImageResource(R.drawable.fgradio);
                title.setText("FG.");
                string = getResources().getString(R.string.fg);
                break;
            case "fg":
                cover.setImageResource(R.drawable.fip);
                title.setText("FIP");
                string = getResources().getString(R.string.fip);
                break;
            case "fip":
                cover.setImageResource(R.drawable.francebleu);
                title.setText("France Bleu");
                string = getResources().getString(R.string.francebleu);
                break;
            case "francebleu":
                cover.setImageResource(R.drawable.franceculture);
                title.setText("France Culture");
                string = getResources().getString(R.string.franceculture);
                break;
            case "franceculture":
                cover.setImageResource(R.drawable.franceinter);
                title.setText("France Inter");
                string = getResources().getString(R.string.franceinter);
                break;
            case "franceinter":
                cover.setImageResource(R.drawable.franceinfo);
                title.setText("France Info");
                string = getResources().getString(R.string.franceinfo);
                break;
            case "franceinfo":
                cover.setImageResource(R.drawable.fun);
                title.setText("Fun Radio");
                string = getResources().getString(R.string.fun);
                break;
            case "fun":
                cover.setImageResource(R.drawable.hitradio);
                title.setText("Hit FM");
                string = getResources().getString(R.string.hit);
                break;
            case "hit":
                cover.setImageResource(R.drawable.jazzradio);
                title.setText("Jazz Radio");
                string = getResources().getString(R.string.jazz);
                break;
            case "jazz":
                cover.setImageResource(R.drawable.mouv);
                title.setText("Mouv'");
                string = getResources().getString(R.string.mouv);
                break;
            case "mouv":
                cover.setImageResource(R.drawable.mradio);
                title.setText("MRadio");
                string = getResources().getString(R.string.mradio);
                break;
            case "mradio":
                cover.setImageResource(R.drawable.nova);
                title.setText("NOVA");
                string = getResources().getString(R.string.nova);
                break;
            case "nova":
                cover.setImageResource(R.drawable.nrj);
                title.setText("NRJ");
                string = getResources().getString(R.string.nrj);
                break;
            case "nrj":
                cover.setImageResource(R.drawable.ouifm);
                title.setText("Oüi FM");
                string = getResources().getString(R.string.ouifm);
                break;
            case "ouifm":
                cover.setImageResource(R.drawable.lapremiere);
                title.setText("La Première");
                string = getResources().getString(R.string.premiere);
                break;
            case "premiere":
                cover.setImageResource(R.drawable.rfm);
                title.setText("RFM");
                string = getResources().getString(R.string.rfm);
                break;
            case "rfm":
                cover.setImageResource(R.drawable.rireetchanson);
                title.setText("Rire et chansons");
                string = getResources().getString(R.string.rire);
                break;
            case "rire":
                cover.setImageResource(R.drawable.rmc);
                title.setText("Rmc");
                string = getResources().getString(R.string.rmc);
                break;
            case "rmc":
                cover.setImageResource(R.drawable.rtl);
                title.setText("RTL");
                string = getResources().getString(R.string.rtl);
                break;
            case "rtl":
                cover.setImageResource(R.drawable.skyrock);
                title.setText("Skyrock");
                string = getResources().getString(R.string.skyrock);
                break;
            case "skyrock":
                cover.setImageResource(R.drawable.sudradio);
                title.setText("Sud Radio");
                string = getResources().getString(R.string.sud);
                break;
            case "sud":
                cover.setImageResource(R.drawable.virgin);
                title.setText("Virgin Radio");
                string = getResources().getString(R.string.virgin);
                break;
            case "virgin":
                cover.setImageResource(R.drawable.nostalgie);
                title.setText("Nostalgie");
                string = getResources().getString(R.string.nostalgie);
                break;
        }

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        name = string.substring(0, string.indexOf("*"));
        flux = string.substring(string.indexOf("*")+1);

        if (mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.reset();
            prepared = false;
            started = false;
        }

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        base.setVisibility(View.GONE);
        play.setImageResource(R.drawable.refresh);
        play.setEnabled(false);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        mediaPlayer = new MediaPlayer();
        playerTask = new Player();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        playerTask.execute(flux);

    }
    private void downRadio() {
        switch (name) {
            case "beur":
                cover.setImageResource(R.drawable.alouette);
                title.setText("Alouette");
                string = getResources().getString(R.string.alouette);
                break;
            case "bfm":
                cover.setImageResource(R.drawable.beurfm);
                title.setText("Beur");
                string = getResources().getString(R.string.beur);
                break;
            case "cheriefm":
                cover.setImageResource(R.drawable.bfm);
                title.setText("BFM");
                string = getResources().getString(R.string.bfm);
                break;
            case "classique":
                cover.setImageResource(R.drawable.cheriefm);
                title.setText("Chérie FM");
                string = getResources().getString(R.string.cheriefm);
                break;
            case "europe1":
                cover.setImageResource(R.drawable.radioclassique);
                title.setText("Radio Classique");
                string = getResources().getString(R.string.classique);
                break;
            case "fg":
                cover.setImageResource(R.drawable.europe);
                title.setText("Europe 1");
                string = getResources().getString(R.string.europe1);
                break;
            case "fip":
                cover.setImageResource(R.drawable.fgradio);
                title.setText("FG.");
                string = getResources().getString(R.string.fg);
                break;
            case "francebleu":
                cover.setImageResource(R.drawable.fip);
                title.setText("FIP");
                string = getResources().getString(R.string.fip);
                break;
            case "franceculture":
                cover.setImageResource(R.drawable.francebleu);
                title.setText("France Bleu");
                string = getResources().getString(R.string.francebleu);
                break;
            case "franceinter":
                cover.setImageResource(R.drawable.franceculture);
                title.setText("France Culture");
                string = getResources().getString(R.string.franceculture);
                break;
            case "franceinfo":
                cover.setImageResource(R.drawable.franceinter);
                title.setText("France Inter");
                string = getResources().getString(R.string.franceinter);
                break;
            case "fun":
                cover.setImageResource(R.drawable.franceinfo);
                title.setText("France Info");
                string = getResources().getString(R.string.franceinfo);
                break;
            case "hit":
                cover.setImageResource(R.drawable.fun);
                title.setText("Fun Radio");
                string = getResources().getString(R.string.fun);
                break;
            case "jazz":
                cover.setImageResource(R.drawable.hitradio);
                title.setText("Hit FM");
                string = getResources().getString(R.string.hit);
                break;
            case "mouv":
                cover.setImageResource(R.drawable.jazzradio);
                title.setText("Jazz Radio");
                string = getResources().getString(R.string.jazz);
                break;
            case "mradio":
                cover.setImageResource(R.drawable.mouv);
                title.setText("Mouv'");
                string = getResources().getString(R.string.mouv);
                break;
            case "nova":
                cover.setImageResource(R.drawable.mradio);
                title.setText("MRadio");
                string = getResources().getString(R.string.mradio);
                break;
            case "nrj":
                cover.setImageResource(R.drawable.nova);
                title.setText("NOVA");
                string = getResources().getString(R.string.nova);
                break;
            case "ouifm":
                cover.setImageResource(R.drawable.nrj);
                title.setText("NRJ");
                string = getResources().getString(R.string.nrj);
                break;
            case "premiere":
                cover.setImageResource(R.drawable.ouifm);
                title.setText("Oüi FM");
                string = getResources().getString(R.string.ouifm);
                break;
            case "rfm":
                cover.setImageResource(R.drawable.lapremiere);
                title.setText("La Première");
                string = getResources().getString(R.string.premiere);
                break;
            case "rire":
                cover.setImageResource(R.drawable.rfm);
                title.setText("RFM");
                string = getResources().getString(R.string.rfm);
                break;
            case "rmc":
                cover.setImageResource(R.drawable.rireetchanson);
                title.setText("Rire et chansons");
                string = getResources().getString(R.string.rire);
                break;
            case "rtl":
                cover.setImageResource(R.drawable.rmc);
                title.setText("Rmc");
                string = getResources().getString(R.string.rmc);
                break;
            case "skyrock":
                cover.setImageResource(R.drawable.rtl);
                title.setText("RTL");
                string = getResources().getString(R.string.rtl);
                break;
            case "sud":
                cover.setImageResource(R.drawable.skyrock);
                title.setText("Skyrock");
                string = getResources().getString(R.string.skyrock);
                break;
            case "virgin":
                cover.setImageResource(R.drawable.sudradio);
                title.setText("Sud Radio");
                string = getResources().getString(R.string.sud);
                break;
            case "nostalgie":
                cover.setImageResource(R.drawable.virgin);
                title.setText("Virgin Radio");
                string = getResources().getString(R.string.virgin);
                break;
            case "alouette":
                cover.setImageResource(R.drawable.nostalgie);
                title.setText("Nostalgie");
                string = getResources().getString(R.string.nostalgie);
                break;
        }

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        name = string.substring(0, string.indexOf("*"));
        flux = string.substring(string.indexOf("*")+1);

        if (mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.reset();
            prepared = false;
            started = false;
        }

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        base.setVisibility(View.GONE);
        play.setImageResource(R.drawable.refresh);
        play.setEnabled(false);

        //----------------------------------------------------------------------------------------------------------------------------------------------------

        mediaPlayer = new MediaPlayer();
        playerTask = new Player();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        playerTask.execute(flux);

    }
    private void getRadio() {
        switch (name) {
            case "alouette":
                cover.setImageResource(R.drawable.alouette);
                title.setText("Alouette");
                break;
            case "beur":
                cover.setImageResource(R.drawable.beurfm);
                title.setText("Beur");
                break;
            case "bfm":
                cover.setImageResource(R.drawable.bfm);
                title.setText("BFM");
                break;
            case "cheriefm":
                cover.setImageResource(R.drawable.cheriefm);
                title.setText("Chérie FM");
                break;
            case "classique":
                cover.setImageResource(R.drawable.radioclassique);
                title.setText("Radio Classique");
                break;
            case "europe1":
                cover.setImageResource(R.drawable.europe);
                title.setText("Europe 1");
                break;
            case "fg":
                cover.setImageResource(R.drawable.fgradio);
                title.setText("FG.");
                break;
            case "fip":
                cover.setImageResource(R.drawable.fip);
                title.setText("FIP");
                break;
            case "francebleu":
                cover.setImageResource(R.drawable.francebleu);
                title.setText("France Bleu");
                break;
            case "franceculture":
                cover.setImageResource(R.drawable.franceculture);
                title.setText("France Culture");
                break;
            case "franceinter":
                cover.setImageResource(R.drawable.franceinter);
                title.setText("France Inter");
                break;
            case "franceinfo":
                cover.setImageResource(R.drawable.franceinfo);
                title.setText("France Info");
                break;
            case "fun":
                cover.setImageResource(R.drawable.fun);
                title.setText("Fun Radio");
                break;
            case "hit":
                cover.setImageResource(R.drawable.hitradio);
                title.setText("Hit FM");
                break;
            case "jazz":
                cover.setImageResource(R.drawable.jazzradio);
                title.setText("Jazz Radio");
                break;
            case "mouv":
                cover.setImageResource(R.drawable.mouv);
                title.setText("Mouv'");
                break;
            case "mradio":
                cover.setImageResource(R.drawable.mradio);
                title.setText("MRadio");
                break;
            case "nova":
                cover.setImageResource(R.drawable.nova);
                title.setText("NOVA");
                break;
            case "nrj":
                cover.setImageResource(R.drawable.nrj);
                title.setText("NRJ");
                break;
            case "ouifm":
                cover.setImageResource(R.drawable.ouifm);
                title.setText("Oüi FM");
                break;
            case "premiere":
                cover.setImageResource(R.drawable.lapremiere);
                title.setText("La Première");
                break;
            case "rfm":
                cover.setImageResource(R.drawable.rfm);
                title.setText("RFM");
                break;
            case "rire":
                cover.setImageResource(R.drawable.rireetchanson);
                title.setText("Rire et chansons");
                break;
            case "rmc":
                cover.setImageResource(R.drawable.rmc);
                title.setText("Rmc");
                break;
            case "rtl":
                cover.setImageResource(R.drawable.rtl);
                title.setText("RTL");
                break;
            case "skyrock":
                cover.setImageResource(R.drawable.skyrock);
                title.setText("Skyrock");
                break;
            case "sud":
                cover.setImageResource(R.drawable.sudradio);
                title.setText("Sud Radio");
                break;
            case "virgin":
                cover.setImageResource(R.drawable.virgin);
                title.setText("Virgin Radio");
                break;
            case "nostalgie":
                cover.setImageResource(R.drawable.nostalgie);
                title.setText("Nostalgie");
                break;
        }
    }

    class Player extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {

            if (playerTask.isCancelled()){
                mediaPlayer.stop();
                mediaPlayer.reset();
                prepared=false;
                started=false;
            }

            try {
                mediaPlayer.setDataSource(params[0]);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                });
                mediaPlayer.prepare();
                prepared = true;
            } catch (IllegalArgumentException | SecurityException | IllegalStateException | IOException e) {
                prepared = false;

                base.setVisibility(View.VISIBLE);
                cover.setImageResource(R.drawable.png);
                play.setEnabled(false);
                play.setImageResource(R.drawable.exclamation);
                title.setText("Flux indisponible");
                playerTask.cancel(true);
                up.setVisibility(View.VISIBLE);
                down.setVisibility(View.VISIBLE);

                e.printStackTrace();
            }

            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            up.setVisibility(View.VISIBLE);
            down.setVisibility(View.VISIBLE);
            play.setEnabled(true);
            play.setImageResource(R.drawable.play_outlined);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            up.setVisibility(View.GONE);
            down.setVisibility(View.GONE);
            play.setEnabled(false);
            play.setImageResource(R.drawable.refresh);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (started){
            mediaPlayer.pause();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (started){
            mediaPlayer.start();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.reset();
            prepared = false;
            started = false;
        }

        playerTask.cancel(true);
    }
}