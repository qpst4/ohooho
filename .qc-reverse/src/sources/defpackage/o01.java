package defpackage;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.extra.TriggerActionsListActivity;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o01 implements a1, q2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ o01(int i, int i2, Object obj) {
        this.b = i2;
        this.d = obj;
        this.c = i;
    }

    @Override // defpackage.a1
    public boolean a(View view) {
        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.d;
        int i = this.c;
        if (i != 1) {
            int i2 = 2;
            if (i != 2) {
                WeakReference weakReference = sideSheetBehavior.p;
                if (weakReference == null || weakReference.get() == null) {
                    sideSheetBehavior.r(i);
                    return true;
                }
                View view2 = (View) sideSheetBehavior.p.get();
                kf kfVar = new kf(i, i2, sideSheetBehavior);
                ViewParent parent = view2.getParent();
                if (parent != null && parent.isLayoutRequested()) {
                    WeakHashMap weakHashMap = uf1.a;
                    if (view2.isAttachedToWindow()) {
                        view2.post(kfVar);
                        return true;
                    }
                }
                kfVar.run();
                return true;
            }
        }
        throw new IllegalArgumentException(l11.k(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
    }

    @Override // defpackage.q2
    public void i(i iVar) {
        int i = this.b;
        int i2 = this.c;
        Object obj = this.d;
        switch (i) {
            case 2:
                p71 p71Var = (p71) obj;
                if (iVar != null) {
                    ((j71) p71Var.Y.get(i2)).e(iVar);
                    p71Var.e();
                    p71Var.a0.getAdapter().d();
                    break;
                }
                break;
            default:
                TriggerActionsListActivity triggerActionsListActivity = (TriggerActionsListActivity) obj;
                if (iVar != null) {
                    ((h91) triggerActionsListActivity.D.get(i2)).e(iVar);
                    triggerActionsListActivity.e();
                    triggerActionsListActivity.F.getAdapter().d();
                } else {
                    bk bkVar = TriggerActionsListActivity.G;
                }
                break;
        }
    }
}
