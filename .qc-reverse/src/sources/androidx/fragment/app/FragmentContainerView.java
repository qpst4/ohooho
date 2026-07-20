package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.quickcursor.R;
import defpackage.j30;
import defpackage.l11;
import defpackage.l30;
import defpackage.ld;
import defpackage.s1;
import defpackage.t30;
import defpackage.uf1;
import defpackage.us0;
import defpackage.wi1;
import defpackage.y30;
import defpackage.z7;
import defpackage.zy;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    public final ArrayList b;
    public final ArrayList c;
    public View.OnApplyWindowInsetsListener d;
    public boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, y30 y30Var) {
        View view;
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = true;
        String classAttribute = attributeSet.getClassAttribute();
        int i = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, us0.b, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(0) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        j30 j30VarC = y30Var.C(id);
        if (classAttribute != null && j30VarC == null) {
            if (id == -1) {
                s1.f(l11.j("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
                throw null;
            }
            t30 t30VarF = y30Var.F();
            context.getClassLoader();
            j30 j30VarA = t30VarF.a(classAttribute);
            j30VarA.getClass();
            j30VarA.F = true;
            l30 l30Var = j30VarA.u;
            if ((l30Var == null ? null : l30Var.m) != null) {
                j30VarA.F = true;
            }
            ld ldVar = new ld(y30Var);
            ldVar.p = true;
            j30VarA.G = this;
            ldVar.g(getId(), j30VarA, string, 1);
            if (ldVar.g) {
                s1.f("This transaction is already being added to the back stack");
                throw null;
            }
            ldVar.h = false;
            ldVar.q.A(ldVar, true);
        }
        ArrayList arrayListK = y30Var.c.k();
        int size = arrayListK.size();
        while (i < size) {
            Object obj = arrayListK.get(i);
            i++;
            a aVar = (a) obj;
            j30 j30Var = aVar.c;
            if (j30Var.y == getId() && (view = j30Var.H) != null && view.getParent() == null) {
                j30Var.G = this;
                aVar.b();
            }
        }
    }

    public final void a(View view) {
        if (this.c.contains(view)) {
            this.b.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof j30 ? (j30) tag : null) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        wi1 wi1VarI;
        windowInsets.getClass();
        wi1 wi1VarH = wi1.h(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.d;
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.getClass();
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            windowInsetsOnApplyWindowInsets.getClass();
            wi1VarI = wi1.h(null, windowInsetsOnApplyWindowInsets);
        } else {
            wi1VarI = uf1.i(this, wi1VarH);
        }
        if (!wi1VarI.a.m()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                uf1.b(getChildAt(i), wi1VarI);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        canvas.getClass();
        if (this.e) {
            ArrayList arrayList = this.b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                super.drawChild(canvas, (View) obj, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        canvas.getClass();
        view.getClass();
        if (this.e) {
            ArrayList arrayList = this.b;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        view.getClass();
        this.c.remove(view);
        if (this.b.remove(view)) {
            this.e = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends j30> F getFragment() {
        j30 j30Var;
        z7 z7Var;
        y30 y30VarW;
        View view = this;
        while (true) {
            if (view == null) {
                j30Var = null;
                break;
            }
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            j30Var = tag instanceof j30 ? (j30) tag : null;
            if (j30Var != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (j30Var == null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    z7Var = null;
                    break;
                }
                if (context instanceof z7) {
                    z7Var = (z7) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (z7Var == null) {
                zy.e(this, " is not within a subclass of FragmentActivity.", "View ");
                return null;
            }
            y30VarW = z7Var.w();
        } else {
            if (!j30Var.D()) {
                throw new IllegalStateException("The Fragment " + j30Var + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            y30VarW = j30Var.l();
        }
        return (F) y30VarW.C(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        windowInsets.getClass();
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                childAt.getClass();
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        view.getClass();
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        View childAt = getChildAt(i);
        childAt.getClass();
        a(childAt);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        view.getClass();
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            childAt.getClass();
            a(childAt);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            childAt.getClass();
            a(childAt);
        }
        super.removeViewsInLayout(i, i2);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.e = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        onApplyWindowInsetsListener.getClass();
        this.d = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        view.getClass();
        if (view.getParent() == this) {
            this.c.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        String str;
        super(context, attributeSet, 0);
        context.getClass();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, us0.b, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }
}
