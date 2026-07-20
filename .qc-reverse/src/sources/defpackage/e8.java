package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e8 {
    public Parcelable a;
    public Object b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final Object f;

    public /* synthetic */ e8(TextView textView) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.d = false;
        this.f = textView;
    }

    public void a() {
        CompoundButton compoundButton = (CompoundButton) this.f;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.c || this.d) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.c) {
                    drawableMutate.setTintList((ColorStateList) this.a);
                }
                if (this.d) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void b() {
        d8 d8Var = (d8) this.f;
        Drawable checkMarkDrawable = d8Var.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.c || this.d) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.c) {
                    drawableMutate.setTintList((ColorStateList) this.a);
                }
                if (this.d) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(d8Var.getDrawableState());
                }
                d8Var.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public Bundle c(String str) {
        if (!this.d) {
            s1.f("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
            return null;
        }
        Bundle bundle = (Bundle) this.a;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = (Bundle) this.a;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = (Bundle) this.a;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.a = null;
        return bundle2;
    }

    public void d(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.f;
        Context context = compoundButton.getContext();
        int[] iArr = zs0.m;
        ra raVarM = ra.M(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) raVarM.c;
        uf1.m(compoundButton, compoundButton.getContext(), iArr, attributeSet, (TypedArray) raVarM.c, i);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(tk0.j(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        compoundButton.setButtonDrawable(tk0.j(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                compoundButton.setButtonDrawable(tk0.j(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                compoundButton.setButtonTintList(raVarM.x(2));
            }
            if (typedArray.hasValue(3)) {
                compoundButton.setButtonTintMode(vu.c(typedArray.getInt(3, -1), null));
            }
            raVarM.O();
        } catch (Throwable th) {
            raVarM.O();
            throw th;
        }
    }

    public void e(String str, px0 px0Var) {
        Object obj;
        px0Var.getClass();
        ix0 ix0Var = (ix0) this.f;
        fx0 fx0VarB = ix0Var.b(str);
        if (fx0VarB != null) {
            obj = fx0VarB.c;
        } else {
            fx0 fx0Var = new fx0(str, px0Var);
            ix0Var.e++;
            fx0 fx0Var2 = ix0Var.c;
            if (fx0Var2 == null) {
                ix0Var.b = fx0Var;
                ix0Var.c = fx0Var;
            } else {
                fx0Var2.d = fx0Var;
                fx0Var.e = fx0Var2;
                ix0Var.c = fx0Var;
            }
            obj = null;
        }
        if (((px0) obj) == null) {
            return;
        }
        zy.n("SavedStateProvider with the given key is already registered");
    }

    public void f() {
        if (!this.e) {
            s1.f("Can not perform this action after onSaveInstanceState");
            return;
        }
        x7 x7Var = (x7) this.b;
        if (x7Var == null) {
            x7Var = new x7(this);
        }
        this.b = x7Var;
        try {
            uf0.class.getDeclaredConstructor(null);
            x7 x7Var2 = (x7) this.b;
            if (x7Var2 != null) {
                ((LinkedHashSet) x7Var2.b).add(uf0.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + uf0.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    public e8() {
        this.f = new ix0();
        this.e = true;
    }
}
