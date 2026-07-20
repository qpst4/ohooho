package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class vg extends FrameLayout {
    public final WindowManager b;
    public final LinearLayout c;
    public boolean d;

    public vg(Context context) {
        super(context);
        f01.d(getContext());
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.b = windowManager;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(ey0.c(), ey0.b(), 2032, 262912, -3);
        layoutParams.gravity = 51;
        layoutParams.y = 0;
        setLayoutParams(layoutParams);
        try {
            windowManager.addView(this, layoutParams);
        } catch (Exception unused) {
        }
        getContext().setTheme(R.style.AppTheme);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.bottom_sheet, (ViewGroup) null);
        this.c = linearLayout;
        addView(linearLayout);
        this.d = true;
        setOnClickListener(new a3(1, this));
    }

    public final void a(LinearLayout linearLayout) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, yb0.l(CursorAccessibilityService.q));
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = this.c;
        linearLayout2.addView(linearLayout);
        linearLayout2.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
        linearLayout2.getChildAt(1).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_up));
    }

    public final void b() {
        LinearLayout linearLayout = this.c;
        try {
            this.d = false;
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
            animationLoadAnimation.setAnimationListener(new s0(this, 1));
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
            layoutParams.flags |= 16;
            setLayoutParams(layoutParams);
            this.b.updateViewLayout(this, layoutParams);
            linearLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
            linearLayout.getChildAt(1).startAnimation(animationLoadAnimation);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        b();
        return true;
    }
}
