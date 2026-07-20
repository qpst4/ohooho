package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ht0 implements Cloneable {
    public final sn0 b;
    public final mw0 c;
    public final z90 d;
    public c70 e;
    public final mv0 f;
    public boolean g;

    public ht0(sn0 sn0Var, mv0 mv0Var) {
        this.b = sn0Var;
        this.f = mv0Var;
        this.c = new mw0(sn0Var);
        z90 z90Var = new z90(2, this);
        this.d = z90Var;
        z90Var.g(0L);
    }

    public final void a() {
        ca0 ca0Var;
        it0 it0Var;
        mw0 mw0Var = this.c;
        mw0Var.d = true;
        u21 u21Var = mw0Var.b;
        if (u21Var != null) {
            synchronized (u21Var.d) {
                u21Var.m = true;
                ca0Var = u21Var.n;
                it0Var = u21Var.j;
            }
            if (ca0Var != null) {
                ca0Var.cancel();
            } else if (it0Var != null) {
                be1.d(it0Var.d);
            }
        }
    }

    public final hw0 b() {
        synchronized (this) {
            if (this.g) {
                throw new IllegalStateException("Already Executed");
            }
            this.g = true;
        }
        this.c.c = qp0.a.j();
        this.d.i();
        this.e.getClass();
        try {
            try {
                g7 g7Var = this.b.b;
                synchronized (g7Var) {
                    ((ArrayDeque) g7Var.e).add(this);
                }
                return c();
            } catch (IOException e) {
                IOException iOExceptionD = d(e);
                this.e.getClass();
                throw iOExceptionD;
            }
        } finally {
            this.b.b.i(this);
        }
    }

    public final hw0 c() {
        ArrayList arrayList = new ArrayList();
        sn0 sn0Var = this.b;
        arrayList.addAll(sn0Var.e);
        arrayList.add(this.c);
        int i = 0;
        arrayList.add(new ch(i, sn0Var.i));
        arrayList.add(new di(i));
        int i2 = 1;
        arrayList.add(new ch(i2, sn0Var));
        arrayList.addAll(sn0Var.f);
        arrayList.add(new di(i2));
        c70 c70Var = this.e;
        int i3 = sn0Var.v;
        int i4 = sn0Var.w;
        int i5 = sn0Var.x;
        mv0 mv0Var = this.f;
        return new jt0(arrayList, null, null, null, 0, mv0Var, this, c70Var, i3, i4, i5).a(mv0Var, null, null, null);
    }

    public final Object clone() {
        sn0 sn0Var = this.b;
        ht0 ht0Var = new ht0(sn0Var, this.f);
        sn0Var.g.getClass();
        ht0Var.e = c70.g;
        return ht0Var;
    }

    public final IOException d(IOException iOException) {
        if (!this.d.k()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }
}
