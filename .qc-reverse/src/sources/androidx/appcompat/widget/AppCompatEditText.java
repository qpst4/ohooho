package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import com.quickcursor.R;
import defpackage.c9;
import defpackage.co;
import defpackage.d61;
import defpackage.eo;
import defpackage.eo0;
import defpackage.fa;
import defpackage.g51;
import defpackage.go;
import defpackage.i9;
import defpackage.l9;
import defpackage.m4;
import defpackage.n51;
import defpackage.sp1;
import defpackage.uf1;
import defpackage.xr;
import defpackage.z9;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText implements eo0 {
    public final m4 b;
    public final fa c;
    public final i9 d;
    public final g51 e;
    public final i9 f;
    public c9 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, R.attr.editTextStyle);
        d61.a(context);
        n51.a(this, getContext());
        m4 m4Var = new m4(this);
        this.b = m4Var;
        m4Var.k(attributeSet, R.attr.editTextStyle);
        fa faVar = new fa(this);
        this.c = faVar;
        faVar.f(attributeSet, R.attr.editTextStyle);
        faVar.b();
        i9 i9Var = new i9(4);
        i9Var.c = this;
        this.d = i9Var;
        this.e = new g51();
        i9 i9Var2 = new i9(this, 3);
        this.f = i9Var2;
        i9Var2.A(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerX = i9Var2.x(keyListener);
        if (keyListenerX == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerX);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }

    private c9 getSuperCaller() {
        if (this.g == null) {
            this.g = new c9(this);
        }
        return this.g;
    }

    @Override // defpackage.eo0
    public final go a(go goVar) {
        this.e.getClass();
        return g51.a(this, goVar);
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

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[PHI: r1
  0x0058: PHI (r1v9 java.lang.String[]) = (r1v4 java.lang.String[]), (r1v10 java.lang.String[]) binds: [B:30:0x006b, B:22:0x0056] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0072  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r8) {
        /*
            r7 = this;
            android.view.inputmethod.InputConnection r0 = super.onCreateInputConnection(r8)
            fa r1 = r7.c
            r1.getClass()
            defpackage.fa.h(r8, r0, r7)
            defpackage.fc0.E(r8, r0, r7)
            if (r0 == 0) goto L78
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 > r2) goto L78
            java.lang.String[] r2 = defpackage.uf1.g(r7)
            if (r2 == 0) goto L78
            java.lang.String r3 = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String r4 = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            r5 = 25
            if (r1 < r5) goto L29
            defpackage.lx.s(r8, r2)
            goto L3e
        L29:
            android.os.Bundle r6 = r8.extras
            if (r6 != 0) goto L34
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            r8.extras = r6
        L34:
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r4, r2)
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r3, r2)
        L3e:
            r1 r2 = new r1
            r6 = 12
            r2.<init>(r6, r7)
            if (r1 < r5) goto L4e
            pb0 r1 = new pb0
            r1.<init>(r0, r2)
        L4c:
            r0 = r1
            goto L78
        L4e:
            java.lang.String[] r6 = defpackage.tk0.e
            if (r1 < r5) goto L5a
            java.lang.String[] r1 = defpackage.lx.u(r8)
            if (r1 == 0) goto L6e
        L58:
            r6 = r1
            goto L6e
        L5a:
            android.os.Bundle r1 = r8.extras
            if (r1 != 0) goto L5f
            goto L6e
        L5f:
            java.lang.String[] r1 = r1.getStringArray(r4)
            if (r1 != 0) goto L6b
            android.os.Bundle r1 = r8.extras
            java.lang.String[] r1 = r1.getStringArray(r3)
        L6b:
            if (r1 == 0) goto L6e
            goto L58
        L6e:
            int r1 = r6.length
            if (r1 != 0) goto L72
            goto L78
        L72:
            qb0 r1 = new qb0
            r1.<init>(r0, r2)
            goto L4c
        L78:
            i9 r7 = r7.f
            xx r7 = r7.B(r0, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatEditText.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean zA = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && uf1.g(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                zA = l9.a(dragEvent, this, activity);
            }
        }
        if (zA) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        co sp1Var;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31 || uf1.g(this) == null || !(i == 16908322 || i == 16908337)) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i2 >= 31) {
                sp1Var = new sp1(primaryClip, 1);
            } else {
                eo eoVar = new eo();
                eoVar.c = primaryClip;
                eoVar.d = 1;
                sp1Var = eoVar;
            }
            sp1Var.t(i == 16908322 ? 0 : 1);
            uf1.j(this, sp1Var.build());
        }
        return true;
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
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(xr.Q(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.f.H(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f.x(keyListener));
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
    public void setTextClassifier(TextClassifier textClassifier) {
        i9 i9Var;
        if (Build.VERSION.SDK_INT >= 28 || (i9Var = this.d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            i9Var.d = textClassifier;
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
