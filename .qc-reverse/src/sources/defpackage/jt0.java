package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jt0 {
    public final ArrayList a;
    public final u21 b;
    public final ca0 c;
    public final it0 d;
    public final int e;
    public final mv0 f;
    public final ht0 g;
    public final c70 h;
    public final int i;
    public final int j;
    public final int k;
    public int l;

    public jt0(ArrayList arrayList, u21 u21Var, ca0 ca0Var, it0 it0Var, int i, mv0 mv0Var, ht0 ht0Var, c70 c70Var, int i2, int i3, int i4) {
        this.a = arrayList;
        this.d = it0Var;
        this.b = u21Var;
        this.c = ca0Var;
        this.e = i;
        this.f = mv0Var;
        this.g = ht0Var;
        this.h = c70Var;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    public final hw0 a(mv0 mv0Var, u21 u21Var, ca0 ca0Var, it0 it0Var) {
        mv0 mv0Var2;
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = this.e;
        if (i >= size) {
            throw new AssertionError();
        }
        this.l++;
        ca0 ca0Var2 = this.c;
        if (ca0Var2 != null) {
            mv0Var2 = mv0Var;
            if (!this.d.j(mv0Var2.a)) {
                s1.e(arrayList.get(i - 1), " must retain the same host and port", "network interceptor ");
                return null;
            }
        } else {
            mv0Var2 = mv0Var;
        }
        if (ca0Var2 != null && this.l > 1) {
            s1.e(arrayList.get(i - 1), " must call proceed() exactly once", "network interceptor ");
            return null;
        }
        int i2 = i + 1;
        jt0 jt0Var = new jt0(arrayList, u21Var, ca0Var, it0Var, i2, mv0Var2, this.g, this.h, this.i, this.j, this.k);
        dc0 dc0Var = (dc0) arrayList.get(i);
        hw0 hw0VarA = dc0Var.a(jt0Var);
        if (ca0Var != null && i2 < arrayList.size() && jt0Var.l != 1) {
            zy.e(dc0Var, " must call proceed() exactly once", "network interceptor ");
            return null;
        }
        if (hw0VarA != null) {
            if (hw0VarA.h != null) {
                return hw0VarA;
            }
            zy.e(dc0Var, " returned a response with no body", "interceptor ");
            return null;
        }
        throw new NullPointerException("interceptor " + dc0Var + " returned null");
    }
}
