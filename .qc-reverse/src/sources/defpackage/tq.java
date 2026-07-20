package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tq {
    public int a;
    public int b;
    public int c;
    public Object d;
    public Object e;
    public Object f;

    public void a() {
        this.a = 1;
        this.e = (wl0) this.d;
        this.c = 0;
    }

    public boolean b() {
        ul0 ul0VarB = ((wl0) this.e).b.b();
        int iA = ul0VarB.a(6);
        return !(iA == 0 || ((ByteBuffer) ul0VarB.d).get(iA + ul0VarB.a) == 0) || this.b == 65039;
    }
}
