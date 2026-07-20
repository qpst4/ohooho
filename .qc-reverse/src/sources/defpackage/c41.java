package defpackage;

import com.google.android.material.tabs.TabLayout;
import com.quickcursor.android.views.VerticalTabLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c41 implements kg1 {
    public final /* synthetic */ int b = 0;
    public final WeakReference c;
    public int d;
    public int e;

    public c41(VerticalTabLayout verticalTabLayout) {
        this.c = new WeakReference(verticalTabLayout);
    }

    @Override // defpackage.kg1
    public final void a(int i) {
        switch (this.b) {
            case 0:
                this.d = this.e;
                this.e = i;
                TabLayout tabLayout = (TabLayout) this.c.get();
                if (tabLayout != null) {
                    tabLayout.V = this.e;
                }
                break;
            default:
                this.d = this.e;
                this.e = i;
                break;
        }
    }

    @Override // defpackage.kg1
    public final void d(int i) {
        int i2 = this.b;
        boolean z = true;
        WeakReference weakReference = this.c;
        switch (i2) {
            case 0:
                TabLayout tabLayout = (TabLayout) weakReference.get();
                if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                    int i3 = this.e;
                    if (i3 != 0 && (i3 != 2 || this.d != 0)) {
                        z = false;
                    }
                    tabLayout.m(tabLayout.i(i), z);
                    break;
                }
                break;
            default:
                VerticalTabLayout verticalTabLayout = (VerticalTabLayout) weakReference.get();
                if (verticalTabLayout != null && verticalTabLayout.getSelectedTabPosition() != i && i < verticalTabLayout.getTabCount()) {
                    int i4 = this.e;
                    if (i4 != 0 && (i4 != 2 || this.d != 0)) {
                        z = false;
                    }
                    verticalTabLayout.j((i < 0 || i >= verticalTabLayout.getTabCount()) ? null : (ze1) verticalTabLayout.b.get(i), z);
                    break;
                }
                break;
        }
    }

    @Override // defpackage.kg1
    public final void l(float f, int i, int i2) {
        int i3 = this.b;
        WeakReference weakReference = this.c;
        boolean z = true;
        switch (i3) {
            case 0:
                TabLayout tabLayout = (TabLayout) weakReference.get();
                if (tabLayout != null) {
                    int i4 = this.e;
                    tabLayout.o(i, f, i4 != 2 || this.d == 1, (i4 == 2 && this.d == 0) ? false : true, false);
                }
                break;
            default:
                VerticalTabLayout verticalTabLayout = (VerticalTabLayout) weakReference.get();
                if (verticalTabLayout != null) {
                    int i5 = this.e;
                    boolean z2 = i5 != 2 || this.d == 1;
                    if (i5 == 2 && this.d == 0) {
                        z = false;
                    }
                    verticalTabLayout.l(i, f, z2, z);
                }
                break;
        }
    }

    public c41(TabLayout tabLayout) {
        this.c = new WeakReference(tabLayout);
    }
}
