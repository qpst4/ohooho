package defpackage;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import com.quickcursor.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ev extends iz {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public AutoCompleteTextView h;
    public final a3 i;
    public final pk j;
    public final r1 k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public AccessibilityManager p;
    public ValueAnimator q;
    public ValueAnimator r;

    public ev(hz hzVar) {
        super(hzVar);
        this.i = new a3(6, this);
        this.j = new pk(this, 1);
        this.k = new r1(11, this);
        this.o = Long.MAX_VALUE;
        this.f = i1.T(hzVar.getContext(), R.attr.motionDurationShort3, 67);
        this.e = i1.T(hzVar.getContext(), R.attr.motionDurationShort3, 50);
        this.g = i1.U(hzVar.getContext(), R.attr.motionEasingLinearInterpolator, s7.a);
    }

    @Override // defpackage.iz
    public final void a() {
        if (this.p.isTouchExplorationEnabled() && this.h.getInputType() != 0 && !this.d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new c(21, this));
    }

    @Override // defpackage.iz
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // defpackage.iz
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // defpackage.iz
    public final View.OnFocusChangeListener e() {
        return this.j;
    }

    @Override // defpackage.iz
    public final View.OnClickListener f() {
        return this.i;
    }

    @Override // defpackage.iz
    public final r1 h() {
        return this.k;
    }

    @Override // defpackage.iz
    public final boolean i(int i) {
        return i != 0;
    }

    @Override // defpackage.iz
    public final boolean k() {
        return this.n;
    }

    @Override // defpackage.iz
    public final void l(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new cr(1, this));
        this.h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: dv
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                ev evVar = this.a;
                evVar.m = true;
                evVar.o = System.currentTimeMillis();
                evVar.s(false);
            }
        });
        this.h.setThreshold(0);
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (editText.getInputType() == 0 && this.p.isTouchExplorationEnabled()) {
            WeakHashMap weakHashMap = uf1.a;
            this.d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // defpackage.iz
    public final void m(n0 n0Var) {
        if (this.h.getInputType() == 0) {
            n0Var.i(Spinner.class.getName());
        }
        if (Build.VERSION.SDK_INT >= 26 ? n0Var.a.isShowingHintText() : n0Var.e(4)) {
            n0Var.k(null);
        }
    }

    @Override // defpackage.iz
    public final void n(AccessibilityEvent accessibilityEvent) {
        if (this.p.isEnabled() && this.h.getInputType() == 0) {
            boolean z = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.n && !this.h.isPopupShowing();
            if (accessibilityEvent.getEventType() == 1 || z) {
                t();
                this.m = true;
                this.o = System.currentTimeMillis();
            }
        }
    }

    @Override // defpackage.iz
    public final void q() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f);
        int i = 1;
        valueAnimatorOfFloat.addUpdateListener(new o3(i, this));
        this.r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.e);
        valueAnimatorOfFloat2.addUpdateListener(new o3(i, this));
        this.q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new m1(3, this));
        this.p = (AccessibilityManager) this.c.getSystemService("accessibility");
    }

    @Override // defpackage.iz
    public final void r() {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.h.setOnDismissListener(null);
        }
    }

    public final void s(boolean z) {
        if (this.n != z) {
            this.n = z;
            this.r.cancel();
            this.q.start();
        }
    }

    public final void t() {
        if (this.h == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.o;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            this.m = false;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        s(!this.n);
        boolean z = this.n;
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (!z) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            this.h.showDropDown();
        }
    }
}
