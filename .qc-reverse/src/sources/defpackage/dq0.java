package defpackage;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.preference.DialogPreference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dq0 extends wt implements DialogInterface.OnClickListener {
    public DialogPreference o0;
    public CharSequence p0;
    public CharSequence q0;
    public CharSequence r0;
    public CharSequence s0;
    public int t0;
    public BitmapDrawable u0;
    public int v0;

    @Override // defpackage.wt, defpackage.j30
    public void J(Bundle bundle) {
        super.J(bundle);
        j30 j30VarA = A(true);
        if (!(j30VarA instanceof gq0)) {
            s1.f("Target fragment must implement TargetFragment interface");
            return;
        }
        gq0 gq0Var = (gq0) j30VarA;
        Bundle bundle2 = this.h;
        if (bundle2 == null) {
            zy.e(this, " does not have any arguments.", "Fragment ");
            return;
        }
        String string = bundle2.getString("key");
        if (bundle != null) {
            this.p0 = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.q0 = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.r0 = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.s0 = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.t0 = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.u0 = new BitmapDrawable(y(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) gq0Var.h0(string);
        this.o0 = dialogPreference;
        this.p0 = dialogPreference.J();
        DialogPreference dialogPreference2 = this.o0;
        this.q0 = dialogPreference2.R;
        this.r0 = dialogPreference2.S;
        this.s0 = dialogPreference2.P;
        this.t0 = dialogPreference2.T;
        Drawable drawable = dialogPreference2.Q;
        if (drawable == null || (drawable instanceof BitmapDrawable)) {
            this.u0 = (BitmapDrawable) drawable;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        this.u0 = new BitmapDrawable(y(), bitmapCreateBitmap);
    }

    @Override // defpackage.wt, defpackage.j30
    public void S(Bundle bundle) {
        super.S(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.p0);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.q0);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.r0);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.s0);
        bundle.putInt("PreferenceDialogFragment.layout", this.t0);
        BitmapDrawable bitmapDrawable = this.u0;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    @Override // defpackage.wt
    public final Dialog i0() {
        this.v0 = -2;
        jl1 jl1Var = new jl1(o());
        CharSequence charSequence = this.p0;
        x6 x6Var = (x6) jl1Var.c;
        x6Var.e = charSequence;
        x6Var.d = this.u0;
        jl1Var.l(this.q0, this);
        x6Var.j = this.r0;
        x6Var.k = this;
        o();
        int i = this.t0;
        View viewInflate = i != 0 ? v().inflate(i, (ViewGroup) null) : null;
        if (viewInflate != null) {
            l0(viewInflate);
            x6Var.u = viewInflate;
        } else {
            x6Var.g = this.s0;
        }
        n0(jl1Var);
        b7 b7VarC = jl1Var.c();
        if (this instanceof kx) {
            Window window = b7VarC.getWindow();
            if (Build.VERSION.SDK_INT >= 30) {
                cq0.a(window);
                return b7VarC;
            }
            kx kxVar = (kx) this;
            kxVar.z0 = SystemClock.currentThreadTimeMillis();
            kxVar.o0();
        }
        return b7VarC;
    }

    public final DialogPreference k0() {
        if (this.o0 == null) {
            Bundle bundle = this.h;
            if (bundle == null) {
                zy.e(this, " does not have any arguments.", "Fragment ");
                return null;
            }
            this.o0 = (DialogPreference) ((gq0) A(true)).h0(bundle.getString("key"));
        }
        return this.o0;
    }

    public void l0(View view) {
        int i;
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.s0;
            if (TextUtils.isEmpty(charSequence)) {
                i = 8;
            } else {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i = 0;
            }
            if (viewFindViewById.getVisibility() != i) {
                viewFindViewById.setVisibility(i);
            }
        }
    }

    public abstract void m0(boolean z);

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.v0 = i;
    }

    @Override // defpackage.wt, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        m0(this.v0 == -1);
    }

    public void n0(jl1 jl1Var) {
    }
}
