package com.example.onlineradioplayer.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.onlineradioplayer.R;


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class RadioContent {

    /**
     * An array of sample (Radio) items.
     */
    public static List<RadioItem> ITEMS = new ArrayList<RadioItem>();

    /**
     * A map of sample (Radio) items, by ID.
     */
    public static Map<String, RadioItem> ITEM_MAP = new HashMap<String, RadioItem>();

    static {
        // Add 3 sample items.
        addItem(new RadioItem("1", "KisFM","http://streaming.centralonline.net:8000/kisfm",R.drawable.logo_kis));
        addItem(new RadioItem("2", "Global","http://202.147.199.98:8000/;stream.nsv",R.drawable.logo_glo));
        addItem(new RadioItem("3", "Prambors","http://live.masima.co.id:9000/;stream.nsv",R.drawable.logo_pra));
        addItem(new RadioItem("4", "Woman","http://202.182.172.146:8005/;stream.mp3",R.drawable.logo_wom));
        addItem(new RadioItem("5", "Mustang","http://live.indostreamserver.com:8800/mustang",R.drawable.logo_mus));
        addItem(new RadioItem("6", "Elshinta","http://202.137.4.147:8000/;stream.nsv",R.drawable.logo_els));
        addItem(new RadioItem("7", "PasFM Surabaya","http://radio.mitra.net.id:8102/;stream.nsv",R.drawable.logo_pas));
        addItem(new RadioItem("8", "OZ Bali","http://radio.simaya.net.id:1320/;stream.mp3",R.drawable.logo_ozb));
        addItem(new RadioItem("9", "Tu Musica FM","http://192.254.193.215:8007/;stream.mp3",R.drawable.logo_tum));
        addItem(new RadioItem("10", "Love Country USA","http://s6.total-streaming.com:9350/;stream.nsv",R.drawable.logo_loc));
        addItem(new RadioItem("11", "Hit FFH","http://mp3ad.ffh.c.nmdn.net/fs_radioffh/hqlivestream.mp3",R.drawable.logo_ffh));
        addItem(new RadioItem("12", "SKY.FM","http://pub4.sky.fm/sky_smoothjazz",R.drawable.logo_sky));
        addItem(new RadioItem("13", "JamRock One","http://64.251.28.190:9100/stream",R.drawable.logo_jam));
        addItem(new RadioItem("14", "Ez Does It Net","http://mega6.radioserver.co.uk:8164/;stream.nsv",R.drawable.logo_ezn));
        addItem(new RadioItem("15", "Central FM","http://85.17.177.8:8040/stream",R.drawable.logo_cen));
        addItem(new RadioItem("16", "Good Time Oldies","http://relay2.181.fm:8046/;stream.nsv",R.drawable.logo_gto));
        addItem(new RadioItem("17", "HotMix Funky","http://hotmixradio-funky.ice.infomaniak.ch/hotmixradio-funky-128.mp3",R.drawable.logo_hot));
    }

    private static void addItem(RadioItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A Radio item representing a piece of content.
     */
    public static class RadioItem {
        public String id;
        public String title;
        public String URL;
        public int icon;

        public RadioItem(String id, String title, String URL, int icon) {
            this.id = id;
            this.title = title;
            this.URL = URL;
            this.icon = icon;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
