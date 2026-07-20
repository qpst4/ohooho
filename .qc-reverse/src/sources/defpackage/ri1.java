package defpackage;

import android.os.Build;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ri1 {
    public static final wi1 b;
    public final wi1 a;

    static {
        int i = Build.VERSION.SDK_INT;
        b = (i >= 34 ? new ii1() : i >= 31 ? new hi1() : i >= 30 ? new gi1() : i >= 29 ? new fi1() : new di1()).b().a.a().a.b().a.c();
    }

    public ri1(wi1 wi1Var) {
        this.a = wi1Var;
    }

    public wi1 a() {
        return this.a;
    }

    public wi1 b() {
        return this.a;
    }

    public wi1 c() {
        return this.a;
    }

    public ku e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ri1)) {
            return false;
        }
        ri1 ri1Var = (ri1) obj;
        return n() == ri1Var.n() && m() == ri1Var.m() && Objects.equals(j(), ri1Var.j()) && Objects.equals(h(), ri1Var.h()) && Objects.equals(e(), ri1Var.e());
    }

    public xb0 f(int i) {
        return xb0.e;
    }

    public xb0 g() {
        return j();
    }

    public xb0 h() {
        return xb0.e;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
    }

    public xb0 i() {
        return j();
    }

    public xb0 j() {
        return xb0.e;
    }

    public xb0 k() {
        return j();
    }

    public wi1 l(int i, int i2, int i3, int i4) {
        return b;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public void d(View view) {
    }

    public void o(xb0[] xb0VarArr) {
    }

    public void p(wi1 wi1Var) {
    }

    public void q(xb0 xb0Var) {
    }

    public void r(int i) {
    }
}
