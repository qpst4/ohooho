package defpackage;

import android.os.Handler;
import androidx.lifecycle.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dr0 implements gg0 {
    public static final dr0 j = new dr0();
    public int b;
    public int c;
    public Handler f;
    public boolean d = true;
    public boolean e = true;
    public final a g = new a(this);
    public final lk0 h = new lk0(4, this);
    public final tb0 i = new tb0(12, this);

    public final void a() {
        int i = this.c + 1;
        this.c = i;
        if (i == 1) {
            if (this.d) {
                this.g.d(yf0.ON_RESUME);
                this.d = false;
            } else {
                Handler handler = this.f;
                handler.getClass();
                handler.removeCallbacks(this.h);
            }
        }
    }

    @Override // defpackage.gg0
    public final a p() {
        return this.g;
    }
}
