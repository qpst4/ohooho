package defpackage;

import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.SeekBarPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sy0 implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ SeekBarPreference b;

    public sy0(SeekBarPreference seekBarPreference) {
        this.b = seekBarPreference;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        SeekBarPreference seekBarPreference = this.b;
        if (z && (seekBarPreference.X || !seekBarPreference.S)) {
            seekBarPreference.K(seekBar);
            return;
        }
        int i2 = i + seekBarPreference.P;
        TextView textView = seekBarPreference.U;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.b.S = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        SeekBarPreference seekBarPreference = this.b;
        seekBarPreference.S = false;
        if (seekBar.getProgress() + seekBarPreference.P != seekBarPreference.O) {
            seekBarPreference.K(seekBar);
        }
    }
}
