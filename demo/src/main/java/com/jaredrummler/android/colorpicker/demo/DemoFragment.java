package com.jaredrummler.android.colorpicker.demo;

import android.os.Bundle;
import android.util.Log;

import androidx.preference.PreferenceFragmentCompat;

import com.jaredrummler.android.colorpicker.ColorPickerPreference;

public class DemoFragment extends PreferenceFragmentCompat {

    private static final String TAG = DemoFragment.class.getSimpleName();

    private static final String KEY_DEFAULT_COLOR = "default_color";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.main, rootKey);

        // Example showing how we can get the new color when it is changed:
        ColorPickerPreference colorPreference = findPreference(KEY_DEFAULT_COLOR);
        assert colorPreference != null;
        colorPreference.setOnPreferenceChangeListener((preference, newValue) -> {
            if (KEY_DEFAULT_COLOR.equals(preference.getKey())) {
                String newDefaultColor = Integer.toHexString((int) newValue);
                Log.d(TAG, "New default color is: #" + newDefaultColor);
            }
            return true;
        });
    }
}
