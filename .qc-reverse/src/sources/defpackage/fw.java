package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fw {
    public final ra a;
    public final long[] b;

    public fw(int i) {
        switch (i) {
            case 1:
                this.a = new ra();
                this.b = new long[10];
                break;
            default:
                fw fwVar = fc0.c;
                this.a = new ra(fwVar.a);
                this.b = Arrays.copyOf(fwVar.b, 10);
                break;
        }
    }

    public static void a(fw fwVar, fw fwVar2) {
        ra raVar = fwVar.a;
        long[] jArr = (long[]) raVar.c;
        ra raVar2 = fwVar2.a;
        long[] jArr2 = (long[]) raVar2.c;
        long[] jArr3 = fwVar2.b;
        lc1.W(jArr, jArr2, jArr3);
        long[] jArr4 = (long[]) raVar.d;
        long[] jArr5 = (long[]) raVar2.d;
        long[] jArr6 = (long[]) raVar2.e;
        lc1.W(jArr4, jArr5, jArr6);
        lc1.W((long[]) raVar.e, jArr6, jArr3);
        lc1.W(fwVar.b, (long[]) raVar2.c, (long[]) raVar2.d);
    }

    public fw(ra raVar, long[] jArr) {
        this.a = raVar;
        this.b = jArr;
    }
}
