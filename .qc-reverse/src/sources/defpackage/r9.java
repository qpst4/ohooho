package defpackage;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class r9 implements x9, DialogInterface.OnClickListener {
    public b7 b;
    public s9 c;
    public CharSequence d;
    public final /* synthetic */ y9 e;

    public r9(y9 y9Var) {
        this.e = y9Var;
    }

    @Override // defpackage.x9
    public final Drawable a() {
        return null;
    }

    @Override // defpackage.x9
    public final boolean b() {
        b7 b7Var = this.b;
        if (b7Var != null) {
            return b7Var.isShowing();
        }
        return false;
    }

    @Override // defpackage.x9
    public final int c() {
        return 0;
    }

    @Override // defpackage.x9
    public final void dismiss() {
        b7 b7Var = this.b;
        if (b7Var != null) {
            b7Var.dismiss();
            this.b = null;
        }
    }

    @Override // defpackage.x9
    public final void e(CharSequence charSequence) {
        this.d = charSequence;
    }

    @Override // defpackage.x9
    public final void g(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.x9
    public final void j(int i) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.x9
    public final void k(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.x9
    public final void l(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // defpackage.x9
    public final void m(int i, int i2) {
        if (this.c == null) {
            return;
        }
        y9 y9Var = this.e;
        jl1 jl1Var = new jl1(y9Var.getPopupContext());
        x6 x6Var = (x6) jl1Var.c;
        CharSequence charSequence = this.d;
        if (charSequence != null) {
            x6Var.e = charSequence;
        }
        s9 s9Var = this.c;
        int selectedItemPosition = y9Var.getSelectedItemPosition();
        x6Var.s = s9Var;
        x6Var.t = this;
        x6Var.y = selectedItemPosition;
        x6Var.x = true;
        b7 b7VarC = jl1Var.c();
        this.b = b7VarC;
        AlertController$RecycleListView alertController$RecycleListView = b7VarC.g.f;
        alertController$RecycleListView.setTextDirection(i);
        alertController$RecycleListView.setTextAlignment(i2);
        this.b.show();
    }

    @Override // defpackage.x9
    public final int n() {
        return 0;
    }

    @Override // defpackage.x9
    public final CharSequence o() {
        return this.d;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        y9 y9Var = this.e;
        y9Var.setSelection(i);
        if (y9Var.getOnItemClickListener() != null) {
            y9Var.performItemClick(null, i, this.c.getItemId(i));
        }
        dismiss();
    }

    @Override // defpackage.x9
    public final void p(ListAdapter listAdapter) {
        this.c = (s9) listAdapter;
    }
}
