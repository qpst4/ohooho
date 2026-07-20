package defpackage;

import android.content.SharedPreferences;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ra1 extends View implements View.OnTouchListener {
    public static final int o = ViewConfiguration.getLongPressTimeout();
    public final WindowManager b;
    public final qa1 c;
    public final f91 d;
    public final WindowManager.LayoutParams e;
    public final boolean f;
    public final b61 g;
    public int h;
    public float i;
    public float j;
    public float k;
    public float l;
    public int m;
    public int n;

    public ra1(CursorAccessibilityService cursorAccessibilityService, qa1 qa1Var, f91 f91Var, boolean z) {
        super(cursorAccessibilityService);
        this.m = 0;
        this.n = 0;
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
        this.b = (WindowManager) cursorAccessibilityService.getSystemService("window");
        this.f = z;
        this.g = new b61(new lk0(21, this), o);
        this.c = qa1Var;
        this.d = f91Var;
        setOnTouchListener(this);
        yb0.w();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(f91Var.h().f(), f91Var.h().c(), 2032, 808, -3);
        this.e = layoutParams;
        layoutParams.gravity = 51;
        layoutParams.x = f91Var.h().d();
        this.e.y = f91Var.h().e();
        setLayoutParams(this.e);
        setBackgroundColor(oq0.a((SharedPreferences) pn0.t().d, oq0.e) ? dn.i0 : 0);
        xr.M(this);
    }

    public final void a() {
        f91 f91Var = this.d;
        this.e.x = f91Var.h().d();
        this.e.y = f91Var.h().e();
        this.e.width = (int) f91Var.h().j();
        this.e.height = (int) f91Var.h().b();
        this.b.updateViewLayout(this, this.e);
    }

    public int getLayoutParamsX() {
        return this.e.x;
    }

    public int getLayoutParamsY() {
        return this.e.y;
    }

    public int getPositionX() {
        return (getSize() / 2) + this.e.x;
    }

    public int getPositionY() {
        return (getSize() / 2) + this.e.y;
    }

    public int getSize() {
        return this.e.width;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int actionMasked = motionEvent.getActionMasked();
        qa1 qa1Var = this.c;
        if (actionMasked == 5) {
            if (this.h == 2) {
                int action = (motionEvent.getAction() & 65280) >> 8;
                int i = Build.VERSION.SDK_INT;
                qa1Var.c(i >= 29 ? (int) motionEvent.getRawX(action) : ey0.c() / 2, i >= 29 ? (int) motionEvent.getRawY(action) : ey0.b() / 2);
                return true;
            }
        } else if (actionMasked != 6) {
            this.k = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            this.l = rawY;
            WindowManager.LayoutParams layoutParams = this.e;
            WindowManager windowManager = this.b;
            f91 f91Var = this.d;
            b61 b61Var = this.g;
            boolean z = this.f;
            if (actionMasked == 0) {
                this.i = this.k;
                this.j = rawY;
                if (z) {
                    this.h = 2;
                    b61Var.d();
                    qa1Var.h(f91Var, (int) this.k, (int) this.l);
                    this.h = 2;
                } else {
                    b61Var.a();
                    this.h = 1;
                    qa1Var.g(f91Var, (int) this.i, (int) this.j);
                    try {
                        this.m = layoutParams.width;
                        this.n = layoutParams.height;
                        layoutParams.width = 1;
                        layoutParams.height = 1;
                        windowManager.updateViewLayout(this, layoutParams);
                    } catch (Exception unused) {
                    }
                }
                VelocityTracker velocityTracker2 = yb0.m;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            VelocityTracker velocityTracker3 = yb0.m;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
            }
            if (actionMasked == 2) {
                if (this.h == 1 && xy0.n(this.i, this.k, this.j, this.l) > dn.p0) {
                    b61Var.d();
                    qa1Var.h(f91Var, (int) this.k, (int) this.l);
                    this.h = 2;
                } else if (this.h == 2) {
                    qa1Var.f((int) this.k, (int) this.l);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                b61Var.d();
                int i2 = this.h;
                if (i2 == 2) {
                    long eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
                    dm0 dm0Var = null;
                    if (eventTime > 300 && (velocityTracker = yb0.m) != null) {
                        velocityTracker.computeCurrentVelocity(1);
                        VelocityTracker velocityTracker4 = yb0.m;
                        dm0Var = new dm0();
                        dm0Var.a = velocityTracker4.getXVelocity();
                        dm0Var.b = velocityTracker4.getYVelocity();
                    }
                    qa1Var.d(dm0Var, (int) this.k, (int) this.l);
                } else if (i2 == 1) {
                    qa1Var.b((int) this.k, (int) this.l);
                }
                if (!z) {
                    try {
                        layoutParams.width = this.m;
                        layoutParams.height = this.n;
                        windowManager.updateViewLayout(this, layoutParams);
                        xr.M(this);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        return true;
    }

    public void setTemporarilyThinner(float f) {
        f91 f91Var = this.d;
        e91 e91VarE = f91Var.e();
        if (e91VarE == e91.left || e91VarE == e91.right) {
            int iF = f91Var.h().f();
            int iMax = Math.max(1, (int) (iF * f));
            int i = iF - iMax;
            WindowManager.LayoutParams layoutParams = this.e;
            layoutParams.width = iMax;
            if (e91VarE == e91.right) {
                layoutParams.x = f91Var.h().d() + i;
            }
        } else {
            int iC = f91Var.h().c();
            int iMax2 = Math.max(1, (int) (iC * f));
            int i2 = iC - iMax2;
            WindowManager.LayoutParams layoutParams2 = this.e;
            layoutParams2.height = iMax2;
            if (e91VarE == e91.bottom) {
                layoutParams2.y = f91Var.h().e() + i2;
            }
        }
        this.b.updateViewLayout(this, this.e);
    }

    public void setTemporarilyVerticalMargin(int i) {
        WindowManager.LayoutParams layoutParams = this.e;
        layoutParams.y = i - layoutParams.height;
        this.b.updateViewLayout(this, layoutParams);
    }
}
