package defpackage;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.quickcursor.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hz extends LinearLayout {
    public final TextInputLayout b;
    public final FrameLayout c;
    public final CheckableImageButton d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public View.OnLongClickListener g;
    public final CheckableImageButton h;
    public final gz i;
    public int j;
    public final LinkedHashSet k;
    public ColorStateList l;
    public PorterDuff.Mode m;
    public int n;
    public ImageView.ScaleType o;
    public View.OnLongClickListener p;
    public CharSequence q;
    public final AppCompatTextView r;
    public boolean s;
    public EditText t;
    public final AccessibilityManager u;
    public r1 v;
    public final ez w;

    public hz(TextInputLayout textInputLayout, ra raVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.j = 0;
        this.k = new LinkedHashSet();
        this.w = new ez(this);
        fz fzVar = new fz(this);
        this.u = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.b = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.c = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.d = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.h = checkableImageButtonA2;
        this.i = new gz(this, raVar);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
        this.r = appCompatTextView;
        TypedArray typedArray = (TypedArray) raVar.c;
        if (typedArray.hasValue(38)) {
            this.e = yb0.h(getContext(), raVar, 38);
        }
        if (typedArray.hasValue(39)) {
            this.f = i1.J(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            i(raVar.y(37));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap weakHashMap = uf1.a;
        checkableImageButtonA.setImportantForAccessibility(2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setFocusable(false);
        if (!typedArray.hasValue(53)) {
            if (typedArray.hasValue(32)) {
                this.l = yb0.h(getContext(), raVar, 32);
            }
            if (typedArray.hasValue(33)) {
                this.m = i1.J(typedArray.getInt(33, -1), null);
            }
        }
        int i = 1;
        if (typedArray.hasValue(30)) {
            g(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27) && checkableImageButtonA2.getContentDescription() != (text = typedArray.getText(27))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(53)) {
            if (typedArray.hasValue(54)) {
                this.l = yb0.h(getContext(), raVar, 54);
            }
            if (typedArray.hasValue(55)) {
                this.m = i1.J(typedArray.getInt(55, -1), null);
            }
            g(typedArray.getBoolean(53, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(51);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            zy.n("endIconSize cannot be less than 0");
            throw null;
        }
        if (dimensionPixelSize != this.n) {
            this.n = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(31)) {
            ImageView.ScaleType scaleTypeL = xy0.l(typedArray.getInt(31, -1));
            this.o = scaleTypeL;
            checkableImageButtonA2.setScaleType(scaleTypeL);
            checkableImageButtonA.setScaleType(scaleTypeL);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        appCompatTextView.setAccessibilityLiveRegion(1);
        appCompatTextView.setTextAppearance(typedArray.getResourceId(72, 0));
        if (typedArray.hasValue(73)) {
            appCompatTextView.setTextColor(raVar.x(73));
        }
        CharSequence text3 = typedArray.getText(71);
        this.q = TextUtils.isEmpty(text3) ? null : text3;
        appCompatTextView.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.f0.add(fzVar);
        if (textInputLayout.e != null) {
            fzVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new si(i, this));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i);
        if (yb0.o(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final iz b() {
        iz frVar;
        int i = this.j;
        gz gzVar = this.i;
        SparseArray sparseArray = gzVar.a;
        iz izVar = (iz) sparseArray.get(i);
        if (izVar != null) {
            return izVar;
        }
        hz hzVar = gzVar.b;
        if (i != -1) {
            int i2 = 1;
            if (i == 0) {
                frVar = new fr(hzVar, i2);
            } else if (i == 1) {
                frVar = new jp0(hzVar, gzVar.d);
            } else if (i == 2) {
                frVar = new sk(hzVar);
            } else {
                if (i != 3) {
                    zy.n(qq0.i("Invalid end icon mode: ", i));
                    return null;
                }
                frVar = new ev(hzVar);
            }
        } else {
            frVar = new fr(hzVar, 0);
        }
        sparseArray.append(i, frVar);
        return frVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.h;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        WeakHashMap weakHashMap = uf1.a;
        return this.r.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.c.getVisibility() == 0 && this.h.getVisibility() == 0;
    }

    public final boolean e() {
        return this.d.getVisibility() == 0;
    }

    public final void f(boolean z) {
        boolean z2;
        boolean zIsActivated;
        boolean z3;
        iz izVarB = b();
        boolean zJ = izVarB.j();
        CheckableImageButton checkableImageButton = this.h;
        boolean z4 = true;
        if (!zJ || (z3 = checkableImageButton.e) == izVarB.k()) {
            z2 = false;
        } else {
            checkableImageButton.setChecked(!z3);
            z2 = true;
        }
        if (!(izVarB instanceof ev) || (zIsActivated = checkableImageButton.isActivated()) == ((ev) izVarB).l) {
            z4 = z2;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z || z4) {
            xy0.y(this.b, checkableImageButton, this.l);
        }
    }

    public final void g(int i) {
        if (this.j == i) {
            return;
        }
        iz izVarB = b();
        r1 r1Var = this.v;
        AccessibilityManager accessibilityManager = this.u;
        if (r1Var != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(new a0(r1Var));
        }
        this.v = null;
        izVarB.r();
        this.j = i;
        Iterator it = this.k.iterator();
        if (it.hasNext()) {
            throw l11.h(it);
        }
        h(i != 0);
        iz izVarB2 = b();
        int iD = this.i.c;
        if (iD == 0) {
            iD = izVarB2.d();
        }
        Drawable drawableJ = iD != 0 ? tk0.j(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.h;
        checkableImageButton.setImageDrawable(drawableJ);
        TextInputLayout textInputLayout = this.b;
        if (drawableJ != null) {
            xy0.b(textInputLayout, checkableImageButton, this.l, this.m);
            xy0.y(textInputLayout, checkableImageButton, this.l);
        }
        int iC = izVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(izVarB2.j());
        if (!izVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        izVarB2.q();
        r1 r1VarH = izVarB2.h();
        this.v = r1VarH;
        if (r1VarH != null && accessibilityManager != null) {
            WeakHashMap weakHashMap = uf1.a;
            if (isAttachedToWindow()) {
                accessibilityManager.addTouchExplorationStateChangeListener(new a0(this.v));
            }
        }
        View.OnClickListener onClickListenerF = izVarB2.f();
        View.OnLongClickListener onLongClickListener = this.p;
        checkableImageButton.setOnClickListener(onClickListenerF);
        xy0.F(checkableImageButton, onLongClickListener);
        EditText editText = this.t;
        if (editText != null) {
            izVarB2.l(editText);
            j(izVarB2);
        }
        xy0.b(textInputLayout, checkableImageButton, this.l, this.m);
        f(true);
    }

    public final void h(boolean z) {
        if (d() != z) {
            this.h.setVisibility(z ? 0 : 8);
            k();
            m();
            this.b.q();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.d;
        checkableImageButton.setImageDrawable(drawable);
        l();
        xy0.b(this.b, checkableImageButton, this.e, this.f);
    }

    public final void j(iz izVar) {
        if (this.t == null) {
            return;
        }
        if (izVar.e() != null) {
            this.t.setOnFocusChangeListener(izVar.e());
        }
        if (izVar.g() != null) {
            this.h.setOnFocusChangeListener(izVar.g());
        }
    }

    public final void k() {
        this.c.setVisibility((this.h.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || ((this.q == null || this.s) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.d;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.b;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.k.q && textInputLayout.m()) ? 0 : 8);
        k();
        m();
        if (this.j != 0) {
            return;
        }
        textInputLayout.q();
    }

    public final void m() {
        int paddingEnd;
        TextInputLayout textInputLayout = this.b;
        if (textInputLayout.e == null) {
            return;
        }
        if (d() || e()) {
            paddingEnd = 0;
        } else {
            EditText editText = textInputLayout.e;
            WeakHashMap weakHashMap = uf1.a;
            paddingEnd = editText.getPaddingEnd();
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = textInputLayout.e.getPaddingTop();
        int paddingBottom = textInputLayout.e.getPaddingBottom();
        WeakHashMap weakHashMap2 = uf1.a;
        this.r.setPaddingRelative(dimensionPixelSize, paddingTop, paddingEnd, paddingBottom);
    }

    public final void n() {
        AppCompatTextView appCompatTextView = this.r;
        int visibility = appCompatTextView.getVisibility();
        int i = (this.q == null || this.s) ? 8 : 0;
        if (visibility != i) {
            b().o(i == 0);
        }
        k();
        appCompatTextView.setVisibility(i);
        this.b.q();
    }
}
