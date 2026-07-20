package defpackage;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ah {
    public final /* synthetic */ int a;
    public int b;
    public boolean c;
    public final Runnable d;
    public final /* synthetic */ no e;

    public ah(SideSheetBehavior sideSheetBehavior) {
        this.a = 1;
        this.e = sideSheetBehavior;
        this.d = new lk0(8, this);
    }

    public final void a(int i) {
        int i2 = this.a;
        Runnable runnable = this.d;
        no noVar = this.e;
        switch (i2) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) noVar;
                WeakReference weakReference = bottomSheetBehavior.U;
                if (weakReference != null && weakReference.get() != null) {
                    this.b = i;
                    if (!this.c) {
                        WeakHashMap weakHashMap = uf1.a;
                        ((View) bottomSheetBehavior.U.get()).postOnAnimation((nc) runnable);
                        this.c = true;
                    }
                    break;
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) noVar;
                WeakReference weakReference2 = sideSheetBehavior.p;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.b = i;
                    if (!this.c) {
                        WeakHashMap weakHashMap2 = uf1.a;
                        ((View) sideSheetBehavior.p.get()).postOnAnimation((lk0) runnable);
                        this.c = true;
                    }
                    break;
                }
                break;
        }
    }

    public ah(BottomSheetBehavior bottomSheetBehavior) {
        this.a = 0;
        this.e = bottomSheetBehavior;
        this.d = new nc(1, this);
    }
}
