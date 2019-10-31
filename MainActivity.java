package com.springmay.motionlayoutwithyoutubeplayer;

import android.os.Bundle;

import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import static com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import static com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import static com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import static com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;

import static com.google.android.youtube.player.YouTubePlayer.Provider;

public class MainActivity extends YouTubeBaseActivity implements OnInitializedListener {

    public static final String API_KEY = "AIzaSyCjVucvFDzd0DXJSYcT*********8";

   
    public static final String VIDEO_ID = "XsX3ATc3FbA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // attaching layout xml
        setContentView(R.layout.activity_main);

        // Initializing YouTube player view
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youTubePlayer);
        youTubePlayerView.initialize(API_KEY, this);

    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        if(null== player) return;

        // Start buffering
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }

        // Add listeners to YouTubePlayer instance
        player.setPlayerStateChangeListener(new PlayerStateChangeListener() {
            @Override public void onAdStarted() { }
            @Override public void onError(ErrorReason arg0) { }
            @Override public void onLoaded(String arg0) { }
            @Override public void onLoading() { }
            @Override public void onVideoEnded() { }
            @Override public void onVideoStarted() { }
        });


        player.setPlaybackEventListener(new PlaybackEventListener() {
            @Override public void onBuffering(boolean arg0) { }
            @Override public void onPaused() { }
            @Override public void onPlaying() { }
            @Override public void onSeekTo(int arg0) { }
            @Override public void onStopped() { }
        });
    }

}
