package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gw0 {
    public mv0 a;
    public vr0 b;
    public String d;
    public s70 e;
    public kt0 g;
    public hw0 h;
    public hw0 i;
    public hw0 j;
    public long k;
    public long l;
    public int c = -1;
    public jj f = new jj(1);

    public static void b(String str, hw0 hw0Var) {
        if (hw0Var.h != null) {
            zy.n(str.concat(".body != null"));
            return;
        }
        if (hw0Var.i != null) {
            zy.n(str.concat(".networkResponse != null"));
        } else if (hw0Var.j != null) {
            zy.n(str.concat(".cacheResponse != null"));
        } else {
            if (hw0Var.k == null) {
                return;
            }
            zy.n(str.concat(".priorResponse != null"));
        }
    }

    public final hw0 a() {
        if (this.a == null) {
            s1.f("request == null");
            return null;
        }
        if (this.b == null) {
            s1.f("protocol == null");
            return null;
        }
        if (this.c < 0) {
            zy.g("code < 0: ", this.c);
            return null;
        }
        if (this.d != null) {
            return new hw0(this);
        }
        s1.f("message == null");
        return null;
    }
}
