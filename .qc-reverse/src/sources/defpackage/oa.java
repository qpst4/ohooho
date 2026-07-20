package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class oa extends ToggleButton {
    public final m4 b;
    public final fa c;
    public d9 d;

    public oa(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        n51.a(this, getContext());
        m4 m4Var = new m4(this);
        this.b = m4Var;
        m4Var.k(attributeSet, R.attr.buttonStyleToggle);
        fa faVar = new fa(this);
        this.c = faVar;
        faVar.f(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.buttonStyleToggle);
    }

    private d9 getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new d9(this);
        }
        return this.d;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
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

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.ToggleButton, android.view.View
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

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
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
}
