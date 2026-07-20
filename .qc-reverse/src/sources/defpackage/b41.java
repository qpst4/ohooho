package defpackage;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class b41 {
    public Integer a;
    public Drawable b;
    public CharSequence c;
    public CharSequence d;
    public int e;
    public View f;
    public TabLayout g;
    public e41 h;

    public final void a(int i) {
        TabLayout tabLayout = this.g;
        if (tabLayout != null) {
            b(tabLayout.getResources().getText(i));
        } else {
            zy.n("Tab not attached to a TabLayout");
        }
    }

    public final void b(CharSequence charSequence) {
        if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(charSequence)) {
            this.h.setContentDescription(charSequence);
        }
        this.c = charSequence;
        e41 e41Var = this.h;
        if (e41Var != null) {
            e41Var.d();
        }
    }
}
