package defpackage;

import android.graphics.RectF;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nq implements Runnable {
    public final WeakReference b;
    public final long c;
    public final long d = System.currentTimeMillis();
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    public final boolean k;

    public nq(pq pqVar, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
        this.b = new WeakReference(pqVar);
        this.c = j;
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
        this.i = f5;
        this.j = f6;
        this.k = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        pq pqVar = (pq) this.b.get();
        if (pqVar == null) {
            return;
        }
        RectF rectF = pqVar.t;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.d;
        long j = this.c;
        float fMin = Math.min(j, jCurrentTimeMillis);
        float f = j;
        float f2 = (fMin / f) - 1.0f;
        float f3 = (f2 * f2 * f2) + 1.0f;
        float f4 = (this.g * f3) + 0.0f;
        float f5 = (f3 * this.h) + 0.0f;
        float f6 = yb0.f(fMin, this.j, f);
        if (fMin < f) {
            float[] fArr = pqVar.f;
            pqVar.d(f4 - (fArr[0] - this.e), f5 - (fArr[1] - this.f));
            if (!this.k) {
                pqVar.i(this.i + f6, rectF.centerX(), rectF.centerY());
            }
            if (pqVar.g(pqVar.e)) {
                return;
            }
            pqVar.post(this);
        }
    }
}
