package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nm extends hf0 implements k40 {
    public final /* synthetic */ int c;
    public final /* synthetic */ pm d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ nm(pm pmVar, int i) {
        super(0);
        this.c = i;
        this.d = pmVar;
    }

    @Override // defpackage.k40
    public final Object a() {
        int i = this.c;
        pm pmVar = this.d;
        switch (i) {
            case 0:
                pmVar.reportFullyDrawn();
                return ow0.h;
            case 1:
                return new j40(pmVar.g, new nm(pmVar, 0));
            default:
                a aVar = new a(new dm(pmVar, 1));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (fc0.b(Looper.myLooper(), Looper.getMainLooper())) {
                        pmVar.b.a(new hm(aVar, pmVar));
                    } else {
                        new Handler(Looper.getMainLooper()).post(new k2(pmVar, 9, aVar));
                    }
                }
                return aVar;
        }
    }
}
