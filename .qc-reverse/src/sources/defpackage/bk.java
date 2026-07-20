package defpackage;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bk {
    public final /* synthetic */ int a;
    public long b;
    public Object c;

    public bk(long j) {
        this.a = 1;
        this.c = new Handler();
        this.b = j;
    }

    public void a(Runnable runnable) {
        Handler handler = (Handler) this.c;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(runnable, this.b);
    }

    public void b(int i) {
        if (i < 64) {
            this.b &= ~(1 << i);
            return;
        }
        bk bkVar = (bk) this.c;
        if (bkVar != null) {
            bkVar.b(i - 64);
        }
    }

    public int c(int i) {
        bk bkVar = (bk) this.c;
        if (bkVar == null) {
            long j = this.b;
            return i >= 64 ? Long.bitCount(j) : Long.bitCount(((1 << i) - 1) & j);
        }
        if (i < 64) {
            return Long.bitCount(((1 << i) - 1) & this.b);
        }
        return Long.bitCount(this.b) + bkVar.c(i - 64);
    }

    public void d() {
        if (((bk) this.c) == null) {
            this.c = new bk();
        }
    }

    public boolean e(int i) {
        if (i < 64) {
            return ((1 << i) & this.b) != 0;
        }
        d();
        return ((bk) this.c).e(i - 64);
    }

    public void f(int i, boolean z) {
        if (i >= 64) {
            d();
            ((bk) this.c).f(i - 64, z);
            return;
        }
        long j = this.b;
        boolean z2 = (Long.MIN_VALUE & j) != 0;
        long j2 = (1 << i) - 1;
        this.b = ((j & (~j2)) << 1) | (j & j2);
        if (z) {
            i(i);
        } else {
            b(i);
        }
        if (z2 || ((bk) this.c) != null) {
            d();
            ((bk) this.c).f(0, z2);
        }
    }

    public boolean g(int i) {
        if (i >= 64) {
            d();
            return ((bk) this.c).g(i - 64);
        }
        long j = 1 << i;
        long j2 = this.b;
        boolean z = (j2 & j) != 0;
        long j3 = j2 & (~j);
        this.b = j3;
        long j4 = j - 1;
        this.b = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
        bk bkVar = (bk) this.c;
        if (bkVar != null) {
            if (bkVar.e(0)) {
                i(63);
            }
            ((bk) this.c).g(0);
        }
        return z;
    }

    public void h() {
        this.b = 0L;
        bk bkVar = (bk) this.c;
        if (bkVar != null) {
            bkVar.h();
        }
    }

    public void i(int i) {
        if (i < 64) {
            this.b |= 1 << i;
        } else {
            d();
            ((bk) this.c).i(i - 64);
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                if (((bk) this.c) == null) {
                    return Long.toBinaryString(this.b);
                }
                return ((bk) this.c).toString() + "xx" + Long.toBinaryString(this.b);
            default:
                return super.toString();
        }
    }

    public bk() {
        this.a = 0;
        this.b = 0L;
    }
}
