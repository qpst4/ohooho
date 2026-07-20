package defpackage;

import android.media.AudioManager;
import android.view.KeyEvent;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class pk0 extends g1 {
    public static final l3 k = new l3(pk0.class, R.string.action_category_media, R.string.action_value_media_pause, R.string.action_title_media_pause, R.string.action_detail_media_pause, R.drawable.icon_action_media_pause, 511, 0, Boolean.FALSE, null, null);

    @Override // defpackage.g1
    public final void g() {
        AudioManager audioManager = (AudioManager) App.c.getSystemService("audio");
        audioManager.dispatchMediaKeyEvent(new KeyEvent(0, 127));
        audioManager.dispatchMediaKeyEvent(new KeyEvent(1, 127));
    }
}
