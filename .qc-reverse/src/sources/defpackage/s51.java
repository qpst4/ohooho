package defpackage;

import android.animation.ValueAnimator;
import com.warkiz.tickseekbar.TickSeekBar;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class s51 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float a;
    public final /* synthetic */ int b;
    public final /* synthetic */ TickSeekBar c;

    public s51(TickSeekBar tickSeekBar, float f, int i) {
        this.c = tickSeekBar;
        this.a = f;
        this.b = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        TickSeekBar tickSeekBar = this.c;
        tickSeekBar.h = tickSeekBar.s;
        float f = tickSeekBar.x[this.b];
        float f2 = this.a;
        if (f2 - f > 0.0f) {
            tickSeekBar.s = f2 - ((Float) valueAnimator.getAnimatedValue()).floatValue();
        } else {
            tickSeekBar.s = ((Float) valueAnimator.getAnimatedValue()).floatValue() + f2;
        }
        tickSeekBar.u(tickSeekBar.s);
        tickSeekBar.setSeekListener(false);
        tickSeekBar.invalidate();
    }
}
