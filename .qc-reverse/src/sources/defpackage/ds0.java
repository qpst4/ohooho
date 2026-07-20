package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.KeyEvent;
import com.heinrichreimersoftware.materialintro.view.FadeableViewPager;
import com.quickcursor.android.activities.AccessibilityStoppedActivity;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ds0 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ KeyEvent.Callback c;

    public /* synthetic */ ds0(KeyEvent.Callback callback, int i, int i2) {
        this.a = i2;
        this.c = callback;
        this.b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.a) {
            case 0:
                AccessibilityStoppedActivity accessibilityStoppedActivity = (AccessibilityStoppedActivity) this.c;
                try {
                    FadeableViewPager fadeableViewPager = accessibilityStoppedActivity.U;
                    if (fadeableViewPager.N) {
                        fadeableViewPager.j();
                    }
                } catch (Exception unused) {
                    accessibilityStoppedActivity.T();
                    return;
                }
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i = this.a;
        int i2 = this.b;
        KeyEvent.Callback callback = this.c;
        switch (i) {
            case 0:
                AccessibilityStoppedActivity accessibilityStoppedActivity = (AccessibilityStoppedActivity) callback;
                try {
                    FadeableViewPager fadeableViewPager = accessibilityStoppedActivity.U;
                    if (fadeableViewPager.N) {
                        fadeableViewPager.j();
                    }
                    accessibilityStoppedActivity.U.setCurrentItem(i2);
                } catch (Exception unused) {
                    accessibilityStoppedActivity.T();
                    return;
                }
                break;
            default:
                ye1 ye1Var = (ye1) callback;
                ye1Var.e = i2;
                ye1Var.f = 0.0f;
                break;
        }
    }
}
