package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o30 implements LayoutInflater.Factory2 {
    public final y30 b;

    public o30(y30 y30Var) {
        this.b = y30Var;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        a aVarF;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        y30 y30Var = this.b;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, y30Var);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, us0.a);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(0);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            String string = typedArrayObtainStyledAttributes.getString(2);
            typedArrayObtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = j30.class.isAssignableFrom(t30.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    j30 j30VarC = resourceId != -1 ? y30Var.C(resourceId) : null;
                    if (j30VarC == null && string != null) {
                        j30VarC = y30Var.D(string);
                    }
                    if (j30VarC == null && id != -1) {
                        j30VarC = y30Var.C(id);
                    }
                    if (j30VarC == null) {
                        t30 t30VarF = y30Var.F();
                        context.getClassLoader();
                        j30VarC = t30VarF.a(attributeValue);
                        j30VarC.o = true;
                        j30VarC.x = resourceId != 0 ? resourceId : id;
                        j30VarC.y = id;
                        j30VarC.z = string;
                        j30VarC.p = true;
                        j30VarC.t = y30Var;
                        l30 l30Var = y30Var.t;
                        j30VarC.u = l30Var;
                        z7 z7Var = l30Var.n;
                        j30VarC.F = true;
                        if ((l30Var == null ? null : l30Var.m) != null) {
                            j30VarC.F = true;
                        }
                        aVarF = y30Var.a(j30VarC);
                        if (y30.I(2)) {
                            Log.v("FragmentManager", "Fragment " + j30VarC + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (j30VarC.p) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        j30VarC.p = true;
                        j30VarC.t = y30Var;
                        l30 l30Var2 = y30Var.t;
                        j30VarC.u = l30Var2;
                        z7 z7Var2 = l30Var2.n;
                        j30VarC.F = true;
                        if ((l30Var2 == null ? null : l30Var2.m) != null) {
                            j30VarC.F = true;
                        }
                        aVarF = y30Var.f(j30VarC);
                        if (y30.I(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + j30VarC + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    f40 f40Var = g40.a;
                    g40.b(new c40(j30VarC, "Attempting to use <fragment> tag to add fragment " + j30VarC + " to container " + viewGroup));
                    g40.a(j30VarC).getClass();
                    j30VarC.G = viewGroup;
                    aVarF.k();
                    aVarF.j();
                    View view2 = j30VarC.H;
                    if (view2 == null) {
                        s1.f(l11.j("Fragment ", attributeValue, " did not create a view."));
                        return null;
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (j30VarC.H.getTag() == null) {
                        j30VarC.H.setTag(string);
                    }
                    j30VarC.H.addOnAttachStateChangeListener(new n30(this, aVarF));
                    return j30VarC.H;
                }
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
