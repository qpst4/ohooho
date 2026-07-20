package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ew {
    public final long[] a;
    public final long[] b;
    public final long[] c;

    public ew() {
        ew ewVar = fc0.b;
        this.a = Arrays.copyOf(ewVar.a, 10);
        this.b = Arrays.copyOf(ewVar.b, 10);
        this.c = Arrays.copyOf(ewVar.c, 10);
    }

    public final void a(ew ewVar, int i) {
        fc0.i(this.a, ewVar.a, i);
        fc0.i(this.b, ewVar.b, i);
        fc0.i(this.c, ewVar.c, i);
    }

    public ew(long[] jArr, long[] jArr2, long[] jArr3) {
        this.a = jArr;
        this.b = jArr2;
        this.c = jArr3;
    }
}
