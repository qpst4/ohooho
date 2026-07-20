package defpackage;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.preference.SeekBarPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ty0 implements View.OnKeyListener {
    public final /* synthetic */ SeekBarPreference b;

    public ty0(SeekBarPreference seekBarPreference) {
        this.b = seekBarPreference;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            SeekBarPreference seekBarPreference = this.b;
            if ((seekBarPreference.V || (i != 21 && i != 22)) && i != 23 && i != 66) {
                SeekBar seekBar = seekBarPreference.T;
                if (seekBar != null) {
                    return seekBar.onKeyDown(i, keyEvent);
                }
                Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
        }
        return false;
    }
}
