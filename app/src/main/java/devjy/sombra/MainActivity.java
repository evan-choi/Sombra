package devjy.sombra;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SoundPool pool;
    int audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pool = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
        audio = pool.load(this, R.raw.ppub, 1);

        View vRipple = findViewById(R.id.v_ripple);
        vRipple.setOnClickListener(v -> click());
    }

    private void click() {
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        float streamVolumeCurrent = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float streamVolumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = streamVolumeCurrent / streamVolumeMax;

        pool.play(audio, volume, volume, 1, 0, 1f);
    }
}
