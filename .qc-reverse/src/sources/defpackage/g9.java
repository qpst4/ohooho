package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class g9 extends MultiAutoCompleteTextView {
    public static final int[] e = {R.attr.popupBackground};
    public final m4 b;
    public final fa c;
    public final i9 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g9(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.quickcursor.R.attr.autoCompleteTextViewStyle);
        d61.a(context);
        n51.a(this, getContext());
        ra raVarM = ra.M(getContext(), attributeSet, e, com.quickcursor.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) raVarM.c).hasValue(0)) {
            setDropDownBackgroundDrawable(raVarM.y(0));
        }
        raVarM.O();
        m4 m4Var = new m4(this);
        this.b = m4Var;
        m4Var.k(attributeSet, com.quickcursor.R.attr.autoCompleteTextViewStyle);
        fa faVar = new fa(this);
        this.c = faVar;
        faVar.f(attributeSet, com.quickcursor.R.attr.autoCompleteTextViewStyle);
        faVar.b();
        i9 i9Var = new i9(this, 3);
        this.d = i9Var;
        i9Var.A(attributeSet, com.quickcursor.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = isFocusable();
        boolean zIsClickable = isClickable();
        boolean zIsLongClickable = isLongClickable();
        int inputType = getInputType();
        KeyListener keyListenerX = i9Var.x(keyListener);
        if (keyListenerX == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerX);
        setRawInputType(inputType);
        setFocusable(zIsFocusable);
        setClickable(zIsClickable);
        setLongClickable(zIsLongClickable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.a();
        }
        fa faVar = this.c;
        if (faVar != null) {
            faVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        m4 m4Var = this.b;
        if (m4Var != null) {
            return m4Var.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        m4 m4Var = this.b;
        if (m4Var != null) {
            return m4Var.i();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.c.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        fc0.E(editorInfo, inputConnectionOnCreateInputConnection, this);
        return this.d.B(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.n(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        fa faVar = this.c;
        if (faVar != null) {
            faVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        fa faVar = this.c;
        if (faVar != null) {
            faVar.b();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(tk0.j(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.d.H(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.d.x(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.t(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        fa faVar = this.c;
        faVar.l(colorStateList);
        faVar.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        fa faVar = this.c;
        faVar.m(mode);
        faVar.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        fa faVar = this.c;
        if (faVar != null) {
            faVar.g(context, i);
        }
    }
}
