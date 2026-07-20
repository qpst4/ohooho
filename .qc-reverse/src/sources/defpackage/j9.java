package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class j9 extends RadioButton implements f61 {
    public final e8 b;
    public final m4 c;
    public final fa d;
    public d9 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j9(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.radioButtonStyle);
        d61.a(context);
        n51.a(this, getContext());
        e8 e8Var = new e8(this);
        this.b = e8Var;
        e8Var.d(attributeSet, R.attr.radioButtonStyle);
        m4 m4Var = new m4(this);
        this.c = m4Var;
        m4Var.k(attributeSet, R.attr.radioButtonStyle);
        fa faVar = new fa(this);
        this.d = faVar;
        faVar.f(attributeSet, R.attr.radioButtonStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.radioButtonStyle);
    }

    private d9 getEmojiTextViewHelper() {
        if (this.e == null) {
            this.e = new d9(this);
        }
        return this.e;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        m4 m4Var = this.c;
        if (m4Var != null) {
            m4Var.a();
        }
        fa faVar = this.d;
        if (faVar != null) {
            faVar.b();
        }
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

    @Override // defpackage.f61
    public ColorStateList getSupportButtonTintList() {
        e8 e8Var = this.b;
        if (e8Var != null) {
            return (ColorStateList) e8Var.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
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

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        e8 e8Var = this.b;
        if (e8Var != null) {
            if (e8Var.e) {
                e8Var.e = false;
            } else {
                e8Var.e = true;
                e8Var.a();
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

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
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

    @Override // defpackage.f61
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        e8 e8Var = this.b;
        if (e8Var != null) {
            e8Var.a = colorStateList;
            e8Var.c = true;
            e8Var.a();
        }
    }

    @Override // defpackage.f61
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        e8 e8Var = this.b;
        if (e8Var != null) {
            e8Var.b = mode;
            e8Var.d = true;
            e8Var.a();
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

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(tk0.j(getContext(), i));
    }
}
