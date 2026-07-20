package defpackage;

import android.content.DialogInterface;
import com.rarepebble.colorpicker.ColorPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sl implements DialogInterface.OnClickListener {
    public final /* synthetic */ rl b;
    public final /* synthetic */ ColorPreference c;

    public sl(ColorPreference colorPreference, rl rlVar) {
        this.c = colorPreference;
        this.b = rlVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int color = this.b.getColor();
        Integer numValueOf = Integer.valueOf(color);
        ColorPreference colorPreference = this.c;
        if (colorPreference.a(numValueOf)) {
            colorPreference.L(Integer.valueOf(color));
        }
    }
}
