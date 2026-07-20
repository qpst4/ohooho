package defpackage;

import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jh extends ContentObserver {
    public final /* synthetic */ kh a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jh(kh khVar, Handler handler) {
        super(handler);
        this.a = khVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        kh khVar = this.a;
        int i = Settings.System.getInt(khVar.t().getContentResolver(), "screen_brightness", 0);
        if (i < khVar.s0) {
            khVar.s0 = i;
            khVar.q0.setText(khVar.s0 + "");
        }
        if (i > khVar.t0) {
            khVar.t0 = i;
            khVar.r0.setText(khVar.t0 + "");
        }
    }
}
