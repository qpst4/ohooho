package defpackage;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.quickcursor.android.views.VerticalTabLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ze1 {
    public Drawable a;
    public CharSequence b;
    public CharSequence c;
    public int d;
    public View e;
    public VerticalTabLayout f;
    public bf1 g;

    public final void a(int i) {
        VerticalTabLayout verticalTabLayout = this.f;
        if (verticalTabLayout != null) {
            b(verticalTabLayout.getResources().getText(i));
        } else {
            zy.n("Tab not attached to a TabLayout");
        }
    }

    public final void b(CharSequence charSequence) {
        if (TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(charSequence)) {
            this.g.setContentDescription(charSequence);
        }
        this.b = charSequence;
        bf1 bf1Var = this.g;
        if (bf1Var != null) {
            bf1Var.e();
        }
    }
}
