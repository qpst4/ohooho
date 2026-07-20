package defpackage;

import android.R;
import android.content.res.ColorStateList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gk0 extends j9 {
    public static final int[][] h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList f;
    public boolean g;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f == null) {
            int iL = xr.l(this, com.quickcursor.R.attr.colorControlActivated);
            int iL2 = xr.l(this, com.quickcursor.R.attr.colorOnSurface);
            int iL3 = xr.l(this, com.quickcursor.R.attr.colorSurface);
            this.f = new ColorStateList(h, new int[]{xr.z(1.0f, iL3, iL), xr.z(0.54f, iL3, iL2), xr.z(0.38f, iL3, iL2), xr.z(0.38f, iL3, iL2)});
        }
        return this.f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g && getButtonTintList() == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.g = z;
        if (z) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }
}
