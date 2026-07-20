package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nj0 extends ArrayAdapter {
    public ColorStateList a;
    public ColorStateList b;
    public final /* synthetic */ oj0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nj0(oj0 oj0Var, Context context, int i, String[] strArr) {
        super(context, i, strArr);
        this.c = oj0Var;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        oj0 oj0Var = this.c;
        ColorStateList colorStateList2 = oj0Var.m;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.b = colorStateList;
        if (oj0Var.l != 0 && oj0Var.m != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{wl.d(oj0Var.m.getColorForState(iArr3, 0), oj0Var.l), wl.d(oj0Var.m.getColorForState(iArr2, 0), oj0Var.l), oj0Var.l});
        }
        this.a = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            oj0 oj0Var = this.c;
            Drawable rippleDrawable = null;
            if (oj0Var.getText().toString().contentEquals(textView.getText()) && oj0Var.l != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(oj0Var.l);
                if (this.b != null) {
                    colorDrawable.setTintList(this.a);
                    rippleDrawable = new RippleDrawable(this.b, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            WeakHashMap weakHashMap = uf1.a;
            textView.setBackground(rippleDrawable);
        }
        return view2;
    }
}
