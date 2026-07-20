package defpackage;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ba implements Runnable {
    public final /* synthetic */ int b = 0;
    public final /* synthetic */ int c;
    public final /* synthetic */ View d;
    public final /* synthetic */ Object e;

    public ba(TextView textView, Typeface typeface, int i) {
        this.d = textView;
        this.e = typeface;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = this.c;
        View view = this.d;
        Object obj = this.e;
        switch (i) {
            case 0:
                ((TextView) view).setTypeface((Typeface) obj, i2);
                break;
            default:
                ((BottomSheetBehavior) obj).E(view, i2, false);
                break;
        }
    }

    public ba(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.e = bottomSheetBehavior;
        this.d = view;
        this.c = i;
    }
}
