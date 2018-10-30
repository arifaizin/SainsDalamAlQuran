package id.co.imastudio.sainsdalamalquran;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import id.co.imastudio.mengenalprofesi.R;

public class BackSoundService extends Service {
    MediaPlayer player;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        this.player = MediaPlayer.create(this, R.raw.backsound);
        this.player.setLooping(true);
    }

    public void onDestroy() {
        this.player.stop();
        this.player.release();
        stopSelf();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        this.player.start();
        return 2;
    }
}
