package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w01 implements d11, iw0, sh {
    public v01 b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final boolean h;
    public final boolean i;
    public String[] j;
    public final int k;
    public final int l;
    public final View.OnClickListener m;

    public w01(u01 u01Var) {
        this.l = 0;
        this.m = null;
        int i = u01Var.b;
        int i2 = u01Var.c;
        int i3 = u01Var.d;
        int i4 = u01Var.a;
        int i5 = u01Var.e;
        Bundle bundle = new Bundle();
        bundle.putLong("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_ID", 0L);
        bundle.putCharSequence("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_TITLE", null);
        bundle.putInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_TITLE_RES", i);
        bundle.putCharSequence("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_DESCRIPTION", null);
        bundle.putInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_DESCRIPTION_RES", i2);
        bundle.putInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_IMAGE_RES", i3);
        bundle.putInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_BACKGROUND_RES", i4);
        bundle.putInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_LAYOUT_RES", i5);
        bundle.putInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_PERMISSIONS_REQUEST_CODE", 34);
        v01 v01Var = new v01();
        v01Var.c0(bundle);
        this.b = v01Var;
        this.c = u01Var.b;
        this.d = u01Var.c;
        this.e = u01Var.d;
        this.f = u01Var.e;
        this.g = u01Var.a;
        this.h = u01Var.f;
        this.i = u01Var.g;
        this.j = null;
        this.k = 34;
        this.l = u01Var.h;
        this.m = u01Var.i;
        j();
    }

    @Override // defpackage.d11
    public final int a() {
        return this.g;
    }

    @Override // defpackage.d11
    public final j30 b() {
        return this.b;
    }

    @Override // defpackage.sh
    public final int c() {
        j();
        if (this.j == null) {
            return this.l;
        }
        return 0;
    }

    @Override // defpackage.d11
    public final int d() {
        return 0;
    }

    @Override // defpackage.d11
    public final boolean e() {
        j();
        return this.h && this.j == null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w01.class != obj.getClass()) {
            return false;
        }
        w01 w01Var = (w01) obj;
        if (this.c != w01Var.c || this.d != w01Var.d || this.e != w01Var.e || this.f != w01Var.f || this.g != w01Var.g || this.h != w01Var.h || this.i != w01Var.i || this.k != w01Var.k || this.l != w01Var.l) {
            return false;
        }
        v01 v01Var = this.b;
        v01 v01Var2 = w01Var.b;
        if (v01Var != null) {
            if (v01Var != v01Var2) {
                return false;
            }
        } else if (v01Var2 != null) {
            return false;
        }
        if (!Arrays.equals(this.j, w01Var.j)) {
            return false;
        }
        View.OnClickListener onClickListener = w01Var.m;
        View.OnClickListener onClickListener2 = this.m;
        return onClickListener2 != null ? onClickListener2.equals(onClickListener) : onClickListener == null;
    }

    @Override // defpackage.sh
    public final CharSequence f() {
        Context contextU;
        j();
        if (this.j == null || (contextU = this.b.u()) == null) {
            return null;
        }
        return contextU.getResources().getQuantityText(R.plurals.mi_label_grant_permission, this.j.length);
    }

    @Override // defpackage.iw0
    public final void g(j30 j30Var) {
        if (j30Var instanceof v01) {
            this.b = (v01) j30Var;
        }
    }

    @Override // defpackage.d11
    public final boolean h() {
        return this.i;
    }

    public final int hashCode() {
        v01 v01Var = this.b;
        Long l = 0L;
        int iHashCode = (((((((((((((((((((((l.hashCode() + ((v01Var != null ? v01Var.hashCode() : 0) * 31)) * 961) + this.c) * 961) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 961) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + Arrays.hashCode(this.j)) * 31) + this.k) * 961) + this.l) * 31;
        View.OnClickListener onClickListener = this.m;
        return iHashCode + (onClickListener != null ? onClickListener.hashCode() : 0);
    }

    @Override // defpackage.sh
    public final View.OnClickListener i() {
        j();
        return this.j == null ? this.m : new l1(6, this);
    }

    public final synchronized void j() {
        try {
            if (this.j != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : this.j) {
                    if (this.b.u() == null || xy0.f(this.b.u(), str) != 0) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 0) {
                    this.j = (String[]) arrayList.toArray(new String[arrayList.size()]);
                } else {
                    this.j = null;
                }
            } else {
                this.j = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
