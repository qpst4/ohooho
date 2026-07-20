package defpackage;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sk extends iz {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public final TimeInterpolator h;
    public EditText i;
    public final a3 j;
    public final pk k;
    public AnimatorSet l;
    public ValueAnimator m;

    public sk(hz hzVar) {
        super(hzVar);
        this.j = new a3(3, this);
        this.k = new pk(this, 0);
        this.e = i1.T(hzVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f = i1.T(hzVar.getContext(), R.attr.motionDurationShort3, 150);
        this.g = i1.U(hzVar.getContext(), R.attr.motionEasingLinearInterpolator, s7.a);
        this.h = i1.U(hzVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, s7.d);
    }

    @Override // defpackage.iz
    public final void a() {
        if (this.b.q != null) {
            return;
        }
        s(t());
    }

    @Override // defpackage.iz
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // defpackage.iz
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // defpackage.iz
    public final View.OnFocusChangeListener e() {
        return this.k;
    }

    @Override // defpackage.iz
    public final View.OnClickListener f() {
        return this.j;
    }

    @Override // defpackage.iz
    public final View.OnFocusChangeListener g() {
        return this.k;
    }

    @Override // defpackage.iz
    public final void l(EditText editText) {
        this.i = editText;
        this.a.setEndIconVisible(t());
    }

    @Override // defpackage.iz
    public final void o(boolean z) {
        if (this.b.q == null) {
            return;
        }
        s(z);
    }

    @Override // defpackage.iz
    public final void q() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.h);
        valueAnimatorOfFloat.setDuration(this.f);
        final int i = 1;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: qk
            public final /* synthetic */ sk b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i2 = i;
                sk skVar = this.b;
                switch (i2) {
                    case 0:
                        skVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = skVar.d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i2 = this.e;
        valueAnimatorOfFloat2.setDuration(i2);
        final int i3 = 0;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: qk
            public final /* synthetic */ sk b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i22 = i3;
                sk skVar = this.b;
                switch (i22) {
                    case 0:
                        skVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = skVar.d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.l.addListener(new rk(this, i3));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i2);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: qk
            public final /* synthetic */ sk b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i22 = i3;
                sk skVar = this.b;
                switch (i22) {
                    case 0:
                        skVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = skVar.d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        this.m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new rk(this, i));
    }

    @Override // defpackage.iz
    public final void r() {
        EditText editText = this.i;
        if (editText != null) {
            editText.post(new c(13, this));
        }
    }

    public final void s(boolean z) {
        boolean z2 = this.b.d() == z;
        if (z && !this.l.isRunning()) {
            this.m.cancel();
            this.l.start();
            if (z2) {
                this.l.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.l.cancel();
        this.m.start();
        if (z2) {
            this.m.end();
        }
    }

    public final boolean t() {
        EditText editText = this.i;
        if (editText != null) {
            return (editText.hasFocus() || this.d.hasFocus()) && this.i.getText().length() > 0;
        }
        return false;
    }
}
