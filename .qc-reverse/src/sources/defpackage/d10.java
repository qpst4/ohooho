package defpackage;

import android.database.DataSetObserver;
import com.google.android.material.tabs.TabLayout;
import com.heinrichreimersoftware.materialintro.view.InkPageIndicator;
import com.quickcursor.android.views.VerticalTabLayout;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class d10 extends DataSetObserver {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d10(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((e10) obj).i();
                break;
            case 1:
                InkPageIndicator inkPageIndicator = (InkPageIndicator) obj;
                inkPageIndicator.setPageCount(inkPageIndicator.k.getAdapter().c());
                inkPageIndicator.invalidate();
                break;
            case 2:
                rh0 rh0Var = (rh0) obj;
                if (rh0Var.A.isShowing()) {
                    rh0Var.d();
                }
                break;
            case 3:
                ((TabLayout) obj).k();
                break;
            case 4:
                ((VerticalTabLayout) obj).i();
                break;
            default:
                ((mg1) obj).g();
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((e10) obj).i();
                break;
            case 1:
            default:
                super.onInvalidated();
                break;
            case 2:
                ((rh0) obj).dismiss();
                break;
            case 3:
                ((TabLayout) obj).k();
                break;
            case 4:
                ((VerticalTabLayout) obj).i();
                break;
            case 5:
                ((mg1) obj).g();
                break;
        }
    }
}
