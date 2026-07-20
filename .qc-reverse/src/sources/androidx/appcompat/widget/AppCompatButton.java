package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.quickcursor.R;
import defpackage.d61;
import defpackage.d9;
import defpackage.fa;
import defpackage.m4;
import defpackage.n51;
import defpackage.na;
import defpackage.vg1;
import defpackage.xr;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button {
    public final m4 b;
    public final fa c;
    public d9 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d61.a(context);
        n51.a(this, getContext());
        m4 m4Var = new m4(this);
        this.b = m4Var;
        m4Var.k(attributeSet, i);
        fa faVar = new fa(this);
        this.c = faVar;
        faVar.f(attributeSet, i);
        faVar.b();
        getEmojiTextViewHelper().b(attributeSet, i);
    }

    private d9 getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new d9(this);
        }
        return this.d;
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

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (vg1.c) {
            return super.getAutoSizeMaxTextSize();
        }
        fa faVar = this.c;
        if (faVar != null) {
            return Math.round(faVar.i.e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (vg1.c) {
            return super.getAutoSizeMinTextSize();
        }
        fa faVar = this.c;
        if (faVar != null) {
            return Math.round(faVar.i.d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (vg1.c) {
            return super.getAutoSizeStepGranularity();
        }
        fa faVar = this.c;
        if (faVar != null) {
            return Math.round(faVar.i.c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (vg1.c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        fa faVar = this.c;
        return faVar != null ? faVar.i.f : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (vg1.c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        fa faVar = this.c;
        if (faVar != null) {
            return faVar.i.a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return xr.P(super.getCustomSelectionActionModeCallback());
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

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        fa faVar = this.c;
        if (faVar == null || vg1.c) {
            return;
        }
        faVar.i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        fa faVar = this.c;
        if (faVar != null) {
            na naVar = faVar.i;
            if (vg1.c || !naVar.f()) {
                return;
            }
            naVar.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (vg1.c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        fa faVar = this.c;
        if (faVar != null) {
            faVar.i(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (vg1.c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        fa faVar = this.c;
        if (faVar != null) {
            faVar.j(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (vg1.c) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        fa faVar = this.c;
        if (faVar != null) {
            faVar.k(i);
        }
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
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(xr.Q(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z) {
        fa faVar = this.c;
        if (faVar != null) {
            faVar.a.setAllCaps(z);
        }
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

    @Override // android.widget.TextView
    public final void setTextSize(int i, float f) {
        boolean z = vg1.c;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        fa faVar = this.c;
        if (faVar != null) {
            na naVar = faVar.i;
            if (z || naVar.f()) {
                return;
            }
            naVar.g(i, f);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }
}
