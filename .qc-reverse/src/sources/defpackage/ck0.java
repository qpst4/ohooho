package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ck0 extends c8 {
    public final LinkedHashSet f;
    public final LinkedHashSet g;
    public ColorStateList h;
    public boolean i;
    public boolean j;
    public boolean k;
    public CharSequence l;
    public Drawable m;
    public Drawable n;
    public boolean o;
    public ColorStateList p;
    public ColorStateList q;
    public PorterDuff.Mode r;
    public int s;
    public int[] t;
    public boolean u;
    public CharSequence v;
    public CompoundButton.OnCheckedChangeListener w;
    public final r7 x;
    public final ak0 y;
    public static final int[] z = {R.attr.state_indeterminate};
    public static final int[] A = {R.attr.state_error};
    public static final int[][] B = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public static final int C = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");

    public ck0(Context context, AttributeSet attributeSet) {
        super(xy0.L(context, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox), attributeSet, R.attr.checkboxStyle);
        this.f = new LinkedHashSet();
        this.g = new LinkedHashSet();
        Context context2 = getContext();
        r7 r7Var = new r7(context2);
        Resources resources = context2.getResources();
        Resources.Theme theme = context2.getTheme();
        ThreadLocal threadLocal = ew0.a;
        Drawable drawable = resources.getDrawable(R.drawable.mtrl_checkbox_button_checked_unchecked, theme);
        r7Var.b = drawable;
        drawable.setCallback(r7Var.g);
        new q7(r7Var.b.getConstantState());
        this.x = r7Var;
        this.y = new ak0(this);
        Context context3 = getContext();
        this.m = getButtonDrawable();
        this.p = getSuperButtonTintList();
        setSupportButtonTintList(null);
        f01.i(context3, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        int[] iArr = ys0.r;
        f01.l(context3, attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context3.obtainStyledAttributes(attributeSet, iArr, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        ra raVar = new ra(context3, typedArrayObtainStyledAttributes);
        this.n = raVar.y(2);
        if (this.m != null && i1.S(context3, R.attr.isMaterial3Theme, false)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
            if (resourceId == C && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.m = tk0.j(context3, R.drawable.mtrl_checkbox_button);
                this.o = true;
                if (this.n == null) {
                    this.n = tk0.j(context3, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.q = yb0.h(context3, raVar, 3);
        this.r = i1.J(typedArrayObtainStyledAttributes.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.i = typedArrayObtainStyledAttributes.getBoolean(10, false);
        this.j = typedArrayObtainStyledAttributes.getBoolean(6, true);
        this.k = typedArrayObtainStyledAttributes.getBoolean(9, false);
        this.l = typedArrayObtainStyledAttributes.getText(8);
        if (typedArrayObtainStyledAttributes.hasValue(7)) {
            setCheckedState(typedArrayObtainStyledAttributes.getInt(7, 0));
        }
        raVar.O();
        a();
    }

    private String getButtonStateDescription() {
        int i = this.s;
        return i == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.h == null) {
            int iL = xr.l(this, R.attr.colorControlActivated);
            int iL2 = xr.l(this, R.attr.colorError);
            int iL3 = xr.l(this, R.attr.colorSurface);
            int iL4 = xr.l(this, R.attr.colorOnSurface);
            this.h = new ColorStateList(B, new int[]{xr.z(1.0f, iL3, iL2), xr.z(1.0f, iL3, iL), xr.z(0.54f, iL3, iL4), xr.z(0.38f, iL3, iL4), xr.z(0.38f, iL3, iL4)});
        }
        return this.h;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.p;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        m1 m1Var;
        Drawable drawableMutate = this.m;
        ColorStateList colorStateList3 = this.p;
        PorterDuff.Mode buttonTintMode = getButtonTintMode();
        if (drawableMutate == null) {
            drawableMutate = null;
        } else if (colorStateList3 != null) {
            drawableMutate = drawableMutate.mutate();
            if (buttonTintMode != null) {
                drawableMutate.setTintMode(buttonTintMode);
            }
        }
        this.m = drawableMutate;
        Drawable drawableMutate2 = this.n;
        ColorStateList colorStateList4 = this.q;
        PorterDuff.Mode mode = this.r;
        if (drawableMutate2 == null) {
            drawableMutate2 = null;
        } else if (colorStateList4 != null) {
            drawableMutate2 = drawableMutate2.mutate();
            if (mode != null) {
                drawableMutate2.setTintMode(mode);
            }
        }
        this.n = drawableMutate2;
        if (this.o) {
            r7 r7Var = this.x;
            if (r7Var != null) {
                p7 p7Var = r7Var.c;
                Drawable drawable = r7Var.b;
                ak0 ak0Var = this.y;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (ak0Var.a == null) {
                        ak0Var.a = new n7(ak0Var);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(ak0Var.a);
                }
                ArrayList arrayList = r7Var.f;
                if (arrayList != null && ak0Var != null) {
                    arrayList.remove(ak0Var);
                    if (r7Var.f.size() == 0 && (m1Var = r7Var.e) != null) {
                        p7Var.b.removeListener(m1Var);
                        r7Var.e = null;
                    }
                }
                Drawable drawable2 = r7Var.b;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (ak0Var.a == null) {
                        ak0Var.a = new n7(ak0Var);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(ak0Var.a);
                } else if (ak0Var != null) {
                    if (r7Var.f == null) {
                        r7Var.f = new ArrayList();
                    }
                    if (!r7Var.f.contains(ak0Var)) {
                        r7Var.f.add(ak0Var);
                        if (r7Var.e == null) {
                            r7Var.e = new m1(1, r7Var);
                        }
                        p7Var.b.addListener(r7Var.e);
                    }
                }
            }
            Drawable drawable3 = this.m;
            if ((drawable3 instanceof AnimatedStateListDrawable) && r7Var != null) {
                ((AnimatedStateListDrawable) drawable3).addTransition(R.id.checked, R.id.unchecked, r7Var, false);
                ((AnimatedStateListDrawable) this.m).addTransition(R.id.indeterminate, R.id.unchecked, r7Var, false);
            }
        }
        Drawable drawable4 = this.m;
        if (drawable4 != null && (colorStateList2 = this.p) != null) {
            drawable4.setTintList(colorStateList2);
        }
        Drawable drawable5 = this.n;
        if (drawable5 != null && (colorStateList = this.q) != null) {
            drawable5.setTintList(colorStateList);
        }
        Drawable drawable6 = this.m;
        Drawable drawable7 = this.n;
        if (drawable6 == null) {
            drawable6 = drawable7;
        } else if (drawable7 != null) {
            int intrinsicWidth = drawable7.getIntrinsicWidth();
            if (intrinsicWidth == -1) {
                intrinsicWidth = drawable6.getIntrinsicWidth();
            }
            int intrinsicHeight = drawable7.getIntrinsicHeight();
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable6.getIntrinsicHeight();
            }
            if (intrinsicWidth > drawable6.getIntrinsicWidth() || intrinsicHeight > drawable6.getIntrinsicHeight()) {
                float f = intrinsicWidth / intrinsicHeight;
                if (f >= drawable6.getIntrinsicWidth() / drawable6.getIntrinsicHeight()) {
                    int intrinsicWidth2 = drawable6.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth2 / f);
                    intrinsicWidth = intrinsicWidth2;
                } else {
                    intrinsicHeight = drawable6.getIntrinsicHeight();
                    intrinsicWidth = (int) (f * intrinsicHeight);
                }
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable6, drawable7});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable6 = layerDrawable;
        }
        super.setButtonDrawable(drawable6);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.m;
    }

    public Drawable getButtonIconDrawable() {
        return this.n;
    }

    public ColorStateList getButtonIconTintList() {
        return this.q;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.r;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.p;
    }

    public int getCheckedState() {
        return this.s;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.l;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.s == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i && this.p == null && this.q == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrCopyOf;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, z);
        }
        if (this.k) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, A);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= iArrOnCreateDrawableState.length) {
                iArrCopyOf = Arrays.copyOf(iArrOnCreateDrawableState, iArrOnCreateDrawableState.length + 1);
                iArrCopyOf[iArrOnCreateDrawableState.length] = 16842912;
                break;
            }
            int i3 = iArrOnCreateDrawableState[i2];
            if (i3 == 16842912) {
                iArrCopyOf = iArrOnCreateDrawableState;
                break;
            }
            if (i3 == 0) {
                iArrCopyOf = (int[]) iArrOnCreateDrawableState.clone();
                iArrCopyOf[i2] = 16842912;
                break;
            }
            i2++;
        }
        this.t = iArrCopyOf;
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.j || !TextUtils.isEmpty(getText()) || (buttonDrawable = getButtonDrawable()) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (i1.E(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.k) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.l));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof bk0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        bk0 bk0Var = (bk0) parcelable;
        super.onRestoreInstanceState(bk0Var.getSuperState());
        setCheckedState(bk0Var.b);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        bk0 bk0Var = new bk0(super.onSaveInstanceState());
        bk0Var.b = getCheckedState();
        return bk0Var;
    }

    @Override // defpackage.c8, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(tk0.j(getContext(), i));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.n = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i) {
        setButtonIconDrawable(tk0.j(getContext(), i));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.q == colorStateList) {
            return;
        }
        this.q = colorStateList;
        a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.r == mode) {
            return;
        }
        this.r = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.p == colorStateList) {
            return;
        }
        this.p = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z2) {
        this.j = z2;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        setCheckedState(z2 ? 1 : 0);
    }

    public void setCheckedState(int i) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.s != i) {
            this.s = i;
            super.setChecked(i == 1);
            refreshDrawableState();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && this.v == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.u) {
                return;
            }
            this.u = true;
            LinkedHashSet linkedHashSet = this.g;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw l11.h(it);
                }
            }
            if (this.s != 2 && (onCheckedChangeListener = this.w) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (i2 >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.u = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.l = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i) {
        setErrorAccessibilityLabel(i != 0 ? getResources().getText(i) : null);
    }

    public void setErrorShown(boolean z2) {
        if (this.k == z2) {
            return;
        }
        this.k = z2;
        refreshDrawableState();
        Iterator it = this.f.iterator();
        if (it.hasNext()) {
            throw l11.h(it);
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.w = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.v = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.i = z2;
        if (z2) {
            setButtonTintList(getMaterialThemeColorsTintList());
        } else {
            setButtonTintList(null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // defpackage.c8, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.m = drawable;
        this.o = false;
        a();
    }
}
