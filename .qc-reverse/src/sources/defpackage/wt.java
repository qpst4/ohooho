package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.b;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class wt extends j30 implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler Y;
    public boolean h0;
    public Dialog j0;
    public boolean k0;
    public boolean l0;
    public boolean m0;
    public final nc Z = new nc(4, this);
    public final tt a0 = new tt(0, this);
    public final ut b0 = new ut(this);
    public int c0 = 0;
    public int d0 = 0;
    public boolean e0 = true;
    public boolean f0 = true;
    public int g0 = -1;
    public final sp1 i0 = new sp1(18, this);
    public boolean n0 = false;

    @Override // defpackage.j30
    public final void G() {
        this.F = true;
    }

    @Override // defpackage.j30
    public final void I(Context context) {
        super.I(context);
        this.S.d(this.i0);
        if (this.m0) {
            return;
        }
        this.l0 = false;
    }

    @Override // defpackage.j30
    public void J(Bundle bundle) {
        super.J(bundle);
        this.Y = new Handler();
        this.f0 = this.y == 0;
        if (bundle != null) {
            this.c0 = bundle.getInt("android:style", 0);
            this.d0 = bundle.getInt("android:theme", 0);
            this.e0 = bundle.getBoolean("android:cancelable", true);
            this.f0 = bundle.getBoolean("android:showsDialog", this.f0);
            this.g0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // defpackage.j30
    public final void M() {
        this.F = true;
        Dialog dialog = this.j0;
        if (dialog != null) {
            this.k0 = true;
            dialog.setOnDismissListener(null);
            this.j0.dismiss();
            if (!this.l0) {
                onDismiss(this.j0);
            }
            this.j0 = null;
            this.n0 = false;
        }
    }

    @Override // defpackage.j30
    public final void N() {
        this.F = true;
        if (!this.m0 && !this.l0) {
            this.l0 = true;
        }
        b bVar = this.S;
        bVar.getClass();
        b.a("removeObserver");
        xh0 xh0Var = (xh0) bVar.b.c(this.i0);
        if (xh0Var == null) {
            return;
        }
        xh0Var.d();
        xh0Var.b(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0044 A[Catch: all -> 0x004c, TryCatch #0 {all -> 0x004c, blocks: (B:12:0x001a, B:14:0x0026, B:24:0x003e, B:26:0x0044, B:29:0x004e, B:20:0x0030, B:22:0x0036, B:23:0x003b, B:30:0x0066), top: B:49:0x001a }] */
    @Override // defpackage.j30
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater O(android.os.Bundle r8) {
        /*
            r7 = this;
            android.view.LayoutInflater r8 = super.O(r8)
            boolean r0 = r7.f0
            java.lang.String r1 = "FragmentManager"
            r2 = 2
            if (r0 == 0) goto L98
            boolean r3 = r7.h0
            if (r3 == 0) goto L11
            goto L98
        L11:
            if (r0 != 0) goto L14
            goto L6f
        L14:
            boolean r0 = r7.n0
            if (r0 != 0) goto L6f
            r0 = 0
            r3 = 1
            r7.h0 = r3     // Catch: java.lang.Throwable -> L4c
            android.app.Dialog r4 = r7.i0()     // Catch: java.lang.Throwable -> L4c
            r7.j0 = r4     // Catch: java.lang.Throwable -> L4c
            boolean r5 = r7.f0     // Catch: java.lang.Throwable -> L4c
            if (r5 == 0) goto L66
            int r5 = r7.c0     // Catch: java.lang.Throwable -> L4c
            if (r5 == r3) goto L3b
            if (r5 == r2) goto L3b
            r6 = 3
            if (r5 == r6) goto L30
            goto L3e
        L30:
            android.view.Window r5 = r4.getWindow()     // Catch: java.lang.Throwable -> L4c
            if (r5 == 0) goto L3b
            r6 = 24
            r5.addFlags(r6)     // Catch: java.lang.Throwable -> L4c
        L3b:
            r4.requestWindowFeature(r3)     // Catch: java.lang.Throwable -> L4c
        L3e:
            android.content.Context r4 = r7.u()     // Catch: java.lang.Throwable -> L4c
            if (r4 == 0) goto L4e
            android.app.Dialog r5 = r7.j0     // Catch: java.lang.Throwable -> L4c
            android.app.Activity r4 = (android.app.Activity) r4     // Catch: java.lang.Throwable -> L4c
            r5.setOwnerActivity(r4)     // Catch: java.lang.Throwable -> L4c
            goto L4e
        L4c:
            r8 = move-exception
            goto L6c
        L4e:
            android.app.Dialog r4 = r7.j0     // Catch: java.lang.Throwable -> L4c
            boolean r5 = r7.e0     // Catch: java.lang.Throwable -> L4c
            r4.setCancelable(r5)     // Catch: java.lang.Throwable -> L4c
            android.app.Dialog r4 = r7.j0     // Catch: java.lang.Throwable -> L4c
            tt r5 = r7.a0     // Catch: java.lang.Throwable -> L4c
            r4.setOnCancelListener(r5)     // Catch: java.lang.Throwable -> L4c
            android.app.Dialog r4 = r7.j0     // Catch: java.lang.Throwable -> L4c
            ut r5 = r7.b0     // Catch: java.lang.Throwable -> L4c
            r4.setOnDismissListener(r5)     // Catch: java.lang.Throwable -> L4c
            r7.n0 = r3     // Catch: java.lang.Throwable -> L4c
            goto L69
        L66:
            r3 = 0
            r7.j0 = r3     // Catch: java.lang.Throwable -> L4c
        L69:
            r7.h0 = r0
            goto L6f
        L6c:
            r7.h0 = r0
            throw r8
        L6f:
            boolean r0 = defpackage.y30.I(r2)
            if (r0 == 0) goto L8b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "get layout inflater for DialogFragment "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r2 = " from dialog context"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L8b:
            android.app.Dialog r7 = r7.j0
            if (r7 == 0) goto Lc3
            android.content.Context r7 = r7.getContext()
            android.view.LayoutInflater r7 = r8.cloneInContext(r7)
            return r7
        L98:
            boolean r0 = defpackage.y30.I(r2)
            if (r0 == 0) goto Lc3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "getting layout inflater for DialogFragment "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r7 = r7.f0
            if (r7 != 0) goto Lba
            java.lang.String r7 = "mShowsDialog = false: "
            java.lang.String r7 = r7.concat(r0)
            android.util.Log.d(r1, r7)
            return r8
        Lba:
            java.lang.String r7 = "mCreatingDialog = true: "
            java.lang.String r7 = r7.concat(r0)
            android.util.Log.d(r1, r7)
        Lc3:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wt.O(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // defpackage.j30
    public void S(Bundle bundle) {
        Dialog dialog = this.j0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.c0;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.d0;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.e0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.f0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.g0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // defpackage.j30
    public void T() {
        this.F = true;
        Dialog dialog = this.j0;
        if (dialog != null) {
            this.k0 = false;
            dialog.show();
            View decorView = this.j0.getWindow().getDecorView();
            decorView.getClass();
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // defpackage.j30
    public void U() {
        this.F = true;
        Dialog dialog = this.j0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // defpackage.j30
    public final void W(Bundle bundle) {
        Bundle bundle2;
        this.F = true;
        if (this.j0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.j0.onRestoreInstanceState(bundle2);
    }

    @Override // defpackage.j30
    public final void X(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.X(layoutInflater, viewGroup, bundle);
        if (this.H != null || this.j0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.j0.onRestoreInstanceState(bundle2);
    }

    public final void h0(boolean z, boolean z2) {
        if (this.l0) {
            return;
        }
        this.l0 = true;
        this.m0 = false;
        Dialog dialog = this.j0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.j0.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.Y.getLooper()) {
                    onDismiss(this.j0);
                } else {
                    this.Y.post(this.Z);
                }
            }
        }
        this.k0 = true;
        if (this.g0 >= 0) {
            y30 y30VarX = x();
            int i = this.g0;
            if (i < 0) {
                zy.n(qq0.i("Bad id: ", i));
                return;
            } else {
                y30VarX.x(new x30(y30VarX, null, i), z);
                this.g0 = -1;
                return;
            }
        }
        ld ldVar = new ld(x());
        ldVar.p = true;
        y30 y30Var = this.t;
        if (y30Var != null && y30Var != ldVar.q) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + toString() + " is already attached to a FragmentManager.");
        }
        ldVar.b(new h40(3, this));
        if (z) {
            ldVar.e(true);
        } else {
            ldVar.e(false);
        }
    }

    public Dialog i0() {
        if (y30.I(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new qm(o(), this.d0);
    }

    public void j0(y30 y30Var, String str) {
        this.l0 = false;
        this.m0 = true;
        y30Var.getClass();
        ld ldVar = new ld(y30Var);
        ldVar.p = true;
        ldVar.g(0, this, str, 1);
        ldVar.e(false);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.k0) {
            return;
        }
        if (y30.I(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        h0(true, true);
    }

    @Override // defpackage.j30
    public final f01 r() {
        return new vt(this, new f30(this));
    }

    public void onCancel(DialogInterface dialogInterface) {
    }
}
