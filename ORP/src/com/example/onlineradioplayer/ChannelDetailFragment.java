package com.example.onlineradioplayer;

import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.onlineradioplayer.models.RadioContent;

/**
 * A fragment representing a single Channel detail screen.
 * This fragment is either contained in a {@link ChannelListActivity}
 * in two-pane mode (on tablets) or a {@link ChannelDetailActivity}
 * on handsets.
 */
public class ChannelDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    private MediaPlayer player;
    
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The Radio content this fragment is presenting.
     */
    private RadioContent.RadioItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ChannelDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the Radio content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = RadioContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
        
        initializeMediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_channel_detail, container, false);
        TextView txvTitle = (TextView) rootView.findViewById(R.id.channel_detail);
        // Show the Radio content as text in a TextView.
        if (mItem != null) {
            txvTitle.setText(mItem.URL);
        }

        return rootView;
    }

    private void startPlaying() {
        //buttonStopPlay.setEnabled(true);
        //buttonPlay.setEnabled(false);

        //playSeekBar.setVisibility(View.VISIBLE);

        player.prepareAsync();

        player.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
                player.start();
            }
        });

    }

    private void initializeMediaPlayer() {
        if(player!=null && player.isPlaying()){
        	player.stop();
        	player.release();
        }
        player = new MediaPlayer();
        try {
            player.setDataSource(mItem.URL);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        player.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {

            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                //playSeekBar.setSecondaryProgress(percent);
                Log.i("Buffering", "" + percent);
            }
        });
        startPlaying();
    }

    @Override
	public void onPause() {
        super.onPause();
        if (player.isPlaying()) {
            player.stop();
            player.release();
        }
    }
}
