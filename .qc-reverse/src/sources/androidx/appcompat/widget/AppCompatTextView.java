package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import defpackage.d61;
import defpackage.d9;
import defpackage.fa;
import defpackage.fc0;
import defpackage.ga;
import defpackage.ha;
import defpackage.i1;
import defpackage.i9;
import defpackage.ia;
import defpackage.k0;
import defpackage.m4;
import defpackage.n51;
import defpackage.na;
import defpackage.nc1;
import defpackage.sp1;
import defpackage.tk0;
import defpackage.vg1;
import defpackage.wp0;
import defpackage.xp0;
import defpackage.xr;
import defpackage.z9;
import defpackage.zy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView {
    public final m4 b;
    public final fa c;
    public final i9 d;
    public d9 e;
    public boolean f;
    public sp1 g;
    public Future h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d61.a(context);
        this.f = false;
        this.g = null;
        n51.a(this, getContext());
        m4 m4Var = new m4(this);
        this.b = m4Var;
        m4Var.k(attributeSet, i);
        fa faVar = new fa(this);
        this.c = faVar;
        faVar.f(attributeSet, i);
        faVar.b();
        i9 i9Var = new i9(4);
        i9Var.c = this;
        this.d = i9Var;
        getEmojiTextViewHelper().b(attributeSet, i);
    }

    private d9 getEmojiTextViewHelper() {
        if (this.e == null) {
            this.e = new d9(this);
        }
        return this.e;
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

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public ga getSuperCaller() {
        if (this.g == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 34) {
                this.g = new ia(this);
            } else if (i >= 28) {
                this.g = new ha(this);
            } else if (i >= 26) {
                this.g = new sp1(6, this);
            }
        }
        return this.g;
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
    public CharSequence getText() {
        Future future = this.h;
        if (future != null) {
            try {
                this.h = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                xr.x(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        i9 i9Var;
        if (Build.VERSION.SDK_INT >= 28 || (i9Var = this.d) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) i9Var.d;
        return textClassifier == null ? z9.a((TextView) i9Var.c) : textClassifier;
    }

    public wp0 getTextMetricsParamsCompat() {
        return xr.x(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.c.getClass();
        fa.h(editorInfo, inputConnectionOnCreateInputConnection, this);
        fc0.E(editorInfo, inputConnectionOnCreateInputConnection, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33 || !onCheckIsTextEditor()) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        fa faVar = this.c;
        if (faVar == null || vg1.c) {
            return;
        }
        faVar.i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Future future = this.h;
        if (future != null) {
            try {
                this.h = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                xr.x(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
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

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? tk0.j(context, i) : null, i2 != 0 ? tk0.j(context, i2) : null, i3 != 0 ? tk0.j(context, i3) : null, i4 != 0 ? tk0.j(context, i4) : null);
        fa faVar = this.c;
        if (faVar != null) {
            faVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? tk0.j(context, i) : null, i2 != 0 ? tk0.j(context, i2) : null, i3 != 0 ? tk0.j(context, i3) : null, i4 != 0 ? tk0.j(context, i4) : null);
        fa faVar = this.c;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().o(i);
        } else {
            xr.J(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().d(i);
        } else {
            xr.K(this, i);
        }
    }

    @Override // android.widget.TextView
    public final void setLineHeight(int i, float f) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 34) {
            getSuperCaller().r(i, f);
        } else if (i2 >= 34) {
            k0.h(this, i, f);
        } else {
            xr.L(this, Math.round(TypedValue.applyDimension(i, f, getResources().getDisplayMetrics())));
        }
    }

    public void setPrecomputedText(xp0 xp0Var) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        xr.x(this);
        throw null;
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
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        fa faVar = this.c;
        if (faVar != null) {
            faVar.g(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        i9 i9Var;
        if (Build.VERSION.SDK_INT >= 28 || (i9Var = this.d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            i9Var.d = textClassifier;
        }
    }

    public void setTextFuture(Future<xp0> future) {
        this.h = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(wp0 wp0Var) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = wp0Var.b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i = 7;
            }
        }
        setTextDirection(i);
        getPaint().set(wp0Var.a);
        setBreakStrategy(wp0Var.c);
        setHyphenationFrequency(wp0Var.d);
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

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i) {
        Typeface typefaceCreate;
        if (this.f) {
            return;
        }
        if (typeface == null || i <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            i1 i1Var = nc1.a;
            if (context == null) {
                zy.n("Context cannot be null");
                return;
            }
            typefaceCreate = Typeface.create(typeface, i);
        }
        this.f = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.f = false;
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        xr.L(this, i);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        fa faVar = this.c;
        if (faVar != null) {
            faVar.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        fa faVar = this.c;
        if (faVar != null) {
            faVar.b();
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }
}
