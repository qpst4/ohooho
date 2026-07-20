package defpackage;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hw0 implements Closeable {
    public final mv0 b;
    public final vr0 c;
    public final int d;
    public final String e;
    public final s70 f;
    public final w70 g;
    public final kt0 h;
    public final hw0 i;
    public final hw0 j;
    public final hw0 k;
    public final long l;
    public final long m;

    public hw0(gw0 gw0Var) {
        this.b = gw0Var.a;
        this.c = gw0Var.b;
        this.d = gw0Var.c;
        this.e = gw0Var.d;
        this.f = gw0Var.e;
        jj jjVar = gw0Var.f;
        jjVar.getClass();
        this.g = new w70(jjVar);
        this.h = gw0Var.g;
        this.i = gw0Var.h;
        this.j = gw0Var.i;
        this.k = gw0Var.j;
        this.l = gw0Var.k;
        this.m = gw0Var.l;
    }

    public final String a(String str) {
        String strA = this.g.a(str);
        if (strA != null) {
            return strA;
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        kt0 kt0Var = this.h;
        if (kt0Var != null) {
            kt0Var.close();
        } else {
            s1.f("response is not eligible for a body and must not be closed");
        }
    }

    public final gw0 g() {
        gw0 gw0Var = new gw0();
        gw0Var.a = this.b;
        gw0Var.b = this.c;
        gw0Var.c = this.d;
        gw0Var.d = this.e;
        gw0Var.e = this.f;
        gw0Var.f = this.g.c();
        gw0Var.g = this.h;
        gw0Var.h = this.i;
        gw0Var.i = this.j;
        gw0Var.j = this.k;
        gw0Var.k = this.l;
        gw0Var.l = this.m;
        return gw0Var;
    }

    public final String toString() {
        return "Response{protocol=" + this.c + ", code=" + this.d + ", message=" + this.e + ", url=" + this.b.a + '}';
    }
}
