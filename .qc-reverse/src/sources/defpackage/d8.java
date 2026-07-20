package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class d8 extends CheckedTextView {
    public final e8 b;
    public final m4 c;
    public final fa d;
    public d9 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d8(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        d61.a(context);
        n51.a(this, getContext());
        fa faVar = new fa(this);
        this.d = faVar;
        faVar.f(attributeSet, R.attr.checkedTextViewStyle);
        faVar.b();
        m4 m4Var = new m4(this);
        this.c = m4Var;
        m4Var.k(attributeSet, R.attr.checkedTextViewStyle);
        this.b = new e8(this);
        Context context2 = getContext();
        int[] iArr = zs0.l;
        ra raVarM = ra.M(context2, attributeSet, iArr, R.attr.checkedTextViewStyle);
        TypedArray typedArray = (TypedArray) raVarM.c;
        uf1.m(this, getContext(), iArr, attributeSet, (TypedArray) raVarM.c, R.attr.checkedTextViewStyle);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(tk0.j(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(0)) {
                        setCheckMarkDrawable(tk0.j(getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(tk0.j(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(raVarM.x(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(vu.c(typedArray.getInt(3, -1), null));
            }
            raVarM.O();
            getEmojiTextViewHelper().b(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            raVarM.O();
            throw th;
        }
    }

    private d9 getEmojiTextViewHelper() {
        if (this.e == null) {
            this.e = new d9(this);
        }
        return this.e;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        fa faVar = this.d;
        if (faVar != null) {
            faVar.b();
        }
        m4 m4Var = this.c;
        if (m4Var != null) {
            m4Var.a();
        }
        e8 e8Var = this.b;
        if (e8Var != null) {
            e8Var.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return xr.P(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        m4 m4Var = this.c;
        if (m4Var != null) {
            return m4Var.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        m4 m4Var = this.c;
        if (m4Var != null) {
            return m4Var.i();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        e8 e8Var = this.b;
        if (e8Var != null) {
            return (ColorStateList) e8Var.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        e8 e8Var = this.b;
        if (e8Var != null) {
            return (PorterDuff.Mode) e8Var.b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.d.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.d.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        fc0.E(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m4 m4Var = this.c;
        if (m4Var != null) {
            m4Var.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        m4 m4Var = this.c;
        if (m4Var != null) {
            m4Var.n(i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        e8 e8Var = this.b;
        if (e8Var != null) {
            if (e8Var.e) {
                e8Var.e = false;
            } else {
                e8Var.e = true;
                e8Var.b();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        fa faVar = this.d;
        if (faVar != null) {
            faVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        fa faVar = this.d;
        if (faVar != null) {
            faVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(xr.Q(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        m4 m4Var = this.c;
        if (m4Var != null) {
            m4Var.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        m4 m4Var = this.c;
        if (m4Var != null) {
            m4Var.t(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        e8 e8Var = this.b;
        if (e8Var != null) {
            e8Var.a = colorStateList;
            e8Var.c = true;
            e8Var.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        e8 e8Var = this.b;
        if (e8Var != null) {
            e8Var.b = mode;
            e8Var.d = true;
            e8Var.b();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        fa faVar = this.d;
        faVar.l(colorStateList);
        faVar.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        fa faVar = this.d;
        faVar.m(mode);
        faVar.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        fa faVar = this.d;
        if (faVar != null) {
            faVar.g(context, i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(tk0.j(getContext(), i));
    }
}
