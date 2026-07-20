package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import com.quickcursor.R;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yh1 extends bi1 {
    public static final PathInterpolator e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
    public static final i10 f = new i10();
    public static final DecelerateInterpolator g = new DecelerateInterpolator(1.5f);
    public static final AccelerateInterpolator h = new AccelerateInterpolator(1.5f);

    public static void e(View view) {
        eo eoVarJ = j(view);
        if (eoVarJ != null) {
            ((View) eoVarJ.f).setTranslationY(0.0f);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                e(viewGroup.getChildAt(i));
            }
        }
    }

    public static void f(View view, wi1 wi1Var, boolean z) {
        eo eoVarJ = j(view);
        if (eoVarJ != null) {
            eoVarJ.c = wi1Var;
            if (!z) {
                View view2 = (View) eoVarJ.f;
                int[] iArr = (int[]) eoVarJ.g;
                view2.getLocationOnScreen(iArr);
                z = true;
                eoVarJ.d = iArr[1];
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                f(viewGroup.getChildAt(i), wi1Var, z);
            }
        }
    }

    public static void g(View view, wi1 wi1Var, List list) {
        eo eoVarJ = j(view);
        if (eoVarJ != null) {
            eoVarJ.a(wi1Var, list);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                g(viewGroup.getChildAt(i), wi1Var, list);
            }
        }
    }

    public static void h(View view, pn0 pn0Var) {
        eo eoVarJ = j(view);
        if (eoVarJ != null) {
            View view2 = (View) eoVarJ.f;
            int[] iArr = (int[]) eoVarJ.g;
            view2.getLocationOnScreen(iArr);
            int i = eoVarJ.d - iArr[1];
            eoVarJ.e = i;
            view2.setTranslationY(i);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                h(viewGroup.getChildAt(i2), pn0Var);
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static eo j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof xh1) {
            return ((xh1) tag).a;
        }
        return null;
    }
}
