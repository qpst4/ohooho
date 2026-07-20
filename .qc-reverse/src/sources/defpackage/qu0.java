package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qu0 extends y {
    public final ru0 d;
    public final WeakHashMap e = new WeakHashMap();

    public qu0(ru0 ru0Var) {
        this.d = ru0Var;
    }

    @Override // defpackage.y
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        y yVar = (y) this.e.get(view);
        return yVar != null ? yVar.a(view, accessibilityEvent) : this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // defpackage.y
    public final sp1 b(View view) {
        y yVar = (y) this.e.get(view);
        return yVar != null ? yVar.b(view) : super.b(view);
    }

    @Override // defpackage.y
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        y yVar = (y) this.e.get(view);
        if (yVar != null) {
            yVar.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // defpackage.y
    public final void d(View view, n0 n0Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = n0Var.a;
        ru0 ru0Var = this.d;
        RecyclerView recyclerView = ru0Var.d;
        RecyclerView recyclerView2 = ru0Var.d;
        boolean zM = recyclerView.M();
        View.AccessibilityDelegate accessibilityDelegate = this.a;
        if (zM || recyclerView2.getLayoutManager() == null) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            return;
        }
        recyclerView2.getLayoutManager().Z(view, n0Var);
        y yVar = (y) this.e.get(view);
        if (yVar != null) {
            yVar.d(view, n0Var);
        } else {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        }
    }

    @Override // defpackage.y
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        y yVar = (y) this.e.get(view);
        if (yVar != null) {
            yVar.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // defpackage.y
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        y yVar = (y) this.e.get(viewGroup);
        return yVar != null ? yVar.f(viewGroup, view, accessibilityEvent) : this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // defpackage.y
    public final boolean g(View view, int i, Bundle bundle) {
        ru0 ru0Var = this.d;
        RecyclerView recyclerView = ru0Var.d;
        RecyclerView recyclerView2 = ru0Var.d;
        if (recyclerView.M() || recyclerView2.getLayoutManager() == null) {
            return super.g(view, i, bundle);
        }
        y yVar = (y) this.e.get(view);
        if (yVar != null) {
            if (yVar.g(view, i, bundle)) {
                return true;
            }
        } else if (super.g(view, i, bundle)) {
            return true;
        }
        gu0 gu0Var = recyclerView2.getLayoutManager().b.c;
        return false;
    }

    @Override // defpackage.y
    public final void h(View view, int i) {
        y yVar = (y) this.e.get(view);
        if (yVar != null) {
            yVar.h(view, i);
        } else {
            super.h(view, i);
        }
    }

    @Override // defpackage.y
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        y yVar = (y) this.e.get(view);
        if (yVar != null) {
            yVar.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
