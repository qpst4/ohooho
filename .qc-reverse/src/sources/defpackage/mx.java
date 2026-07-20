package defpackage;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mx extends c70 {
    public final /* synthetic */ int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mx(int i) {
        super(27);
        this.m = i;
    }

    @Override // defpackage.c70
    public final void l(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float fSin;
        float fCos;
        switch (this.m) {
            case 0:
                RectF rectFE = c70.e(tabLayout, view);
                RectF rectFE2 = c70.e(tabLayout, view2);
                if (rectFE.left < rectFE2.left) {
                    double d = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) (1.0d - Math.cos(d));
                    fCos = (float) Math.sin(d);
                } else {
                    double d2 = (((double) f) * 3.141592653589793d) / 2.0d;
                    fSin = (float) Math.sin(d2);
                    fCos = (float) (1.0d - Math.cos(d2));
                }
                drawable.setBounds(s7.c(fSin, (int) rectFE.left, (int) rectFE2.left), drawable.getBounds().top, s7.c(fCos, (int) rectFE.right, (int) rectFE2.right), drawable.getBounds().bottom);
                break;
            default:
                if (f >= 0.5f) {
                    view = view2;
                }
                RectF rectFE3 = c70.e(tabLayout, view);
                float fB = f < 0.5f ? s7.b(1.0f, 0.0f, 0.0f, 0.5f, f) : s7.b(0.0f, 1.0f, 0.5f, 1.0f, f);
                drawable.setBounds((int) rectFE3.left, drawable.getBounds().top, (int) rectFE3.right, drawable.getBounds().bottom);
                drawable.setAlpha((int) (fB * 255.0f));
                break;
        }
    }
}
