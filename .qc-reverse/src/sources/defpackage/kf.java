package defpackage;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kf implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ kf(int i, int i2, Object obj) {
        this.b = i2;
        this.d = obj;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = this.c;
        Object obj = this.d;
        switch (i) {
            case 0:
                ((rf) obj).b(i2);
                break;
            case 1:
                ((i1) obj).G(i2);
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.p.get();
                if (view != null) {
                    sideSheetBehavior.t(view, i2, false);
                }
                break;
        }
    }
}
