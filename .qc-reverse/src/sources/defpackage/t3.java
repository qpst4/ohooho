package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.quickcursor.R;
import com.quickcursor.android.views.settings.ActionsRecyclerView;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class t3 {
    public static final qc0 e = new qc0(0);
    public static final qc0 f = new qc0(1);
    public int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public t3(ActionsRecyclerView actionsRecyclerView, List list, z3 z3Var) {
        this.d = actionsRecyclerView;
        this.b = list;
        this.c = z3Var;
        this.a = -1;
    }

    public static void a(pu0 pu0Var) {
        View view = pu0Var.a;
        Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
        if (tag instanceof Float) {
            float fFloatValue = ((Float) tag).floatValue();
            WeakHashMap weakHashMap = uf1.a;
            lf1.k(view, fFloatValue);
        }
        view.setTag(R.id.item_touch_helper_previous_elevation, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public static int b(int i, int i2) {
        int i3;
        int i4 = i & 3158064;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 >> 2;
        } else {
            int i6 = i4 >> 1;
            i5 |= (-3158065) & i6;
            i3 = (i6 & 3158064) >> 2;
        }
        return i5 | i3;
    }

    public static int c(int i, int i2) {
        int i3;
        int i4 = i & 789516;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 << 2;
        } else {
            int i6 = i4 << 1;
            i5 |= (-789517) & i6;
            i3 = (i6 & 789516) << 2;
        }
        return i5 | i3;
    }

    public static void e(RecyclerView recyclerView, pu0 pu0Var, float f2, float f3, boolean z) {
        View view = pu0Var.a;
        if (z && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            WeakHashMap weakHashMap = uf1.a;
            Float fValueOf = Float.valueOf(lf1.e(view));
            int childCount = recyclerView.getChildCount();
            float f4 = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    WeakHashMap weakHashMap2 = uf1.a;
                    float fE = lf1.e(childAt);
                    if (fE > f4) {
                        f4 = fE;
                    }
                }
            }
            lf1.k(view, f4 + 1.0f);
            view.setTag(R.id.item_touch_helper_previous_elevation, fValueOf);
        }
        view.setTranslationX(f2);
        view.setTranslationY(f3);
    }

    public int d(ActionsRecyclerView actionsRecyclerView, int i, int i2, long j) {
        if (this.a == -1) {
            this.a = actionsRecyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
        }
        int interpolation = (int) (e.getInterpolation(j <= 2000 ? j / 2000.0f : 1.0f) * ((int) (f.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)) * ((int) Math.signum(i2)) * this.a)));
        return interpolation == 0 ? i2 > 0 ? 1 : -1 : interpolation;
    }

    public void f(int i) {
        ActionsRecyclerView actionsRecyclerView = (ActionsRecyclerView) this.d;
        if (!zq0.b.c()) {
            yb0.y(R.string.setting_not_available_for_free_version, 0);
            actionsRecyclerView.getAdapter().a.d(i, 1, null);
        } else {
            ((List) this.b).remove(i);
            actionsRecyclerView.getAdapter().a.f(i, 1);
            ((z3) this.c).e();
        }
    }

    public void g(Throwable th) {
        boolean z = th instanceof TimeoutException;
        ul1 ul1Var = (ul1) this.d;
        if (z) {
            ul1Var.D(114, 28, zl1.t);
            pn1.h("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            ul1Var.D(107, 28, zl1.t);
            pn1.h("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        ((Runnable) this.c).run();
    }

    public t3(ul1 ul1Var, int i, Consumer consumer, Runnable runnable) {
        this.a = i;
        this.b = consumer;
        this.c = runnable;
        this.d = ul1Var;
    }
}
