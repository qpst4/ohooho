package defpackage;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class oq implements Runnable {
    public final WeakReference b;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final long d = System.currentTimeMillis();
    public final long c = 200;

    public oq(pq pqVar, float f, float f2, float f3, float f4) {
        this.b = new WeakReference(pqVar);
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        pq pqVar = (pq) this.b.get();
        if (pqVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.d;
        long j = this.c;
        float fMin = Math.min(j, jCurrentTimeMillis);
        float f = j;
        float f2 = yb0.f(fMin, this.f, f);
        if (fMin >= f) {
            pqVar.setImageToWrapCropBounds(true);
        } else {
            pqVar.i(this.e + f2, this.g, this.h);
            pqVar.post(this);
        }
    }
}
